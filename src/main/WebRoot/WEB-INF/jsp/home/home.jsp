<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>首页</title>
<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resources/css/hmstyle.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resources/css/skin.css" rel="stylesheet"
	type="text/css" />
<script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>

<body>
	<div class="hmtop">
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
			<div class="logo">
				<img src="${ctx}/resources/images/logo.png" />
			</div>
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
	</div>
	<div class="banner">
		<!--轮播 -->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li class="banner1"><a href="introduction.html"><img
						src="${ctx}/resources/images/ad1.jpg" /></a></li>
				<li class="banner2"><a><img
						src="${ctx}/resources/images/ad2.jpg" /></a></li>
				<li class="banner3"><a><img
						src="${ctx}/resources/images/ad3.jpg" /></a></li>
				<li class="banner4"><a><img
						src="${ctx}/resources/images/ad4.jpg" /></a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="shopNav">
		<div class="slideall">
			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="${ctx}/">首页</a></li>
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

			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">
						<div class="category">
							<ul class="category-list" id="js_climit_li">
								<!-- 一级分类 -->
								<c:forEach items="${classifyOneList}" var="classifyOne"
									varStatus="status">
									<c:choose>
										<c:when test="${status.index+1==1}">
											<li class="appliance js_toggle relative first">
												<div class="category-info">
													<h3 class="category-name b-category-name">
														<i><img
															src="${ctx}/resources/images/classify_img/${status.index+1}cf.png" /></i><a
															class="ml-22" title="点心">${classifyOne.cOneName}</a>
													</h3>
													<em>&gt;</em>
												</div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<!-- 二级分类 -->
																	<c:forEach items="${classifyOne.classifyTwo}"
																		var="classifyTwo">
																		<dl class="dl-sort">
																			<dt>
																				<span title="蛋糕">${classifyTwo.cTwoName}</span>
																			</dt>
																			<c:forEach items="${classifyTwo.classifyThree}"
																				var="classifyThree">
																				<dd>
																					<a title="${classifyThree.cThreeName}"
																						href="${ctx}/home/query?type=${classifyThree.cThreeName}"
																						onclick="queryType(this.title);return false;"><span>${classifyThree.cThreeName}</span></a>
																				</dd>
																			</c:forEach>
																		</dl>
																	</c:forEach>
																</div>
															</div>
														</div>
													</div>
												</div> <b class="arrow"></b>
											</li>
										</c:when>
										<c:when test="${status.index+1==7}}">
											<li class="appliance js_toggle relative">
												<div class="category-info">
													<h3 class="category-name b-category-name">
														<i><img
															src="${ctx}/resources/images/classify_img/${status.index+1}cf.png" /></i><a
															class="ml-22" title="点心">${classifyOne.cOneName}</a>
													</h3>
													<em>&gt;</em>
												</div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<!-- 二级分类 -->
																	<c:forEach items="${classifyOne.classifyTwo}"
																		var="classifyTwo">
																		<dl class="dl-sort">
																			<dt>
																				<span title="蛋糕">${classifyTwo.cTwoName}</span>
																			</dt>
																			<c:forEach items="${classifyTwo.classifyThree}"
																				var="classifyThree">
																				<dd>
																					<a title="${classifyThree.cThreeName}"
																						href="${ctx}/home/query?type=${classifyThree.cThreeName}"
																						onclick="queryType(this.title);return false;"><span>${classifyThree.cThreeName}</span></a>
																				</dd>
																			</c:forEach>
																		</dl>
																	</c:forEach>
																</div>
															</div>
														</div>
													</div>
												</div> <b class="arrow"></b>
											</li>
										</c:when>
										<c:otherwise>
											<li class="appliance js_toggle relative last">


												<div class="category-info">
													<h3 class="category-name b-category-name">
														<i><img
															src="${ctx}/resources/images/classify_img/${status.index+1}cf.png" /></i><a
															class="ml-22" title="点心">${classifyOne.cOneName}</a>
													</h3>
													<em>&gt;</em>
												</div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<!-- 二级分类 -->
																	<c:forEach items="${classifyOne.classifyTwo}"
																		var="classifyTwo">
																		<dl class="dl-sort">
																			<dt>
																				<span title="蛋糕">${classifyTwo.cTwoName}</span>
																			</dt>
																			<c:forEach items="${classifyTwo.classifyThree}"
																				var="classifyThree">
																				<dd>
																					<a title="${classifyThree.cThreeName}"
																						href="${ctx}/home/query?type=${classifyThree.cThreeName}"
																						onclick="queryType(this.title);return false;"><span>${classifyThree.cThreeName}</span></a>
																				</dd>
																			</c:forEach>
																		</dl>
																	</c:forEach>
																</div>
															</div>
														</div>
													</div>
												</div> <b class="arrow"></b>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!--轮播-->
			<script type="text/javascript">
				(function() {
					$('.am-slider').flexslider();
				});
				$(document)
						.ready(
								function() {
									$("li")
											.hover(
													function() {
														$(
																".category-content .category-list li.first .menu-in")
																.css("display",
																		"none");
														$(
																".category-content .category-list li.first")
																.removeClass(
																		"hover");
														$(this).addClass(
																"hover");
														$(this)
																.children(
																		"div.menu-in")
																.css("display",
																		"block")
													},
													function() {
														$(this).removeClass(
																"hover")
														$(this).children(
																"div.menu-in")
																.css("display",
																		"none")
													});
								});
			</script>
			<!--小导航 -->
			<div class="am-g am-g-fixed smallnav">
				<div class="am-u-sm-3">
					<a href="sort.html"><img src="${ctx}/resources/images/navsmall.jpg" />
						<div class="title">商品分类</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="${ctx}/resources/images/huismall.jpg" />
						<div class="title">大聚惠</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="${ctx}/resources/images/mansmall.jpg" />
						<div class="title">个人中心</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="${ctx}/resources/images/moneysmall.jpg" />
						<div class="title">投资理财</div> </a>
				</div>
			</div>

			<!--走马灯 -->
			<div class="marqueen">
				<span class="marqueen-title">商城头条</span>
				<div class="demo">
					<ul>
						<c:forEach items="${commodityList}" var="commodity"
							varStatus="statop">
							<li><a target="_blank" href="${ctx }/toShowOne?cid=${commodity.cid }"><span>[特惠]</span>${commodity.cname}</a></li>
							<c:if test="${statop.index+1==2}">
								<div class="mod-vip">
									<c:choose>
										<c:when test="${empty users}">
											<div class="m-baseinfo">
												<a href="${ctx}/resources/person/index.html"> <img
													src="${ctx}/resources/images/getAvatar.do.jpg" />
												</a> <em> Hi,<span class="s-name">欢迎光临</span> <a href="#">
														<p>点击更多优惠活动</p>
												</a>
												</em>
											</div>
											<div class="member-logout">
												<a class="am-btn-warning btn"
													href="${ctx}/loginOrRegister/loginInput">登录</a> <a
													class="am-btn-warning btn"
													href="${ctx}/loginOrRegister/registerInput">注册</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class="m-baseinfo">
												<a href="${ctx}/resources/person/index.html"> <img
													src="${ctx}${users.uicon}" />
												</a> <em> Hi,<span class="s-name">${users.nickName}</span>
													<a href="#">
														<p>点击更多优惠活动</p>
												</a>
												</em>
											</div>
											<div class="member-logout">
												<a class="am-btn-warning btn"
													href="${ctx}/users/orders">我的订单</a>
											</div>
										</c:otherwise>
									</c:choose>
									<div class="clear"></div>
								</div>
							</c:if>
						</c:forEach>
					</ul>
					<div class="advTip">
						<img src="${ctx}/resources/images/advTip.jpg" />
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<script type="text/javascript">
			if ($(window).width() < 640) {
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop : "-39px"
					}, 500, function() {
						$(this).css({
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".demo")', 3000);
				})
			}
		</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">

			<!--今日推荐 -->

			<div class="am-g am-g-fixed recommendation">
				<div class="clock am-u-sm-3"">
					<img src="${ctx}/resources/images/2016.png "></img>
					<p>
						今日<br> 推荐
					</p>
				</div>
				<c:forEach items="${commodityNow}" var="commodity">
					<div class="am-u-sm-4 am-u-lg-3 ">
						<div class="info ">
							<h3 class="shenglue">${commodity.cname}</h3>
							<h4>开年福利篇</h4>
						</div>
						<div class="recommendationMain one">
							<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
								src="${ctx}${commodity.commodityPics.cpImg} "></img></a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="clear "></div>

			<!-- 类型推荐展示 -->
			<c:forEach items="${ClassifyTwoList}" var="classifyTwo"
				varStatus="stwos">
				<div id="f${stwos.index+1 }">
					<!--甜点-->
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>${classifyTwo.cTwoName}</h4>
							<h3>挑战你的味蕾</h3>
							<span class="more "> <a
								href="${ctx}/home/query?type=${classifyTwo.cTwoName} ">更多美味<i
									class="am-icon-angle-right" style="padding-left: 10px;"></i></a>
							</span>
						</div>
					</div>
					<div class="am-g am-g-fixed floodFour">
						<div class="am-u-sm-5 am-u-md-4 text-one list ">
							<div class="word">
								<c:forEach items="${classifyTwo.classifyThree}"
									var="classifythree" end="5">
									<a class="outer"
										href="${ctx}/home/query?type=${classifyThree.cThreeName}"><span
										class="inner"><b class="text">${classifythree.cThreeName}</b></span></a>
								</c:forEach>
							</div>
							<a href="# ">
								<div class="outer-con ">
									<div class="title ">开抢啦！</div>
									<div class="sub-title ">零食大礼包</div>
								</div> <img src="${ctx}/resources/images/act1.png " />
							</a>
							<div class="triangle-topright"></div>
						</div>


						<c:forEach items="${classifyTwo.commodity}" var="commodity"
							varStatus="stacom" end="5">
							<c:if test="${stacom.index+1==1}">
								<div class="am-u-sm-7 am-u-md-4 text-two sug">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
							<c:if test="${stacom.index+1==2}">
								<div class="am-u-sm-7 am-u-md-4 text-two">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
							<c:if test="${stacom.index+1==3}">
								<div class="am-u-sm-3 am-u-md-2 text-three big">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
							<c:if test="${stacom.index+1==4}">
								<div class="am-u-sm-3 am-u-md-2 text-three sug">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
							<c:if test="${stacom.index+1==5}">
								<div class="am-u-sm-3 am-u-md-2 text-three ">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
							<c:if test="${stacom.index+1==6}">
								<div class="am-u-sm-3 am-u-md-2 text-three last big ">
									<div class="outer-con ">
										<div class="title shenglue">${commodity.cname }</div>
										<div class="sub-title ">¥${commodity.forSalePrice }</div>
										<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
									</div>
									<a href="${ctx }/toShowOne?cid=${commodity.cid }"><img
										src="${ctx}${commodity.commodityPics.cpImg}" /></a>
								</div>
							</c:if>
						</c:forEach>

					</div>
					<div class="clear "></div>
				</div>
			</c:forEach>
			<!-- 尾部 -->
			<div class="footer ">
				<div class="footer-hd ">
					<p>
						<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
							href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
					</p>
				</div>
				<div class="footer-bd ">
					<p>
						<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a>
						<a href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板
							<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
							- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
							target="_blank">网页模板</a>
						</em>
					</p>
				</div>
			</div>

		</div>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="${ctx}/resources/person/index.html"><i
				class="am-icon-user"></i>我的</a></li>
	</div>

	<!--菜单 -->
	<div class="tip">
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="${ctx}/users/allInfo"> <span class="setting "></span>
					</a>
					<div class="ibar_login_box status_login ">
						<c:choose>
							<c:when test="${!empty users}">
								<div class="avatar_box ">
									<p class="avatar_imgbox ">
										<img src="${ctx}${users.uicon} " />
									</p>
									<ul class="user_info ">
										<li>${users.nickName }</li>
										<li>级&nbsp;别:黄金会员</li>
									</ul>
								</div>
								<div class="login_btnbox ">
									<a href="${ctx}/users/orders" class="login_order ">我的订单</a> <a
										href="${ctx}/users/allCollects" class="login_favorite ">我的收藏</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="avatar_box ">
									<p class="avatar_imgbox ">
										<img src="${ctx}/resources/images/no-img_mid_.jpg " />
									</p>
									<ul class="user_info ">
										<li>尚未登录！</li>
										<li></li>
									</ul>
								</div>
								<div class="login_btnbox ">
									<a href="${ctx}/loginOrRegister/loginInput "
										class="login_order ">马上登录</a> <a
										href="${ctx}/loginOrRegister/registerInput "
										class="login_favorite ">立即注册</a>
								</div>
							</c:otherwise>
						</c:choose>
						<i class="icon_arrow_white "></i>
					</div>
				</div>
				<div id="shopCart " class="item ">
					<a href="${ctx}/shopping/shoppingCart "> <span class="message "></span>
					</a>
					<p>购物车</p>
				</div>
				<div id="asset " class="item ">
					<a href="${ctx}/users/allInfo "> <span class="view "></span>
					</a>
					<div class="mp_tooltip ">
						我的资产 <i class="icon_arrow_right_black "></i>
					</div>
				</div>
				<div id="brand " class="item ">
					<a href="${ctx}/users/allCollects"> <span class="wdsc "><img
							src="${ctx}/resources/images/wdsc.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我的收藏 <i class="icon_arrow_right_black "></i>
					</div>
				</div>
				<!--回到顶部 -->
				<div id="quick_links_pop " class="quick_links_pop hide "></div>
			</div>
		</div>
    </div>
	<script>
		window.jQuery
				|| document
						.write('<script src="${ctx}/resources/basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript "
		src="${ctx}/resources/basic/js/quick_links.js "></script>
</body>
</html>
