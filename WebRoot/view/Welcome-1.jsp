<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	    #upper{
	        width: 1567px;
	        height: 70px;
	        background-image: url("loginMy/z.jpg");
	 
	    }
	    #left{
	        width:300px;
	        height:660px;
	        background-image: url("loginMy/oo.jpg");
	        float: left;
	    }
	    #dexter{
	        width:1266px;
	        height:660px;
	         background-image: url("loginMy/1.jpg");
	        float:left;
	    }
	    #left a{
	        text-decoration: none;
	        color: teal;
	        font-size: 20px;
	        font-weight:bold;
	        font-family: serif;
	        display: block;
	        margin-top: 50px;
	        padding-left: 30px; 
	    }
	    #lefta a:hover{
	        text-decoration:underline;
	        background-color: maroon;
	        color: #ffffff;
	    }
	</style>
  </head>
  
  <body>
      
      <div id="upper">
          <h2>欢迎使用,${loginUser.userName}<a href="logout.do?methodName=logout" >安全退出</a> </div></h2>
      </div>
	  <div id="left">
	   
	       <ul>
	          <c:forEach items="${menuList}"var="m2">
	            <c:if test="${m2.level==2}">
	              <li>
	                 <span>${m2.name}</span>
	                 <ul>
	                    <c:forEach items="${menuList}" var="m3">
	                      <c:if test="${m3.parentid==m2.mid}">
	                         <li><a href="<%=basePath%>${m3.url}" target="center">${m3.name}</a></li>
	                      </c:if>
	                    </c:forEach>
	                 </ul>
	              </li>
	            </c:if>
	          </c:forEach>
	       </ul>
	       
	       
	       
	       
            <!--<a href="bb">点击下载</a>  
            <a href="showUser.do?methodName=showUser"target="center">用户列表</a>
            <a href="student"target="center">学生列表</a>
            <a href="class"target="center">班级列表</a>
            <a href="StudentsReg.jsp" target="center">添加学生</a>
            <a href="ClassReg.jsp" target="center">添加班级</a>-->
	  </div>
	  <div id="dexter">
	      <iframe name="center"frameborder="0"scrolling="auto"width="100%"height="100%"></iframe>
	  </div>
  </body>
</html>
