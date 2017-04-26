<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>商品页面</title>

<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="${ctx}/resources/css/optstyle.css"
	rel="stylesheet" />
<link type="text/css" href="${ctx}/resources/css/style.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${ctx}/resources/basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/basic/js/quick_links.js"></script>

<script type="text/javascript"
	src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/js/jquery.imagezoom.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/list.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jsAddress.js"></script>

</head>

<body>


	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<c:if test="${empty users}">
							<a href="${ctx}/loginOrRegister/registerInput" target="_top">免费注册</a>
							<a href="${ctx}/loginOrRegister/loginInput   " target="_top" class="h">亲，请登录</a>
						</c:if>
						<c:if test="${!empty users}">
							<b>${users.nickName }</b>，
							<a href="${ctx}/loginOrRegister/loginOut">注销</a>
						</c:if>
				</div>
			</div>
		</ul>
		<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="${ctx}/" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<c:if test="${!empty users}">
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="${ctx}/users/allInfo" target="_top"><i
								class="am-icon-user am-icon-fw"></i>个人中心</a>
						</div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="#" target="_top"><i
								class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
								id="J_MiniCartNum" class="h">0</strong></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
				</c:if>
				<c:if test="${empty users}">
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng">
							<a href="javascript:void(0);" onclick="toLogin();" target="_top"><i
								class="am-icon-user am-icon-fw"></i>个人中心</a>
						</div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd">
							<a id="mc-menu-hd" href="javascript:void(0);" onclick="toLogin();" target="_top"><i
								class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
								id="J_MiniCartNum" class="h">0</strong></a>
						</div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd">
							<a href="javascript:void(0);" onclick="toLogin();" target="_top"><i
								class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
						</div>
				</c:if>
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
	<div class="listMain">

		<!--分类-->
		<div class="nav-table">
			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
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
		<ol class="am-breadcrumb am-breadcrumb-slash">
			<li><a href="#">首页</a></li>
			<li><a href="#">分类</a></li>
			<li class="am-active">内容</li>
		</ol>
		<script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script>
		<div class="scoll">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li><img src="${ctx}/resources/images/01.jpg" title="pic" />
						</li>
						<li><img src="${ctx}/resources/images/02.jpg" /></li>
						<li><img src="${ctx}/resources/images/03.jpg" /></li>
					</ul>
				</div>
			</section>
		</div>

		<!--放大镜-->

		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">

				<div class="box">
					<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

					<div class="tb-booth tb-pic tb-s310">
						<a href="${ctx}/resources/images/01.jpg"><img
							src="${ctx}/resources/images/01_mid.jpg" alt="细节展示放大镜特效"
							rel="${ctx}/resources/images/01.jpg" class="jqzoom" /></a>
					</div>
					<ul class="tb-thumb" id="thumblist">
						<li class="tb-selected">
							<div class="tb-pic tb-s40">
								<a href="#"><img src="${ctx}/resources/images/01_small.jpg"
									mid="${ctx}/resources/images/01_mid.jpg"
									big="${ctx}/resources/images/01.jpg"></a>
							</div>
						</li>
						<li>
							<div class="tb-pic tb-s40">
								<a href="#"><img src="${ctx}/resources/images/02_small.jpg"
									mid="${ctx}/resources/images/02_mid.jpg"
									big="${ctx}/resources/images/02.jpg"></a>
							</div>
						</li>
						<li>
							<div class="tb-pic tb-s40">
								<a href="#"><img src="${ctx}/resources/images/03_small.jpg"
									mid="${ctx}/resources/images/03_mid.jpg"
									big="${ctx}/resources/images/03.jpg"></a>
							</div>
						</li>
					</ul>
				</div>

				<div class="clear"></div>
			</div>

			<div class="clearfixRight">

				<!--规格属性-->
				<!--名称-->
				<div class="tb-detail-hd">
					<h1>${commodity.cname }</h1>
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
						<c:if test="${commodity.forSalePrice!=0 }">
							<li class="price iteminfo_price">
								<dt>促销价</dt>
								<dd>
									<em>¥</em><b class="sys_item_price" id="ppp">${commodity.forSalePrice}</b>
									<input id="showMoney" type="hidden"
										value="${commodity.forSalePrice}" />
								</dd>
							</li>
							<li class="price iteminfo_mktprice">
								<dt>原价</dt>
								<dd>
									<em>¥</em><b class="sys_item_mktprice">${commodity.price }</b>
								</dd>
							</li>
						</c:if>
						<c:if test="${commodity.forSalePrice==0 }">
							<li class="price iteminfo_price">
								<dt>原价</dt>
								<dd>
									<em>¥</em><b class="sys_item_price" id="ppp">${commodity.price }</b>
									<input id="showMoney" type="hidden" value="${commodity.price}" />
								</dd>
							</li>
						</c:if>
						<div class="clear"></div>
					</div>

					<!--地址-->
					<dl class="iteminfo_parameter freight">
						<dt>配送至</dt>
						<div class="iteminfo_freprice">
							<div class="am-form-content address">
								<select id="cmbProvince" name="cmbProvince"></select> <select
									id="cmbCity" name="cmbCity"></select> <select id="cmbArea"
									name="cmbArea"></select>
								<script type="text/javascript">  
                  						  addressInit('cmbProvince', 'cmbCity', 'cmbArea');  
            					     </script>
							</div>
							<div class="pay-logis">
								<c:if test="${commodity.postage!=0 && !empty commodity.postage }">
										快递<b class="sys_item_freprice">${commodity.postage }</b>元
										</c:if>
								<c:if test="${empty commodity.postage || commodity.postage==0}">包邮</c:if>
							</div>
						</div>
					</dl>
					<div class="clear"></div>

					<!--销量-->
					<ul class="tm-ind-panel">
						<li class="tm-ind-item tm-ind-sellCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">月销量</span><span class="tm-count">${commodity.commoditySell.monthSell }</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-sumCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">累计销量</span><span class="tm-count">${commodity.commoditySell.allSell }</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
							<div class="tm-indcon">
								<span class="tm-label">累计评价</span><span class="tm-count">${commodity.commoditySell.allComm }</span>
							</div>
						</li>
					</ul>
					<div class="clear"></div>

					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login">
							<div class="cart-title">
								可选规格<span class="am-icon-angle-right"></span>
							</div>
						</dt>
						<dd>
							<!--操作页面-->

							<div class="theme-popover-mask"></div>

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" name="loginform" action=""
										method="post">

										<div class="theme-signin-left">
											<div class="theme-options">
												<div class="cart-title">口味</div>
												<ul>
													<c:forEach items="${commodity.commodityTypes }" var="l">
														<li class="sku-line ">${l.typeName }<i></i> <input
															id="tprice" type="hidden" value="${l.price }" /> <input
															id="ct_id" type="hidden" value="${l.ct_id }" />
														</li>
													</c:forEach>
													<div id="show1" class="stock"
														style="display: none; color: red; font-size: 14px; margin-top: 10px;">请选择你需要的口味和包装</div>
												</ul>

											</div>
											<div class="theme-options">
												<div class="cart-title">包装</div>
												<ul>
													<c:forEach items="${commodity.combos }" var="l">
														<li class="sku-line ">${l.ccname }<i></i> <input
															id="cprice" type="hidden" value="${l.price }" /> <input
															id="ccid" type="hidden" value="${l.ccid }" />
														</li>
													</c:forEach>
												</ul>
											</div>
											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd>
													<input id="min" class="am-btn am-btn-default" name=""
														type="button" value="-" /> <input id="text_box" name=""
														type="text" value="1" style="width: 30px;"
														onkeyup="this.value=this.value.replace(/\D/g,'')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')" />
													<input id="add" class="am-btn am-btn-default" name=""
														type="button" value="+" /> <input id="c_number"
														type="hidden" value="${commodity.number }" /> <span
														id="Stock" class="tb-hidden">库存<span class="stock">${commodity.number }</span>件
													</span>
												</dd>
											</div>
											<div class="clear"></div>

											<div class="btn-op">
												<div class="btn am-btn am-btn-warning">确认</div>
												<div class="btn close am-btn am-btn-warning">取消</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</dd>
					</dl>
					<div class="clear"></div>
					<!--活动	-->
					<div class="shopPromotion gold">
						<div class="hot">
							<dt class="tb-metatit">商城优惠</dt>
							<div class="gold-list">
								<p>
									免费领取优惠券，每张每月限领一次<span>点击领券<i class="am-icon-sort-down"></i></span>
								</p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="coupon">
							<dt class="tb-metatit">优惠券</dt>
							<div class="gold-list">
							<c:if test="${!empty users }">
								<ul>
									<a href="javascript:void(0);" onclick="getyhq();"><li><i id="q1">125</i>减<i id="q2">5</i></li></a>
									<a href="javascript:void(0);" onclick="getyhq1();"><li><i id="a1">198</i>减<i id="a2">10</i></li></a>
									<a href="javascript:void(0);" onclick="getyhq2();"><li><i id="w1">298</i>减<i id="w2">30</i></li></a>
								</ul>
							</c:if>
							<c:if test="${empty users }">
								<ul>
									<a href="javascript:void(0);" onclick="toLogin();"><li><i id="q1">125</i>减<i id="q2">5</i></li></a>
									<a href="javascript:void(0);" onclick="toLogin();"><li><i id="a1">198</i>减<i id="a2">10</i></li></a>
									<a href="javascript:void(0);" onclick="toLogin();"><li><i id="w1">298</i>减<i id="w2">30</i></li></a>
								</ul>
							</c:if>
							</div>
							<script type="text/javascript">
								function toLogin() {
									alert("请先登录！")
									window.location.href="loginOrRegister/loginInput";
							}
							</script>
							<script type="text/javascript" >
								function getyhq() {
									var condition = parseInt($("#q1").html());
									var reduce = parseInt($("#q2").html());
									if (confirm("确定领取？")){ 
										$.post("getDc","cond="+condition+"&red="+reduce+"&uid="+${users.uid},function(a){
											if (a==0) {
												alert("领取成功")
											}else{
												alert("您已领取过，请下月再来领取")
											}
											
										});
									} 
								}
								function getyhq1() {
									var condition = parseInt($("#a1").html());
									var reduce = parseInt($("#a2").html());
									if (confirm("确定领取？")){ 
										$.post("getDc","cond="+condition+"&red="+reduce+"&uid="+${users.uid},function(a){
											if (a==0) {
												alert("领取成功")
											}else{
												alert("您已领取过，请下月再来领取")
											}
											
										});
									} 
								}
								function getyhq2() {
									var condition = parseInt($("#w1").html());
									var reduce = parseInt($("#w2").html());
									if (confirm("确定领取？")){ 
										$.post("getDc","cond="+condition+"&red="+reduce+"&uid="+${users.uid},function(a){
											if (a==0) {
												alert("领取成功")
											}else{
												alert("您已领取过，请下月再来领取")
											}
											
										});
									} 
								}
							</script>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="pay">
					<div class="pay-opt">
						<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
						<a><span class="am-icon-heart am-icon-fw">收藏</span></a>

					</div>
					<c:if test="${!empty users }">
					<li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
						
							<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="javascript:void(0)"
								onclick="show()">立即购买</a>
							
						</div>
					</li>
					<li>
						<div class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="加入购物车" href="javascript:void(0)"
								onclick="show2()"><i></i>加入购物车</a>
						</div> 
					</li>
					</c:if>
					<c:if test="${empty users }">
					<li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
						
							<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="javascript:void(0)"
								onclick="toLogin()">立即购买</a>
							
						</div>
					</li>
					<li>
						<div class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="加入购物车" href="javascript:void(0)"
								onclick="toLogin()"><i></i>加入购物车</a>
						</div> 
					</li>
					</c:if>
						<script type="text/javascript">
										function show(){
											if(mon + m2 <=0){
												$("#show1").show();
											}else if(sel1 && sel2 && flag && flag2){
												var oneMoney = mon+m2;
												var allMoney = oneMoney*tt
												alert("正在下订单。。cid:"+${commodity.cid }+" 口味id："+selctid+" 包装id："+selccid+" 数量为："+tt)
												alert("单个金额为："+oneMoney+" 总金额为："+allMoney)
											}else{
												$("#show1").show();
											}
										}
						</script>
						<script type="text/javascript">
										function show2(){
											if(mon + m2 <=0){
												$("#show1").show();
											}else if(sel1 && sel2 && flag && flag2){
												var oneMoney = mon+m2;
												var allMoney = oneMoney*tt
												alert("正在下订单。。cid:"+${commodity.cid }+" 口味id："+selctid+" 包装id："+selccid+" 数量为："+tt)
												alert("单个金额为："+oneMoney+" 总金额为："+allMoney )
											}else{
												$("#show1").show();
											}
										}
					    </script>
					
				</div>

			</div>

			<div class="clear"></div>

		</div>
		<!-- introduce-->

		<div class="introduce">
			<div class="browse">
				<div class="mc">
					<ul>
						<div class="mt">
							<h2>看了又看</h2>
						</div>
						<c:forEach items="${seeList }" var="l">
							<li class="first">
								<div class="p-img">
									<a href="toShowOne?cid=${l.cid }"> <img class=""
										src="${ctx}${l.commodityPics.cpImg}">
									</a>
								</div>
								<div class="p-name">
									<a href="toShowOne?cid=${l.cid }"> ${l.cname } </a>
								</div>
								<div class="p-price">
									<strong>￥${l.price }</strong>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="introduceMain">
				<div class="am-tabs" data-am-tabs>
					<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#"> <span
								class="index-needs-dt-txt">宝贝详情</span></a></li>

						<li><a href="#"> <span class="index-needs-dt-txt">全部评价</span></a>

						</li>

						<li><a href="#"> <span class="index-needs-dt-txt">猜你喜欢</span></a>
						</li>
					</ul>

					<div class="am-tabs-bd">

						<div class="am-tab-panel am-fade am-in am-active">
							<div class="J_Brand">

								<div class="attr-list-hd tm-clear">
									<h4>产品参数：</h4>
								</div>
								<div class="clear"></div>
								<ul id="J_AttrUL">
									<c:forEach items="${ds }" var="d">
										<li title="">${d }</li>
									</c:forEach>
								</ul>
								<div class="clear"></div>
							</div>

							<div class="details">
								<div class="attr-list-hd after-market-hd">
									<h4>商品细节</h4>
								</div>
								<div class="twlistNews">
									<img src="${ctx}/resources/images/tw1.jpg" /> <img
										src="${ctx}/resources/images/tw2.jpg" /> <img
										src="${ctx}/resources/images/tw3.jpg" /> <img
										src="${ctx}/resources/images/tw4.jpg" /> <img
										src="${ctx}/resources/images/tw5.jpg" /> <img
										src="${ctx}/resources/images/tw6.jpg" /> <img
										src="${ctx}/resources/images/tw7.jpg" />
								</div>
							</div>
							<div class="clear"></div>

						</div>

						<div class="am-tab-panel am-fade">
							<div class="actor-new">
								<div class="rate">
									<strong>${commodity.commoditySell.goodlv }<span>%</span></strong><br>
									<span>好评度</span>
								</div>
							</div>
							<div class="clear"></div>
							<div class="tb-r-filter-bar">
								<ul class=" tb-taglist am-avg-sm-4">
									<li class="tb-taglist-li tb-taglist-li-current">
										<div class="comment-info">
											<span>全部评价</span> <span class="tb-tbcr-num">(${commodity.commoditySell.allComm })</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li-1">
										<div class="comment-info">
											<span>好评</span> <span class="tb-tbcr-num">(${commodity.commoditySell.goodcomm })</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li-0">
										<div class="comment-info">
											<span>中评</span> <span class="tb-tbcr-num">(${commodity.commoditySell.midcomm })</span>
										</div>
									</li>

									<li class="tb-taglist-li tb-taglist-li--1">
										<div class="comment-info">
											<span>差评</span> <span class="tb-tbcr-num">(${commodity.commoditySell.badcomm })</span>
										</div>
									</li>
								</ul>
							</div>
							<div class="clear"></div>
							<ul class="am-comments-list am-comments-list-flip">
								<c:forEach items="${commodity.comments }" var="cc">
									<li class="am-comment">
										<!-- 评论容器 --> <a href=""> <img class="am-comment-avatar"
											src="${ctx}/resources/images/hwbn40x40.jpg" /> <!-- 评论者头像 -->
									</a>

										<div class="am-comment-main">
											<!-- 评论内容容器 -->
											<header class="am-comment-hd">
												<!--<h3 class="am-comment-title">评论标题</h3>-->
												<div class="am-comment-meta">
													<!-- 评论元数据 -->
													<a href="#link-to-user" class="am-comment-author">*****
														(匿名)</a>
													<!-- 评论者 -->
													评论于
													<time datetime="">${cc.createDate }</time>
												</div>
											</header>

											<div class="am-comment-bd">
												<div class="tb-rev-item " data-id="255776406962">
													<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
														${cc.content }</div>
												</div>

											</div>
											<!-- 评论内容 -->
										</div>
									</li>
								</c:forEach>
							</ul>
							<div class="clear"></div>
							<div class="clear"></div>
							<div class="tb-reviewsft">
								<div class="tb-rate-alert type-attention">
									购买前请查看该商品的 <a href="#" target="_blank">购物保障</a>，明确您的售后保障权益。
								</div>
							</div>

						</div>

						<div class="am-tab-panel am-fade">
							<div class="like">
								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<c:forEach items="${likeList }" var="li">
										<li>
											<div class="i-pic limit">
												<a href="toShowOne?cid=${li.cid }"><img
													src="${ctx}${li.commodityPics.cpImg}" /></a>
												<p>
													<a href="toShowOne?cid=${li.cid }">${li.cname }</a>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>${li.price}</strong>
												</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="clear"></div>

						</div>

					</div>

				</div>

				<div class="clear"></div>

				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
								href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
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
			</div>

		</div>
	</div>
	<!--菜单 -->
	<div class=tip>
		<c:if test="${!empty users }">
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item">
					<a href="#"> <span class="setting"></span>
					</a>
					<div class="ibar_login_box status_login">
						<div class="avatar_box">
							<p class="avatar_imgbox">
								<img src="${ctx}/resources/images/no-img_mid_.jpg" />
							</p>
							<ul class="user_info">
								<li>用户名：sl1903</li>
								<li>级&nbsp;别：普通会员</li>
							</ul>
						</div>
						<div class="login_btnbox">
							<a href="#" class="login_order">我的订单</a> <a href="#"
								class="login_favorite">我的收藏</a>
						</div>
						<i class="icon_arrow_white"></i>
					</div>

				</div>
				<div id="shopCart" class="item">
					<a href="#"> <span class="message"></span>
					</a>
					<p>购物车</p>
					<p class="cart_num">0</p>
				</div>
				<div id="asset" class="item">
					<a href="#"> <span class="view"></span>
					</a>
					<div class="mp_tooltip">
						我的资产 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div id="brand" class="item">
					<a href="#"> <span class="wdsc"><img
							src="${ctx}/resources/images/wdsc.png" /></span>
					</a>
					<div class="mp_tooltip">
						我的收藏 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div id="broadcast" class="item">
					<a href="#"> <span class="chongzhi"><img
							src="${ctx}/resources/images/chongzhi.png" /></span>
					</a>
					<div class="mp_tooltip">
						我要充值 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div class="quick_toggle">
					<li class="qtitem"><a href="#"><span class="kfzx"></span></a>
						<div class="mp_tooltip">
							客服中心<i class="icon_arrow_right_black"></i>
						</div></li>
					<!--二维码 -->
					<li class="qtitem"><a href="#none"><span
							class="mpbtn_qrcode"></span></a>
						<div class="mp_qrcode" style="display: none;">
							<img src="${ctx}/resources/images/weixin_code_145.png" /><i
								class="icon_arrow_white"></i>
						</div></li>
					<li class="qtitem"><a href="#top" class="return_top"><span
							class="top"></span></a></li>
				</div>
				<!--回到顶部 -->
				<div id="quick_links_pop" class="quick_links_pop hide"></div>
			</div>
		</div>
		</c:if>
		
		<c:if test="${empty users }">
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item">
					<a href="javascript:void(0);" onclick="toLogin();"> <span class="setting"></span>
					</a>
					<div class="ibar_login_box status_login">
						<div class="avatar_box">
							<p class="avatar_imgbox">
								<img src="${ctx}/resources/images/no-img_mid_.jpg" />
							</p>
							<ul class="user_info">
								<li>用户名：****</li>
								<li>级&nbsp;别：**会员</li>
							</ul>
						</div>
						<div class="login_btnbox">
							<a href="javascript:void(0);" onclick="toLogin();" class="login_order">我的订单</a> 
							<a href="javascript:void(0);" onclick="toLogin();"
								class="login_favorite">我的收藏</a>
						</div>
						<i class="icon_arrow_white"></i>
					</div>

				</div>
				<div id="shopCart" class="item">
					<a href="javascript:void(0);" onclick="toLogin();"><span class="message"></span>
					</a>
					<p>购物车</p>
					<p class="cart_num">0</p>
				</div>
				<div id="asset" class="item">
					<a href="javascript:void(0);" onclick="toLogin();"> <span class="view"></span>
					</a>
					<div class="mp_tooltip">
						我的资产 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div id="brand" class="item">
					<a href="javascript:void(0);" onclick="toLogin();"> <span class="wdsc"><img
							src="${ctx}/resources/images/wdsc.png" /></span>
					</a>
					<div class="mp_tooltip">
						我的收藏 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div id="broadcast" class="item">
					<a href="javascript:void(0);" onclick="toLogin();"> <span class="chongzhi"><img
							src="${ctx}/resources/images/chongzhi.png" /></span>
					</a>
					<div class="mp_tooltip">
						我要充值 <i class="icon_arrow_right_black"></i>
					</div>
				</div>

				<div class="quick_toggle">
					<li class="qtitem"><a href="#"><span class="kfzx"></span></a>
						<div class="mp_tooltip">
							客服中心<i class="icon_arrow_right_black"></i>
						</div></li>
					<!--二维码 -->
					<li class="qtitem"><a href="#none"><span
							class="mpbtn_qrcode"></span></a>
						<div class="mp_qrcode" style="display: none;">
							<img src="${ctx}/resources/images/weixin_code_145.png" /><i
								class="icon_arrow_white"></i>
						</div></li>
					<li class="qtitem"><a href="#top" class="return_top"><span
							class="top"></span></a></li>
				</div>

				<!--回到顶部 -->
				<div id="quick_links_pop" class="quick_links_pop hide"></div>
			</div>
		</div>
		</c:if>
		
	</div>

</body>

</html>