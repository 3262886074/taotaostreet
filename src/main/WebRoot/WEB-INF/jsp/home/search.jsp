<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>搜索页面</title>

<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css" />

<link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet"
	type="text/css" />

<link href="${ctx}/resources/css/seastyle.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript"
	src="${ctx}/resources/basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/script.js"></script>
<script type="text/javascript">
	var pageNow = 1;// 第几页
	var pageSize = 12;// 每页行数
	var searchBid = 0;// 品牌id(查询参数)
	var searchSid = 0;// 产地id(查询参数)
	var sumPage;// 总行数（依赖后台返回）
	var parameter;// 起始查询参数
	var sortType=0;//排序类型（综合0，销量1，价格2，评价3，默认综合排序）
	var sortWay=0;//排序（降序0，升序1，默认降序）
	
	$(document).ready(
			function() {
				
				//分页
				$(".pagId").live("click",function(){
					pageNow=parseInt($(this).text());
					queryCom();
				
				});
				//上一页
				$(".pagFront").live("click",function(){
					pageNow=parseInt(pageNow)-1;
					queryCom();
				
				});
				//下一页
				$(".pagBack").live("click",function(){
					pageNow=parseInt(pageNow)+1;
					queryCom();
				
				});
				
				
				//品牌
				$(".bid").click(function() {
					if (searchBid != $(this).attr("title")) {
						searchBid = $(this).attr("title");
						$("#i-pic").remove();
						pageNow=1;
						queryCom();
					}

				});
				//产地
				$(".sid").click(function() {
					if (searchSid != $(this).attr("title")) {
						searchSid = $(this).attr("title");
						pageNow=1;
						queryCom();
					}

				});
				//清除
				$(".delid").click(function(){
					searchBid=0;
					searchSid=0;
					pageNow=1;
					queryCom();
					
				});
				//去除选中品牌
				$("#selectA").live("click",function() {
					$(this).remove();
					$("#select1 .select-all").addClass("selected")
						.siblings().removeClass("selected");
					searchBid=0;
					pageNow=1;
					queryCom();
				});
				//去除选中产地
				$("#selectB").live("click",	function() {
					$(this).remove();
					$("#select2 .select-all").addClass("selected")
						.siblings().removeClass("selected");
					searchSid=0;
					pageNow=1;
					queryCom();
				});
				
				//排序方式
				$("#select3 a").click(function(){
					if($(this).attr("title")==0){//综合
						sortType=0;
						queryCom();
						
					}else if($(this).attr("title")==1){//销量
						sortType=1;
						queryCom();
						
					}else if($(this).attr("title")==2){//价格
						sortType=2;
						sortWay=sortWay==0?1:0;
						queryCom();
						
					}else if($(this).attr("title")==3){//评价
						sortType=3;
						queryCom();
					}
				});
				//商品查询显示
				function queryCom() {
					if(parameter==null){
						parameter = $("#searchInput").attr("title");
					}
					/* alert("pageNow=" + pageNow+ "&pageSize=" + pageSize
							+ "&parameter="+ parameter + "&searchBid="
							+ searchBid	+ "&searchSid=" + searchSid
							+"&sortType="+sortType+"&sortWay="+sortWay); */
					$.get("${ctx}/home/query/search", "pageNow=" + pageNow
							+ "&pageSize=" + pageSize + "&parameter="
							+ parameter + "&searchBid=" + searchBid
							+ "&searchSid=" + searchSid+"&sortType="
							+sortType+"&sortWay="+sortWay, function(pagCom) {//回调函数
						sumPage = pagCom.sumPage;//总行数
						var strs = "";
						$.each(pagCom.commodity, function(i, commodity) {
							//alert("商品编号："+commodity.cid);
						    var comPrice = commodity.forSalePrice<=0?commodity.price:commodity.forSalePrice; 
							strs+="<li>"
								+"<a href='#'>"
							  	+"<div class='i-pic limit' style='height: 300px;'>"
							    +"<img src='${ctx}"+commodity.commodityPics.cpImg+"' />"
							    +"<p class='title fl'>"+commodity.cname+"</p>"
							    +"<p class='price fl'>"
							    +"<b>¥ </b>"
							    +"<strong>"+comPrice.toFixed(1)+"</strong>"
							    +"</p>"
							    +"<p class='number fl'>销量"
							    +"<span>"+commodity.commoditySell.allSell+"</span>"
							    +"</p>"
							    +"</div>"
							    +"</li>";
						
						});

						$("li").remove("#ulupdat li");
						$("#ulupdat").html(strs);
						showPag();
					});
				}
				//显示分页
				function showPag(){
					var strPage="";
					//alert("几页："+pageNow+"个数："+pageSize+"总个数："+sumPage);
					if(pageNow>=2){
						strPage+="<li><a class='pagFront' href='javascript:;'>&laquo;</a></li>";
					}else{
						strPage+="<li class='am-disabled'><a class='pagFront' href='javascript:;'>&laquo;</a></li>";
					}
					for(var i=1;i<sumPage/pageSize+1;i++){
						if(pageNow<3){
							if(i<=5&&i>=1){
								if(pageNow==i){
									strPage+="<li class='am-active'><a class='pagId' href='javascript:;'>"+ i +"</a></li>";
								}else{
									strPage+="<li><a class='pagId' href='javascript:;'> "+ i +"</a></li>";
								}
							}
						}else if(sumPage/pageSize-pageNow<2){
							if(i>=sumPage/pageSize-4&&i>=1){
								if(pageNow==i){
									strPage+="<li class='am-active'><a class='pagId' href='javascript:;'>"+ i +"</a></li>";	
								}else{
									strPage+="<li><a class='pagId' href='javascript:;'>"+ i +"</a></li>";
								}
							}
						}else{
							if(i<=pageNow+2&&i>=pageNow-2){
								if(pageNow==i){
									strPage+="<li class='am-active'><a class='pagId' href='javascript:;'>"+ i +"</a></li>";
								}else{
									strPage+="<li><a class='pagId' href='javascript:;'>"+ i +"</a></li>";
								}
							}
						}
					}
					if(pageNow<=sumPage/pageSize){
						strPage+="<li><a class='pagBack' href='javascript:;'>&raquo;</a></li>";
					}else{
						strPage+="<li class='am-disabled'><a class='pagBack' href='javascript:;'>&raquo;</a></li>";
					}
					//刷新
					$("li").remove("#pageShows li");
					$("#pageShows").html(strPage);
				}
				
			});
