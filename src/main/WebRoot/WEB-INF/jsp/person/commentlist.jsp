<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>发表评论</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/css/appstyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.7.2.min.js"></script>
</head>

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
                            <c:if test="${empty users}">
                                <a href="${ctx}/loginOrRegister/loginInput" target="_top" class="h">亲，请登录</a>
                                <a href="${ctx}/loginOrRegister/registerInput" target="_top">免费注册</a>
                            </c:if>
                            <c:if test="${!empty users}">
                                <a href="${ctx}/loginOrRegister/loginOut">注销</a>
                            </c:if>
                        </div>
                    </div>
                </ul>
                <ul class="message-r">
                    <div class="topMessage home">
                        <div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
                    </div>
                    <div class="topMessage my-shangcheng">
                        <div class="menu-hd MyShangcheng"><a href="${ctx}/users/allInfo" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
                    </div>
                    <div class="topMessage mini-cart">
                        <div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
                    </div>
                    <div class="topMessage favorite">
                        <div class="menu-hd"><a href="${ctx}/users/allCollects" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
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

            <div class="user-comment">
                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">发表评论</strong> /
                        <small>Make&nbsp;Comments</small>
                    </div>
                </div>
                <hr/>
                    <div class="comment-main">
                        <!-- TODO 多个商品评论 -->
                        <c:forEach items="${commodityItems}" var="items">
                        <%-- action="${ctx}/users/addComment" --%>
                        <form id="form${items.commodity.cid}" method="post">
                            <div class="comment-list">
                                <div class="item-pic">
                                    <a href="#" class="J_MakePoint">
                                        <img src="${items.commodity.commodityPics.cpImg}" class="itempic">
                                    </a>
                                </div>
                                <div class="item-title">
                                    <div class="item-name">
                                        <a href="#">
                                            <p class="item-basic-info">${items.commodity.cname}</p>
                                        </a>
                                    </div>
                                    <div class="item-info">
                                        <div class="info-little">
                                            <span>类型：${items.commodityType.typeName}</span>
                                            <span>包装：${items.commodityCombo.ccname}</span>
                                        </div>
                                        <div class="item-price">
                                            价格：<strong>${items.commodity.price}元</strong>
                                        </div>
                                    </div>
                                </div>
                                <div class="clear"></div>
                                <div class="item-comment">
                                    <%-- 评论内容 --%>
                                    <textarea id="text${items.commodity.cid}" name="content" required placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
                                    <%-- 商品id --%>
                                    <input type="hidden" name="cid" value="${items.commodity.cid}">
                                    <%-- 用户id --%>
                                    <input type="hidden" name="uid" value="${users.uid}">
                                    <%-- 订单id --%>
                                    <input type="hidden" name="oid" value="${order.oid}">
                                    <%-- 评论类别 --%>
                                    <input type="hidden" name="type" id="ctype${items.commodity.cid}">
                                </div>
                                <div id="type${items.commodity.cid}" class="item-opinion">
                                    <li value="1"><i class="op1"></i>好评</li>
                                    <li value="2"><i class="op2"></i>中评</li>
                                    <li value="0"><i class="op3"></i>差评</li>
                                </div>
                            </div>
                            <div class="info-btn">
                                <div class="am-btn am-btn-danger">
                                    <input class="am-btn am-btn-danger" id="subComment${items.commodity.cid}" type="submit" value="发表评论">
                                </div>
                            </div>
                        </form>
                        </c:forEach>
                        <script type="text/javascript">
                            $(document).ready(function () {
                                //截取最后的数字 不管是几位数字
                                //被点击的按钮id
                                //选择评论类型
                                $("div[id^=type] li").click(function () {
                                    $(this).prevAll().children('i').removeClass("active");
                                    $(this).nextAll().children('i').removeClass("active");
                                    $(this).children('i').addClass("active");
                                    //被点击的按钮id
                                    var idStr = $(this).parent('div').attr("id");
                                    //截取最后的数字 不管是几位数字
                                    var id = idStr.substring(4, idStr.length);
                                    //设置评论类别
                                    $("#ctype" + id).attr("value", $(this).val());
                                    return false;
                                });
                                //记录点击提交的次数，如果i等于集合长度就提交
                                var i = 0;
                                function cli() {
                                    i++;
                                    return i;
                                }
                                $("input[id^=subComment]").click(function () {
                                    var idStr = $(this).attr("id");
                                    var id = idStr.substring(10, idStr.length);
                                    var type = $("#ctype" + id).val();
                                    //获取页面上所有form 返回的是数组
                                    var form = $("form[id^=form]");
                                    //记录点击提交的次数
                                    var j;
                                    if (type == '') {
                                        alert("请选择评价类型");
                                        return false;
                                    }
                                    //console.info("数组长度:" + form.length);
                                    //console.info("i长度:" + i)
                                    //如果i为form的长度则是最后一个表单 就要修改订单状态为已完成
                                    var cid = id; //商品id
                                    var oid = ${order.oid}; //订单id
                                    var uid = ${users.uid}; //用户id
                                    var content = $("#text" + id).val();
                                    if (content == ''){
                                        alert("请填写评论内容");
                                        return false;
                                    }
                                    if (type != '' && content != ''){
                                        j = cli();
                                    }
                                    if (j != form.length) {
                                        var url = "${ctx}/users/addComment";
                                        var param = {cid:cid,uid:uid,type:type,content:content};
                                        console.info(param);
                                        $.post(url,param,function (data) {
                                            if (data == 1){
                                                alert("添加评价成功");
                                            }
                                            //隐藏点击提交的表单
                                            $("#form" + id).hide();
                                        });
                                    } else if (j == form.length){
                                        var url = "${ctx}/users/okOrder/" + ${order.oid};
                                        var param = {cid:cid,uid:${users.uid},type:type,content:content};
                                        $.post(url,param,function (data) {
                                            if (data == 1){
                                                alert("添加评价成功");
                                            }
                                            parent.location.href = "${ctx}/users/orders";
                                        });
                                    }
                                    return false;
                                });
                            })
                        </script>
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
