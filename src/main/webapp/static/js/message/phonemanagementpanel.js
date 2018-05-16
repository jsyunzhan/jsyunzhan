$(function () {

    var selectedPhoneMess, reqObj = {};
    var $phoneMessGrid = $('#phoneMessGrid').datagrid({
        url: '/message/phonemanpage/list', method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 50, 100, 150],
        columns: [[
            {
                field: 'title', title: "公告标题", width: 150, sortable: true,
                align: 'left'
            },
            {
                field: 'message', title: "公告内容", width: 400, sortable: true,
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
            selectedPhoneMess = row;

        },
        onLoadSuccess: function () {
            selectedPhoneMess = $phoneMessGrid.datagrid('getSelected');
        }
    });

});