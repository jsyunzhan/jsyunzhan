$(function () {

    var selectedrole, reqObj = {};
    var $rolesGrid = $('#rolesGrid').datagrid({
        url: '/system/rolemanpage/rolelist', method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 50, 100, 150],
        columns: [[
            {
                field: 'roleName', title: "角色名称", width: 100, sortable: true,
                align: 'left'
            }
        ]],
        toolbar: [
            {
                text: "新增", iconCls: 'icon-add',
                handler: function () {
                    $addRolesWin.window('open');
                }
            },
            {
                text: "修改", iconCls: 'icon-edit',
                handler: function () {

                    if (!selectedrole) {
                        alert("请先选中")
                    } else {
                        $editRolesForm.form('load', selectedrole);
                        $editRolesWin.window('open');
                    }

                }
            }

        ],
        onBeforeLoad: function (param) {
            getPage(param);
            $.extend(param, reqObj);
        },
        onSelect: function (index, row) {
            selectedrole = row;
        },
        onLoadSuccess: function () {
            selectedrole = $rolesGrid.datagrid('getSelected');
        }
    });


    /*************新增*******************/

    var $addRolesForm = $('#addRolesForm').form({
        novalidate: true
    });

    var $addRolesWin = $('#addRolesWin').window({
        title: "新增", closed: true, modal: true, height: 215,
        width: 360, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#addRolesWinFooter',
        onClose: function () {
            $('#addRolesForm').form('disableValidation').form('reset');
        }
    });

    $('#addRolesWinSubmitBtn').linkbutton({
        onClick: function () {

            if (!$('#addRolesForm').form('enableValidation').form('validate')) {
                return;
            }

            var addRoleData = $addRolesForm.serializeObject(),
                url = "/system/rolemanpage/add";
            $.ajax({
                url: url, type: "POST", contentType: "application/json", timeout: 360000, cache: false,
                data: JSON.stringify(addRoleData),
                success: function (serverResponse) {
                    if (serverResponse.success){
                        $rolesGrid.datagrid('reload');
                        $addRolesWin.window('close');
                    }
                }
            });

        }
    });

    $('#addRolesWinCloseBtn').linkbutton({
        onClick: function () {
            $addRolesWin.window('close');
        }
    });

    /*************修改*******************/

    var $editRolesForm = $('#editRolesForm').form({
        novalidate: true
    });

    var $editRolesWin = $('#editRolesWin').window({
        title: "修改", closed: true, modal: true, height: 215,
        width: 360, iconCls: 'icon-edit', collapsible: false, minimizable: false,
        footer: '#editRolesWinFooter',
        onClose: function () {
            $('#editRolesForm').form('disableValidation').form('reset');
        }
    });

    $('#editRolesWinSubmitBtn').linkbutton({
        onClick: function () {

            if (!$('#editRolesForm').form('enableValidation').form('validate')) {
                return;
            }

            var editRoleData = $editRolesForm.serializeObject(),
                url = "/system/rolemanpage/edit";

            editRoleData.id = selectedrole.id;
            $.ajax({
                url: url, type: "POST", contentType: "application/json",
                data: JSON.stringify(editRoleData),
                success: function (serverResponse) {
                    if (serverResponse.success){
                        $rolesGrid.datagrid('reload');
                        $editRolesWin.window('close');
                    }
                }
            });

        }
    });

    $('#editRolesWinCloseBtn').linkbutton({
        onClick: function () {
            $editRolesWin.window('close');
        }
    });

    /*****************************校验新增是否重复************************************/

    $.extend($.fn.textbox.defaults.rules, {
        checkNameAdd: {// 验证故障类型存在与否
            validator: function (value) {
                var flag = true;
                var data = {roleName:value};
                $.ajax({
                    url: "/system/rolemanpage/checkrolename" , type: "POST", dataType:"json",data:data,
                    success: function (r) {
                        flag = r;
                    }
                });
                return flag;
            },
            message: "角色名称重复,请重新输入！"
        }
    });


    /*****************************校验修改是否重复************************************/
    $.extend($.fn.textbox.defaults.rules, {
        checkNameEdit: {// 验证消息类型名称存在与否
            validator: function (value) {
                var flag = true;
                var data = {id:selectedrole.id,roleName:value};
                $.ajax({
                    url: "/system/rolemanpage/checkrolename" , type: "POST", dataType:"json",data:data,
                    success: function (r) {
                        flag = r;
                    }
                });
                return flag;
            },
            message: "角色名称重复,请重新输入！"
        }
    });
});