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
    
    <title>My JSP 'stuinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h3>学生列表</h3>
    <p>${msq} </p>

    <table    border="1"  width="100%" bordercolor="blue"cellpadding="0">
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        <tr>
            <td>编号</td>
            <td>名字</td>
            <td>性别</td>
            <td>入学时间</td>
            <td>班级</td>
        </tr>
         
          <c:forEach items="${stuinfoList}" var="u">
              <tr>
                 <td>${u.uid}</td>
                 <td>${u.userName}</td>
                 <td>
                    <c:if test="${u.sex==1}">男</c:if>
                    <c:if test="${u.sex==2}">女</c:if>
                 </td>
                 <td>${u.time}</td>
                 <td>
                    <c:if test="${u.deptid==1}">电子商务</c:if>
                    <c:if test="${u.deptid==2}">计算机</c:if>
                 </td>
              </tr>
         </c:forEach>
    </table>
  </body>
</html>

