<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    

<!--模态框中，标签的选择-->
<script language="javascript">
//移动光标到最后
var setPos=function(o){
if(o.setSelectionRange){//W3C
setTimeout(function(){
o.setSelectionRange(o.value.length,o.value.length);
o.focus();
},0);
}else if(o.createTextRange){//IE
var textRange=o.createTextRange();
textRange.moveStart("character",o.value.length);
textRange.moveEnd("character",0);
textRange.select();
}
};
function Insert(str) {
var obj = document.getElementById('tag_name');
var obj1 = document.getElementById('tag_name1');
setPos(obj);
if(document.selection) {
obj.focus();
var sel=document.selection.createRange();
document.selection.empty();
sel.text = str;
} else {
var  main, suffix;
main = obj.value.substring(obj.selectionStart, obj.selectionEnd);
suffix = obj.value.substring(obj.selectionEnd);
obj.value =  str + suffix;
obj1.value =  str + suffix;

if(str=="电影"){
	document.getElementById('tag_id').value=1;
	document.getElementById('tag_id1').value=1;
}else if(str=="动漫"){
	document.getElementById('tag_id').value=2;
	document.getElementById('tag_id1').value=2;
}else if(str=="绘画"){
	document.getElementById('tag_id').value=3;
	document.getElementById('tag_id1').value=3;
}else if(str=="摄影"){
	document.getElementById('tag_id').value=4;
	document.getElementById('tag_id1').value=4;
}else if(str=="学习"){
	document.getElementById('tag_id').value=5;
	document.getElementById('tag_id1').value=5;
}else if(str=="生活"){
	document.getElementById('tag_id').value=6;
	document.getElementById('tag_id1').value=6;
}else if(str=="心情"){
	document.getElementById('tag_id').value=7;
	document.getElementById('tag_id1').value=7;
}else if(str=="美食"){
	document.getElementById('tag_id').value=8;
	document.getElementById('tag_id1').value=8;
}else if(str=="宠物"){
	document.getElementById('tag_id').value=9;
	document.getElementById('tag_id1').value=9;
}else if(str=="科技"){
	document.getElementById('tag_id').value=10;
	document.getElementById('tag_id1').value=10;
}else if(str=="娱乐"){
	document.getElementById('tag_id').value=11;
	document.getElementById('tag_id1').value=11;
}else if(str=="原创"){
	document.getElementById('tag_id').value=12;
	document.getElementById('tag_id1').value=12;
}else {
	document.getElementById('tag_id').value=0;
	document.getElementById('tag_id1').value=0;
}	
}
obj.focus();
}
</script>
<script src="js/photo-unload.js"></script>

