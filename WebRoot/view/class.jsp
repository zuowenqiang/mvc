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
    <h3>班级列表</h3>
    <p>${msq} </p>

    <table    border="1"  width="100%" bordercolor="blue"cellpadding="0">
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        <tr>
            <td>编号</td>
            <td>班级名字</td>
            <td>时间</td>
        </tr>
         
          <c:forEach items="${classList}" var="u">
              <tr>
                 <td>${u[0]}</td>
                 <td>${u[1]}</td>
                 <td>${u[2]} </td>
              </tr>
         </c:forEach>
    </table>
  </body>
</html>