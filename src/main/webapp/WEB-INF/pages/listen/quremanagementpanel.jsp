<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:20
  按人员查询
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <%--<script src="../../../static/js/listen/quremanagementpanel.js"></script>--%>
    <script type="text/javascript"
            src="<c:url value="/static/js/listen/quremanagementpanel.js"/>"></script>
</head>

<body class="easyui-layout">

    <div style="height:137px" data-options="region:'north',collapsible:false">
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

    <!-- 查看听课记录窗口 -->
    <div id="viewListenNoteWin">

        <div style="height:103px" data-options="region:'north',collapsible:false">
            <form id="queryListenNoteFrom" name="queryListenNoteFrom" method="post">
                <table align="center" style="line-height: 30px;margin-top: 10px">
                    <tr>
                        <td><span style="margin-left: 15px;">听课起始时间</span></td>
                        <td><input class="easyui-datebox" name="beginDate" data-options="prompt:'请选择...'"/></td>


                        <td><span style="margin-left: 15px;">至</span></td>
                        <td><input class="easyui-datebox" name="endDate" data-options="prompt:'请选择...'"></td>
                    </tr>

                </table>
                <table align="center" style="margin-bottom: 10px;margin-top: 10px">
                    <tr>
                        <td colspan="7" style="text-align: center;">
                                    <span style="margin-left: 10px;">
                                        <a href="#" class="easyui-linkbutton"
                                           id="logSearchTwo">确定</a>
                                        <a href="#" class="easyui-linkbutton"
                                           id="logResertTwo" style="margin-left:25px">取消</a>
                                    </span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

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

    <!--听课记录详情-->
    <div id="detailListenNoteWin">
        <form id="detailListenNoteForm" class="control-form">
            <table class="table_list" style="text-align: right;margin:3px;width:99%">
                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">听课学校

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="schoolName" readonly="readonly"/></td>

                    <th width="120"><label class="control-label required-mark" style="width:100px">班级名称

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="className" readonly="readonly"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">学科

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="disciplineName" readonly="readonly"/></td>

                    <th width="120"><label class="control-label required-mark" style="width:100px">执教老师

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="teacherName" readonly="readonly"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">评分

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="scoreName" readonly="readonly"/></td>

                    <th width="120"><label class="control-label required-mark" style="width:100px">是否分享

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="shareFlag" readonly="readonly"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">听课地址

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="listenPath" readonly="readonly"/></td>

                    <th width="120"><label class="control-label required-mark" style="width:100px">听课时间

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="createDate" readonly="readonly"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">听课内容

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" style="height: 150px" data-options="multiline:true" name="comments" readonly="readonly"/></td>

                    <th width="120"><label class="control-label required-mark" style="width:100px">听课图片

                    </label>
                    </th>
                    <td width="200" id="listenerPicture"></td>
                </tr>



            </table>
        </form>

        <div id="detailListenNoteWinFooter" style="text-align:center;padding:5px">
            <a id="detailListenNoteWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
               class="easyui-linkbutton">
                取消
            </a>
        </div>
    </div>

</body>
</html>
