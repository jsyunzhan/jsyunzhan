<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:20
  听课人员管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <script src="../../../static/js/person/listenermanagementpanel.js"></script>
</head>

<body class="easyui-layout">

    <div style="height:110px" data-options="region:'north',collapsible:false">
        <form id="queryLitenerFrom" name="queryLitenerFrom" method="post">
            <table align="center" style="line-height: 30px;margin-top: 10px">
                <tr>
                    <td><span style="margin-left: 15px;">听课人员姓名</span></td>
                    <td><input class="easyui-textbox" name="listenerName" data-options="prompt:'请输入...'"/></td>

                    <%--<td><span style="margin-left: 15px;">听课人员身份证</td>--%>
                    <%--<td><input class="easyui-textbox" name="listenerNumb" data-options="prompt:'请输入...'"></td>--%>

                    <td><span style="margin-left: 15px;">单位</span></td>
                    <td><input class="easyui-textbox" name="schoolName" data-options="prompt:'请输入...'"></td>
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
        <table id="listenerGrid"></table>
    </div>

    <!--新增窗口-->
    <div id="addListenerWin">
        <form id="addListenerForm" class="control-form">
            <table class="table_list" style="text-align: right;margin:3px;width:99%">
                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px"
                                           required="required">听课人员姓名

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="listenerName" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">听课人员身份证

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="listenerNumb" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">单位

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="schoolName" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">是否拥有权限</label>
                    </th>
                    <td width="200">
                        <select class="easyui-combobox" name="permissionFlag" required="required" data-options="width:'169',panelHeight:'auto',editable:false">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </td>
                </tr>

            </table>
        </form>

        <div id="addListenerWinFooter" style="text-align:center;padding:5px">
            <a id="addListenerWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
               style="margin-right:20px;">
                确认
            </a>
            <a id="addListenerWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
               class="easyui-linkbutton">
                取消
            </a>
        </div>
    </div>

    <!--修改窗口-->
    <div id="editListenerWin">
        <form id="editListenerForm" class="control-form">
            <table class="table_list" style="text-align: right;margin:3px;width:99%">
                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px"
                                           required="required">听课人员姓名

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="listenerName" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">听课人员身份证

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="listenerNumb" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:110px"
                                           required="required">单位

                    </label>
                    </th>
                    <td width="200"><input class="easyui-textbox control" name="schoolName" required="required"
                                           data-options="prompt:'请输入...'"/></td>
                </tr>

                <tr>
                    <th width="120"><label class="control-label required-mark" style="width:100px">是否拥有权限</label>
                    </th>
                    <td width="200">
                        <select class="easyui-combobox" name="permissionFlag" required="required" data-options="width:'169',panelHeight:'auto',editable:false">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </td>
                </tr>

            </table>
        </form>

        <div id="editListenerWinFooter" style="text-align:center;padding:5px">
            <a id="editListenerWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
               style="margin-right:20px;">
                确认
            </a>
            <a id="editListenerWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
               class="easyui-linkbutton">
                取消
            </a>
        </div>
    </div>



</body>
</html>
