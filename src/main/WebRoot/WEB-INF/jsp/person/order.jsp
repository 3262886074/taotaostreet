<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>订单管理</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/css/orstyle.css" rel="stylesheet" type="text/css">

    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
    $(function () {
        //一键支付
        $("div[id^=pay]").click(function () {
            if (confirm("确定要支付吗?")) {
                //被点击的按钮id
                var idStr = $(this).attr("id");
                //截取最后的数字 不管是几位数字
                var id = idStr.substring(3, idStr.length);
                var url = "${ctx}/users/pay/" + id;
                $.post(url, {}, function (data) {
                    alert(data.object.stateInfo);
                    if (data.object.userAddress != null) {
                        parent.location.href = "${ctx}/users/paySuccess/" + id;
                    }
                });
            }
            return false;
        });
        //取消订单
        $("a[id^=cancel]").click(function () {
           if (confirm("确定要取消订单吗?")){
               //被点击的按钮id
               var idStr = $(this).attr("id");
               //截取最后的数字 不管是几位数字
               var id = idStr.substring(6, idStr.length);
               var url = "${ctx}/users/cancelOrder/" + id;
               $.post(url, {}, function (data) {
                   if (data == 1) {
                       alert("成功");
                       parent.location.href = "${ctx}/users/orders";
                   } else {
                       alert("失败");
                   }
               });
           }
            return false;
        });
        //确认收货
        $("a[id^=confirm]").click(function () {
            if (confirm("确定要确认收货吗?")){
                //被点击的按钮id
                var idStr = $(this).attr("id");
                //截取最后的数字 不管是几位数字
                var id = idStr.substring(7, idStr.length);
                var url = "${ctx}/users/confirmOrder/" + id;
                $.post(url, {}, function (data) {
                    if (data == 1) {
                        alert("成功");
                        parent.location.href = "${ctx}/users/orders";
                    } else {
                        alert("失败");
                    }
                });
            }
            return false;
        });
    })
</script>
<body>
<!--头 -->
<header>
    <article>
        <div class="mt-logo">
            <!--顶部导航条 -->
            <div class="am-container header">
                <ul class="message-l">
                    <div class="menu-hd">
                        <c:if test="${empty users}">
                            <a href="${ctx}/loginOrRegister/loginInput" target="_top" class="h">亲，请登录</a>
                            <a href="${ctx}/loginOrRegister/registerInput" target="_top">免费注册</a>
                        </c:if>
                        <c:if test="${!empty users}">
                            <a href="${ctx}/loginOrRegister/loginOut">注销</a>
                        </c:if>
                    </div>
                </ul>
                <ul class="message-r">
                    <div class="topMessage home">
                        <div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
                    </div>
                    <div class="topMessage my-shangcheng">
                        <div class="menu-hd MyShangcheng"><a href="${ctx}/users/allInfo" target="_top"><i
                                class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                    </div>
                    <div class="topMessage mini-cart">
                        <div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i
                                class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum"
                                                                                                      class="h">0</strong></a>
                        </div>
                    </div>
                    <div class="topMessage favorite">
                        <div class="menu-hd"><a href="${ctx}/users/allCollects" target="_top"><i
                                class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
                </ul>
            </div>

            <!--悬浮搜索框-->

            <div class="nav white">
                <div class="logoBig">
                    <li><img src="${ctx}/resources/images/logobig.png"/></li>
                </div>

                <div class="search-bar pr">
                    <a name="index_none_header_sysc" href="#"></a>
                    <form>
                        <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索"
                               autocomplete="off">
                        <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
                    </form>
                </div>
            </div>

            <div class="clear"></div>
        </div>
        </div>
    </article>
</header>
<div class="nav-table">
    <div class="long-title"><span class="all-goods">全部分类</span></div>
    <div class="nav-cont">
        <ul>
            <li class="index"><a href="#">首页</a></li>
            <li class="qc"><a href="#">闪购</a></li>
            <li class="qc"><a href="#">限时抢</a></li>
            <li class="qc"><a href="#">团购</a></li>
            <li class="qc last"><a href="#">大包装</a></li>
        </ul>
        <div class="nav-extra">
            <i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
            <i class="am-icon-angle-right" style="padding-left: 10px;"></i>
        </div>
    </div>
