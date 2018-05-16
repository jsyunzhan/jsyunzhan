

$(function () {

    function setYear(id,oldtime){
        var year = new Date().getFullYear();
        while(year>=oldtime){
            $(id).append("<option>"+year+"</option>");
            year--;
        }
    }
    setYear("#year",2008);

    var selectedQure, reqObj = {};

    reqObj.yearString = new Date().getFullYear();
    var $qureGrid = $('#qureGrid').datagrid({
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
                field: 'schoolName', title: "单位", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'threeCount', title: "三月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'fourCount', title: "四月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'fiveCount', title: "五月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'sixCount', title: "六月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'nineCount', title: "九月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'tenCount', title: "十月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'elevenCount', title: "十一月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            },
            {
                field: 'twelveCount', title: "十二月听课次数", width: 100, sortable: true,
                align: 'left',formatter:listenResult
            }

        ]],
        toolbar: [
            {
                text: "新增", iconCls: 'icon-add',
                handler: function () {
                    $addListenerWin.window('open');
                }
            }
        ],
        onBeforeLoad: function (param) {
            getPage(param);
            $.extend(param, reqObj);
        },
        onSelect: function (index, row) {
            selectedQure = row;

        },
        onLoadSuccess: function () {
            selectedQure = $qureGrid.datagrid('getSelected');
        }
    });

    /********************查询**************************/
    var $queryListenCountFrom = $('#queryListenCountFrom').form({
        novalidate: true
    });

    $('#logSearch').linkbutton({
        iconCls: 'icon-ok',
        onClick: function () {
            reqObj = $queryListenCountFrom.serializeObject();
            $qureGrid.datagrid('load');
        }
    });

    $('#logResert').linkbutton({
        iconCls: 'icon-cancel',
        onClick: function () {
            reqObj = null;
            reqObj.yearString = new Date().getFullYear();
            $queryListenCountFrom.form('reset');
            $qureGrid.datagrid('reload');
        }
    });

    /*********************达到节数***********************/
    function listenResult(value, row, index) {

        if (value>0) {
            return "<span style='color:blue;'>" + value + "</span>";
        } else {
            return "<span style='color:red;'>" + value + "</span>";
        }
    }

});
