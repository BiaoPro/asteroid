<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<script>

$(document).ready(function(){


  
});
</script>

<!--热度、评论-->
<script>
	$(document).ready(function() {
//<!--关注、取消关注-->
		$("button.button2").hide();

		$("#show").click(function() {
			$("button.button2").show();
			$("button.button1").hide();
		});
		$("#hide").click(function() {
			$("button.button2").hide();
			$("button.button1").show();
		});

//<!--热度、评论-->
		$("#hot1").hide();
		$("#say1").hide();

		$("#hot").click(function() {
			$("#say1").slideUp();
			$("#hot1").slideToggle();
		});
		$("#say").click(function() {
			$("#hot1").slideUp();
			$("#say1").slideToggle();
		});
	});
</script>

<div class="row">
  <!--用户头像-->
    <div class="span2"> <a><img src="images/photograph/6608484896375594997.jpg" class="head2"></a> </div>
    <div class="span7">
      <div class="div1">
        <div>
          <table>
            <tr>
              <td><p style="color:#666;font-size:18px;margin:5px;">----我是摄影专家</p></td>
              <!--关注、取消关注-->
               <td><button class="btn button1 btn-mini" id="show" ><i class="icon-plus button1"></i></button>
              <button class="btn button2 btn-mini" id="hide"><i class="icon-minus"></i></button></td>
            </tr>
          </table>
        </div>
        <div>
          <hr/>
        </div>
         <!--此处获取用户发布动态的标题-->
        <div><h3 style="margin-left:30px;">摄影，瞬间的记录</h3></div>
        <!--此处获取用户发布动态的内容-->
        <div id="content1"> <img src="images/photograph/m_eecf537ead2f000001334abeb488.jpg" class="l_img"  />
          <p style=" line-height:20px;margin-left:40px;">一幅图片是一个时间的遗址，这里保存了某些记忆。由此我们可以进入回忆，并说话。被拍下的瞬间并非世界的结束，而是世界的开始。瞬间的记录，它是一个入口，由此而去，思之路开始。图片不是世界的终结之处，而是开始。我们来到一幅图片面前，就像面对荒野，它可以把我们领到世界的另一面。文明的这一面。文是一个动词。明是一个被文出来的状态。图片具有某种原始因素，它来自存在，但存在已经不在此，它其实是虚构，但不是凭空的，它是世界的某种痕迹，这种痕迹令我们向文明而去。图片象征着在文字之前人与世界的关系。我们看见了这样而不是那样。是这些痕迹令我们思想。图片是最早的文字，它的本能是记录世界，如早期人类的某些壁画。图片的本能不是思想世界，而是看见世界。文字是关于世界的思想</p>
        </div>
        <div>
          <hr/>
        </div>
        <div>
          <ul>
            <li><i class="icon-tag" id="icon-tag1"></i>标签：</li>
            <li>
              <button class="btn btn-inverse btn-mini">摄影</button>
            </li>
            <li style="position:relative;left:250px;">
              <button class="btn btn-mini" id="hot">热度</button>
              <button class="btn btn-mini" id="say">评论</button>
              <button class="btn btn-mini">分享</button>
              <i class="icon-heart"></i></li>
          </ul>
        </div>
        <hr/>
      </div>
      <!--***************************************热度列表***************************************-->
      <div id="hot1" style="background-color:#FFF" class="div1">
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
      <!--***************************************评论列表***************************************-->
      <div id="say1" style="background-color:#ccc" class="div1">
        <div style="background:#999;height:30px"><p style="padding:2px;"><strong>我要发表评论</strong></p></div>
        <div>
          <textarea class="input-xlarge"  style="width:500px;margin:10px;" placeholder="请在此处评论"></textarea>
          <button class="btn" style="margin:1px;position:relative;left:470px;">发布</button>
        </div>
        <div>
          <table class="table table-striped">
            <tbody>
            <thead style="background-color:#999;">
              <tr>
                <th>评论列表</th>
                <th>评论内容</th>
              </tr>
              
            </thead>
            <tr>
              <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
              <td><p>感觉很不错</p></td>
            </tr>
            <tr>
              <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
              <td><p>感觉很不错</p></td>
            </tr>
            <tr>
              <td><img src="images/photograph/6608484896375594997.jpg" style="height:30px;width:30px;">我是摄影专家</td>
              <td><p>感觉很不错</p></td>
            </tr>
              </tbody>
            
          </table>
        </div>
      </div>
    </div>
 </div>
    
