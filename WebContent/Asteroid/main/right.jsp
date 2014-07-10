<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!--*************************************************右边按钮链接***********************************************************-->

	<div>
		<button class="btn btn-inverse"
			style="height: 50px; width: 200px; margin-left: 10px">
			<i class="icon-user icon-white"></i>${sessionScope.user.name}</button>
		
		<a href="ReleaseAction?user_id=${sessionScope.user.user_id}">
		<button class="btn btn-large"
			style="height: 50px; width: 200px; margin-left: 10px">
			<i class="icon-book"></i>文章
		</button>
		</a>
	</div>

	<div>
	<!--                   ***********删除该按钮************
		<button class="btn"
			style="height: 50px; width: 200px; margin-top: 30px; margin-left: 10px;">
			<i class="icon-home"></i>博客
		</button>
	 -->	
	    <a href="ReleaseAction?user_love_id=${sessionScope.user.user_id}">
		<button class="btn btn-large"
			style="height: 50px; width: 200px; margin-left: 10px; margin-top: 5px;">
			<i class="icon-heart"></i>喜欢
		</button>
		</a>
		
		<a href="ReleaseAction?user_add_id=${sessionScope.user.user_id}">
		<button class="btn btn-large"
			style="height: 50px; width: 200px; margin-left: 10px; margin-top: 5px;">
			<i class="icon-eye-open"></i>关注
		</button>
		</a>
	</div>
	<!--每日推荐的图片，点击图片可以链接到其主页-->
	<div>
		<a href="#"><img src="images/web/637a7951gw1e04qtmakj8j.jpg" style="height: 400px; width: 200px; margin: 10px;"></a>
	</div>
