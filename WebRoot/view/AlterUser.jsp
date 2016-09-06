<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'class.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	</head>
	<body>

         <form action="alterMenu.do?methodName=alterMenu&rid=${role.rid}" method="post"> 
         <p>角色<b>${role.rname}</b>编辑角色菜单</p>
	         <table>
		    	<c:forEach items="${list}" var="ml">
		    		<input type="checkbox" name = "mName" value="${ml[0]}" <c:if test="${ml[2]==1}">checked</c:if>>${ml[1]}<br/>
		    	</c:forEach>
	    	</table>
    	<input type = "submit" value="执行修改">
      
    </form>
  </body>
</html>