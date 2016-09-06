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
	        background: auto;
	    }
	</style>

  </head>
  
  <body>
    <div id="div">
       <fieldset>
          <form action="students" method="post">
        	<legend>学生入住</legend>
        
              <p><label>姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
              <input type="text"name="name"size="30"></p>
          
              
               <p><label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
               <input type="radio" name="sex" value="1"/>男
        	   <input type="radio" name="sex" value="2"/>女</p>
          
          
              <p><label>入学时间</label>
              <input type="text"name="time"size="30"></p>
        
              <p><label>班&nbsp;&nbsp;&nbsp;&nbsp;级</label>
              <select name="deptid">
                      <option value="1">电子商务</option>
                      <option value="2">计算机</option>
                      <option value="3">未知</option>
                      <option value="4">一班</option>
                  </select></p>
              
              <input type="submit"value="加&nbsp;入"colspan="2"/>
              </form>
        </fieldset>      
   </div> 
  </body>
</html>
