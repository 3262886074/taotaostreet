<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>结算页面</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>

    <link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/cartstyle.css" rel="stylesheet" type="text/css"/>

    <link href="${ctx}/resources/css/jsstyle.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="${ctx}/resources/js/address.js"></script>

</head>

<body>

<!--顶部导航条 -->
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
            <div class="menu-hd MyShangcheng"><a href="${ctx}/users/allInfo" target="_top"><i
                    class="am-icon-user am-icon-fw"></i>个人中心</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="${ctx}/shopping/shoppingCart" target="_top"><i
                    class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div>
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
        <form action="${ctx}/home/query" method="get">
            <input id="searchInput" name="type" type="text" placeholder="搜索"
                   autocomplete="off"/> <input id="ai-topsearch"
                                               class="submit am-btn" value="搜索" index="1" type="submit"/>
        </form>
    </div>
</div>
<div class="clear"></div>

<div class="concent">
    <!--地址 -->
    <div class="paycont">
        <div class="address">
            <h3>确认收货地址 </h3>
            <%--<div class="control">--%>
                <%--<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>--%>
            <%--</div>--%>
            <div class="clear"></div>
            <ul>
                <%-- 开始遍历用户地址 --%>
                <c:forEach items="${userAddresses}" var="addr" varStatus="i">
                    <div class="per-border"></div>
                    <li id="addr${addr.uaId}" class="user-addresslist <c:if test="${i.count == 1}">defaultAddr</c:if>">
                    <div>
                        <input type="hidden" id="uaid${addr.uaId}" value="${addr.uaId}"/>
                        <input type="hidden" id="uaname${addr.uaId}" value="${addr.uaname}"/>
                        <input type="hidden" id="uatel${addr.uaId}" value="${addr.uatel}"/>
                        <input type="hidden" id="location${addr.uaId}" value="${addr.location}"/>
                        <input type="hidden" id="address${addr.uaId}" value="${addr.address}"/>
                    </div>
                    <div class="address-left">
                        <div class="user DefaultAddr">
                        <span class="buy-address-detail">
                            <span class="buy-user">${addr.uaname} </span>
                            <span class="buy-phone">${addr.uatel}</span>
                        </span>
                        </div>
                        <div class="default-address DefaultAddr">
                            <span class="buy-line-title buy-line-title-type">收货地址：</span>
                            <span class="buy--address-detail">
								<span class="province">${addr.location}</span>省
								<span class="street">${addr.address}</span>
							</span>
                        </div>
                        <c:if test="${addr.status == 1}">
                            <ins class="deftip">默认地址</ins>
                        </c:if>
                    </div>
                </li>
                </c:forEach>
                <%-- 结束 --%>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <div class="clear"></div>

        <!--订单 -->
        <div class="concent">
            <div id="payTable">
                <h3>确认订单信息</h3>
                <div class="cart-table-th">
                    <div class="wp">

                        <div class="th th-item">
                            <div class="td-inner">商品信息</div>
                        </div>
                        <div class="th th-price">
                            <div class="td-inner">价格</div>
                        </div>
                        <div class="th th-amount">
                            <div class="td-inner">数量</div>
                        </div>
                        <div class="th th-sum">
                            <div class="td-inner">金额</div>
                        </div>

                    </div>
                </div>
                <div class="clear"></div>

                <tr class="item-list">
                    <div class="bundle  bundle-last ">
                        <div class="clear"></div>
                        <div class="bundle-main">
                            <c:if test="${!empty commodityItems}">
                                <%-- 购物车商品 --%>
                                <c:forEach items="${commodityItems}" var="items">
                                    <ul class="item-content clearfix">
                                        <li class="td td-item">
                                            <div class="item-pic">
                                                <a href="#" target="_blank" data-title="" class="J_MakePoint"
                                                   data-point="tbcart.8.12">
                                                    <img src="${items.commodity.commodityPics.cpImg}"
                                                         class="itempic J_ItemImg" width="100%"></a>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-basic-info">
                                                    <a href="#" target="_blank" title="" class="item-title J_MakePoint"
                                                       data-point="tbcart.8.11">${items.commodity.cname}</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-price">
                                            <div class="item-price price-promo-promo">
                                                <div class="price-content">
                                                    <div class="price-line">
                                                        <em class="J_Price price-now"
                                                            tabindex="0">
                                                            <c:if test="${!empty items.commodity.forSalePrice}">
                                                                <%--<c:out value="${items.commodity.forSalePrice +--%>
                                                                <%--items.commodityType.price + items.commodityCombo.price}"/>--%>
                                                                <fmt:formatNumber value="${items.commodity.forSalePrice +
                                                                        items.commodityType.price + items.commodityCombo.price}"
                                                                                  type="currency" pattern="￥.0"/>
                                                            </c:if>
                                                            <c:if test="${empty items.commodity.forSalePrice}">
                                                                <fmt:formatNumber value="${items.commodity.price +
                                                                            items.commodityType.price + items.commodityCombo.price}"
                                                                                  type="currency" pattern="￥.0"/>
                                                            </c:if>
                                                        </em>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-amount">
                                            <div class="amount-wrapper ">
                                                <div class="item-amount ">
                                                    <div class="sl">
                                                        <input class="text_box" name="" type="text" disabled
                                                               value="${items.number}" style="width:30px;"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-sum">
                                            <div class="td-inner">
                                                <em tabindex="0" class="J_ItemSum number">
                                                    <c:if test="${!empty items.commodity.forSalePrice}">
                                                        <%--<c:out value="${(items.commodity.forSalePrice +--%>
                                                        <%--items.commodityType.price +--%>
                                                        <%--items.commodityCombo.price) * items.number}"/>--%>
                                                        <fmt:formatNumber value="${(items.commodity.forSalePrice +
                                                    items.commodityType.price +
                                                    items.commodityCombo.price) * items.number}" type="currency" pattern="￥.0"/>
                                                        <input type="hidden" id="sum${items.ciId}" value="${(items.commodity.forSalePrice +
                                                    items.commodityType.price +
                                                    items.commodityCombo.price) * items.number}"/>
                                                    </c:if>
                                                    <c:if test="${empty items.commodity.forSalePrice}">
                                                        <fmt:formatNumber value="${(items.commodity.price +
                                                    items.commodityType.price +
                                                    items.commodityCombo.price) * items.number}" type="currency" pattern="￥.0"/>
                                                        <input type="hidden" id="sum${items.ciId}" value="${(items.commodity.price +
                                                    items.commodityType.price +
                                                    items.commodityCombo.price) * items.number}"/>
                                                    </c:if>
                                                </em>
                                            </div>
                                        </li>
                                    </ul>
                                </c:forEach>
                                <%-- 购物车商品 --%>
                            </c:if>
                        </div>
                    </div>
                </tr>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
        <div class="pay-total">
            <div class="clear"></div>
        </div>
        <!--含运费小计 -->
        <div class="buy-point-discharge ">
            <p class="price g_price ">
                合计（含运费） <span>¥</span><em class="pay-sum">
                <fmt:formatNumber value="${sum}" type="currency" pattern="￥.0"/>
            </em>
            </p>
        </div>

        <!--信息 -->
        <div class="order-go clearfix">
            <div class="pay-confirm clearfix">
                <div class="box">
                    <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                        <span class="price g_price ">
                           <span>¥</span>
                            <em class="style-large-bold-red " id="J_ActualFee">
                               <fmt:formatNumber value="${sum}" type="currency" pattern="￥.0"/>
                            </em>
						</span>
                    </div>
                    <div id="holyshit268" class="pay-address">

                        <p class="buy-footer-address">
                            <span class="buy-line-title buy-line-title-type">寄送至：</span>
                            <span class="buy--address-detail">
								<span class="province" id="location">${defaultAddr.location}</span>
								<span class="street" id="address">${defaultAddr.address}</span>
							</span>
                        </p>
                        <p class="buy-footer-address">
                            <span class="buy-line-title">收货人：</span>
                            <span class="buy-address-detail">
                            <span class="buy-user" id="uname">${defaultAddr.uaname}</span>
							<span class="buy-phone" id="tel">${defaultAddr.uatel}</span>
							</span>
                        </p>
                    </div>
                </div>
                <form action="" id="mainForm" method="post">
                    <input type="hidden" name="money" value="${sum}"/>
                    <input type="hidden" name="dcid" value="0"/>
                    <input type="hidden" name="urpid" value="0"/>
                    <input type="hidden" id="uaid" name="uaid" value="${defaultAddr.uaId}"/>
                </form>
                <div id="holyshit269" class="submitOrder">
                    <div class="go-btn-wrap">
                        <a id="J_Go" href="" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <div class="clear"></div>
