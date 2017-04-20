<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.min.css"/>
    <link href="${ctx}/resources/css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</head>

<body>

<div class="login-boxtitle">
    <a href="${ctx}/index.jsp"><img alt="" src="${ctx}/resources/images/logobig.png"/></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="${ctx}/resources/images/big.jpg"/></div>
        <div class="login-box">

            <div class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li class="am-active"><a href="">注册</a></li>
                </ul>

                <div class="am-tabs-bd">
                    <form action="${ctx}/users/register" method="post" id="registerForm">

                        <div class="user-email">
                            <label for="uname"><i class="am-icon-envelope-o"></i></label>
                            <input type="email" name="nickname" id="uname" placeholder="请输入用户名">
                        </div>
                        <div class="user-pass">
                            <label for="password"><i class="am-icon-lock"></i></label>
                            <input type="password" name="pwd" id="password" placeholder="设置密码">
                        </div>
                        <div class="user-pass">
                            <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                            <input type="password" id="passwordRepeat" placeholder="确认密码">
                        </div>

                    </form>
                    <div class="am-tab-panel am-active">

                        <div class="login-links">
                            <label for="reader-me">
                                <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
                            </label>
                            <a href="${ctx}/users/loginInput" class="zcnext am-fr am-btn-default">登录</a>
                        </div>
                        <div class="am-cf">
                            <input type="submit" id="registerBtn" value="注册"
                                   class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>

                    </div>

                    <script>
                        $(function () {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

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
                <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
                    - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
            </p>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#registerBtn").click(function () {
            var uname = $("#uname").val();
            var pwd = $("#password").val();
            var register = $("#registerForm");
            if (uname != '' && pwd != '') {
                register.submit();
            } else {
                alert("不能为空!");
            }
            return false;
        });
    })
</script>
</html>