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
    <form id="queryManufacturerFrom" name="queryOperationLogFrom" method="post">
        <table align="center" style="line-height: 30px;margin-top: 10px">
            <tr>
                <td><span style="margin-left: 15px;"><spring:message code="lab.manufacturer.manufacturer"/>听课人员姓名</td>
                <td><input id="manufacturer" class="easyui-textbox" name="manufacturer" data-options="prompt:'请输入...'"/></td>

                <td><span style="margin-left: 15px;"><spring:message code="lab.manufacturer.nationId"/>听课人员姓名</td>
                <td><input id="manufacturerNationId" class="easyui-textbox" name="nationId" data-options="prompt:'请输入...'"></td>
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



</body>
</html>
