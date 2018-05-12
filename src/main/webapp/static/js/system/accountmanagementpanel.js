$(function () {

    /*****************下拉框加载************************/
    var $addRoleId = $('#addRoleId').combobox({
        panelHeight: 'auto', valueField: 'id',
        textField: 'roleName', editable: false
    });

    $.ajax({
        url:"/system/accountmanpage/getAllRole",
        type:"GET",dataType:"json",
        success:function (r) {
            $addRoleId.combobox('loadData',r);
        }
    })

    var selectedaccount, reqObj = {};
    var $accountGrid = $('#accountGrid').datagrid({
        url: '/system/accountmanpage/accountlist', method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 50, 100, 150],
        columns: [[
            {
                field: 'userName', title: "用户名", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'loginName', title: "登录名", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'roleName', title: "角色名称", width: 100, sortable: true,
                align: 'left'
            }
        ]],
        toolbar: [
            {
                text: "新增", iconCls: 'icon-add',
                handler: function () {
                    $addAccountWin.window('open');
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
            selectedaccount = row;

        },
        onLoadSuccess: function () {
            selectedaccount = $accountGrid.datagrid('getSelected');
        }
    });

    /*************新增*******************/

    $('#confirmPassword').textbox({
        validType: 'passwordMatch["#password"]'
    });

    var $addAccountForm = $('#addAccountForm').form({
        novalidate: true
    });

    var $addAccountWin = $('#addAccountWin').window({
        title: "新增", closed: true, modal: true, height: 260,
        width: 360, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#addAccountWinFooter',
        onClose: function () {
            $('#addAccountForm').form('disableValidation').form('reset');
        }
    });

    $('#addAccountWinSubmitBtn').linkbutton({
        onClick: function () {
            if (!$('#addAccountForm').form('enableValidation').form('validate')) {
                return;
            }

            alert("1")
        }
    });

    $('#addAccountWinCloseBtn').linkbutton({
        onClick: function () {
            $addAccountWin.window('close');
        }
    });
});