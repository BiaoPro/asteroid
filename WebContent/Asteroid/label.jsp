<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>label-wall</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<style>
body {
	background-color: #EEE;
}

.div1 {
	background-color: #FFF;
	-moz-box-shadow: 1px 5px 5px #888888; /* 老的 Firefox */
	box-shadow: 1px 5px 5px #888888;
}

<!--
照片墙特效CSS-->.wrap a {
	display: block;
	width: 200px;
	height: 270px;
	text-decoration: none;
	color: #000;
}

.wrap {
	width: 200px;
	height: 270px;
	position: relative;
	overflow: hidden;
	font-family: arial, sans-serif;
	border: 0;
	margin: 10px 10px;
	float: left;
	display: inline;
}

.wrap img {
	width: 200px;
	height: 270px;
	border: 0;
}

.wrap i {
	display: block;
	width: 200px;
	height: 270px;
	position: absolute;
	left: 0;
	top: 250px;
	z-index: 1;
	background: #000;
	filter: alpha(opacity = 40);
	filter: progid:DXImageTransform.Microsoft.Alpha(opacity=40);
	opacity: 0.40;
	-webkit-transition: all 0.6s ease-in-out;
}

.wrap p {
	display: block;
	width: 200px;
	height: 270px;
	position: absolute;
	left: 0;
	top: 250px;
	z-index: 1;
	background: transparent;
	font-size: 12px;
	color: #fff;
	padding: 0;
	margin: 0;
	line-height: 16px;
	-webkit-transition: all 0.6s ease-in-out;
}

.wrap p b {
	display: block;
	font-size: 20px;
	color: #FFF;
	text-align: center;
	margin: 0;
	padding: 0;
	line-height: 40px;
}

.wrap p span {
	display: block;
	padding: 5px;
	line-height: 20px;
}

.wrap a:hover {
	direction: ltr;
}

.wrap a:hover i {
	top: 0;
}

.wrap a:hover p {
	top: 0;
}

.clear {
	clear: left;
}
</style>
<script>
	$('.carousel').carousel({
		interval : 1000
	})
