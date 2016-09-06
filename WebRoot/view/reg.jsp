<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	    #div{
	        height:100%;
	        background-image: url("loginMy/j.jpg");
	        padding-upper:300px;
	    }
	</style>

  </head>
  
  <body>
    <div id="div">
       <form action="reg"method="post">
        <table border="0"  cellpadding="0"  cellspacing="0"style="margin: auto">
          <tr>
              <td><label>账号：</label></td>
              <td><input type="text"name="userName"size="30"></td>
             ${regError}
          </tr>
          <br/>
           <tr>
              <td><label>密码：</label></td>
              <td><input type="password"name="userpass"size="30"></td>
          </tr>
          <br/>
          <tr>
              <td><label>邮箱：</label></td>
              <td><input type="text"name="myForm"size="30"></td>
          </tr>
           <tr>
              <td><label>性别：</label></td>
              <td> <input type="radio" name="sex" value="1"/>男
        	       <input type="radio" name="sex" value="2"/>女</td>
          </tr>
          <br/>
          <tr>
              <td><label>学历：</label></td>
              <td>
                  <select name="education">
                      <option value="1">高中</option>
                      <option value="2">大专</option>
                      <option value="3">本科</option>
                      <option value="4">研究生</option>
                  </select>
              </td>
          </tr>
          <tr>
              <td><label>爱好：</label></td>
              <td><input type="checkbox" name="hobby" value="1"/>读书
                  <input type="checkbox" name="hobby" value="2"/>音乐
                  <input type="checkbox" name="hobby" value="3"/>足球
                  <input type="checkbox" name="hobby" value="4"/>游泳
              </td>
          </tr>
          <tr>
              <td><label>自我介绍：</label></td>
              <td><textarea rows="3"cols="25"name="introduce"></textarea></td>
          </tr>
          <tr>
              <td colspan="2"style="text-align:center;">
                  <input type="submit"value="注册"/>
                  <span>已经有账号<a href="view/index.jsp">立刻登录</a></span>
              </td>
              
          </tr>  
       </table>
     </form>
   </div> 
  </body>
</html>