</div>
</div>
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
<div class="theme-popover-mask"></div>
<div class="theme-popover">

    <!--标题 -->
    <%--<div class="am-cf am-padding">--%>
        <%--<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> /--%>
            <%--<small>Add address</small>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<hr/>--%>

    <%--<div class="am-u-md-12">--%>
        <%--&lt;%&ndash; 新增地址 &ndash;%&gt;--%>
        <%--<form action="" method="post" class="am-form am-form-horizontal">--%>
            <%--<div class="am-form-group">--%>
                <%--<label for="user-name" class="am-form-label">收货人</label>--%>
                <%--<div class="am-form-content">--%>
                    <%--<input type="text" id="user-name" required placeholder="收货人">--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="am-form-group">--%>
                <%--<label for="user-phone" class="am-form-label">手机号码</label>--%>
                <%--<div class="am-form-content">--%>
                    <%--<input id="user-phone" placeholder="手机号必填" required type="email">--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="am-form-group">--%>
                <%--<label for="user-phone" class="am-form-label">所在地</label>--%>
                <%--<div class="am-form-content address">--%>
                    <%--<input id="user-location" required name="location"--%>
                           <%--placeholder="所在地必填" type="text">--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="am-form-group">--%>
                <%--<label for="user-intro" class="am-form-label">详细地址</label>--%>
                <%--<div class="am-form-content">--%>
                    <%--<textarea class="" rows="3" id="user-intro" required placeholder="输入详细地址"></textarea>--%>
                    <%--<small>100字以内写出你的详细地址...</small>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="am-form-group theme-poptit">--%>
                <%--<div class="am-u-sm-9 am-u-sm-push-3">--%>
                    <%--<div class="am-btn am-btn-danger">保存</div>--%>
                    <%--<div class="am-btn am-btn-danger close">取消</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</form>--%>
    <%--</div>--%>

