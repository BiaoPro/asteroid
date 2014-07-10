<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.asteroid.controller.daoVO.CommentVO" %>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function() {
		var id=${param.id };
		$('.face_${param.id }').qqFace({
			assign:'saytext_'+id+'' , 
			path:'arclist/'	//表情存放的路径
		});
	});
</script>

<div class="row" id="div_${param.id }">
  <!--用户头像-->
    <div class="span2"> <a><img src="${sessionScope.release.user_img}" class="head2"></a> </div>
	<div class="span7">
		<div class="div1">
			<div style="height:30px">
				<table>
					<tr>
						<td><p style="color: #666; font-size: 18px; margin-left: 10px; margin-top: 15px; float:left">${sessionScope.release.user_name }</p>
						<!--关注、取消关注-->
						<span style="margin-top:15px;  padding-left: 10px; float:left">
				<c:if test="${sessionScope.release.user_id!=sessionScope.user.user_id}">
						<c:if test="${!sessionScope.userVO.isAttention(sessionScope.release.user_id)}">
							<button class="btn button1_${param.id } btn-mini btn-info"
								onClick="addAttention(${sessionScope.release.user_id },${param.id })">
								<i class="icon-plus icon-white button1_${param.id }"></i>关注
							</button>
							<button class="btn button2_${param.id } btn-mini btn-info"
								onClick="delAttention(${sessionScope.release.user_id },${param.id })" style="display: none">
								<i class="icon-minus icon-white"></i>取消
							</button>
						</c:if>
						<c:if test="${sessionScope.userVO.isAttention(sessionScope.release.user_id)}">
							<button class="btn button1_${param.id } btn-mini btn-info"
								onClick="addAttention(${sessionScope.release.user_id },${param.id })" style="display: none">
								<i class="icon-plus icon-white button1_${param.id }"></i>关注
							</button>
							<button class="btn button2_${param.id } btn-mini btn-info"
								onClick="delAttention(${sessionScope.release.user_id },${param.id })">
								<i class="icon-minus icon-white"></i>取消
							</button>
						</c:if>
				</c:if>
						</span>	
						</td>
						<c:if test="${sessionScope.release.user_id==sessionScope.user.user_id}">
						<a class="close" onclick="deleteRelease(${param.id })">X</a>
						</c:if>
					</tr>
				</table>

			</div>
			<div>
				<hr />
			</div>
			<!--此处获取用户发布动态的标题-->
			<div>
				<h3 style="margin-left: 35px;margin-bottom:20px;">${sessionScope.release.title }</h3>
			</div>
			<!--此处获取用户发布动态的内容-->
			<div id="content1">
				<c:if test="${not empty sessionScope.release.image}">
					<img src="${sessionScope.release.image }" class="l_img" />
				</c:if>
				<p style="line-height: 20px; margin-left: 40px;">${sessionScope.release.content }</p>
			</div>
			<div>
				<hr />
			</div>
			<div>
				<ul>
					<li><i class="icon-tag" id="icon-tag1"></i>标签：</li>
					<li>
						<button class="btn btn-inverse btn-mini">${sessionScope.release.tag_name }</button>
					</li>
					<li style="position: relative; left: 325px;">
						<!-- 删除该功能 -->
						<button class="btn btn-mini" onclick="showComment(${param.id })">评论</button>
						
						<!-- 删除该功能，时间不够弄 
						<button class="btn btn-mini" onclick="showHot(${param.id })">热度</button>
						 -->
						<!-- <button class="btn btn-mini">分享</button>  -->
						<c:if test="${sessionScope.userVO.isPraise(param.id)}">
						<button class="btn btn-mini button3_${param.id }" onClick="addPraise(${param.id })"
						style="display: none">
							<i class="icon-heart"></i>
						</button>
						<button class="btn btn-mini btn-danger button4_${param.id }" onClick="delPraise(${param.id })">
							<i class="icon-heart icon-white"></i>
						</button>
						</c:if>
						<c:if test="${!sessionScope.userVO.isPraise(param.id)}">
						<button class="btn btn-mini button3_${param.id }" onClick="addPraise(${param.id })">
							<i class="icon-heart"></i>
						</button>
						<button class="btn btn-mini btn-danger button4_${param.id }" onClick="delPraise(${param.id })"
						style="display: none">
							<i class="icon-heart icon-white"></i>
						</button>
						</c:if>
					</li>
				</ul>
			</div>
			<hr />
		</div> 

		<!--***************************************热度列表***************************************-->
<!-- 删除该功能
      <div id="hot1_${param.id }" style="background-color:#FFF;display:none" class="div1">
        <table class="table table-striped">
          <tbody>
          <thead style="background-color:#999">
            <tr>
              <th>热度列表</th>
            </tr>
          </thead>
          <tr>
            <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
          </tr>
          <tr>
            <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
          </tr>
          <tr>
            <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
          </tr>
            </tbody>
          
        </table>
      </div>
-->      
		<!--***************************************评论列表***************************************-->
		<div id="say1_${param.id }" style="background-color:#fff;display:none"
			class="div1" >

			<form action="CommentAction" method="post" onsubmit="return changeStr(${param.id })">
			    <input type="hidden" name="user_id" value="${sessionScope.user.user_id}" >
			    <input type="hidden" name="release_id" value="${param.id }" >
				<div class="comment">
					<div class="com_form">
						<textarea class="input" id="saytext_${param.id }" name="content"
							placeholder="我要发表评论。。。"></textarea>
						<p>
							<input type="submit" class="sub_btn sub_btn_${param.id }" value="提交"><span
								class="emotion face_${param.id }">表情</span>
						</p>
					</div>
				</div>
			</form>
			<!--
        <div>
          <textarea class="input-xlarge"  style="width:500px;margin:10px;" placeholder="请在此处评论"></textarea>
          <button class="btn" style="margin:1px;position:relative;left:470px;">发布</button>
        </div>
          -->
			<div>
				<table class="table table-striped"  style="word-break:break-all; word-wrap:break-all;">
					<tbody>
					<thead style="background-color: #CCC;">
						<tr>
							<th>评论列表</th>
							<th></th>
						</tr>

					</thead>
					<c:forEach items="${sessionScope.release.commentList }" var="vo">
						<tr>
							<td style="width:150px">
					<img src="${vo.user.image}" style="height: 30px; width: 30px;">
							<font color=blue>${vo.user.name}</font></td>
							<td><p>${vo.content}</p>
							</td>
						</tr>
					</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>

