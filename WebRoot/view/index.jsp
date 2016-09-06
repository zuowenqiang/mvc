<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>登录系统</title>

<link rel="stylesheet" href="loginMy/css/font-awesome.min.css"/>
<link rel="stylesheet" href="loginMy/css/loginMy.css"/>

<style>
html,body{width:100%;}
</style>

</head>
<body>

<div class="main">
            
	<div class="center">
		<form action="login.do" id="formOne" method="post"onsubmit="return submitB()" >
		    <input type="hidden" name="methodName" value="login" />
		    <h2 align="center">学习系统登录</h2>
			<i class="fa fa-user Cone">  | </i>
			<input type="text" name="userName" id="user" placeholder="用户名"onblur="checkUser()"/>
			<span id="user_pass"></span> ${loginError}
			<br/>
			<i class="fa fa-key Cone">  | </i>
			<input type="password" name="userpass" id="pwd" placeholder="密码"onblur="checkUser1()"/>
			<span id="pwd_pass"></span> ${loginError}
			<br/>
            <br/>
			<br/>
			<br/>
			<input type="submit" value="登录" id="submit" name="submit"/><br/>
			<p align="center">还没有账号吗！<a href="view/reg.jsp">立刻注册</a></p>
			<br/>
		</form>
	</div>
	
</div>


<script type="text/javascript" src="loginMy/js/loginMy.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>