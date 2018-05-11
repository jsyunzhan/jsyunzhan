<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2018/5/8
  Time: 8:26
  角色管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <link href="../../../static/easyui/themes/default/easyui.css" rel="stylesheet" />
    <link href="../../../static/easyui/themes/icon.css" rel="stylesheet" />
    <script src="../../../static/easyui/jquery.min.js"></script>
    <script src="../../../static/easyui/jquery.easyui.min.js"></script>
    <script src="../../../static/js/untis/jquery.jdirk.js"></script>



    <link href="../../../static/css/customer.css" rel="stylesheet" />
    <script src="../../../static/easyui/locale/easyui-lang-zh_CN.js"></script>



    <script src="../../../static/js/system/rolemanagementpanel.js"></script>
    <script src="../../../static/js/untis/datautils.js"></script>
    <title>Title</title>
</head>

<body class="easyui-layout">
<div data-options="region:'center'">
    <table id="rolesGrid"></table>
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
                <td width="200"><input class="easyui-textbox control" name="roleName" required="required"/></td>
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
</body>
</html>

