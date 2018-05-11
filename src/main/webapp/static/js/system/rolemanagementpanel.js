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
                        showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
                    } else {
                        $editRolesForm.form('load', selectedrole);
                        $editRolesWin.window('open');
                    }

                }
            },
            {
                text: "删除", iconCls: 'icon-remove',
                handler: function () {
                    removeHandle();
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

            var data = {roleName:addRoleData.roleName};
            if (!checkRoleName(data)){
                alert("重复");
                return
            }

            $.ajax({
                url: url, type: "POST", contentType: "application/json", timeout: 360000, cache: false,
                data: JSON.stringify(addRoleData),
                success: function (serverResponse) {
                    if (serverResponse.success){
                        $rolesGrid.datagrid('reload');
                        $addRolesWin.window('close');
                        showInfoMessage(SYSTEM_MESSAGE.msg_action_success);
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

            var data = {id:editRoleData.id,roleName:editRoleData.roleName};
            if (!checkRoleName(data)){
                alert("重复")
                return
            }
            $.ajax({
                url: url, type: "POST", contentType: "application/json",
                data: JSON.stringify(editRoleData),
                success: function (serverResponse) {
                    if (serverResponse.success){
                        $rolesGrid.datagrid('reload');
                        $editRolesWin.window('close');
                        showInfoMessage(SYSTEM_MESSAGE.msg_action_success);
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

    /************删除*************/

    function removeHandle() {
        if (!selectedrole) {
            showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
            return
        }

        if (selectedrole.useCount > 0) {
            showErrorMessage("已有用户选择此角色，不能删除！");
            return
        }

        var msg = String.format("您确定要删除角色：<span style='color: red;'>{0}</span>？", selectedrole.roleName);

        showConfirm(msg, function () {
            $.ajax({
                url:"/system/rolemanpage/delete/"+selectedrole.id,
                type:"GET",dataType:"json",
                success:function (r) {
                    $rolesGrid.datagrid('reload');
                }
            })
        })
    }


    /****************************************右边树*****************************/
    var selectedOrganization, reqTreeObj = {};
    var $reourecesGrid = $('#reourecesGrid').treegrid({
        url: '/system/rolemanpage/resources', method: 'GET',
        treeField:'resourceName',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true, border: false, remoteSort: false,
        columns: [[
            {
                field: 'resourceName', title: "资源名称", width: 300, sortable: true,
                align: 'left',formatter:function (value,rowData,rowIndex) {
                return "<input id='"+ rowData.id +"'  type='checkbox' name='checkName' >" + rowData.resourceName;
                }
            }
        ]],
        toolbar: [
            {
                text: "确定", iconCls: 'icon-ok',
                handler: function () {
                    var obj=document.getElementsByName('checkName');
                    var objArray = [];
                    for(var i=0; i<obj.length; i++){
                        if(obj[i].checked){
                            objArray.push(obj[i].id);
                        }
                    }
                }
            }, {
                text: "取消", iconCls: 'icon-cancel',
                handler: function () {

                }
            }
        ],
        onBeforeLoad: function (param) {
            $.extend(param, reqTreeObj);
        },
        onSelect: function (row) {
            selectedOrganization = row;
        },
        onLoadSuccess: function () {
            selectedOrganization = $reourecesGrid.treegrid('getSelected');
        }
    });
});