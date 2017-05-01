<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>购物车页面</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/css/optstyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
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
<div class="clear"></div>

<!--购物车 -->
<div class="concent">
    <div id="cartTable">
        <div class="cart-table-th">
            <div class="wp">
                <div class="th th-chk">
                    <div id="J_SelectAll1" class="select-all J_SelectAll">

                    </div>
                </div>
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
                <div class="th th-op">
                    <div class="td-inner">操作</div>
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
                        <li class="td td-chk">
                            <div class="cart-checkbox ">
                                <input class="check" id="J_CheckBox_170037950254" name="id" value="" type="checkbox">
                                <label for="J_CheckBox_170037950254"></label>
                            </div>
                        </li>
                        <li class="td td-item">
                            <div class="item-pic">
                                <a href="#" target="_blank" data-title="" class="J_MakePoint" data-point="tbcart.8.12">
                                    <img src="${items.commodity.commodityPics.cpImg}" class="itempic J_ItemImg" width="100%"></a>
                            </div>
                            <div class="item-info">
                                <div class="item-basic-info">
                                    <a href="#" target="_blank" title="" class="item-title J_MakePoint"
                                       data-point="tbcart.8.11">${items.commodity.cname}</a>
                                </div>
                            </div>
                        </li>
                        <li class="td td-info">
                            <div class="item-props item-props-can">
                                <span class="sku-line">类型：${items.commodityType.typeName}</span>
                                <span class="sku-line">包装：${items.commodityCombo.ccname}</span>
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
                                                    items.commodityType.price + items.commodityCombo.price}" type="currency" pattern="￥.0"/>
                                            </c:if>
                                            <c:if test="${empty items.commodity.forSalePrice}">
                                                <fmt:formatNumber value="${items.commodity.price +
                                                    items.commodityType.price + items.commodityCombo.price}" type="currency" pattern="￥.0"/>
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
                                        <input class="text_box" name="" type="text" disabled value="${items.number}" style="width:30px;" />
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
                        <li class="td td-op">
                            <div class="td-inner">
                                <a title="移入收藏夹" class="btn-fav" href="">移入收藏夹</a>
                                <a href="" data-point-url="#" class="delete">删除</a>
                            </div>
                        </li>
                    </ul>
                    </c:forEach>
                    <%-- 购物车商品 --%>
                    </c:if>
                    <c:if test="${empty commodityItems}">
                        购物车为空
                    </c:if>
                </div>
            </div>
        </tr>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>

    <div class="float-bar-wrapper">
        <div id="J_SelectAll2" class="select-all J_SelectAll">
            <div class="cart-checkbox">
                <input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
                <label for="J_SelectAllCbx2"></label>
            </div>
            <span>全选</span>
        </div>
        <div class="operations">
            <a href="#" hidefocus="true" class="deleteAll">删除</a>
            <a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
        </div>
        <div class="float-bar-right">
            <div class="amount-sum">
                <span class="txt">已选商品</span>
                <em id="J_SelectedItemsCount">${itemSize}</em><span class="txt">件</span>
                <div class="arrow-box">
                    <span class="selected-items-arrow"></span>
                    <span class="arrow"></span>
                </div>
            </div>
            <div class="price-sum" id="sum">
                <span class="txt">合计:</span>
                <strong class="price">¥<em id="J_Total">${sum}</em></strong>
            </div>
            <div id="sub" class="btn-area">
                <form id="mainForm" action="" method="post">

                </form>
                <c:if test="${!empty commodityItems}">
                    <a href="${ctx}/shopping/payPage" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
                        <span>结&nbsp;算</span></a>
                </c:if>
                <c:if test="${empty commodityItems}">
                    <a href="${ctx}/" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
                        <span>去购物</span></a>
                </c:if>
            </div>
        </div>

    </div>
    <script type="text/javascript">
        $(function () {
//            $("#sub").click(function () {
//                $("#mainForm").submit();
//            });
        })
    </script>
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

<!--操作页面-->

<div class="theme-popover-mask"></div>

<!--引导 -->

</body>

</html>
