<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//List<Object[]> list=(List<Object[]>)request.getAttribute("useList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
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
   <form action="showUser.do?methodName=showUser">
    <h3>用户列表</h3>
    <p>${msq} </p>

    <table    border="1"  width="100%" bordercolor="blue"cellpadding="0">
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        <tr>
            <td>编号</td>
            <td>用户</td>
            <td>邮箱</td>
            <td>性别</td>
            <td>学历</td>
            <td>爱好</td>
            <td>自我介绍</td>
            <td>操作</td>
        </tr>
         
          <c:forEach items="${userList}" var="u">
              <tr>
                 <td>${u.uid}</td>
                 <td>${u.userName}</td>
                 <td>${u.myForm} </td>
                 <td>
                    <c:if test="${u.sex==1}">男</c:if>
                    <c:if test="${u.sex==2}">女</c:if>
                 </td>
                 <td>
                    <c:if test="${u.education==-1}">未知</c:if>
                    <c:if test="${u.education==1}">高中</c:if>
                    <c:if test="${u.education==2}">大专</c:if>
                    <c:if test="${u.education==3}">本科</c:if>
                    <c:if test="${u.education==4}">研究生</c:if>
                 </td>
                 <td>${u.hobby}</td>
                 <td>${u.introduce}</td>
                 <td>
                     <a href='delete?id=${u.uid}'>删除</a>
                 </td>
              </tr>
         </c:forEach>
    </table>
   </form> 
  </body>
</html>
