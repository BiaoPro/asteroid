<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<style>
body {
	background-color: #EEE;
}

.img1 {
	height: 180px;
	width: 840px;
}

.head {
	height: 180px;
	width: 220px;
}

.div1 {
	background: #FFF;
	width: 800px;
	margin: 30px 100px 10px 75px;
	padding: 10px 25px 50px 25px;
}

.title1 {
	font-size: 20px;
	color: #333;
	font-weight: 400;
}

.l_img {
	height: 400px;
	width: 600px;
}

.head_img {
	height: 20px;
	width: 20px;
}

li {
	display: inline;
	list-style-type: none;
}

.img-circle {
	border-radius: 80%;
	width: 100px;
	height: 100px;
}
</style>
</head>

<body>
<!--------------*******************************************导航条*********************************************--------------------->
<%@include file="main/banner.jsp" %>
<!--------------*******************************************页面顶部图片*********************************************--------------------->
<div class="container">
  <div class="div1" align="center"> <img src="images/oldman.jpg" class="img-circle">
    <h1 class="name1">丘山日尧王木木</h1>
    <a  data-toggle="modal" href="#S">
    <button class="btn btn-inverse btn-mini">私信</button></a>
  </div>
</div>
<!--------------*******************************************内容*********************************************--------------------->
<div class="container">
  <div align="center" class="div1"> 
    <!------************此处获取博文标题*************------->
    <h1 class="page-header">摄影</h1>
    <!------************此处获取博文内容*************-------> 
    <img src="images/buildings.jpg" class="l_img" >
    <p>一幅图片是一个时间的遗址，这里保存了某些记忆。由此我们可以进入回忆，并说话。被拍下的瞬间并非世界的结束，而是世界的开始。瞬间的记录，它是一个入口，由此而去，思之路开始。图片不是世界的终结之处，而是开始。我们来到一幅图片面前，就像面对荒野，它可以把我们领到世界的另一面。文明的这一面。文是一个动词。明是一个被文出来的状态。图片具有某种原始因素，它来自存在，但存在已经不在此，它其实是虚构，但不是凭空的，它是世界的某种痕迹，这种痕迹令我们向文明而去。图片象征着在文字之前人与世界的关系。我们看见了这样而不是那样。是这些痕迹令我们思想。图片是最早的文字，它的本能是记录世界，如早期人类的某些壁画。图片的本能不是思想世界，而是看见世界。文字是关于世界的思想</p>
  </div>
</div>
<!--------------*******************************************标签*********************************************--------------------->
<div>
  <ul>
    <li><i class="icon-tag" style="margin-left:230px;"></i>标签：</li>
    <li>
      <button class="btn btn-inverse btn-mini">摄影</button>
    </li>
    <li style="position:relative;left:700px;"> <i class="icon-heart"></i></li>
    <!------************此处获取博文发布时间*************------->
    <li><small">2014-06-10</small></li>
  </ul>
</div>
<!--***************************************评论列表***************************************-->
<div class="container">
<div class="div1">
  <textarea class="input-xlarge"  style="width:600px;margin:10px 100px;" placeholder="请在此处评论"></textarea>
  <input type="submit" value="发布" style="background:black;color:white; margin-left:600px;width:70px;" />
  <h1 class="page-header">评论</h1>
  <!------************此处获取评论者头像*************-------> 
  <img src="images/oldman.jpg" class="head_img" > 
  <!------************此处获取评论者昵称*************-------> 
  <b>丘山日尧王木木：</b> 
  <!------************此处获取评论内容*************-------> 
  <small>感觉挺好的</small> <a  data-toggle="modal" href="#R">
  <input type="submit" value="回复" style="background:black;color:white;  margin-left:700px;width:60px;" />
  </a>
  <hr>
  <img src="images/oldman.jpg" class="head_img" > <b>丘山日尧王木木：</b> <small>感觉挺好的</small> <a  data-toggle="modal" href="#R">
  <input type="submit" value="回复" style="background:black;color:white; margin-left:700px;width:60px;" />
  </a>
  <hr>
  <img src="images/oldman.jpg" class="head_img" > <b>丘山日尧王木木：</b> <small>感觉挺好的</small> <a  data-toggle="modal" href="#R">
  <input type="submit" value="回复" style="background:black;color:white; margin-left:700px;width:60px;" />
  </a>
  <hr>
</div>
</div>
<!--***************************************热度列表***************************************-->
<div class="container">
<div class="div1">
  <h1 class="page-header">热度</h1>
  <!------************此处获取评论者头像*************-------> 
  <img src="images/oldman.jpg" class="head_img" > 
  <!------************此处获取评论者昵称*************-------> 
  <b>丘山日尧王木木</b> 
  <!------************此处获取评论内容*************-------> 
  <small>喜欢此文字</small>
  <hr>
  <img src="images/oldman.jpg" class="head_img" > <b>丘山日尧王木木</b> <small>喜欢此文字</small>
  <hr>
</div>
</div>
<!--------------******************************************* 文字发表S*********************************************--------------------->
<div class="container">
  <div id="S" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a class="close" data-dismiss="modal">×</a> <img src="images/oldman.jpg" style="height:80px;width:80px"> <small>----丘山日尧王木木</small> </div>
    <div class="control-group">
      <div class="controls"> <i class="icon-edit" style="margin-left:30px;"></i>
        <textarea class="input-xlarge"  style="width:400px;height:200px;margin:10px;" placeholder="私信内容："></textarea>
        <input type="submit" value="发送" style="background:black;color:white; margin-left:400px;width:60px;" />
      </div>
    </div>
  </div>
</div>
</div>
<!--------------******************************************* 文字发表R*********************************************--------------------->
<div class="container">
  <div id="R" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a class="close" data-dismiss="modal">×</a> <img src="images/oldman.jpg" style="height:80px;width:80px"> <small>----丘山日尧王木木</small> </div>
    <div class="control-group">
      <div class="controls"> <i class="icon-edit" style="margin-left:30px;"></i>
        <textarea class="input-xlarge"  style="width:400px;height:200px;margin:10px;" placeholder=" 回复内容："></textarea>
        <input type="submit" value="发送" style="background:black;color:white; margin-left:400px;width:60px;" />
      </div>
    </div>
  </div>
</div>
</div>
<script type="text/javascript" src=" js/jquery.min.js"></script> 
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script> 
<script src="js/bootstrap.js"></script> 

</body>
</html>

