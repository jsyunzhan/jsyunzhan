<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">

    <%--<link rel="shortcut icon" href="../../static/images/favicon.ico">--%>

    <jsp:include flush="true" page="/WEB-INF/pages/commons/servercommonjs.jsp"/>

    <%--以上三个meta不可或缺--%>
    <%--<link rel="stylesheet" href="../../static/bootstrap-3.3.7-dist/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="../../static/css/public.css">--%>
    <%--<link rel="stylesheet" href="../../static/css/login.css">--%>

    <link rel="shortcut icon" href="<c:url value="/static/images/favicon.ico"/>">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/css/public.css"/>"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/static/css/login.css"/>"/>


    <%--<script src="../../static/jquery/jquery-1.7.2.min.js"></script>--%>
    <%--<script src="../../static/js/public.js"></script>--%>
    <%--<script src="../../static/js/login.js"></script>--%>
    <%--<script src="../../static/js/untis/jquery.jdirk.js"></script>--%>

    <script type="text/javascript"
            src="<c:url value="/static/jquery/jquery-1.7.2.min.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/js/public.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/js/login.js"/>"></script>
    <script type="text/javascript"
            src="<c:url value="/static/js/untis/jquery.jdirk.js"/>"></script>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <title>后台登录</title>
</head>
<body>
    <div class="container-fluid m0 p0">
        <div class="banner">
            <img src="${APP_PATH}/static/images/login_banner.jpg">
        </div>
        <div class="login round5 bor_gray">
            <div class="w80 mtb30 f18 gray_1">LOGIN</div>
            <form id="loginForm">
                <div class="w80 mtb20 pr">
                    <div class="icon pa">
                        <img src="${APP_PATH}/static/images/ic_username.png">
                    </div>
                    <input type="text" placeholder="请输入用户名" name="loginName" class="btn w100 bor_gray b_gray username tl">
                </div>
                <div class="w80 mtb20 pr">
                    <div class="icon pa">
                        <img src="${APP_PATH}/static/images/ic_password.png">
                    </div>
                    <input type="password" placeholder="请输入密码" name="password" class="btn w100 bor_gray b_gray password tl">
                </div>
                <div class="w80 mtb20 f12 tc gray_1" id="userError">（请输入用户名及密码）</div>
            </form>
            <div class="w80 mtb20">
                <input id="loginBtn" type="submit" class="btn btn-primary w100" value="登录">
            </div>
        </div>
    </div>
</body>

</html>