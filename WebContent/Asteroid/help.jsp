<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>help</title>
<style>
body {
	background-color:#EEE;
}
.div1 {
	background-color:#FFF;
	-moz-box-shadow: 1px 5px 5px #888888; /* 老的 Firefox */
	box-shadow: 1px 5px 5px #888888;
}
.button-sure {
	color:#999;
	width:70px;
	height:50px;
}
</style>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>

<body>
<!--------------*******************************************导航条*********************************************--------------------->
<%@include file="main/banner.jsp" %>
<!--------------*******************************************反馈内容模块*********************************************--------------------->
<div class="container">
  <div class="div1" style="margin-top:45px;">
    <div>
    <form action="LetterAction" method="post">
    <input type="hidden" name="user_id" value="${sessionScope.user.user_id }">
      <div style="background-color:#CCC;height:40px;padding:5px;">
        <p style="margin:5px;font-size:24px;"><strong>我要反馈</strong></p>
      </div>
      <textarea name="content" class="input-xlarge"  style="width:820px;height:60px;margin-top:20px;margin-left:20px;" placeholder="请在此处填写你的反馈信息"></textarea>
      <button type="submit" class="btn" style="margin-top:25px;width:70px;height:40px;"><i class="icon-check"></i>提交</button>
   </form>
   
    </div>
    <div>
      <hr/>
    </div>

  </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script src="js/bootstrap-modal.js"></script> 
<script  src="js/bootstrap-dropdown.js">
</script> 
<script type="text/javascript">
        $(document).ready(function () {
            $('.dropdown-toggle').dropdown();
        });
   </script>
   
<script language="javascript">
	var msg="${actionErrors[0]}";
	if(msg!=null&&msg!="") {alert(msg);}
	
</script>
</body>
</html>