</div>
<b class="line"></b>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">

            <div class="user-order">

                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> /
                        <small>Order</small>
                    </div>
                </div>
                <hr/>

                <div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

                    <ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
                        <li class="am-active"><a href="#tab1">所有订单</a></li>
                        <li><a href="#tab2">待付款</a></li>
                        <li><a href="#tab3">待发货</a></li>
                        <li><a href="#tab4">待收货</a></li>
                        <li><a href="#tab5">待评价</a></li>
                    </ul>
                    <%-- 所有订单 --%>
                    <div class="am-tabs-bd">
                        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-price">
                                    <td class="td-inner">单价</td>
                                </div>
                                <div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
                                </div>
                                <div class="th th-amount">
                                    <td class="td-inner">合计</td>
                                </div>
                                <div class="th th-status">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>
                            <%-- 所有订单 --%>
                            <div class="order-main">
                                <div class="order-list">
                                    <!--交易成功-->
                                    <c:forEach items="${orders}" var="order">
                                        <div class="order-status3">
                                            <div class="order-title">
                                                <div class="dd-num">订单编号：<a href="">${order.key.oid}</a></div>
                                                <span>创建时间：<fmt:formatDate value="${order.key.createTime}"
                                                                           pattern="yyyy年MM月dd日"/></span>
                                                <!--    <em>店铺：小桔灯</em>-->
                                            </div>
                                            <div class="order-content">
                                                <div class="order-left">
                                                    <c:forEach items="${order.value}" var="item">
                                                        <ul class="item-list">
                                                            <li class="td td-item">
                                                                <div class="item-pic">
                                                                    <a href="#" class="J_MakePoint">
                                                                        <img src="${item.commodity.commodityPics.cpImg}"
                                                                             class="itempic J_ItemImg">
                                                                    </a>
                                                                </div>
                                                                <div class="item-info">
                                                                    <div class="item-basic-info">
                                                                        <a href="#">
                                                                            <p>${item.commodity.cname}</p>
                                                                            <p class="info-little">
                                                                                类型：${item.commodityType.typeName}
                                                                                <br/>包装：${item.commodityCombo.ccname}
                                                                            </p>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="td td-price">
                                                                <div class="item-price">
                                                                    ￥${item.commodity.price}
                                                                </div>
                                                            </li>
                                                            <li class="td td-number">
                                                                <div class="item-number">
                                                                    <span>×</span>${item.number}
                                                                </div>
                                                            </li>
                                                            <li class="td td-operation">
                                                                <div class="item-operation">
                                                                        <%--<a href="refund.html">退款/退货</a>--%>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </c:forEach>
                                                </div>
                                                <div class="order-right">
                                                    <li class="td td-amount">
                                                        <div class="item-amount">
                                                            合计：￥${order.key.money}
                                                        </div>
                                                    </li>
                                                    <div class="move-right">
                                                        <li class="td td-status">
                                                        <c:if test="${order.key.status == -1}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">未付款</p>
                                                                <p class="order-info"><a
                                                                        href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                                <p class="order-info">
                                                                    <a id="cancel${order.key.oid}">取消订单</a>
                                                                </p>
                                                            </div>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="pay${order.key.oid}"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        一键支付
                                                                    </div>
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${order.key.status == 0}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">待发货</p>
                                                                <p class="order-info"><a
                                                                        href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                                <p class="order-info">
                                                                    <a id="cancel${order.key.oid}">取消订单</a>
                                                                </p>
                                                            </div>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="cancel"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        <a id="confirm${order.key.oid}">确认收货</a>
                                                                    </div>
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${order.key.status == 1}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">在途中</p>
                                                                <p class="order-info"><a href="">查看物流</a></p>
                                                                <p class="order-info">
                                                                    <a href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                                <p class="order-info"><a id="confirm${order.key.oid}">确认收货</a></p>
                                                            </div>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="cancel"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        <a id="cancel${order.key.oid}">取消订单</a>
                                                                    </div>
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${order.key.status == 2}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">待评价</p>
                                                                <p class="order-info"><a
                                                                        href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                                <p class="order-info"><a href="logistics.html">立即评价</a></p>
                                                            </div>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="comment"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        <a href="${ctx}/users/commentInput/${order.key.oid}">立即评价</a>
                                                                    </div>
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${order.key.status == 3}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">已完成</p>
                                                                <p class="order-info"><a
                                                                        href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                            </div>
                                                            <%--<p class="order-info"><a href="logistics.html">退货/售后</a></p>--%>
                                                        </c:if>
                                                        <c:if test="${order.key.status == 4}">
                                                            <div class="item-status">
                                                                <p class="Mystatus">已取消</p>
                                                                <p class="order-info">
                                                                    <a href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                </p>
                                                            </div>
                                                            <%--<p class="order-info"><a href="logistics.html">退货/售后</a></p>--%>
                                                        </c:if>
                                                        </li>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <%-- 待付款 --%>
                        <div class="am-tab-panel am-fade" id="tab2">

                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-price">
                                    <td class="td-inner">单价</td>
                                </div>
                                <div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
                                </div>
                                <div class="th th-amount">
                                    <td class="td-inner">合计</td>
                                </div>
                                <div class="th th-status">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <div class="order-main">
                                <div class="order-list">
                                    <c:forEach items="${orders}" var="order">
                                        <c:if test="${order.key.status == -1}">
                                            <div class="order-status3">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="">${order.key.oid}</a></div>
                                                    <span>创建时间：<fmt:formatDate value="${order.key.createTime}"
                                                                               pattern="yyyy年MM月dd日"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
                                                </div>
                                                <div class="order-content">
                                                    <div class="order-left">
                                                        <c:forEach items="${order.value}" var="item">
                                                            <ul class="item-list">
                                                                <li class="td td-item">
                                                                    <div class="item-pic">
                                                                        <a href="#" class="J_MakePoint">
                                                                            <img src="${item.commodity.commodityPics.cpImg}"
                                                                                 class="itempic J_ItemImg">
                                                                        </a>
                                                                    </div>
                                                                    <div class="item-info">
                                                                        <div class="item-basic-info">
                                                                            <a href="#">
                                                                                <p>${item.commodity.cname}</p>
                                                                                <p class="info-little">
                                                                                    类型：${item.commodityType.typeName}
                                                                                    <br/>包装：${item.commodityCombo.ccname}
                                                                                </p>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="td td-price">
                                                                    <div class="item-price">
                                                                            ${item.commodity.price}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-number">
                                                                    <div class="item-number">
                                                                        <span>×</span>${item.number}
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="order-right">
                                                        <li class="td td-amount">
                                                            <div class="item-amount">
                                                                合计：￥${order.key.money}
                                                            </div>
                                                        </li>
                                                        <div class="move-right">
                                                            <li class="td td-status">
                                                                <div class="item-status">
                                                                    <p class="Mystatus">未付款</p>
                                                                    <p class="order-info"><a
                                                                            href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                    </p>
                                                                    <p class="order-info">
                                                                        <a id="cancel${order.key.oid}">取消订单</a>
                                                                    </p>
                                                                </div>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="pay${order.key.oid}"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        一键支付
                                                                    </div>
                                                                </a>
                                                            </li>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>

                            </div>
                        </div>
                        <%-- 待发货 --%>
                        <div class="am-tab-panel am-fade" id="tab3">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-price">
                                    <td class="td-inner">单价</td>
                                </div>
                                <div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
                                </div>
                                <div class="th th-amount">
                                    <td class="td-inner">合计</td>
                                </div>
                                <div class="th th-status">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <div class="order-main">
                                <div class="order-list">

                                    <c:forEach items="${orders}" var="order">
                                        <c:if test="${order.key.status == 0}">
                                            <div class="order-status3">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="">${order.key.oid}</a></div>
                                                    <span>创建时间：<fmt:formatDate value="${order.key.createTime}"
                                                                               pattern="yyyy年MM月dd日"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
                                                </div>
                                                <div class="order-content">
                                                    <div class="order-left">
                                                        <c:forEach items="${order.value}" var="item">
                                                            <ul class="item-list">
                                                                <li class="td td-item">
                                                                    <div class="item-pic">
                                                                        <a href="#" class="J_MakePoint">
                                                                            <img src="${item.commodity.commodityPics.cpImg}"
                                                                                 class="itempic J_ItemImg">
                                                                        </a>
                                                                    </div>
                                                                    <div class="item-info">
                                                                        <div class="item-basic-info">
                                                                            <a href="#">
                                                                                <p>${item.commodity.cname}</p>
                                                                                <p class="info-little">
                                                                                    类型：${item.commodityType.typeName}
                                                                                    <br/>包装：${item.commodityCombo.ccname}
                                                                                </p>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="td td-price">
                                                                    <div class="item-price">
                                                                        ￥${item.commodity.price}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-number">
                                                                    <div class="item-number">
                                                                        <span>×</span>${item.number}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">
                                                                            <%--<a href="refund.html">退款/退货</a>--%>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="order-right">
                                                        <li class="td td-amount">
                                                            <div class="item-amount">
                                                                合计：￥${order.key.money}
                                                            </div>
                                                        </li>
                                                        <div class="move-right">
                                                            <li class="td td-status">
                                                                <div class="item-status">
                                                                    <p class="Mystatus">已付款</p>
                                                                    <p class="order-info"><a
                                                                            href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                    </p>
                                                                    <p class="order-info">
                                                                        <a id="cancel${order.key.oid}">取消订单</a>
                                                                    </p>
                                                                </div>
                                                            </li>
                                                            <li class="td td-change">
                                                                <a>
                                                                    <div id="cancel"
                                                                         class="am-btn am-btn-danger anniu">
                                                                        <a id="confirm${order.key.oid}">确认收货</a>
                                                                    </div>
                                                                </a>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>
                        <%-- 待收货 --%>
                        <div class="am-tab-panel am-fade" id="tab4">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-price">
                                    <td class="td-inner">单价</td>
                                </div>
                                <div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
                                </div>
                                <div class="th th-amount">
                                    <td class="td-inner">合计</td>
                                </div>
                                <div class="th th-status">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <div class="order-main">
                                <div class="order-list">

                                    <c:forEach items="${orders}" var="order">
                                        <c:if test="${order.key.status == 1}">
                                            <div class="order-status3">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="">${order.key.oid}</a></div>
                                                    <span>创建时间：<fmt:formatDate value="${order.key.createTime}"
                                                                               pattern="yyyy年MM月dd日"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
                                                </div>
                                                <div class="order-content">
                                                    <div class="order-left">
                                                        <c:forEach items="${order.value}" var="item">
                                                            <ul class="item-list">
                                                                <li class="td td-item">
                                                                    <div class="item-pic">
                                                                        <a href="#" class="J_MakePoint">
                                                                            <img src="${item.commodity.commodityPics.cpImg}"
                                                                                 class="itempic J_ItemImg">
                                                                        </a>
                                                                    </div>
                                                                    <div class="item-info">
                                                                        <div class="item-basic-info">
                                                                            <a href="#">
                                                                                <p>${item.commodity.cname}</p>
                                                                                <p class="info-little">
                                                                                    类型：${item.commodityType.typeName}
                                                                                    <br/>包装：${item.commodityCombo.ccname}
                                                                                </p>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="td td-price">
                                                                    <div class="item-price">
                                                                        ￥${item.commodity.price}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-number">
                                                                    <div class="item-number">
                                                                        <span>×</span>${item.number}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">
                                                                            <%--<a href="refund.html">退款/退货</a>--%>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="order-right">
                                                        <li class="td td-amount">
                                                            <div class="item-amount">
                                                                合计：￥${order.key.money}
                                                            </div>
                                                        </li>
                                                        <div class="move-right">
                                                            <li class="td td-status">
                                                                <div class="item-status">
                                                                    <p class="Mystatus">在途中</p>
                                                                    <p class="order-info"><a
                                                                            href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                    </p>
                                                                    <p class="order-info">
                                                                        <a id="cancel${order.key.oid}">取消订单</a>
                                                                    </p>
                                                                </div>
                                                                <li class="td td-change">
                                                                    <a>
                                                                        <div id="cancel"
                                                                             class="am-btn am-btn-danger anniu">
                                                                            <a id="confirm${order.key.oid}">确认收货</a>
                                                                        </div>
                                                                    </a>
                                                                </li>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>
                        <%-- 待评价 --%>
                        <div class="am-tab-panel am-fade" id="tab5">
                            <div class="order-top">
                                <div class="th th-item">
                                    <td class="td-inner">商品</td>
                                </div>
                                <div class="th th-price">
                                    <td class="td-inner">单价</td>
                                </div>
                                <div class="th th-number">
                                    <td class="td-inner">数量</td>
                                </div>
                                <div class="th th-operation">
                                    <td class="td-inner">商品操作</td>
                                </div>
                                <div class="th th-amount">
                                    <td class="td-inner">合计</td>
                                </div>
                                <div class="th th-status">
                                    <td class="td-inner">交易状态</td>
                                </div>
                                <div class="th th-change">
                                    <td class="td-inner">交易操作</td>
                                </div>
                            </div>

                            <div class="order-main">
                                <div class="order-list">
                                    <!--不同状态的订单	-->
                                    <c:forEach items="${orders}" var="order">
                                        <c:if test="${order.key.status == 2}">
                                            <div class="order-status3">
                                                <div class="order-title">
                                                    <div class="dd-num">订单编号：<a href="">${order.key.oid}</a></div>
                                                    <span>创建时间：<fmt:formatDate value="${order.key.createTime}"
                                                                               pattern="yyyy年MM月dd日"/></span>
                                                    <!--    <em>店铺：小桔灯</em>-->
                                                </div>
                                                <div class="order-content">
                                                    <div class="order-left">
                                                        <c:forEach items="${order.value}" var="item">
                                                            <ul class="item-list">
                                                                <li class="td td-item">
                                                                    <div class="item-pic">
                                                                        <a href="#" class="J_MakePoint">
                                                                            <img src="${item.commodity.commodityPics.cpImg}"
                                                                                 class="itempic J_ItemImg">
                                                                        </a>
                                                                    </div>
                                                                    <div class="item-info">
                                                                        <div class="item-basic-info">
                                                                            <a href="#">
                                                                                <p>${item.commodity.cname}</p>
                                                                                <p class="info-little">
                                                                                    类型：${item.commodityType.typeName}
                                                                                    <br/>包装：${item.commodityCombo.ccname}
                                                                                </p>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="td td-price">
                                                                    <div class="item-price">
                                                                        ￥${item.commodity.price}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-number">
                                                                    <div class="item-number">
                                                                        <span>×</span>${item.number}
                                                                    </div>
                                                                </li>
                                                                <li class="td td-operation">
                                                                    <div class="item-operation">
                                                                            <%--<a href="refund.html">退款/退货</a>--%>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="order-right">
                                                        <li class="td td-amount">
                                                            <div class="item-amount">
                                                                合计：￥${order.key.money}
                                                            </div>
                                                        </li>
                                                        <div class="move-right">
                                                            <li class="td td-status">
                                                                <div class="item-status">
                                                                    <p class="Mystatus">已完成</p>
                                                                    <p class="order-info"><a
                                                                            href="${ctx}/users/orderInfo/${order.key.oid}">订单详情</a>
                                                                    </p>
                                                                    <p class="order-info">
                                                                        <a href="${ctx}/users/commentInput/${order.key.oid}">立即评价</a>
                                                                    </p>
                                                                </div>
                                                                <li class="td td-change">
                                                                    <a>
                                                                        <div id="cancel"
                                                                            class="am-btn am-btn-danger anniu">
                                                                            <a href="${ctx}/users/commentInput/${order.key.oid}">立即评价</a>
                                                                        </div>
                                                                    </a>
                                                                </li>
                                                            </li>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>

                            </div>

                        </div>
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
                    <li><a href="${ctx}/users/userInfo/${users.uid}">个人信息</a></li>
                    <li><a href="${ctx}/users/safety">安全设置</a></li>
                    <li><a href="${ctx}/users/getAddress">收货地址</a></li>
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
                    <li><a href="${ctx}/users/allCoupons">优惠券 </a></li>
                    <li><a href="${ctx}/users/allRedPackage">红包</a></li>
                </ul>
            </li>

            <li class="person">
                <a href="#">我的小窝</a>
                <ul>
                    <li><a href="${ctx}/users/allCollects">收藏</a></li>
                </ul>
            </li>

        </ul>

    </aside>
</div>

</body>

</html>
