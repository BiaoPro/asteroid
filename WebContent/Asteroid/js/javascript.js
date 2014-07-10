$(function(){
var $backToTopTxt = "返回顶部", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
.text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
$("html, body").animate({ scrollTop: 0 }, 120);
}), $backToTopFun = function() {
var st = $(document).scrollTop(), winh = $(window).height();
(st > 0)? $backToTopEle.show(): $backToTopEle.hide();
//IE6下的定位
if (!window.XMLHttpRequest) {
$backToTopEle.css("top", st + winh );
}
};
$(window).bind("scroll", $backToTopFun);
$(function() { $backToTopFun(); });
});


	function deleteRelease(release_id) { //根据用户名删除用户信息
		if (confirm('确定要删除吗？')) {
			$.ajax({
				url : "ReleaseDel",
				type : 'post',
				data : 'release_id=' + release_id,
				success : function(mm) {
					$("#div_" + release_id + "").remove();
				}
			});
		}
	}
	
	
	
	function addPraise(release_id) { //根据用户名删除用户信息
			$.ajax({
				url : "PraiseAddAction",
				type : 'post',
				data : 'release_id=' + release_id,
				success : function(mm) {
					changePraise(release_id);
				}
			});
	}
	function delPraise(release_id) { //根据用户名删除用户信息
		$.ajax({
			url : "PraiseDelAction",
			type : 'post',
			data : 'release_id=' + release_id,
			success : function(mm) {
				changePraise(release_id);
			}
		});
    }
	function changePraise(id){
		if($("button.button3_" + id).is(":hidden")){
			$("button.button3_" + id).show();
			$("button.button4_" + id).hide();
		}else{
			$("button.button3_" + id).hide();
			$("button.button4_" + id).show();
		} 
	}
	
	
	
	function changeStr(id) {
		var str = $("#saytext_" + id + "").val();
		str = str.replace(/\</g, '&lt;');
		str = str.replace(/\>/g, '&gt;');
		str = str.replace(/\n/g, '<br/>');
		str = str.replace(/\[em_([0-9]*)\]/g, '<img src="arclist/$1.gif" />');
		$("#saytext_" + id + "").val(str);
		return true;
	}
	
	
	
	function addAttention(a_userid,release_id) { //根据用户名删除用户信息
		$.ajax({
			url : "AttentionAddAction",
			type : 'post',
			data : 'a_userid=' + a_userid,
			success : function(mm) {
				attention(release_id);

			}
		});
    }
	function delAttention(a_userid,release_id) { //根据用户名删除用户信息
		$.ajax({
			url : "AttentionDelAction",
			type : 'post',
			data : 'a_userid=' + a_userid,
			success : function(mm) {
				attention(release_id);
				
			}
		});
	}
	
	function attention(id) {
		if($("button.button2_" + id).is(":hidden")){
			$("button.button2_" + id).show();
			$("button.button1_" + id).hide();
		}else{
			$("button.button2_" + id).hide();
			$("button.button1_" + id).show();
		} 
		
	}
	
	
	function showComment(id){
		$("#hot1_" + id).hide();
		$("#say1_" + id).slideToggle();
	}
	
	function showHot(id){
		$("#say1_" + id).hide();
		$("#hot1_" + id).slideToggle();
		
	}
	
	
	
