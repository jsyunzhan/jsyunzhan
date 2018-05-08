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
    <script src="../../static/js/home.js"></script>
    <title>后台首页</title>
</head>
<body>
    <div  class="container-fluid p0">
        <div class="tit_home row m0 pr white">
            <img src="../../static/images/tit_bg.jpg">
            <div class="pa title_project">高邮市教育局听课管理系统</div>
            <div class="pa tc time">2018-5-8 8:34</div>
        </div>
        <div>
            <div class="sidebar tc white">
                <div class="modular">
                    <div class="title_first" data-target="#modular_child1" data-toggle="collapse">
                        <div class="icon"></div>
                        评价查询
                        <div class=""></div>
                    </div>
                    <ul id="modular_child1" class="collapse">
                        <li>新增评价</li>
                        <li>评价管理</li>
                        <li>管理过往</li>
                    </ul>
                </div>
            </div>
            <div class="sidebar tc white">
                <div class="modular">
                    <div class="title_first" data-target="#modular_child2" data-toggle="collapse">
                        <div class="icon"></div>
                        评价查询
                        <div class=""></div>
                    </div>
                    <ul id="modular_child2" class="collapse">
                        <li>新增评价</li>
                        <li>评价管理</li>
                        <li>管理过往</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    var roleId = "${roleId}";
</script>
</html>