<script>

    
    

	$(document).ready(function() {
		$("#image3").change(function(){
	    	var str=$(this).val();
	    	if(str.indexOf("fakepath")<= 0){
	    		document.getElementById("imageTou").src=str;
	    	}	
	    	});
		$(".Pmod").click(function() {
			$("#P").slideDown("slow");
		});
		$(".Tmod").click(function() {
			$("#T").slideDown("slow");
		});
		$(".TClose").click(function() {
			$("#T").slideUp("slow");
		});
		$(".PTmod").click(function() {
			$("#pt").slideDown("slow");
		});
		$(".PTClose").click(function() {
			$("#pt").slideUp("slow");
		});
		
		$('.faceT').qqFace({
			assign:'saytextT' , 
			path:'arclist/'	//表情存放的路径
		});
		
		$('.facePT').qqFace({
			assign:'saytextPT' , 
			path:'arclist/'	//表情存放的路径
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

	function changStrT() { //根据用户名删除用户信息
		
		var str = $("#saytextT").val();
		str = str.replace(/\</g, '&lt;');
		str = str.replace(/\>/g, '&gt;');
		str = str.replace(/\n/g, '<br/>');
		str = str.replace(/\[em_([0-9]*)\]/g, '<img src="arclist/$1.gif" />');
		$("#saytextT").val(str);
		return true;
	}
	
   function changStrPT() { //根据用户名删除用户信息
		
		var str = $("#saytextPT").val();
		str = str.replace(/\</g, '&lt;');
		str = str.replace(/\>/g, '&gt;');
		str = str.replace(/\n/g, '<br/>');
		str = str.replace(/\[em_([0-9]*)\]/g, '<img src="arclist/$1.gif" />');
		$("#saytextPT").val(str);
		return true;
	}
    
	
	
</script>

	<!--***************************************头像，昵称修改***************************************-->
	<div class="row">
		<div class="span9">
			<ul>
				<li><a data-toggle="modal" href="#P" class="Pmod"> <img
						src="${sessionScope.user.image}" class="head">
				</a></li>
				<li><a data-toggle="modal" href="#T" class="Tmod"><img
						src="T.jpg" id="word"></a></li>
				<li><a data-toggle="modal" href="#pt" class="PTmod"><img
						src="tp.jpg" id="photo"></a></li>
				<li><a><img src="images/web/001052I49-10.jpg"
						style="height: 110px; width: 273px;"></a></li>
			</ul>
		</div>
	</div>
<!--------------******************************************* 文字发表T*********************************************--------------------->	
<div id="P" class="modal hide fade in" style="display:none;">


    <div class="modal-header"> <a  class="TClose close" data-dismiss="modal">×</a>  <h3>信息修改：</h3> </div>
    <form class="form-horizontal" action="UserInfoAction" method="post" enctype="multipart/form-data">
		<div class="modal-body">
			<input type="hidden" name="user_id"
				value="${sessionScope.user.user_id}">
			<fieldset>
				<div class="control-group" >
					<label class="control-label" for="fileInput"><i
						class="icon-file"></i>头像修改：</label>
						 
					<div id="preview">
						 <img id="imageTou" src="${sessionScope.user.image}" style="height: 160px; width: 160px">
					</div>	 
					<div class="controls" id="choose">
						<input type="file" id="image3" name="image3" onchange="previewImage(this)" >
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name3"><i
						class=" icon-text-width"></i>名字：</label>
					<div class="controls">
						<input type="text" class="input-xlarge" name="name3"
							value="${sessionScope.user.name}">
					</div>
				</div>

			</fieldset>
		</div>

		<div class="modal-footer">
			<input type="submit" class="btn btn-primary" value="保存">
		</div>
	</form>

</div>
	
<!--------------******************************************* 文字发表T*********************************************--------------------->
<div class="container">
  <div id="T" class="modal hide fade in" style="display:none;">
    <div class="modal-header"> <a  class="TClose close" data-dismiss="modal">×</a> <img  src="${sessionScope.user.image}" style="height:80px;width:80px"> <small>----${sessionScope.user.name}</small> </div>
    <form class="form-horizontal" action="ReleaseActionAdd2"  onSubmit="return changStrT()" method="post" enctype="multipart/form-data">
    <div class="modal-body">
      <input type="hidden" name="user_id" value="${sessionScope.user.user_id}">
        <fieldset>
          <div class="control-group">
            <label class="control-label" for="titile"><i class=" icon-text-width"></i>标题：</label>
            <div class="controls">
              <input type="text" class="input-xlarge" name="title" id="title"  placeholder="可不填">
            </div>
          </div>
          
          <div class=" comment control-group">
          <label class="control-label" for="titile"><i class=" icon-text-width"></i></label>
			<div class="com_form">
				<textarea class="input" id="saytextT" style="width:350px;height:100px" name="content" placeholder="发表内容。。。"></textarea>
				<span class="emotion faceT">表情</span>
			</div>
	      </div>
	      
          <div class="control-group">
            <label class="control-label" for="tags"><i class="icon-tags" ></i>标签：</label>
            <div class="controls">
              <table>
                <tr>
                  <td><input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('电影')" value="电影" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('动漫')" value="动漫" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('绘画')" value="绘画" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('摄影')" value="摄影" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('学习')" value="学习" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('生活')" value="生活" /><br>
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('心情')" value="心情" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('美食')" value="美食" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('宠物')" value="宠物" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('科技')" value="科技" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('娱乐')" value="娱乐" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('原创')" value="原创" /></td>
                  <td><label>
                      <input type="hidden" name="tag_id" id="tag_id" value="1" ><!-- 保存tag_id -->
                      <input type="text"  id="tag_name" style="height:30px;width:40px;" placeholder="电影">
                    </label></td>
                </tr>
              </table>
            </div>
          </div>
        </fieldset>
    </div>
    <div class="modal-footer"> <a href="#" class="btn" id="TClose" data-dismiss="modal">取消</a> <input type="submit" class="btn btn-primary" value="提交"> </div>
  </form>
  </div>
</div>

<!--------------******************************************* 文字和图片发表pt*********************************************--------------------->
<div class="container">
<div id="pt" class="modal hide fade" tabindex="-1" style="display:none;">
<div class="modal-header"> <a class="PTClose close" data-dismiss="modal">×</a> <img src="${sessionScope.user.image}" style="height:80px;width:80px"> <small>----${sessionScope.user.name}</small> </div>
<form class="form-horizontal" action="ReleaseActionAdd2"  onSubmit="return changStrPT()" method="post" enctype="multipart/form-data">
  <div class="modal-body">
    <input type="hidden" name="user_id" value="${sessionScope.user.user_id}">
    <fieldset>
      <div class="control-group">
        <label class="control-label"><i class="icon-file"></i>图片：</label>
        <div class="controls">
           <input type="file" name="image2">
        </div>
      </div>
      <div>
        <hr/>
      </div>
      <div class=" comment control-group">
          <label class="control-label" for="titile"><i class=" icon-text-width"></i></label>
			<div class="com_form">
				<textarea class="input" id="saytextPT" style="width:350px;height:80px" name="content" placeholder="发表内容。。。"></textarea>
				<span class="emotion facePT">表情</span>
			</div>
	  </div>
      
      <div class="control-group">
        <label class="control-label" for="tags"><i class="icon-tags" ></i>标签：</label>
        <div class="controls">
              <table>
                <tr>
                  <td><input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('电影')" value="电影" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('动漫')" value="动漫" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('绘画')" value="绘画" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('摄影')" value="摄影" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('学习')" value="学习" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('生活')" value="生活" /><br>
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('心情')" value="心情" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('美食')" value="美食" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('宠物')" value="宠物" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('科技')" value="科技" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('娱乐')" value="娱乐" />
                      <input  type="button" class="btn btn-mini btn-info" onClick="javascript:Insert('原创')" value="原创" /></td>
                  <td><label>
                      <input type="hidden" name="tag_id" id="tag_id1" value="1" ><!-- 保存tag_id -->
                      <input type="text"  id="tag_name1" style="height:30px;width:40px;" placeholder="电影">
                    </label></td>
                </tr>
              </table>
            </div>
      </div>
    </fieldset>

  <div class="modal-footer"> <a href="#" class="btn PTClose"  data-dismiss="modal">取消</a> <input type="submit" class="btn btn-primary" value="提交" > </div>
 </div>
</form>
</div>
</div>
