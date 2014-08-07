<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Asteroid-login</title>
<link href="Asteroid/css/bootstrap-2.3.2.css" rel="stylesheet">
<link href="Asteroid/css/button.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="Asteroid/css/html.css">
<script type="text/javascript" src="Asteroid/js/jquery.min.js"></script>
<style type="text/css">
body {
	background-color:#313131;
}
h1 {
	margin-top:15%;
	font-size:500%;
	color:#FFF;
}
h3 {
	margin-top:3%;
	color:#FFF;
	letter-spacing: 15px;
}
button {
	margin-top:2%;
}
p {
	color:#CCC;
}
a {
	margin-top:2%;
	font-size:15px;
	color:#FFF;
	letter-spacing: 15px;
}
</style>
<script language="javascript">
	var msg="${actionErrors[0]}";
	if(msg!=null&&msg!="") {alert(msg);}
	
</script>
<script>
jQuery(document).ready(function($) {
	$('#loading').click(function(){
		$('#loading3').fadeIn(100);
		$('#loading1').slideDown(200);
	})
	$('#loading2').click(function(){
		$('#loading3').fadeOut(100);
		$('#loading1').slideUp(200);
	})

})
</script>
<script>
jQuery(document).ready(function($) {
	$('.theme-login').click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	})
	$('.theme-poptit.close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})

})
</script>
</head>

<body align="center">
<div class="container">
  <div>
    <h1>ASTEROID<strong>&nbsp;&nbsp;·&nbsp;&nbsp;</strong>小行星</h1>
  </div>
  <div>
    <h3>快速、漂亮、有趣的记录方式</h3>
  </div>
  <!--------------------------------登陆和注册按钮--------------------------->
  <div class="theme-buy"> 
    <!--------------------------------登陆----------------------------------> 
    <a class="theme-loading" id="loading"><button type="submit" class="button black">登陆</button></a>
    <div class="theme-popover" id="loading1">
      <div class="theme-poptit" id="loading2"> <a  href="" title="关闭" class="close">×</a>
        <h4>登录 是一种态度</h4>
      </div>
      <div class="theme-popbod dform">
        <form class="theme-signin" name="loginform" action="Asteroid/LoginAction" method="post">
          <ol>
            <li>
              <h4>小行星，遇见美的开始</h4>
            </li>
            <li><strong>用户名：</strong>
              <input class="ipt" type="text" name="username"/>
            </li>
            <li><strong>密码：</strong>
              <input class="ipt" type="password" name="password" />
            </li>
            <li>
              <input class="btn btn-primary" type="submit" name="submit" value=" 登录" style="width:194px;" />
              <!-- 
              &nbsp;&nbsp;&nbsp;&nbsp; <a style="color:#000">忘记密码</a> 
               -->
            </li>
            <!-- 
            <li>
              <label class="checkbox">
                <input type="checkbox">
                &nbsp;&nbsp;&nbsp;&nbsp;记住密码</label>
            </li>
             -->
          </ol>
        </form>
      </div>
    </div>
    <div class="theme-popover-mask" id="loading3"></div>
    <!--------------------------------注册按钮-------------------------------> 
    <a class="theme-login">
    <button type="submit" class="button black">注册</button>
    </a>
    <div class="theme-popover">
      <div class="theme-poptit"> <a href="" title="关闭" class="close">×</a>
        <h4>欢迎注册小行星</h4>
      </div>
      <div class="theme-popbod dform">   
        <form class="theme-signin" name="loginform" action="RegisterAction" method="post">
          <ol>
            <li><strong>用户名称：</strong>
              <input class="ipt" type="text" name="name" />
            <li><strong>常用邮箱：</strong>
              <input class="ipt" type="text" name="username"/>
            </li>
            <li><strong>设置密码：</strong>
              <input class="ipt" type="password" name="pwd1" />
            </li>
             <li><strong>确认密码：</strong>
              <input class="ipt" type="password" name="pwd2"  />
            </li>
            <li>
              <input class="btn btn-primary" type="submit" name="submit" value=" 注册 " style="width:194px;" />
            </li>
          </ol>
        </form>
      </div>
    </div>
    <div class="theme-popover-mask"></div>
  </div>
  <div>
    <footer>
      <p>12信管2班"吴泽标组"版权所有@吴泽标 @黄佳莹 @吕柔纯 @岳晓琳 @钟霞萍</p>
    </footer>
  </div>
</div>

</body>
</html>
