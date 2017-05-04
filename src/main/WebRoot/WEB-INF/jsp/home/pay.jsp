<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>结算页面</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>

    <link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/cartstyle.css" rel="stylesheet" type="text/css"/>

    <link href="${ctx}/resources/css/jsstyle.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="${ctx}/resources/js/address.js"></script>

</head>

<body>
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
            <div class="menu-hd"><a id="mc-menu-hd" href="${ctx}/shop/shopping_Cart" target="_top"><i
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
<b class="line"></b>
<div class="clear"></div>

<!--配送地址-->
<div class="concent">
    <form action="${ctx}/pay" id="tjfm">
        <div class="concent">
            <!--地址 -->
            <div class="paycont">
                <div class="address">
                    <h3>确认收货地址 </h3>
                    <div class="control">
                        <div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
                    </div>
                    <div class="clear"></div>
                    <ul>

                        <div class="per-border"></div>
                        <c:forEach var="ad" items="${userAddresses}">
                            <li class="user-addresslist" id="userAddress${ad.uaId }">

                                <input id="uaname${ad.uaId }" name="" value="${ad.uaname}" style="display:none"/>
                                <input id="uatel${ad.uaId }" name="" value="${ad.uatel}" style="display:none"/>
                                <input id="oid${ad.uaId }" name="" value="${orders.oid}" style="display:none"/>
                                <input id="location${ad.uaId }" name="" value="${ad.location}" style="display:none"/>


                                <div class="address-left">
                                    <div class="user DefaultAddr">

										<span class="buy-address-detail">   
                   <span class="buy-user"><c:out value="${ad.uaname}"/> </span>

										<span class="buy-phone"><c:out value="${ad.uatel}"/></span>
										</span>
                                    </div>
                                    <div class="default-address DefaultAddr">
                                        <input class="uaId" name="" value="${ad.uaId}" style="display:none"/>


                                        <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                        <span class="buy--address-detail"><c:out value="${ad.address}"/></span>
                                        </span>

                                        </span>
                                    </div>
                                    <ins class="deftip"><c:if test="${ad.status==1}">默认地址</c:if><c:if
                                            test="${ad.status!=1}"></c:if></ins>
                                </div>
                                <div class="address-right">
                                    <span class="am-icon-angle-right am-icon-lg"></span>
                                </div>
                                <div class="clear"></div>

                                <div class="new-addr-btn">
                                    <a href="#"><c:if test="${ad.status==1}"></c:if><c:if
                                            test="${ad.status!=1}"></c:if></a>
                                    <span class="new-addr-bar"></span>
                                    <a href="#"></a>
                                    <span class="new-addr-bar"></span>
                                    <a href="javascript:void(0);" onclick="delClick(this);"></a>
                                </div>

                            </li>
                        </c:forEach>


                    </ul>
                </div>

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
                                    <div class="td-inner">单价</div>
                                </div>
                                <div class="th th-amount">
                                    <div class="td-inner">数量</div>
                                </div>
                                <div class="th th-sum">
                                    <div class="td-inner">金额</div>
                                </div>
                                <div class="th th-oplist">
                                    <div class="td-inner">库存</div>
                                </div>

                            </div>
                        </div>
                        <c:forEach var="ci" items="${shopping_Cart.commodityItems}">
                        <div class="clear"></div>

                        <tr class="item-list">
                            <div class="bundle  bundle-last">

                                <div class="bundle-main">
                                    <ul class="item-content clearfix">
                                        <div class="pay-phone">
                                            <li class="td td-item">
                                                <div class="item-pic">
                                                    <a href="#" class="J_MakePoint">
                                                        <img src="${ctx}${ci.commodity.commodityPics.cpImg}"
                                                             class="itempic J_ItemImg"></a>
                                                </div>
                                                <div class="item-info">
                                                    <div class="item-basic-info">
                                                        <a href="#" class="item-title J_MakePoint"
                                                           data-point="tbcart.8.11"><c:out
                                                                value="${ci.commodity.cname}"/></a>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="td td-info">
                                                <div class="item-props">
                                                    <span class="sku-line">颜色：<c:out
                                                            value="${ci.commodityType.typeName}"></c:out></span>
                                                    <span class="sku-line">包装：<c:out
                                                            value="${ci.commodityCombo.ccname}"/></span>
                                                </div>
                                            </li>
                                            <li class="td td-price">
                                                <div class="item-price price-promo-promo">
                                                    <div class="price-content">
                                                        <input class="pc" type="text"
                                                               value="${ci.commodity.forSalePrice}"
                                                               style="width:60px; text-align:center; border:none"
                                                               readonly/>
                                                    </div>
                                                </div>
                                            </li>
                                        </div>
                                        <li class="td td-amount">
                                            <div class="amount-wrapper ">
                                                <div class="item-amount ">
                                                    <span class="phone-title">购买数量</span>
                                                    <div class="sl">
                                                        <input class="min am-btn" name="" type="button" value="-"/>
                                                        <input class="ciId" name="" value="${ci.ciId}"
                                                               style="display:none"/>
                                                        <input class="text_box" name="" value="${ci.number}" type="text"
                                                               style="width:50px; text-align:center; border:none" onkeyup="this.value=this.value.replace(/\D/g,'')"
                                                               onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
                                                        <input class="kc" value="${ci.commodity.number}" type="text"
                                                               style="display:none"/>
                                                        <input class="add am-btn" name="" type="button" value="+"/>
                                                    </div>
                                                </div>
                                            </div>

                                        </li>
                                        <li class="td td-sum">
                                            <div class="td-inner">
                                                <input class="wt" name="" value="${ci.commodity.forSalePrice*ci.number}"
                                                       type="text" style="width:50px; text-align:center; border:none"
                                                       readonly/>
                                            </div>
                                        </li>
                                        <li class="td td-oplist">
                                            <div class="td-inner">
                                                <span class="phone-title">库存</span>
                                                <div class="pay-logis">
                                                    <b class="sys_item_freprice"><input id=""
                                                                                        value="${ci.commodity.number}"
                                                                                        type="text"
                                                                                        style=" text-align:center; border:none"
                                                                                        readonly/></b>
                                                </div>
                                            </div>
                                        </li>

                                    </ul>
                                </div>

                                </c:forEach>

                                <div class="pay-total">
                                    <!--留言-->
                                    <div class="order-extra">
                                        <div class="order-user-info">
                                            <div id="holyshit257" class="memo">
                                                <label></label>

                                                <div class="msg hidden J-msg">

                                                </div>
                                            </div>
                                        </div>

                                    </div>


                                    <!--优惠券 -->
                                    <div class="buy-agio">
                                        <li class="td td-coupon">

                                            <span class="coupon-title">优惠券</span>
                                            <select id="yhxz" data-am-selected>

                                                <c:forEach var="dc" items="${discountCoupons}">

                                                    <c:if test="${dc.status==0}">
                                                        <option value="${dc.reduce},${dc.dcId}" id="yhj">
                                                            <div class="c-price">
                                                                <strong>￥<c:out value="${dc.reduce }"/></strong>
                                                            </div>
                                                            <div class="c-limit">
                                                                【消费满<c:out value="${dc.condition }"/>元可用】
                                                            </div>
                                                        </option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </li>

                                        <li class="td td-bonus">

                                            <span class="bonus-title">红包</span>
                                            <select data-am-selected id="hbxz" name="">
                                                <c:forEach var="urp" items="${userRedPackages}">


                                                    <c:if test="${urp.status!=1}">
                                                        <option value="${urp.money},${urp.urpId}" id="hb"
                                                                name="userRedPackages.urpId">
                                                            <div class="item-info">
                                                                <c:out value="${urp.money}"/><span>元</span>
                                                            </div>
                                                            <div class="item-remainderprice">
												<span>
												未使用</span>
                                                            </div>
                                                        </option>
                                                    </c:if>
                                                </c:forEach>

                                            </select>

                                        </li>

                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!--含运费小计 -->
                                <div class="buy-point-discharge ">
                                    <p class="price g_price ">
                                        合计（含运费） <span>¥</span><em class="pay-sum"><input class="total" id="tt"
                                                                                         value="${orders.money}"
                                                                                         type="text"
                                                                                         style="width:50px; text-align:center; border:none; border:none"
                                                                                         readonly/></em>
                                    </p>
                                </div>

                                <!--信息 -->
                                <div class="order-go clearfix">
                                    <div class="pay-confirm clearfix">
                                        <div class="box">
                                            <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                                                <span class="price g_price ">
                                    <span>¥</span> <input class="style-large-bold-red " name="money" id="J_ActualFee"
                                                          value="${orders.money}" type="text"
                                                          style="  border:none; border:none" readonly/>
											</span>
                                            </div>

                                            <div id="holyshit268" class="pay-address">

                                                <p class="buy-footer-address">
                                                    <span class="buy-line-title buy-line-title-type">寄送至：</span>
                                                    <span class="buy--address-detail">
								   <span class="province">
												<span class="street"><input id="jsz"
                                                                            value="${orders.userAddress.location}"
                                                                            style="width:100px;text-align:center; border:none; border:none"
                                                                            readonly/></span>
												</span>
												</span>
                                                </p>
                                                <p class="buy-footer-address">

                                                    <span class="buy-line-title">收货人：</span>
                                                    <span class="buy-address-detail">
												 <input id="uaIdw" name="userAddress.uaId"
                                                        value="${orders.userAddress.uaId}" style="display:none"/>
                                         <input id="shr" value="${orders.userAddress.uaname}" type="text"
                                                style="width:50px; text-align:center; border:none; border:none"
                                                readonly/>
												<span class="buy-phone"><input id="lxt"
                                                                               value="${orders.userAddress.uatel}"
                                                                               style="width:100px; text-align:center; border:none;"
                                                                               readonly/></span>
												</span>
                                                </p>
                                            </div>
                                        </div>

                                        <div id="holyshit269" class="submitOrder">
                                            <div class="go-btn-wrap">
                                                <input name="uid" value="${uid}" style="display:none"/>
                                                <input name="shoppingCart.scId" value="${shopping_Cart.scId}"
                                                       style="display:none"/>
                                                <input id="dc" name="discountCoupon.dcId" value="1"
                                                       style="display:none">
                                                <input id="urp" name="userRedPackage.urpId" value="1"
                                                       style="display:none">
                                                <input name="oid" value="${orders.oid}" style="display:none"/>
                                                <input name="status" value="0" style="display:none"/>
    </form>
    <a id="J_Go" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
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
            <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank"
                                                       title="模板之家">模板之家</a> - Collect from <a
                    href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
        </p>
    </div>
