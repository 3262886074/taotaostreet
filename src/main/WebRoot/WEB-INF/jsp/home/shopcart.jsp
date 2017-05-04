<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>购物车页面</title>

<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resources/css/cartstyle.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resources/css/optstyle.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

</head>

<body>

	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
						target="_top">免费注册</a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="#" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd"
						href="${ctx}/shopping_Cart?uid=${shopping_Cart.users.uid}"
						target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h"></strong></a>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
				</div>
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="${ctx}/resources/images/logo.png" />
		</div>
		<div class="logoBig">
			<li><img src="${ctx}/resources/images/logobig.png" /></li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit">
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
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
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
					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>



			<div class="bundle  bundle-last ">
				<div class="bundle-hd">
					<div class="bd-promos">
						<span class="list-change theme-login">编辑</span>
					</div>
				</div>
				<c:forEach var="ci" items="${shopping_Cart.commodityItems}">
					<input name="shopping_Cart.commodityItems.ciId" value="${ci.ciId}"
						style="display: none">
					<div class="bundle-main">
						<ul class="item-content clearfix">
							<li class="td td-item">
								<div class="item-pic">
									<img src="${ctx}/${ci.commodity.commodityPics.cpImg}" class="itempic J_ItemImg" />
								</div>
								<div class="item-info">
									<div class="item-basic-info">
										<a href="#" target="_blank" title="1"
											class="item-title J_MakePoint" data-point="tbcart.8.11"><c:out
												value="${ci.commodity.cname}" /></a>
									</div>
								</div>
							</li>
							<li class="td td-info">
								<div class="item-props item-props-can">
									<span class="sku-line">颜色：<c:out
											value="${ci.commodityType.typeName}" /></span> <span
										class="sku-line">包装：<c:out
											value="${ci.commodityCombo.ccname}" /></span> <i
										class="theme-login am-icon-sort-desc"></i>
								</div>
							</li>
							<li class="td td-price">
								<div class="item-price price-promo-promo">
									<div class="price-content">
										<div class="price-line">
											<em class="price-original"><c:out
													value="${ci.commodity.price}" /></em>
										</div>
										<div class="price-line">
											<input class="pc" type="text"
												value="${ci.commodity.forSalePrice}"
												style="width: 50px; text-align: center; border: none"
												readonly />
										</div>
									</div>
								</div>

							</li>
							<li class="td td-amount">
								<div class="amount-wrapper ">
									<div class="item-amount ">
										<div class="sl">

											<input class="min am-btn" name="" type="button" value="-" />
											<input class="ciId" name="ciId" value="${ci.ciId}"
												style="display: none" /> <input class="text_box"
												name="number" value="${ci.number}" type="text"
												style="width: 50px; text-align: center; border: none"
												onkeyup="this.value=this.value.replace(/\D/g,'')"
												onafterpaste="this.value=this.value.replace(/\D/g,'')"></input>
											<input class="add am-btn" name="" type="button" value="+" />

										</div>
									</div>
								</div>
							</li>
							<li class="td td-sum">
								<div class="td-inner">
									<input class="wt" name=""
										value="${ci.commodity.forSalePrice*ci.number}" type="text"
										style="width: 50px; text-align: center; border: none" readonly />

								</div>
							</li>
							<li class="td td-op">
								<div class="td-inner">
									<a title="移入收藏夹" class="btn-fav"
										href="${ctx}/shop/moveUc?cid=${ci.commodity.cid }&scId=${shopping_Cart.scId}&uid=${shopping_Cart.users.uid}&ciId=${ci.ciId}">
										移入收藏夹</a> <a
										href="${ctx}/shop/deleteCommodity_items?ciId=${ci.ciId }&scId=${shopping_Cart.scId}"
										data-point-url="#" class="delete"> 删除</a>
								</div>
							</li>

						</ul>
					</div>
				</c:forEach>


			</div>


			<div class="float-bar-wrapper">

				<div class="float-bar-right">

					<div class="price-sum">


						<form action="${ctx}/addOrders" method="post" id="sbform">
							<input name="shoppingCart.scId" value="${shopping_Cart.scId}"
								style="display: none"> <input
								name="shoppingCart.users.uid" value="${shopping_Cart.users.uid}"
								style="display: none"> <input name="uid"
								value="${shopping_Cart.users.uid}" style="display: none">
							<input name="status" value="-1" style="display: none"> <span
								class="txt">合计:</span> <strong class="price">¥<em
								id="J_Total"> <input class="total" id="tt" name="money"
									value="1.00" type="text" style="border: none" readonly />
							</em></strong>
					</div>
					</form>

					<div class="btn-area">
						<a href="#" id="J_Go" class="submit-btn submit-btn-disabled"
							aria-label="请注意如果没有选择宝贝，将无法结算"> <span>结&nbsp;算</span></a>

					</div>
				</div>

			</div>
		</div>

		<div class="footer">
			<div class="footer-hd">
				<p>
					<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a>

				</p>
			</div>
			<div class="footer-bd">
				<p>
					<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
						href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
						href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a></em>
				</p>
			</div>
		</div>

		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="#"><i
					class="am-icon-shopping-basket"></i>购物车</a></li>
			<li><a href="${ctx}/resources/person/index.html"><i
					class="am-icon-user"></i>我的</a></li>
		</div>

	</div>

</body>

</html>