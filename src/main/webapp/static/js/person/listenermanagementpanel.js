$(function () {
    var selectedlistener, reqObj = {};
    var $listenerGrid = $('#listenerGrid').datagrid({
        url: '/person/listenermanpage/list', method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 50, 100, 150],
        columns: [[
            {
                field: 'listenerName', title: "听课人员姓名", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'listenerNumb', title: "听课人员身份证", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'permissionFlag', title: "是否拥有权限", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'openId', title: "是否注册", width: 100, sortable: true,
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

                    if (!selectedaccount) {
                        showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
                    } else {
                        $editAccountForm.form('load', selectedaccount);
                        $editAccountWin.window('open');
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
            selectedlistener = row;

        },
        onLoadSuccess: function () {
            selectedlistener = $listenerGrid.datagrid('getSelected');
        }
    });
});