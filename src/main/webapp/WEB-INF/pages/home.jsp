<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="../../static/bootstrap-3.3.7-dist/js/bootstrap.js">
    <script src="../../static/js/public.js"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>后台首页</title>
    <style>
        * {margin:0;padding:0;}
        #mobile-menu {position:fixed;top:0;left:0;width:220px;height:100%;background-color:#373737;z-index:9999;}
        a:hover ,a:focus{text-decoration:none}
        .mobile-nav ul li a {color:gray;display:block;padding:1em 5%;    border-top:1px solid #4f4f4f;border-bottom:1px solid #292929;transition:all 0.2s ease-out;cursor:pointer;#mobile-menu {position:fixed;top:0;left:0;width:220px;height:100%;background-color:#373737;z-index:9999;transition:all 0.3s ease-in;}}
        .mobile-nav ul li a:hover {background-color: #23A1F6;color: #ffffff;}
        .show-nav {transform:translateX(0);}
        .hide-nav {transform:translateX(-220px);} /*侧滑关键*/
        .mobile-nav-taggle {height:35px;line-height:35px;width:35px;background-color:#23A1F6;color:#ffffff;display:inline-block;text-align:center;cursor:pointer}
        .nav.avbar-inverse{position:relative;}
        .nav-btn {position:absolute;right:20px;top:20px;}
    </style>
</head>
<body>
    <!--手机导航栏-->
    <div id="mobile-menu" class="mobile-nav visible-xs visible-sm">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">Java</a></li>
            <li><a href="#">SVN</a></li>
            <li><a href="#">iOS</a></li>
        </ul>
    </div>
    <!--pc导航栏-->
    <nav class="navbar-inverse visible-lg visible-md" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">菜鸟教程</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">iOS</a></li>
                    <li><a href="#">SVN</a></li>
                    <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Java</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--手机导航栏侧滑-->
    <div class="nav-btn visible-xs visible-sm">
        <a href="#" class="mobile-nav-taggle" id="mobile-nav-taggle">
            <span class="glyphicon glyphicon-align-justify"></span>
        </a>
    </div>
</body>
</html>
