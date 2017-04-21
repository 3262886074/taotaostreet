// JavaScript Document

//商品规格选择
$(function() {
	
	var money = 0.0*1;
	var mon = 0.0*1;
	$(".theme-options").each(function() {
		var i = $(this);
		var p = i.find("ul>li");
		p.click(function() {
			var tprice = $(this).find("input[type='hidden']").val()*1;
			if (!!$(this).hasClass("selected")) {
				$(this).removeClass("selected");
				mon = money;
			} else {
				$(this).addClass("selected").siblings("li").removeClass("selected");
				money = tprice+money;
				mon = money;
				money = money-tprice;
				alert(mon);
			}
		})
	})
	
	

})


//弹出规格选择
$(document).ready(function() {
	var $ww = $(window).width();
	if ($ww <1025) {
		$('.theme-login').click(function() {
			$(document.body).css("position", "fixed");
			$('.theme-popover-mask').show();
			$('.theme-popover').slideDown(200);

		})

		$('.theme-poptit .close,.btn-op .close').click(function() {
			$(document.body).css("position", "static");
			//					滚动条复位
			$('.theme-signin-left').scrollTop(0);

			$('.theme-popover-mask').hide();
			$('.theme-popover').slideUp(200);
		})

	}
})

//导航固定
$(document).ready(function() {
	var $ww = $(window).width();
	var dv = $('ul.am-tabs-nav.am-nav.am-nav-tabs'),
		st;

	if ($ww < 623) {

				var tp =$ww+363;
				$(window).scroll(function() {
					st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
					if (st >= tp) {
						if (dv.css('position') != 'fixed') dv.css({
							'position': 'fixed',
							top: 53,
							'z-index': 1000009
						});

					} else if (dv.css('position') != 'static') dv.css({
						'position': 'static'
					});
				});
				//滚动条复位（需要减去固定导航的高度）

				$('.introduceMain ul li').click(function() {
					sts = tp;
					$(document).scrollTop(sts);
				});
       } else {

		dv.attr('otop', dv.offset().top); //存储原来的距离顶部的距离
		var tp = parseInt(dv.attr('otop'))+36;
		$(window).scroll(function() {
			st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
			if (st >= tp) {
             
					if (dv.css('position') != 'fixed') dv.css({
						'position': 'fixed',
						top: 0,
						'z-index': 998
					});

				//滚动条复位	
				$('.introduceMain ul li').click(function() {
					sts = tp-35;
					$(document).scrollTop(sts);
				});

			} else if (dv.css('position') != 'static') dv.css({
				'position': 'static'
			});
		});



	}
});



$(document).ready(function() {
	//优惠券
	$(".hot span").click(function() {
		$(".shopPromotion.gold .coupon").toggle();
	})




	//获得文本框对象
	var t = $("#text_box");
	//获得库存
	var c_number = parseInt($("#c_number").val());
	//初始化数量为1,并失效减
	$('#min').attr('disabled', true);
	//输入文本框数量
	$("#text_box").keyup(function(){
			if (t.val()=="") {
				t.val(1);
				$('#min').attr('disabled', true);
				$('#add').attr('disabled', false);
			}
			if (parseInt(t.val())<=1) {
				t.val(1);
				$('#min').attr('disabled', true);
				$('#add').attr('disabled', false);
			}
			if (parseInt(t.val())>c_number) {
				t.val(1);
				$('#min').attr('disabled', true);
				$('#add').attr('disabled', false);
			}
			if (parseInt(t.val())<c_number&&parseInt(t.val())>1) {
				$('#min').attr('disabled', false);
				$('#add').attr('disabled', false);
			}
			if (parseInt(t.val())==c_number) {
				$("#add").attr('disabled', true);
			}
	});
	//数量增加操作
	$("#add").click(function() {
			t.val(parseInt(t.val()) + 1)
			if (parseInt(t.val()) != 1) {
				$('#min').attr('disabled', false);
			}
			if (parseInt(t.val()) == c_number) {
				$("#add").attr('disabled', true);
			}

		})
		//数量减少操作
	$("#min").click(function() {
			t.val(parseInt(t.val()) - 1);
		if (parseInt(t.val()) == 1) {
			$('#min').attr('disabled', true);
		}
		if (parseInt(t.val()) != c_number) {
			$("#add").attr('disabled', false);
		}

	})

})