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
    
    <title>My JSP 'addMenu.jsp' starting page</title>
    
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
    
    <form action="addMenuto.do" method="post">
    <input type="hidden" name="methodName" value="addMenuto" />
    <div id="DIV">
    <p>添加菜单列表</p>
	  	  	<table border="0" cellpadding="0" cellspacing="0">
	  	  		<tr>
	  				<td class="lab"><label>菜单名称</label></td>
	  				<td><input type="text" name="name" class="in"/></td>
	  			</tr>
	  			<tr>
	  				<td class="lab"><label>url</label></td>
	  				<td ><input type="text" name="url" class="in"/></td>
	  			</tr>
	  			<tr>
	  				<td class="lab"><label>是否显示</label></td>
	  				<td >
	  				<input type="radio" name="isshow"  value="1"/>是
	  				<input type="radio" name="isshow" value="0"/>否
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="lab"><label>父类级别</label></td>
	  				<td >
	  					<select name="parentid">
	  						<c:forEach items="${MenueList}" var="s">
	  							<option value="${s.mid }">
	  								<c:if test="${s.level==1}">一级菜单-${s.name}</c:if>
	  								<c:if test="${s.level==2}">二级菜单-${s.name}</c:if>
	  							</option>
	  						</c:forEach>
	  					</select>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td colspan="3" style="text-align: center;">
	  					<input type="submit" value="添加" size="5"/>
	  			</tr>
	  		</table>
	  		</form>
	  	</div>
  	${regError}${chenggong}
  </body>
</html>
