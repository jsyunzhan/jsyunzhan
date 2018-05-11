$(function () {

    var selectedFaultType, reqObj = {};
    var $faultTypesGrid = $('#faultTypesGrid').datagrid({
        url: '/system/rolemanpage/rolelist', method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 3,
        pageList: [3, 50, 100, 150],
        // queryParams: {
        //     "page.start" : function(){
        //         debugger
        //         return $faultTypesGrid.datagrid("getPager").pagination("options").pageSize;
        //     },
        //     "page.end" : function(){
        //         return $faultTypesGrid.datagrid("getPager").pagination("options").pageNumber;
        //     }
        // },
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


                }
            }

        ],
        onBeforeLoad: function (param) {
            getPage(param);
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