</div>
</div>
<div class="theme-popover-mask"></div>
<div class="theme-popover">

    <!--标题 -->
    <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> /
            <small>Add address</small>
        </div>
    </div>
    <hr/>

    <div class="am-u-md-12">

        <div class="am-form-group">
            <form id="addressForm" action="${ctx}/shop/addAddresso" method="post" class="am-form am-form-horizontal">
                <label for="user-name" class="am-form-label">收货人</label>
                <div class="am-form-content">
                    <input type="text" required name="uaname" id="user-name" placeholder="收货人">
                </div>
        </div>

        <div class="am-form-group">
            <label for="user-phone" class="am-form-label">手机号码</label>
            <div class="am-form-content">
                <input id="user-phone" required name="uatel" placeholder="手机号必填" type="tel">
            </div>
        </div>
        <div class="am-form-group">
            <label class="am-form-label">所在地</label>
            <div class="am-form-content address">
                <input id="user-location" required name="location" placeholder="所在地必填" type="text">
            </div>
        </div>

        <div class="am-form-group">
            <label for="user-intro" class="am-form-label">详细地址</label>
            <div class="am-form-content">
                <textarea class="" rows="3" required id="user-intro" name="address" placeholder="输入详细地址"></textarea>
                <small>100字以内写出你的详细地址...</small>
            </div>
        </div>
        <input type="hidden" name="uid" value="${uid}">

        <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
                <input class="am-btn am-btn-danger" type="submit" value="提交">
                <input class="am-btn am-btn-danger" type="reset" value="重置">
            </div>
        </div>
        </input>
    </div>
</div>

</div>

</div>

<div class="clear"></div>

</body>

</html>