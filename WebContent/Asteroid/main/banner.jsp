<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.asteroid.model.User" %>

<%
User user=(User)session.getAttribute("user");
if(user==null){
  response.sendRedirect("../index.jsp");
}

%>
<script>
function checkStr(){
	  var str=$("#keyStr").val();
	  if(str!=null||str!="")
	    return true;
	  else return false;
	}


</script>

<div class="navbar">
  <div class="navbar-inner">
    <div class="container">
      <ul class="nav">
        <a class="brand" href="main.jsp">ASTEROID</a>
        <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
        <li id="main"><a href="main.jsp">首页</a></li>
        <li id="label"><a href="label.jsp">浏览</a></li>
        <li class="dropdown" id="accountmenu"> <a class="dropdown-toggle" data-toggle="dropdown" href="#">更多<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="account.jsp">账号设置</a></li>
            <li><a href="search.jsp">寻找好友</a></li>
            <li class="divider"></li>
            <li><a href="help.jsp">帮助与反馈</a></li>
            <li><a href="../index.jsp">退出</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-search pull-right" action="SearchAction" method="post" onSubmit="return checkStr()">
        <input type="text" name="key" id="keyStr" class="search-query" placeholder="Search">
      </form>
    </div>
  </div>
</div>
