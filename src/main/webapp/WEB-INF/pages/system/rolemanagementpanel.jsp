<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:26
  角色管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>


    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">


    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <script type="text/javascript"
            src="<c:url value="/static/js/system/rolemanagementpanel.js"/>"></script>

    <title>Title</title>
</head>

<body class="easyui-layout">
<div data-options="region:'west'" style="width: 50%">
    <table id="rolesGrid"></table>
</div>
<div data-options="region:'center'">
    <table id="reourecesTree"></table>
</div>
<!--新增窗口-->
<div id="addRolesWin">
    <form id="addRolesForm" class="control-form">
        <table class="table_list" style="text-align: right;margin:3px;width:99%">
            <tr>
                <th width="100"><label class="control-label required-mark" style="width:100px"
                                       required="required">角色名称

                </label>
                </th>
                <td width="200"><input class="easyui-textbox control" name="roleName" required="required"
                                       data-options="prompt:'请输入...'"/></td>
            </tr>

        </table>
    </form>

    <div id="addRolesWinFooter" style="text-align:center;padding:5px">
        <a id="addRolesWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
           style="margin-right:20px;">
            确认
        </a>
        <a id="addRolesWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
           class="easyui-linkbutton">
            取消
        </a>
    </div>
</div>

<!--修改窗口-->
<div id="editRolesWin">
    <form id="editRolesForm" class="control-form">
        <table class="table_list" style="text-align: right;margin:3px;width:99%">
            <tr>
                <th width="100"><label class="control-label required-mark" style="width:100px"
                                       required="required">角色名称

                </label>
                </th>
                <td width="200"><input class="easyui-textbox control" name="roleName" required="required"
                                       data-options="prompt:'请输入...'"/></td>
            </tr>

        </table>
    </form>

    <div id="editRolesWinFooter" style="text-align:center;padding:5px">
        <a id="editRolesWinSubmitBtn" href="javascript:void(0);" iconCls="icon-ok" class="easyui-linkbutton"
           style="margin-right:20px;">
            确认
        </a>
        <a id="editRolesWinCloseBtn" href="javascript:void(0);" iconCls="icon-cancel" style="margin-left:20px;"
           class="easyui-linkbutton">
            取消
        </a>
    </div>
</div>
</body>
</html>

