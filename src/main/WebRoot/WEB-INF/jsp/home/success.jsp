<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="${ctx}/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="${ctx}/resources/css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/basic/js/jquery-1.7.min.js"></script>

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
<b class="line"></b>


<c:if test="${orders.status==0}">
<div class="take-delivery">
 <div class="status">
   <h2>您已成功付款</h2>
   <div class="successInfo">
     <ul>
       <li>付款金额<em><c:out value="${orders.money}"/></em></li>
       <div class="user-info">
         <p>收货人：<c:out value="${orders.userAddress.uaname}"/></p>
         <p>联系电话：<c:out value="${orders.userAddress.uatel}" /></p>
         <p>收货地址：<c:out value="${orders.userAddress.address}" /></p>
       </div>
             请认真核对您的收货信息，如有错误请联系客服
                               
     </ul>
     <div class="option">
       <span class="info">您可以</span>
        <a href="${ctx}/resources/person/order.html" class="J_MakePoint">查看<span>已买到的宝贝</span></a>
        <a href="${ctx}/resources/person/orderinfo.html" class="J_MakePoint">查看<span>交易详情</span></a>
     </div>
    </div>
  </div>
</div>
</c:if>
<c:if test="${orders.status==-1}">
<div class="take-delivery">
 <div class="status">
<h2>余额不足</h2>
<li>应付款金额<em>￥：<c:out value="${orders.money }"/></em></li>

<h2>请扫码充值</h2>
<div class="successInfo">
<img src="${ctx}/resources/images/zhifukuaid.jpg" style="widows:200px;height:300px">
</img>	
</div>
</div>
</c:if>
<div class="footer" >
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


</body>
</html>