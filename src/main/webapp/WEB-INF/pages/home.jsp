<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%--以上三个meta不可或缺--%>
    <link rel="stylesheet" href="../../static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/css/public.css">
    <link rel="stylesheet" href="../../static/css/home.css">
    <script src="../../static/jquery/jquery-1.12.4.min.js"></script>
    <script src="../../static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="../../static/js/public.js"></script>
    <script src="../../static/js/home.js"></script>
    <title>后台首页</title>
</head>
<body class="b_gray2">
    <div class="container-fluid p0">
        <div class="tit_home row m0 pr white">
            <img src="../../static/images/tit_bg.jpg">
            <div class="pa title_project">高邮市教育局听课管理系统</div>
            <div class="pa"></div>
        </div>
        <div class="clearfix">
            <div class="sidebar tc white"></div>
            <div class="main_content">
                <iframe src="http://baidu.com" width="100%" height="300px"></iframe>
            </div>
        </div>
    </div>
</body>
<script>
    var roleId = "${roleId}";
</script>
</html>
