<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <link rel="stylesheet" href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"/>
    <link href="${ctx}/resources/css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
</head>
<body>

<div class="login-boxtitle">
    <a href="${ctx}/index.jsp"><img alt="logo" src="${ctx}/resources/images/logobig.png"/></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="${ctx}/resources/images/big.jpg"/></div>
        <div class="login-box">

            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form">
                <form action="${ctx}/loginOrRegister/login" method="post" id="loginForm">
                    <div class="user-name">
                        <label for="uname"><i class="am-icon-user"></i></label>
                        <input type="text" required name="nickname" id="uname" placeholder="用户名">
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" required name="pwd" id="password" placeholder="请输入密码">
                    </div>
                </form>
            </div>

            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                <a href="#" class="am-fr">忘记密码</a>
                <a href="${ctx}/loginOrRegister/registerInput" class="zcnext am-fr am-btn-default">注册</a>
                <br/>
            </div>
            <div class="am-cf">
                <input type="button" id="loginBtn" value="登 录" class="am-btn am-btn-primary am-btn-sm"/>
            </div>
        </div>
    </div>
</div>

<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="# ">恒望科技</a>
            <b>|</b>
            <a href="# ">商城首页</a>
            <b>|</b>
            <a href="# ">支付宝</a>
            <b>|</b>
            <a href="# ">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="# ">关于恒望</a>
            <a href="# ">合作伙伴</a>
            <a href="# ">联系我们</a>
            <a href="# ">网站地图</a>
        </p>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("#loginBtn").click(function () {
            var uname = $("#uname").val();
            var pwd = $("#password").val();
            var form = $("#loginForm");
            if (uname != '' && pwd != '') {
                form.submit();
            } else {
                alert("不能为空!");
            }
            return false;
        });
    });
</script>
</html>
