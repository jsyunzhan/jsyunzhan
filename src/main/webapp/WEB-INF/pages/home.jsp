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
            <img src="../../static/images/tit_bg.jpg" class="tit_bg">
            <div class="pa title_project">高邮市教育局听课管理系统</div>
            <div class="pa personal">
                <div class="clearfix">
                    <div style="width:30px; height:30px;">
                        <img src="../../static/images/person.png">
                    </div>
                    <div style="width:60px;line-height: 30px;">调研员</div>
                    <div style="width:16px; height: 16px;margin: 7px;">
                        <img src="../../static/images/white_down.png">
                    </div>
                </div>
                <ul class="dropdown-menu personal_ul">
                    <li class="clearfix">
                        <a href="javascript:;"><span><img src="../../static/images/modify.png"></span>忘记密码</a>
                    </li>
                    <li class="clearfix">
                        <a href="javascript:;"><span><img src="../../static/images/signOut.png"></span>退出登录</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clearfix">
            <div class="aa">
                <div class="sidebar tc white"></div>
            </div>
            <div class="main_content">
                <iframe src="" width="100%" height="300px"></iframe>
            </div>
        </div>
    </div>
</body>
<script>
    var roleId = "${roleId}";
</script>
</html>