</script>
<body>

	<!--------------*******************************************导航条*********************************************--------------------->
	<%@include file="main/banner.jsp"%>
	<script>
		var div = document.getElementById('label').setAttribute("class",
				"active");
	</script>
	<!--------------*******************************************浏览页*********************************************--------------------->
	<div class="container">
		<div style="background-color: #FFF; box-shadow: 1px 2px 2px #888888">
			<h2
				style="color: #666; text-align: center; padding: 5px; margin-bottom: 10px;">浏览页</h2>
		</div>

		<!--------------*******************************************图片轮播*********************************************--------------------->
		<div id="mycarousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner ">
				<div class="active item">
					<img src="images/web/road.jpg" class="img-carousel"
						style="height: 300px; width: 950px;">
				</div>
				<div class="item">
					<img src="images/web/country.jpg" class="img-carousel"
						style="height: 300px; width: 950px;">
					<div class="carousel-caption">
						<p>我什么都不知道</p>
					</div>
				</div>
				<div class="item">
					<img src="images/web/camera.jpg" class="img-carousel"
						style="height: 300px; width: 950px;">
				</div>
			</div>
			<a class="left carousel-control" href="#mycarousel" data-slide="prev">‹</a>
			<a class="right carousel-control" href="#mycarousel"
				data-slide="next">›</a>

		</div>
	</div>
	<!--------------*******************************************浏览、标签页*********************************************--------------------->
	<div class="container">
		<div style="background-color: #FFF; box-shadow: 1px 2px 2px #888888">
			<h2 style="color: #666; text-align: center; padding: 5px;">标签</h2>
		</div>
		<div class="div1" style="margin-top: 15px;">
			<div class="row">
				<div class="span3">
					<!--每刷新一次，获取不同的内容-------此处需要插入相对应标签的文章、图片-->
					<div class="wrap">
						<a href="ReleaseAction?tag_id=1"> <img
							src="images/photograph/movie.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">电影</button>
								<b>整容日记</b> <span> 讲述了毕业在即的名牌大学生郭晶（白百何
									饰）一夜之间沦为“双失青年”：因为容貌像“车祸现场”，被交往三年的男友直接从“女友”降级为“炮友”；因为长相缺乏“存在感”，屡次被应聘单位视做透明。痛定思痛，郭晶手握分手费去开了双眼皮，踏上了“整容不归路”。越来越升级的“美丽”，助她进入500百强，还尝到了爱情的甜头，她义无反顾向前冲，一路高歌猛进。直到有一天被小人“曝光”整容真相，美丽的奇迹瞬间幻灭成最大的笑话，郭晶只能落荒而逃。事业和爱情将面临怎样的考验？</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=2"> <img
							src="images/photograph/dongman.jpeg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">动漫</button>
								<b>《夏目友人帐》</b> <span>《夏目友人帐》是绿川幸在漫画杂志《LaLa》上连载的一部漫画作品（03年起在《LaLa
									DX》上连载，2007年10月转至《LaLa》）。夏目贵志从祖母夏目玲子的遗物中得到了那些契约书所做成的“友人帐”，他做出一个重要的决定：将友人帐中妖怪们的名字一一归还。在这样的夏目的身边，开始聚集起各种各样的妖怪们……能看到妖怪的少年夏目贵志，与招财猫外表的妖怪猫咪老师一起，为大家讲述一个个奇异、悲伤、怀念、令人感动的怪诞故事。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=3"> <img
							src="images/photograph/painting.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">绘画</button>
								<b>猫</b> <span>手绘素描小猫</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=4"> <img
							src="images/photograph/picture.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">摄影</button>
								<b>挪威</b> <span>相册拍了三年，第三次来到挪威，相册名字从北欧四国变成五国。晚上11点10分，和叶卡捷琳堡战斗民族的小伙伴们夜登奥于兰峡湾，徒步时一路的大太阳晒得人没有累的感觉。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=5"> <img
							src="images/photograph/book.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">学习</button>
								<b>管理统计学</b> <span>本书以经济管理应用案例为基础，将理论框架蕴于现实经济领域之中，将统计学理论与管理实践有机结合，同时精选作者数年来积累的MBA教学案例和实际工作案例，便于读者学以致用。本书还结合理论和应用，详细阐述了应用软件解决实际问题的方法、程序和技巧，指导读者动手操作。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=6"> <img
							src="images/photograph/life.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">生活</button>
								<b>两个人</b> <span>我觉得 俩个人在一起、 在做同一样事情就会很美妙。 不如就一起走下去吧～</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=7"> <img
							src="images/photograph/feeling.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">心情</button>
								<b>随笔</b> <span>我就是爱胡思乱想然后给自己添堵。每个人都有选择自己立场的权利，我也没有什么可责怪的，本想把那几个人叫出来好好发泄一番，大树又教育我一顿……关键是，存在十几二十年的友情！友情啊！也是我要做筛选的时候了，在我最难得时候没有人帮我，在我最幸福的时候指指点点，巴不得等着看笑话的人们，把你们抹掉不过分吧，如果你们还时刻在关注我，那看来我真是对你们意义非凡啊，但愿我能照耀你们的人生……太阳出来喽～（我又小心眼了，不过现在舒服多了）</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=8"> <img
							src="images/photograph/food.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">美食</button>
								<b>柠香玛德琳</b> <span>胖乎乎的柠香玛德琳，飘着淡淡的柠檬香味。口感松软，不油腻。配上一杯红茶或则咖啡，即是简单的下午茶。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=9"> <img
							src="images/photograph/dog.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">宠物</button>
								<b>俊介</b> <span>英系博美 实在是太可爱了..</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=10"> <img
							src="images/photograph/iphone.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">科技</button>
								<b>iphone</b> <span>iPhone，是苹果公司旗下研发的智能手机系列，它搭载苹果公司研发的iOS手机操作系统。第一代iPhone于2007年1月9日由苹果公司前首席执行官的史蒂夫•乔布斯发布，并在同年6月29日正式发售。2013年9月10日，苹果公司在美国加州举行新产品发布会上，推出第七代产品iPhone
									5S及iPhone 5C首次发布会还在北京、柏林和东京三地设置分会场，再在各地分别举行了发布会。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=11"> <img
							src="images/photograph/yule.jpeg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">娱乐</button>
								<b>TFBOYS</b> <span>TFBOYS是北京时代峰峻文化艺术发展有限公司于2013年推出的组合，由王俊凯、王源和易烊千玺3名成员组成。
									2013年10月18日，TFBOYS发行首张EP《Heart梦•出发》。2014年3月，TFBOYS发行单曲《魔法城堡》；4月，TFBOYS获得音悦V榜中国内地最具人气歌手奖和音悦直播人气歌手；5月31日，TFBOYS参与录制的《快乐大本营》播出。</span>
							</p>
						</a>
					</div>
				</div>
				<div class="span3">
					<div class="wrap">
						<a href="ReleaseAction?tag_id=12"> <img
							src="images/photograph/yuanchuang.jpg" /> <i></i>
							<p>
								<button class="btn btn-inverse btn-mini">原创</button>
								<b>WW</b> <span>里程碑，虽然知道丑极了但是是自己第一次原创的原画设计，为一个游戏做的呢w</span>
							</p>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
		<%@include file="main/footer.jsp"%>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="boostrap/js/bootstrap-carousel.js"></script>
	<script src="boostrap/js/bootstrap-dropdown.js"></script>
</body>
</html>
