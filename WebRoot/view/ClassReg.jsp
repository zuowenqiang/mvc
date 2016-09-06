<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级添加页面</title>
    
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
  	<form action="classt" method="post">
  		<table>
  			<tr>
  				<td><label>添加班级</label></td>
  				<td><input type="text" name="cname"/></td>
  			</tr>
  			<tr>
  				<td><label>添加时间</label></td>
  				<td><input type="text" name="time"/>${date}</td>
  			</tr>
          <tr>
          	  <td colspan="2" style="text-align: center;">
          	  <p>{classError}</p>
          	  	  <input type="submit" value="添加"/> 
          	  	  
          	  
          	  </td>
          </tr>
  		</table>
  	</form>