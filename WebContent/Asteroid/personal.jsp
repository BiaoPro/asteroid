<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人主页</title>
<style>
body {
	background-color:#EEE;
}

.head {
	height:180px;
	width:220px;
}

.name1 {
	font-family:黑体；
	font-size:50px;
	color:#333;
	font-weight:800;
}
.l_img {
	float:left;
	height:200px;
	width:300px;
	margin-left:10px;
	clear:both;
	padding:20px;
}
.div1{
	background:#FFF;
	width:800px;
	margin:30px 100px 10px 75px;
	padding:10px 25px 50px 25px;
}
.img-circle {
  border-radius: 80%;
  width:100px;
  height:100px;
}
.passage{
	font-size:16px;
	line-height:20px;
}
</style>
</head>
<body >
<!--------------*******************************************导航条*********************************************--------------------->
<%@include file="main/banner.jsp" %>
<!--------------*******************************************页面顶部图片*********************************************--------------------->
<div class="container">
<div class="div1" align="center">
<img src="images/oldman.jpg" class="img-circle">
<h1 class="name1">丘山日尧王木木</h1>
<a  data-toggle="modal" href="#S"><button class="btn btn-inverse btn-mini">私信</button>
</div></div>
<!--------------*******************************************博文*********************************************--------------------->
<div class="container">
      <div class="div1"> 
        <!------************此处获取博文标题*************------->
        <div align="left"> <a href="passage.html" style="font-size:30px;font-family:黑体;color:#333;font-weight:800;">摄影</a>
          <!------************此处获取博文内容*************------->
          <img src="images/buildings.jpg"  class="l_img">
           <p class="passage">一幅图片是一个时间的遗址，这里保存了某些记忆。由此我们可以进入回忆，并说话。被拍下的瞬间并非世界的结束，而是世界的开始。瞬间的记录，它是一个入口，由此而去，思之路开始。图片不是世界的终结之处，而是开始。我们来到一幅图片面前，就像面对荒野，它可以把我们领到世界的另一面。文明的这一面。文是一个动词。明是一个被文出来的状态。图片具有某种原始因素，它来自存在，但存在已经不在此，它其实是虚构，但不是凭空的，它是世界的某种痕迹，这种痕迹令我们向文明而去。图片象征着在文字之前人与世界的关系。我们看见了这样而不是那样。是这些痕迹令我们思想。图片是最早的文字，它的本能是记录世界，如早期人类的某些壁画。图片的本能不是思想世界，而是看见世界。文字是关于世界的思想</p>
          </div>
        </div>
      </div>
    
<!--------------******************************************* 文字发表S*********************************************--------------------->
<div class="container">
  <div id="S" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a class="close" data-dismiss="modal">×</a> <img src="images/老人.jpg" style="height:80px;width:80px"> <small>----丘山日尧王木木</small> </div>
    <div class="control-group">
      <div class="controls"> <i class="icon-edit" style="margin-left:30px;"></i>
        <textarea class="input-xlarge"  style="width:400px;height:200px;margin:10px;" placeholder=" 私信内容："></textarea>
        <input type="submit" value="发送" style="background:black;color:white; margin-left:400px;width:60px;" />
      </div>
    </div>
  </div>
</div>


<script type="text/javascript" src=" js/jquery.min.js"></script> 
<script type="text/javascript" src="js/bootstrap-dropdown.js"></script> 
<script src="js/bootstrap.js"></script> 


</body>
</html>
