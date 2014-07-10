<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>set-account</title>
<script src="js/jquery.min.js">
</script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">


</head>
<style>
body {
	background-color:#EEE;
}
li {
	display:inline;
	list-style-type: none;
}
.div1 {
	background-color:#FFF;
	-moz-box-shadow: 1px 5px 5px #888888; /* 老的 Firefox */
	box-shadow: 1px 5px 5px #888888;
}
#preview {
	width:100px;
	height:100px;
	overflow:hidden;
	position:relative;
	left:120px;
}
#imghead {
 filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
	height:100px;
	width:100px;
	background-color:#FFF;
	-moz-box-shadow: 2px 0px 2px #888888; /* 老的 Firefox */
	box-shadow: 2px 0px 2px #888888;
}
#choose {
	position:relative;
	left:100px;
}
.text-large{
	height:30px;
	margin:7px;
}
</style>
<script src="photo-unload.js"></script>
<script>
$(document).ready(function(){
 $("#change1").hide(); 
});
$(document).ready(function(){
  $("#change").click(function(){
    $("#change1").toggle();
  });
});
</script>
<script>
$(document).ready(function(){
 $("#change2").hide(); 
});
$(document).ready(function(){
  $("#change3").click(function(){
    $("#change2").toggle();
  });
});
</script>
<body>
<!--------------*******************************************导航条*********************************************--------------------->
<%@include file="main/banner.jsp" %>


<!--  
<!--------------*******************************************账号设置、包括注销账号*********************************************------------------->
<div class="container">
  <div class="div1">
    <table>
      <tr>
        <th><h2 style="margin:10px;">账号设置</h2></th>
        <th><a href="#cancel" data-toggle="modal"><button class="btn btn-large btn-inverse" style="position:relative; left:700px; "><i class="icon-trash icon-white"></i>注销账号</button></a></th>
      </tr>
    </table>
  </div>
  <div class="div1" style="margin-bottom:15px;margin-top:10px;">
    <div class="row">
      <div class="span2" style="background:#CCC">
        <h3 style="margin:25px;">用户设置</h3>
      </div>
      <div class="span4" >
        <p style="font-size:18px;margin-left:5px;margin-top:15px;text-align:center;">用户目前使用名称：</p>
        <h3 style="text-align:center">${sessionScope.user.name }</h3>
        <div align="center">
          <button class="btn btn-large" style="margin:30px;" id="change3"><i class="icon-pencil"></i>修改个人资料</button>
        </div>
      </div>
      <div class="span4">
        <div id="change2" >
						<form action="UserInfoAction" method="post" enctype="multipart/form-data">
						<input type="hidden" name="user_id" value="${sessionScope.user.user_id }"> 
						<input type="hidden" name="goToUrl" value="account"> 
							<table>
								<tr>
									<td id="preview"><img id="imghead"
										src="${sessionScope.user.image }"></td>
								</tr>
								<tr>
									<td id="choose"><input type="file" name="image3" onchange="previewImage(this)" /></td>
								</tr>
								<tr>
									<td style="position: relative; left: 60px;"><input
										type="text" name="name3" value="${sessionScope.user.name }" />
									</td>
										
								</tr>
							</table>
							<button class="btn btn-success"
											style="position: relative; left: 210px; margin-bottom: 10px;">
											<i class=" icon-ok-circle icon-white"></i>确认
							</button>
						</form>

					</div>
      </div>
    </div>
  </div>
  
  <div class="div1" style="margin-bottom:15px;margin-top:10px;">
    <div class="row">
      <div class="span2" style="background:#CCC">
        <h3 style="margin:25px;">邮箱账号</h3>
      </div>
      <div class="span4" >
        <p style="font-size:18px;margin-left:5px;margin-top:15px;text-align:center;">该帐号直接登陆Asteroid</p>
        <h3 style="text-align:center">${sessionScope.user.username }</h3>
        <div align="center">
          <button class="btn btn-large" style="margin:30px;" id="change"><i class="icon-pencil"></i>修改账号密码</button>
        </div>
      </div>
      <div class="span4">
        <div id="change1">
        <form action="UserPassAction" method="post">
        <input type="hidden" name="user_id" value="${sessionScope.user.user_id }"  />
        <input type="hidden" name="username" value="${sessionScope.user.username }"  />
          <table style="text-align:center;">
            <tr>
              <td><strong>原先密码：</strong></td>
              <td><input class="ipt" type="password" name="password"  /></td>
            </tr>
            <tr>
              <td><strong>修改密码：</strong></td>
              <td><input class="ipt" type="password" name="pwd1"  /></td>
            </tr>
            <tr>
              <td><strong>确认密码：</strong></td>
              <td><input class="ipt" type="password" name="pwd2" /></td>
            </tr>
          </table>
           <button class="btn btn-success" style="position:relative;left:220px; margin-bottom:10px;"><i class=" icon-ok-circle icon-white"></i>确认</button>
         </form>
         
        </div>
      </div>
    </div>
  </div>
  
