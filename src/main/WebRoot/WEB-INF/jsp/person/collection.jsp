<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>我的收藏</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/css/colstyle.css" rel="stylesheet" type="text/css">

</head>

<body>
<!--头 -->
<header>
    <article>
        <div class="mt-logo">
            <!--顶部导航条 -->
            <div class="am-container header">
                <ul class="message-l">
                    <div class="topMessage">
                        <div class="menu-hd">
                            <c:if test="${empty users}">
                                <a href="${ctx}/loginOrRegister/loginInput" target="_top" class="h">亲，请登录</a>
                                <a href="${ctx}/loginOrRegister/registerInput" target="_top">免费注册</a>
                            </c:if>
                            <c:if test="${!empty users}">
                                欢迎您,${users.nickName}
                                <a href="${ctx}/loginOrRegister/loginOut">注销</a>
                            </c:if>
                        </div>
                    </div>
                </ul>
                <ul class="message-r">
                    <div class="topMessage home">
                        <div class="menu-hd"><a href="${ctx}/" target="_top" class="h">商城首页</a></div>
                    </div>
                    <div class="topMessage my-shangcheng">
                        <div class="menu-hd MyShangcheng"><a href="${ctx}/users/allInfo" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                    </div>
                    <div class="topMessage mini-cart">
                        <div class="menu-hd"><a id="mc-menu-hd" href="${ctx}/shopping/shoppingCart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div>
                    </div>
                    <div class="topMessage favorite">
                        <div class="menu-hd"><a href="${ctx}/users/allCollects" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
                </ul>
            </div>

            <!--悬浮搜索框-->

            <div class="nav white">
                <div class="logoBig">
                    <li><img src="${ctx}/resources/images/logobig.png" /></li>
                </div>
                <div class="search-bar pr">
                    <a name="index_none_header_sysc" href="#"></a>
                    <form action="${ctx}/home/query" method="get">
                        <input id="searchInput" name="type" type="text" placeholder="搜索"
                               autocomplete="off" /> <input id="ai-topsearch"
                                                            class="submit am-btn" value="搜索" index="1" type="submit" />
                    </form>
                </div>
            </div>
            <b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="user-collection">
                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的收藏</strong> / <small>My&nbsp;Collection</small></div>
                </div>
                <hr/>

                <div class="you-like">
                    <div class="s-bar">
                        我的收藏
                    </div>
                    <div class="s-content">

                        <c:forEach items="${userCollects}" var="collect">
                        <div class="s-item-wrap">
                            <div class="s-item">

                                <div class="s-pic">
                                    <a href="#" class="s-pic-link">
                                        <img src="${ctx}/resources/images/0-item_pic.jpg_220x220.jpg" alt="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰" class="s-pic-img s-guess-item-img">
                                    </a>
                                </div>
                                <div class="s-info">
                                    <div class="s-title"><a href="#" title="包邮s925纯银项链女吊坠短款锁骨链颈链日韩猫咪银饰简约夏配饰">${collect.commodity.cname}</a></div>
                                    <div class="s-price-box">
                                        <span class="s-price"><em class="s-price-sign">¥</em><em class="s-value">${collect.commodity.price}</em></span>
                                        <span class="s-history-price"><em class="s-price-sign">¥</em><em class="s-value">${collect.commodity.forSalePrice}</em></span>
                                    </div>
                                </div>
                                <div class="s-tp">
                                    <i class="am-icon-shopping-cart"></i>
                                    <p>
                                        <a href="javascript:;" class="c-nodo J_delFav_btn">取消收藏</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>

                </div>

            </div>

        </div>
        <!--底部-->
        <div class="footer">
            <div class="footer-hd">
                <p>
                    <a href="#">恒望科技</a>
                    <b>|</b>
                    <a href="#">商城首页</a>
                    <b>|</b>
                    <a href="#">支付宝</a>
                    <b>|</b>
                    <a href="#">物流</a>
                </p>
            </div>
            <div class="footer-bd">
                <p>
                    <a href="#">关于恒望</a>
                    <a href="#">合作伙伴</a>
                    <a href="#">联系我们</a>
                    <a href="#">网站地图</a>
                    <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
                </p>
            </div>
        </div>
    </div>

    <aside class="menu">
        <ul>
            <li class="person active">
                <a href="${ctx}/users/allInfo">个人中心</a>
            </li>
            <li class="person">
                <a href="">个人资料</a>
                <ul>
                    <li> <a href="${ctx}/users/userInfo/${users.uid}">个人信息</a></li>
                    <li> <a href="${ctx}/users/safety">安全设置</a></li>
                    <li> <a href="${ctx}/users/getAddress">收货地址</a></li>
                </ul>
            </li>
            <li class="person">
                <a href="#">我的交易</a>
                <ul>
                    <li><a href="${ctx}/users/orders">订单管理</a></li>
                </ul>
            </li>
            <li class="person">
                <a href="#">我的资产</a>
                <ul>
                    <li> <a href="${ctx}/users/allCoupons">优惠券 </a></li>
                    <li> <a href="${ctx}/users/allRedPackage">红包</a></li>
                </ul>
            </li>

            <li class="person">
                <a href="#">我的小窝</a>
                <ul>
                    <li> <a href="${ctx}/users/allCollects">收藏</a></li>
                </ul>
            </li>

        </ul>

    </aside>
</div>

</body>

</html>