</div>

<div class="clear"></div>
<script type="text/javascript">
    $(function () {
        $("li[id^=addr]").click(function () {
            //被点击的按钮id
            var idStr = $(this).attr("id");
            //截取最后的数字 不管是几位数字
            var uaid = idStr.substring(4, idStr.length);
            var uaname = $("#uaname" + uaid).val();
            var uatel = $("#uatel" + uaid).val();
            var location = $("#location" + uaid).val();
            var address = $("#address" + uaid).val();
            $("#location").html(location);
            $("#address").html(address);
            $("#uname").html(uaname);
            $("#tel").html(uatel);
            $("#uaid").attr("value", uaid);
            return false;
        });
        $("#J_Go").click(function () {
           if (confirm("您要立即支付吗?")){
               var url = "${ctx}/shopping/checkOut";
               //var dcid = $("#dcid").val();
               var money = $("#money").val();
               //var urpid = $("#urpid").val();
               var uaid = $("#uaid").val();
               console.info("uaid:",uaid,"money:",${sum},"urpid:",0,"dcid:",0);
               var args = {dcid:0,money:${sum},urpid:0,uaid:uaid};
               $.post(url,args,function (data) {
                   var stateInfo = data.object.stateInfo;
                   alert(stateInfo);
                   if (stateInfo == '支付成功'){
                        parent.location.href = "${ctx}/shopping/paySuccess";
                   } else {
                       parent.location.href = "${ctx}/shopping/failedPay";
                   }
               });
           } else {
               var form = $("#mainForm");
               var url = "${ctx}/shopping/waitPay";
               form.attr("action", url);
               form.submit();
           }
           return false;
        });
    })
</script>
</body>
</html>