</script>

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
<<<<<<< HEAD
					<input id="searchInput" name="type" type="text" placeholder="搜索"
						   autocomplete="off" /> <input id="ai-topsearch"
														class="submit am-btn" value="搜索" index="1" type="submit" />
=======
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off" title="${pagCom.parameter }" />
					<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
						type="submit" />
>>>>>>> yls-stage01
				</form>
			</div>
		</div>
		<b class="line"></b>

		<div class="search">
			<div class="search-list">
				<div class="am-g am-g-fixed">
					<div class="am-u-sm-12 am-u-md-12">
						<div class="theme-popover">
							<div class="searchAbout">
								<span class="font-pale" title="${pagCom.parameter}">${pagCom.parameter}相关搜索：</span>
								<a title="坚果" href="#">坚果</a> <a title="瓜子" href="#">瓜子</a> <a
									title="鸡腿" href="#">豆干</a>

							</div>
							<ul class="select">
								<p class="title font-normal">
									<span class="fl">松子</span> <span class="total fl">搜索到<strong
										class="num">997</strong>件相关商品
									</span>
								</p>
								<div class="clear"></div>
								<li class="select-result">
									<dl>
										<dt>已选</dt>
										<dd class="select-no"></dd>
										<p class="eliminateCriteria"><a class="delid">清除</a></p>
									</dl>
								</li>
								<div class="clear"></div>

								<li class="select-list">
									<dl id="select1">
										<dt class="am-badge am-round">品牌</dt>

										<div class="dd-conent">
											<dd class="select-all selected">
												<a class="bid" href="javascript:;" title="0">全部</a>
											</dd>
											<c:forEach items="${pagCom.brand }" var="brand">
												<dd>
													<a class="bid" href="javascript:;" title="${brand.bid }">${brand.bname }</a>
												</dd>
											</c:forEach>
										</div>

									</dl>
								</li>
								<li class="select-list">
									<dl id="select2">
										<dt class="am-badge am-round">产地</dt>
										<div class="dd-conent">
											<dd class="select-all selected">
												<a class="sid" href="javascript:;" title="0">全部</a>
											</dd>
											<c:forEach items="${pagCom.site }" var="site">
												<dd>
													<a class="sid" href="javascript:;" title="${site.sid }">${site.sname }</a>
												</dd>
											</c:forEach>
										</div>
									</dl>
								</li>
							</ul>
							<div class="clear"></div>
						</div>
						<div class="search-content">
							<div class="sort">
								<dl id="select3">
									<li class="first"><a  title="0" href="javascript:;">综合排序</a></li>
									<li><a title="1" href="javascript:;">销量排序</a></li>
									<li><a title="2" href="javascript:;">价格优先</a></li>
									<li class="big"><a  title="3" href="javascript:;">评价为主</a></li>
								</dl>
							</div>
							<div class="clear" id="divcun"></div>

							<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes"
								id="ulupdat">
								<c:forEach items="${pagCom.commodity}" var="commodity">
									<li>
									
										<div class="i-pic limit">
											<a href="${ctx }/toShowOne?cid=${commodity.cid }">
											<img src="${ctx}${commodity.commodityPics.cpImg}" />
											<p class="title fl">${commodity.cname}</p>
												<p class="price fl">
													<b>¥</b> <strong> <c:choose>
															<c:when test="${commodity.forSalePrice!=0}">
															${commodity.forSalePrice }
														</c:when>
															<c:otherwise>
															${commodity.price }
												</c:otherwise>
														</c:choose></strong>
												</p>
												<p class="number fl">

													销量<span> ${commodity.commoditySell.allSell} </span>
												</p>
											</div>
										</a>
									</li>
								</c:forEach>
							</ul>
						</div>
						<!--  -->
						<div class="search-side">
							<div class="side-title">经典搭配</div>
							<c:forEach items="${reComs}" var="commodity">
								<li><a href="#">
										<div class="i-pic check">
											<img src="${ctx}${commodity.commodityPics.cpImg}" />
											<p class="check-title">${commodity.cname}</p>
											<p class="price fl">
												<b>¥</b> <strong> <c:choose>
														<c:when test="${commodity.forSalePrice!=0}">
															${commodity.forSalePrice }
														</c:when>
														<c:otherwise>
															${commodity.price }
												</c:otherwise>
													</c:choose></strong>
											</p>
											<p class="number fl">
												销量<span> ${commodity.commoditySell.allSell} </span>
											</p>
										</div>
								</a></li>
							</c:forEach>
						</div>
						<div class="clear"></div>
						<!--分页 -->
						<dl id="select4">
							<ul id="pageShows" class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active"><a class="pagFront" href="javascript:;">1</a></li>
								<c:forEach var="i" varStatus="stutrs" begin="0"
									end="${pagCom.sumPage/12>5?3:pageCom.sumPage/12 }">
									<li><a class="pagId" href="javascript:;">${stutrs.index+2}</a></li>
								</c:forEach>
								<li><a class="pagBack" href='javascript:;'>&raquo;</a></li>
							</ul>
						</dl>
					</div>
				</div>
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
		<div class=tip>
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

					<div id="foot" class="item">
						<a href="#"> <span class="zuji"></span>
						</a>
						<div class="mp_tooltip">
							我的足迹 <i class="icon_arrow_right_black"></i>
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
			<div id="prof-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>我</div>
			</div>
			<div id="shopCart-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>购物车</div>
			</div>
			<div id="asset-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>资产</div>

				<div class="ia-head-list">
					<a href="#" target="_blank" class="pl">
						<div class="num">0</div>
						<div class="text">优惠券</div>
					</a> <a href="#" target="_blank" class="pl">
						<div class="num">0</div>
						<div class="text">红包</div>
					</a> <a href="#" target="_blank" class="pl money">
						<div class="num">￥0</div>
						<div class="text">余额</div>
					</a>
				</div>

			</div>
			<div id="foot-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>足迹</div>
			</div>
			<div id="brand-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>收藏</div>
			</div>
			<div id="broadcast-content" class="nav-content">
				<div class="nav-con-close">
					<i class="am-icon-angle-right am-icon-fw"></i>
				</div>
				<div>充值</div>
			</div>
		</div>
		<script>
			window.jQuery
					|| document
							.write('<script src="basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript"
			src="${ctx}/resources/basic/js/quick_links.js"></script>

		<div class="theme-popover-mask"></div>
</body>

</html>