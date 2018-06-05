$(function () {

    /*****************下拉框加载************************/
    var $addRoleId = $('#addRoleType,#editRoleType').combobox({
        panelHeight: 'auto', valueField: 'id',
        textField: 'paramName', editable: false
    });
    // 获取听课人员角色
    $.ajax({
        url:path + "/paramters/ROLE_TYPE",
        type:"GET",
        dataType:"json",
        success:function (r) {
            $addRoleId.combobox('loadData',r);
        }
    });

    var selectedlistener, reqObj = {};
    var $listenerGrid = $('#listenerGrid').datagrid({
        url: path + '/person/listenermanpage/list', method: 'GET',
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
                field: 'roleType', title: "听课人员职务", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'schoolName', title: "单位", width: 100, sortable: true,
                align: 'left'
            },
            {
                field: 'permissionFlag', title: "是否拥有权限", width: 100, sortable: true,
                align: 'left',formatter:permissionResult
            },{
                field: 'openId', title: "是否注册", width: 100, sortable: true,
                align: 'left',formatter:registeredResult
            }

        ]],
        toolbar: [
            {
                text: "新增", iconCls: 'icon-add',
                handler: function () {
                    $addListenerWin.window('open');
                }
            },
            {
                text: "修改", iconCls: 'icon-edit',
                handler: function () {

                    if (!selectedlistener) {
                        showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
                    } else {
                        $editListenerForm.form('load', selectedlistener);
                        $editListenerWin.window('open');
                    }

                }
            },
            {
                text: "删除", iconCls: 'icon-remove',
                handler: function () {
                    removeHandle();
                }
            },
            {
                text: "授权", iconCls: 'icon-remove',
                handler: function () {

                    if (selectedlistener.permissionFlag == '1'){
                        showWarningMessage("该用户已经拥有权限，请重新选择！");
                        return
                    }

                    var msg = String.format("您确定要授权用户：<span style='color: red;'>{0}</span>？", selectedlistener.listenerName);

                    showConfirm(msg, function () {
                        $.ajax({
                            url:path + "/person/listenermanpage/authorization/"+selectedlistener.id,
                            type:"GET",dataType:"json",
                            success:function (r) {
                                $listenerGrid.datagrid('reload');
                            }
                        })
                    })

                }
            },
            {
                text: "解除授权", iconCls: 'icon-remove',
                handler: function () {

                    if (selectedlistener.permissionFlag == '0'){
                        showWarningMessage("该用户没有权限，请重新选择！");
                        return
                    }

                    var msg = String.format("您确定要解除用户权限：<span style='color: red;'>{0}</span>？", selectedlistener.listenerName);

                    showConfirm(msg, function () {
                        $.ajax({
                            url: path + "/person/listenermanpage/authorizationnot/"+selectedlistener.id,
                            type:"GET",dataType:"json",
                            success:function (r) {
                                $listenerGrid.datagrid('reload');
                            }
                        })
                    })

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

    /********************查询**************************/
    var $queryLitenerFrom = $('#queryLitenerFrom').form({
        novalidate: true
    });

    $('#logSearch').linkbutton({
        iconCls: 'icon-ok',
        onClick: function () {
            reqObj = $queryLitenerFrom.serializeObject();
            $listenerGrid.datagrid('load');
        }
    });

    $('#logResert').linkbutton({
        iconCls: 'icon-cancel',
        onClick: function () {
            reqObj = null;
            $queryLitenerFrom.form('reset');
            $listenerGrid.datagrid('reload');
        }
    });

    /*************新增*******************/

    var $addListenerForm = $('#addListenerForm').form({
        novalidate: true
    });

    var $addListenerWin = $('#addListenerWin').window({
        title: "新增", closed: true, modal: true, height: 258,
        width: 375, iconCls: 'icon-add', collapsible: false, minimizable: false,
        footer: '#addListenerWinFooter',
        onClose: function () {
            $('#addListenerForm').form('disableValidation').form('reset');
        }
    });

    $('#addListenerWinSubmitBtn').linkbutton({
        onClick: function () {
            if (!$('#addListenerForm').form('enableValidation').form('validate')) {
                return;
            }

            var listenerData = $addListenerForm.serializeObject(),
                url = path + "/person/listenermanpage/add";


            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(listenerData),
                success:function (r) {
                    $listenerGrid.datagrid('reload');
                    $addListenerWin.window('close');
                    showInfoMessage(SYSTEM_MESSAGE.msg_action_success)
                }
            })

        }
    });

    $('#addListenerWinCloseBtn').linkbutton({
        onClick: function () {
            $addListenerWin.window('close');
        }
    });

    /*************修改*******************/

    var $editListenerForm = $('#editListenerForm').form({
        novalidate: true
    });

    var $editListenerWin = $('#editListenerWin').window({
        title: "修改", closed: true, modal: true, height: 258,
        width: 375, iconCls: 'icon-edit', collapsible: false, minimizable: false,
        footer: '#editListenerWinFooter',
        onClose: function () {
            $('#editListenerForm').form('disableValidation').form('reset');
        }
    });

    $('#editListenerWinSubmitBtn').linkbutton({
        onClick: function () {
            if (!$('#editListenerForm').form('enableValidation').form('validate')) {
                return;
            }

            var listenerData = $editListenerForm.serializeObject(),
                url = path + "/person/listenermanpage/edit";

            listenerData.id = selectedlistener.id;

            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(listenerData),
                success:function (r) {
                    $listenerGrid.datagrid('reload');
                    $editListenerWin.window('close');
                    showInfoMessage(SYSTEM_MESSAGE.msg_action_success)
                }
            })

        }
    });

    $('#editListenerWinCloseBtn').linkbutton({
        onClick: function () {
            $editListenerWin.window('close');
        }
    });

    /************删除*************/

    function removeHandle() {
        if (!selectedlistener) {
            showWarningMessage(SYSTEM_MESSAGE.msg_please_select_record);
            return
        }

        if (selectedlistener.openId){
            showWarningMessage("该用户已经注册，不可删除！");
            return
        }

        var msg = String.format("您确定要删除用户：<span style='color: red;'>{0}</span>？", selectedlistener.listenerName);

        showConfirm(msg, function () {
            $.ajax({
                url: path + "/person/listenermanpage/delete/"+selectedlistener.id,
                type:"GET",dataType:"json",
                success:function (r) {
                    $listenerGrid.datagrid('reload');
                }
            })
        })
    }

    /*********************是否拥有权限***********************/
    function permissionResult(value, row, index) {

        if ('0' == value) {
            return "<span style='color:red;'>" + '否' + "</span>";
        } else if ('1' == value) {
            return "<span style='color:blue;'>" + '是' + "</span>";
        }
    }

    /*********************是否注册***********************/
    function registeredResult(value, row, index) {

        if ('' == value || null == value) {
            return "<span style='color:red;'>" + '否' + "</span>";
        } else {
            return "<span style='color:blue;'>" + '是' + "</span>";
        }
    }

});