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



</body>
</html>
