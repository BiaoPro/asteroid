<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<style>
body {
	background-color:#EEE;
	
}

*{
font:幼圆;
}


.div1 {
	background-color:#CCC;
	width:100%;
	-moz-box-shadow: 1px 5px 5px #888888; /* 老的 Firefox */
	box-shadow: 1px 5px 5px #888888;
}
li {
	display:inline;
	float:left;
}
.photo {
	height:200px;
	width:180px;
	border:solid;
	border-color:#CCC;
}
.pics {opacity:1;filter:alpha(opacity=100);}
.pics:hover {opacity:0.5;filter:alpha(opacity=50);}
</style>
<!--关注、取消关注-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

</head>

<body style="background-color:#EEE;">
<%@include file="main/banner.jsp" %>
<!--------------*******************************************寻找好友******找呀找呀找朋友***************************************------------>
<div class="container">
		<div class="div1">
			<div class="row">
				<form role="form" class="form-horizontal" action="SearchAttentionAction" method="post">

					<ul style="display: in-line">
						<li><label for="key" class="well" style="height:50px;	background-color:#CCC;border:0px;"><strong>寻找好友:</strong></label></li>
						<li><input name="key"  style="height:50px;width:600px" type="text"
							class="form-control" placeholder="文本输入"></li>
						<li>
							<button type="submit" class="btn btn-link well"
								style="width: 70px; height: 30px; margin: 14px;">
								<i class="icon-check"></i>确定
							</button>
						</li>
					</ul>
				</form>
		 </div>
		</div>
	<div class="panel panel-default">
      <div class="panel-heading" style="text-align:center;">
        <h2>好友列表</h2>
      </div>
   
      <div class="panel-body">
        <div class="row">
        
         <c:forEach items="${sessionScope.userList}" var="users">
          <div class="span3" style=" width:202px;">
            <div class="panel panel-default">
              <div class="panel-heading"><a href="ReleaseAction?user_id=${users.user_id }"><img src="${users.image }" class="photo pics"></a> </div>
              <div class="panel-body">
                 <div style="width:100px;height:15px;float:left;">
                    <p style="color:#666; font-family:Verdana, Geneva, sans-serif; font-size:16px;">${users.name }</p>
                    </div>
                    <div style="float:right">
               <c:if test="${sessionScope.user.user_id!=users.user_id }">
                    <c:if test="${!userVO.isAttention(users.user_id) }">
                    <button class="btn btn-mini btn-info" id="btnA_${users.user_id }" onClick="addAttention(${users.user_id })"><i class=" icon-plus icon-white"></i>关注</button>
                    <button class="btn btn-mini btn-info" id="btnD_${users.user_id }" onClick="delAttention(${users.user_id })" style="display:none"><i class=" icon-plus icon-white"></i>取消</button>
                    </c:if>
                     <c:if test="${userVO.isAttention(users.user_id) }">
                    <button class="btn btn-mini btn-info" id="btnA_${users.user_id }" onClick="addAttention(${users.user_id })" style="display:none"><i class=" icon-plus icon-white"></i>关注</button>
                    <button class="btn btn-mini btn-info" id="btnD_${users.user_id }" onClick="delAttention(${users.user_id })"><i class=" icon-plus icon-white"></i>取消</button>
                    </c:if>
                </c:if>    
                    
                    </div>
              </div>
            </div>
          </div>
       </c:forEach>
       
          <!----我是分割线----->
        </div>
      </div>
    </div>
</div>

<%@include file="main/footer.jsp" %>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap-dropdown.js">
</script> 
<script>
function addAttention(a_userid) { //根据用户名删除用户信息
	$.ajax({
		url : "AttentionAddAction",
		type : 'post',
		data : 'a_userid=' + a_userid,
		success : function(mm) {
			attention(a_userid);
		}
	});
}
function delAttention(a_userid) { //根据用户名删除用户信息
	$.ajax({
		url : "AttentionDelAction",
		type : 'post',
		data : 'a_userid=' + a_userid,
		success : function(mm) {
			attention(a_userid);
		}
	});
}

function attention(id) {
	if($("#btnA_" + id).is(":hidden")){
		$("#btnA_" + id).show();
		$("#btnD_" + id).hide();
	}else{
		$("#btnA_" + id).hide();
		$("#btnD_" + id).show();
	} 
	
}


</script>
</body>
</html>
