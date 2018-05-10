$(function () {

    var selectedFaultType, reqObj = {};
    var $faultTypesGrid = $('#faultTypesGrid').datagrid({
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


        ],
        onBeforeLoad: function (param) {
            $.extend(param, reqObj);
        },
        onSelect: function (index, row) {
            selectedFaultType = row;
        },
        onLoadSuccess: function () {
            selectedFaultType = $faultTypesGrid.datagrid('getSelected');
        }
    });
});