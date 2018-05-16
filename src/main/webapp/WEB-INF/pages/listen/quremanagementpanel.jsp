<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:20
  按人员查询
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <script src="../../../static/js/listen/quremanagementpanel.js"></script>
</head>

<body class="easyui-layout">

    <div style="height:135px" data-options="region:'north',collapsible:false">
        <form id="queryListenCountFrom" name="queryListenCountFrom" method="post">
            <table align="center" style="line-height: 30px;margin-top: 10px">
                <tr>
                    <td><span style="margin-left: 15px;">听课人员姓名</span></td>
                    <td><input class="easyui-textbox" name="listenerName" data-options="prompt:'请输入...'"/></td>


                    <td><span style="margin-left: 15px;">单位</span></td>
                    <td><input class="easyui-textbox" name="schoolName" data-options="prompt:'请输入...'"></td>
                </tr>

                <tr>
                    <td><span style="margin-left: 15px;">年份</span></td>
                    <td><select id="year" name="yearString"></select></td>

                </tr>
            </table>
            <table align="center" style="margin-bottom: 10px;margin-top: 10px">
                <tr>
                    <td colspan="7" style="text-align: center;">
                                    <span style="margin-left: 10px;">
                                        <a href="#" class="easyui-linkbutton"
                                           id="logSearch">确定</a>
                                        <a href="#" class="easyui-linkbutton"
                                           id="logResert" style="margin-left:25px">取消</a>
                                    </span>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div data-options="region:'center'">
        <table id="qureGrid"></table>
    </div>

    <!-- 查看详情表单 -->
    <div id="viewListenNoteWin">
        <%--<div class="easyui-layout" style="width: 425px;height: 330px;margin:10px 3px">--%>
            <%----%>
        <%--</div>--%>
            <div style="width:100%;height:100%" data-options="region:'west',collapsible:true">
                <table id="viewListenNoteGrid"></table>
            </div>
        <div id="viewListenNoteWinFooter" style="text-align:center;padding:5px">
            <a id="viewListenNoteWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" class="easyui-linkbutton"
               style="margin-right:20px;">
                返回
            </a>
        </div>
    </div>

</body>
</html>
