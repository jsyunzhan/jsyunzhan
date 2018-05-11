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

                }
            });

        }
    });

    $('#addRolesWinCloseBtn').linkbutton({
        onClick: function () {
            $addRolesWin.window('close');
        }
    });
});