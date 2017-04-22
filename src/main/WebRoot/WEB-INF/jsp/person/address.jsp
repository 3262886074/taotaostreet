<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>地址管理</title>

    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

    <link href="${ctx}/resources/css/personal.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/css/addstyle.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
    <script src="${ctx}/resources/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
</head>

<script type="text/javascript">
    $(function () {
        //更新默认地址
        $("li[id^=userAddress]").click(function () {
            //被点击的按钮id
            var idStr = $(this).attr("id");
            //截取最后的数字 不管是几位数字
            var id = idStr.substring(11, idStr.length);
            var form = $("#form" + id);
            var url = "${ctx}/users/setDefaultAddress";
            form.attr("action",url);
            form.submit();
            return false;
        });
        //删除地址
        $("a[id^=deleteAddr]").click(function () {
            //被点击的按钮id
            var idStr = $(this).attr("id");
            //截取最后的数字 不管是几位数字
            var id = idStr.substring(10, idStr.length);
            var form =  $("#deleteForm"+id);
            var action = "${ctx}/users/deleteAddress";
            form.attr("action",action);
            form.submit();
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

            <div class="user-address">
                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
                </div>
                <hr/>
                <ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
                    <c:forEach items="${userAddresses}" var="address">
                    <li id="userAddress${address.uaId}" class="user-addresslist defaultAddr">
                        <c:if test="${address.status == 1}">
                        <span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
                        </c:if>
                        <c:if test="${address.status == 0}">
                            <span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
                        </c:if>
                        <p class="new-tit new-p-re">
                            <span class="new-txt">${address.uaname}</span>
                            <span class="new-txt-rd2">${address.uatel}</span>
                        </p>
                        <div class="new-mu_l2a new-p-re">
                            <p class="new-mu_l2cw">
                                <span class="title">地址：</span>
                                <span class="province">${address.location}</span>省
                                <span class="street">${address.address}</span></p>
                        </div>
                        <div class="new-addr-btn">
                            <%--<a href="#"><i class="am-icon-edit"></i>编辑</a>--%>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" id="deleteAddr${address.uaId}"><i class="am-icon-trash"></i>删除</a>
                            <%-- 隐藏表单 --%>
                            <form action="" id="deleteForm${address.uaId}" method="post">
                                <input type="hidden" id="hideUaId" name="uaid" value="${address.uaId}">
                                <input type="hidden" name="_method" value="DELETE">
                            </form>
                        </div>
                    </li>
                    <%-- 隐藏表单 --%>
                    <form action="" method="post" id="form${address.uaId}">
                        <input type="hidden" name="_method" value="PUT">
                        <input type="hidden" name="uid" value="${users.uid}">
                        <input type="hidden" name="uaid" value="${address.uaId}">
                    </form>
                    </c:forEach>
                </ul>
                <div class="clear"></div>
                <a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
                <!--例子-->
                <div class="am-modal am-modal-no-btn" id="doc-modal-1">

                    <div class="add-dress">

                        <!--标题 -->
                        <div class="am-cf am-padding">
                            <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
                        </div>
                        <hr/>

                        <div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
                            <form action="${ctx}/users/addAddress" method="post" class="am-form am-form-horizontal">

                                <div class="am-form-group">
                                    <label for="user-name" class="am-form-label">收货人</label>
                                    <div class="am-form-content">
                                        <input type="text" required name="uaname" id="user-name" placeholder="收货人">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-form-label">手机号码</label>
                                    <div class="am-form-content">
                                        <input id="user-phone" required name="uatel" placeholder="手机号必填" type="telephone">
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
                                <input type="hidden" name="uid" value="${users.uid}">

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <a class="am-btn am-btn-danger">
                                            保存<input type="submit">
                                        </a>
                                        <a href="javascript: void(0)" class="am-close am-btn am-btn-danger" data-am-modal-close>
                                            取消<input type="reset">
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>

                </div>

            </div>

            <script type="text/javascript">
                $(document).ready(function() {
                    $(".new-option-r").click(function() {
                        $(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
                    });

                    var $ww = $(window).width();
                    if($ww>640) {
                        $("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
                    }

                })
            </script>

            <div class="clear"></div>

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
                <a href="#">我的资产</a>
                <ul>
                    <li> <a href="${ctx}/users/allCoupons">优惠券 </a></li>
                    <li> <a href="${ctx}/users/allRedPackage">红包</a></li>
                </ul>
            </li>

            <li class="person">
                <a href="#">我的小窝</a>
                <ul>
                    <li> <a href="${ctx}/users/allCollects">收藏</a></li>
                </ul>
            </li>

        </ul>

    </aside>
</div>

</body>

</html>
