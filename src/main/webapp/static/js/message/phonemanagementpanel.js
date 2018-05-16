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
                    $addMessageWin.window('open');
                }
            },
            {
                text: "修改", iconCls: 'icon-edit',
                handler: function () {

                    if (!selectedPhoneMess) {
                        showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
                    } else {
                        $editMessageForm.form('load', selectedPhoneMess);
                        $editMessageWin.window('open');
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

    /*************新增*******************/

    var $addMessageForm = $('#addMessageForm').form({
        novalidate: true
    });

    var $addMessageWin = $('#addMessageWin').window({
        title: "新增", closed: true, modal: true, height: 380,
        width: 600, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#addMessageWinFooter',
        onClose: function () {
            $('#addMessageForm').form('disableValidation').form('reset');
        }
    });

    $('#addMessageWinSubmitBtn').linkbutton({
        onClick: function () {
            if (!$('#addMessageForm').form('enableValidation').form('validate')) {
                return;
            }

            var messageData = $addMessageForm.serializeObject(),
                url = "/message/phonemanpage/add";


            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(messageData),
                success:function (r) {
                    $phoneMessGrid.datagrid('reload');
                    $addMessageWin.window('close');
                    showInfoMessage(SYSTEM_MESSAGE.msg_action_success)
                }
            })

        }
    });

    $('#addMessageWinCloseBtn').linkbutton({
        onClick: function () {
            $addMessageWin.window('close');
        }
    });

    /*************修改*******************/

    var $editMessageForm = $('#editMessageForm').form({
        novalidate: true
    });

    var $editMessageWin = $('#editMessageWin').window({
        title: "新增", closed: true, modal: true, height: 380,
        width: 600, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#editMessageWinFooter',
        onClose: function () {
            $('#editMessageForm').form('disableValidation').form('reset');
        }
    });

    $('#editMessageWinSubmitBtn').linkbutton({
        onClick: function () {
            if (!$('#editMessageForm').form('enableValidation').form('validate')) {
                return;
            }

            var messageData = $editMessageForm.serializeObject(),
                url = "/message/phonemanpage/edit";
            messageData.id = selectedPhoneMess.id;
            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(messageData),
                success:function (r) {
                    $phoneMessGrid.datagrid('reload');
                    $editMessageWin.window('close');
                    showInfoMessage(SYSTEM_MESSAGE.msg_action_success)
                }
            })

        }
    });

    $('#editMessageWinCloseBtn').linkbutton({
        onClick: function () {
            $editMessageWin.window('close');
        }
    });

    /************删除*************/

    function removeHandle() {
        if (!selectedPhoneMess) {
            showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
            return
        }



        var msg = String.format("您确定要删除公告：<span style='color: red;'>{0}</span>？", selectedPhoneMess.title);

        showConfirm(msg, function () {
            $.ajax({
                url:"/message/phonemanpage/delete/"+selectedPhoneMess.id,
                type:"GET",dataType:"json",
                success:function (r) {
                    $phoneMessGrid.datagrid('reload');
                }
            })
        })
    }

});