</div>
<!--------------*******************************************注销账号框*********************************************------------------->
<div class="container">
  <div id="cancel" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a class="close" data-dismiss="modal">×</a>
      <h3>账号注销</h3>
    </div>
   <form class="form-horizontal" action="UserDelAction" method="post">
    <input type="hidden"  name="user_id" value="${sessionScope.user.user_id }">
    
    <div class="modal-body">
   
     
        <fieldset>
          <div class="control-group">
            <label class="control-label" for="titile">你当前的账号：</label>
            <div class="controls">
              <input type="text" class="input-xlarge" name="username" id="title"  value="${sessionScope.user.username }" readonly>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="text"><i class="icon-edit"></i> 请输入密码：</label>
            <div class="controls">
              <input type="text" name="password" class="input-xlarge" id="text" >
            </div>
          </div>
        </fieldset>
   
    </div>
    <div class="modal-footer"> <a href="#" class="btn" data-dismiss="modal">取消</a> <button type="submit" class="btn btn-primary">注销</button> </div>
    </form>
  </div>
</div>



<!--------------*******************************************账号设置、包括注销账号*********************************************------------------->
<!-- 
<div class="container">
  <div class="div1">
    <div class="panel panel-default">
      <div class="panel-heading">
        <table>
          <tr>
            <th><h2 style="margin:10px;">账号设置</h2></th>
            <th style="padding-left:40px;"><a href="#cancel" data-toggle="modal">
              <button class="btn btn-large btn-success" ><i class="icon-trash icon-white"></i>注销账号</button>
              </a></th>
          </tr>
        </table>
      </div>
      <div class="panel-body">
        <div class="row">
          <div class="span6" style="margin-left:70px;;">
            <div class="panel panel-default">
              <div class="panel-heading"> 账号密码修改 </div>
              <div class="panel-body">
              <form>
                <table style="margin-top:10px;">
                  <tr>
                    <td style="padding-left:40px;">原先密码：</td>
                    <td><input class="text-large" type="password"  /></td>
                  </tr>
                  <tr>
                    <td style="padding-left:40px;">修改密码：</td>
                    <td><input class="text-large" type="password"  /></td>
                  </tr>
                  <tr>
                    <td style="padding-left:40px;">确认密码：</td>
                    <td><input class="text-large" type="password" /></td>
                  </tr>
                </table>
                <button class="btn btn-success" type="submit" style="position:relative;left:120px; margin-bottom:10px;width:210px;margin-top:20px;"><i class=" icon-ok-circle icon-white"></i>确认</button>
                </form>
              </div>
            </div>
          </div>
          <div class="span6" style="margin-left:80px;">
          <div class="panel panel-default">
          <div class="panel-heading">
          个人设置
          </div>
          <div class="panel-body">
          <table>
                <tr>
                  <td id="preview"><img id="imghead" src="<%=request.getContextPath()%>"></td>
                </tr>
                <tr>
                  <td id="choose"><input type="file" onchange="previewImage(this)" /></td>
                </tr>
                <tr>
                  <td style="position:relative;left:60px;"><input type="text" placeholder="请输入新的用户名称" class="text-large"/></td>
                </tr>  
              </table>
              <button class="btn btn-success" type="sumbit" style="position:relative;left:61px; margin-bottom:10px;width:220px;margin-top:10px;"><i class=" icon-ok-circle icon-white"></i>确认</button>
          </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
-->
<!--fengexian--> 

<!--------------*******************************************注销账号框*********************************************------------------->
<!--  
<div class="container">
  <div id="cancel" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a class="close" data-dismiss="modal">×</a>
      <h3>账号注销</h3>
    </div>
   <form class="form-horizontal" action="UserDelAction" method="post">
    <input type="hidden"  name="user_id" value="${sessionScope.user.user_id }">
    
    <div class="modal-body">
   
     
        <fieldset>
          <div class="control-group">
            <label class="control-label" for="titile">你当前的账号：</label>
            <div class="controls">
              <input type="text" class="input-xlarge" name="username" id="title"  value="${sessionScope.user.username }" readonly>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="text"><i class="icon-edit"></i> 请输入密码：</label>
            <div class="controls">
              <input type="text" name="password" class="input-xlarge" id="text" >
            </div>
          </div>
        </fieldset>
   
    </div>
    <div class="modal-footer"> <a href="#" class="btn" data-dismiss="modal">取消</a> <button type="submit" class="btn btn-primary">注销</button> </div>
    </form>
  </div>
</div>
-->






<script src="js/bootstrap-modal.js"></script> 
<script src="js/bootstrap-dropdown.js"></script> 

<script >
	var msg="${actionErrors[0]}";
	if(msg!=null&&msg!="") {alert(msg);}
	
</script>

</body>
</html>



