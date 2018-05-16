<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:20
  公告管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <script src="../../../static/js/message/phonemanagementpanel.js"></script>
</head>

<body class="easyui-layout">


    <div data-options="region:'center'">
        <table id="phoneMessGrid"></table>
    </div>

    <!--新增窗口-->
    <div id="addMessageWin">
        <form id="addMessageForm" class="control-form">
            <table class="table_list" style="text-align: right;margin:3px;width:99%">
                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px"
                                           required="required">公告标题

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" style="height:50px;width: 300px" name="title" required="required"
                                           data-options="multiline:true,prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">公告内容

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" style="height: 200px;width: 300px" name="message" required="required"
                                           data-options="multiline:true,prompt:'请输入...'"/></td>
                </tr>

            </table>
        </form>

        <div id="addMessageWinFooter" style="text-align:center;padding:5px">
            <a id="addMessageWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
               style="margin-right:20px;">
                确认
            </a>
            <a id="addMessageWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
               class="easyui-linkbutton">
                取消
            </a>
        </div>
    </div>

    <!--修改窗口-->
    <div id="editMessageWin">
        <form id="editMessageForm" class="control-form">
            <table class="table_list" style="text-align: right;margin:3px;width:99%">
                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px"
                                           required="required">公告标题

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" style="height:50px;width: 300px" name="title" required="required"
                                           data-options="multiline:true,prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">公告内容

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" style="height: 200px;width: 300px" name="message" required="required"
                                           data-options="multiline:true,prompt:'请输入...'"/></td>
                </tr>

            </table>
        </form>

        <div id="editMessageWinFooter" style="text-align:center;padding:5px">
            <a id="editMessageWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
               style="margin-right:20px;">
                确认
            </a>
            <a id="editMessageWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
               class="easyui-linkbutton">
                取消
            </a>
        </div>
    </div>

</body>
</html>
