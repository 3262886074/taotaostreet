<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>订单详情</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/css/orstyle.css" rel="stylesheet" type="text/css">

    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.js"></script>


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
                    <div class="topMessage">
                        <div class="menu-hd">
                            <a href="#" target="_top" class="h">亲，请登录</a>
                            <a href="#" target="_top">免费注册</a>
                        </div>
                    </div>
                </ul>
                <ul class="message-r">
                    <div class="topMessage home">
                        <div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
                    </div>
                    <div class="topMessage my-shangcheng">
                        <div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                    </div>
                    <div class="topMessage mini-cart">
                        <div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
                    </div>
                    <div class="topMessage favorite">
                        <div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
                </ul>
            </div>

            <!--悬浮搜索框-->

            <div class="nav white">
                <div class="logoBig">
                    <li><img src="${ctx}/resources/images/logobig.png" /></li>
                </div>

                <div class="search-bar pr">
                    <a name="index_none_header_sysc" href="#"></a>
                    <form>
                        <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
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

            <div class="user-orderinfo">

                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单详情</strong> / <small>Order&nbsp;details</small></div>
                </div>
                <hr/>
                <div class="order-infoaside">
                    <div class="order-addresslist">
                        <div class="order-address">
                            <div class="icon-add">
                            </div>
                            <p class="new-tit new-p-re">
                                <span class="new-txt">${order.userAddress.uaname}</span>
                                <span class="new-txt-rd2">${order.userAddress.uatel}</span>
                            </p>
                            <div class="new-mu_l2a new-p-re">
                                <p class="new-mu_l2cw">
                                    <span class="title">收货地址：</span>
                                    <span class="province">${order.userAddress.location}</span>省
                                    <span class="street">${order.userAddress.address}</span></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="order-infomain">

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

                        <div class="order-status3">
                            <div class="order-title">
                                <div class="dd-num">订单编号：<a href="javascript:;">${order.oid}</a></div>
                                <span>创建时间：<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日"/></span>
                                <!--    <em>店铺：小桔灯</em>-->
                            </div>
                            <div class="order-content">
                                <div class="order-left">
                                    <c:forEach items="${commodityItems}" var="item">
                                        <ul class="item-list">
                                        <li class="td td-item">
                                            <div class="item-pic">
                                                <a href="#" class="J_MakePoint">
                                                    <img src="${item.commodity.commodityPics.cpImg}" class="itempic J_ItemImg">
                                                </a>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-basic-info">
                                                    <a href="#">
                                                        <p>${item.commodity.cname}</p>
                                                        <p class="info-little">类型：${item.commodityType.typeName}
                                                            <br/>包装：${item.commodityCombo.ccname} </p>
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
                                        <li class="td td-operation">
                                            <div class="item-operation">
                                                <%--退款/退货--%>
                                            </div>
                                        </li>
                                    </ul>
                                    </c:forEach>
                                </div>
                                <div class="order-right">
                                    <li class="td td-amount">
                                        <div class="item-amount">
                                            合计：￥${order.money}
                                            <%--<p>含运费：<span>10.00</span></p>--%>
                                        </div>
                                    </li>
                                    <div class="move-right">
                                        <li class="td td-status">
                                            <c:if test="${order.status == -1}">
                                                <div class="item-status">
                                                    <p class="Mystatus">等待付款</p>
                                                    <p class="order-info">
                                                        <a id="cancel${order.oid}">取消订单</a>
                                                    </p>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 0}">
                                                <div class="item-status">
                                                    <p class="Mystatus">等待发货</p>
                                                    <p class="order-info">
                                                        <a id="cancel${order.oid}">取消订单</a>
                                                    </p>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 1}">
                                                <div class="item-status">
                                                    <p class="Mystatus">在途中</p>
                                                    <p class="order-info">
                                                        <a id="cancel${order.oid}">取消订单</a>
                                                    </p>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 2}">
                                                <div class="item-status">
                                                    <p class="Mystatus">待评价</p>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 3}">
                                                <div class="item-status">
                                                    <p class="Mystatus">已完成</p>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 4}">
                                                <div class="item-status">
                                                    <p class="Mystatus">已取消</p>
                                                </div>
                                            </c:if>
                                        </li>
                                        <li class="td td-change">
                                            <c:if test="${order.status == -1}">
                                                <div id="pay${order.oid}" class="am-btn am-btn-danger anniu">
                                                    一键支付
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 0}">
                                                <div class="am-btn am-btn-danger anniu">
                                                    <a id="cancel${order.key.oid}">取消订单</a>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 1}">
                                                <div class="am-btn am-btn-danger anniu">
                                                    <a id="confirm${order.key.oid}">确认收货</a>
                                                </div>
                                            </c:if>
                                            <c:if test="${order.status == 2}">
                                                <div class="am-btn am-btn-danger anniu">
                                                    去评价
                                                </div>
                                            </c:if>
                                        </li>
                                    </div>
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
                <a href="">我的资产</a>
                <ul>
                    <li> <a href="${ctx}/users/allCoupons">优惠券 </a></li>
                    <li> <a href="${ctx}/users/allRedPackage">红包</a></li>
                </ul>
            </li>

            <li class="person">
                <a href="">我的小窝</a>
                <ul>
                    <li> <a href="${ctx}/users/allCollects">收藏</a></li>
                </ul>
            </li>

        </ul>

    </aside>
</div>

</body>

</html>
