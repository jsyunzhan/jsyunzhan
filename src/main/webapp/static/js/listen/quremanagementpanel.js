

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
                text: "查看笔记", iconCls: 'icon-add',
                handler: function () {
                    $viewListenNoteGrid.datagrid("options").url = 'quremanpage/notelist';
                    reqListenNoteObj.listenerId = selectedQure.id;
                    $viewListenNoteGrid.datagrid("load");
                    $viewListenNoteWin.window('open');
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

    var selectedListenNote, reqListenNoteObj = {};
    var $viewListenNoteGrid = $('#viewListenNoteGrid').datagrid({
        method: 'GET',
        rownumbers: true, animate: false, collapsible: true, idField: 'id', fit: true, striped: true,
        singleSelect: true,
        border: false,
        remoteSort: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 50, 100, 150],
        columns: [[
            {
                field: 'schoolName', title: "学校", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'className', title: "班级名称", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'disciplineName', title: "学科", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'teacherName', title: "执教老师", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'scoreName', title: "评分", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'shareFlag', title: "是否分享", width: 100, sortable: true,
                align: 'left',formatter:shareResult
            },{
                field: 'listenPath', title: "听课地址", width: 100, sortable: true,
                align: 'left'
            },{
                field: 'createDate', title: "听课时间", width: 100, sortable: true,
                align: 'left',formatter:formatDate
            }
        ]],
        toolbar: [
            {
                text: "查看详情", iconCls: 'icon-add',
                handler: function () {

                }
            }
        ],
        onBeforeLoad: function (param) {
            getPage(param);
            $.extend(param, reqListenNoteObj);
        },
        onSelect: function (index, row) {
            selectedListenNote = row;

        },
        onLoadSuccess: function () {
            selectedListenNote = $viewListenNoteGrid.datagrid('getSelected');
        }
    });

    /********************查询**************************/
    var $queryListenNoteFrom = $('#queryListenNoteFrom').form({
        novalidate: true
    });

    $('#logSearchTwo').linkbutton({
        iconCls: 'icon-ok',
        onClick: function () {
            reqListenNoteObj = $queryListenNoteFrom.serializeObject();
            reqListenNoteObj.listenerId = selectedQure.id;
            $viewListenNoteGrid.datagrid('load');
        }
    });

    $('#logResertTwo').linkbutton({
        iconCls: 'icon-cancel',
        onClick: function () {
            reqListenNoteObj = {};
            reqListenNoteObj.listenerId = selectedQure.id;
            $queryListenNoteFrom.form('reset');
            $viewListenNoteGrid.datagrid('reload');
        }
    });

    /*************查看详情*******************/

    var $viewListenNoteWin = $('#viewListenNoteWin').window({
        title: "查看笔记", closed: true, modal: true, height: 600,
        width: 1024, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#viewListenNoteWinFooter',
        onClose: function () {

        }
    });



    $('#viewListenNoteWinCloseBtn').linkbutton({
        onClick: function () {
            $viewListenNoteWin.window('close');
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

    /*********************是否分享***********************/
    function shareResult(value, row, index) {

        if (0 == value ) {
            return "<span style='color:red;'>" + '否' + "</span>";
        } else {
            return "<span style='color:blue;'>" + '是' + "</span>";
        }
    }

});
