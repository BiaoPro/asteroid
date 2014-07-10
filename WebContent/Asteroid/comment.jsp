<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!-- -----------------------------------------------------------qq表情插件部分---------------------------------------------------------- -->

<style>
.comment{width:95%; margin:0px auto; position:relative; background:#fff; padding:20px 10px 10px; border:1px solid #DDD; border-radius:5px;}
.comment h3{height:28px; line-height:28px}
.com_form{width:100%; position:relative}
.input{width:99%; height:60px; border:1px solid #ccc}
.com_form p{height:28px; line-height:28px; position:relative; margin-top:10px;}
span.emotion{width:42px; height:20px; background:url(http://www.16code.com/cache/demos/user-say/img/icon.gif) no-repeat 2px 2px; padding-left:20px; cursor:pointer}
span.emotion:hover{background-position:2px -28px}
.qqFace{margin-top:4px;background:#fff;padding:2px;border:1px #dfe6f6 solid;}
.qqFace table td{padding:0px;}
.qqFace table td img{cursor:pointer;border:1px #fff solid;}
.qqFace table td img:hover{border:1px #0066cc solid;}
#show1{width:400px; margin:20px auto; background:#fff; padding:5px; border:1px solid #DDD; vertical-align:top;}

.sub_btn {
	position:absolute; right:0px; top:0;
	display: inline-block;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	*display: inline;
	vertical-align: baseline;
	margin: 0 2px;
	outline: none;
	cursor: pointer;
	text-align: center;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0,0,0,.6);
	-webkit-border-radius: 3px; 
	-moz-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
	color: #e8f0de;
	border: solid 1px #538312;
	background: #64991e;
	background: -webkit-gradient(linear, left top, left bottom, from(#7db72f), to(#4e7d0e));
	background: -moz-linear-gradient(top,  #7db72f,  #4e7d0e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#7db72f', endColorstr='#4e7d0e');
}
.sub_btn:hover {
	background: #538018;
	background: -webkit-gradient(linear, left top, left bottom, from(#6b9d28), to(#436b0c));
	background: -moz-linear-gradient(top,  #6b9d28,  #436b0c);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#6b9d28', endColorstr='#436b0c');
}
</style>
<!-- -----------------------------------------------------------qq表情插件部分---------------------------------------------------------- -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <!--***************************************评论列表***************************************-->
      <div id="say1_${param.id }" style="background-color:#fff" class="div1">
       
        <div> 
               <div class="show1"></div>
				<div class="comment">
					<div class="com_form">
						<textarea class="input" id="saytext" name="saytext" placeholder="我要发表品论。。。"></textarea>
						<p>
							<input type="button" class="sub_btn" value="提交"><span
								class="emotion">表情</span>
						</p>
					</div>
				</div>
		</div>
        <!--
        <div>
          <textarea class="input-xlarge"  style="width:500px;margin:10px;" placeholder="请在此处评论"></textarea>
          <button class="btn" style="margin:1px;position:relative;left:470px;">发布</button>
        </div>
          -->
			<div>
				<table class="table table-striped">
					<tbody>
					<thead style="background-color: #999;">
						<tr>
							<th>评论列表</th>
						</tr>

					</thead>
					<c:forEach items="${sessionScope.release.commentList }" var="vo">
						<tr>
							<td><img src="${vo.user.image}"
								style="height: 30px; width: 30px;"><font color=blue>${vo.user.name}</font>:${vo.content}</td>
						</tr>
					</c:forEach>
					</tbody>

				</table>
			</div>
	
			
    </div>
<script  src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.qqFace.js"></script>
<script type="text/javascript">
$(function(){
	$('.emotion').qqFace({
		id : 'facebox', 
		assign:'saytext', 
		path:'arclist/'	//表情存放的路径
	});
	$(".sub_btn").click(function(){
		var str = $("#saytext").val();
		$("#show").html(replace_em(str));
	});
});
//查看结果
function replace_em(str){
	str = str.replace(/\</g,'&lt;');
	str = str.replace(/\>/g,'&gt;');
	str = str.replace(/\n/g,'<br/>');
	str = str.replace(/\[em_([0-9]*)\]/g,'<img src="arclist/$1.gif" border="0" />');
	return str;
}
</script>
<script src="http://www.jq22.com/js/jq.js"></script>

