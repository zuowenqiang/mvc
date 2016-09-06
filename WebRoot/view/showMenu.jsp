<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'look.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	   $('#dg').datagrid({
	      url:'showMenu.do?methodName=showMenu&pageNo=1&pageSize=10',
	      frozenColumns:[[{field:'hhhh',checkbox:true}]],
	      rownumbers:true,
	      striped:true,
	      pagination:true,
	      columns:[[
	            {field:'mid',hidden:true},
	            {field:'name',title:'菜单名字',width:100,alige:'center'},
	            {field:'url',title:'地址',width:300,alige:'center'},
	            {field:'isshow',title:'是否展示',width:100,alige:'center'},
	            {field:'level',title:'菜单级别',width:100,alige:'center'},
	            {field:'parentid',title:'上级菜单',width:100,alige:'center'},
	      ]]
	   });
	   var pager=$('#dg').datagrid("getPager");
	   pager.pagination({
	      onSelectPage:function(pagNumber,pagSize){
	          $('#dg').datagrid('loading');
	          $.post("showMenu.do",{
	             methodName:'showMenu',
	             pageNo:pagNumber,
	             pageSize:pagSize
	          },function(data){
	             $("#dg").datagrid("loaData",{
	                rows:data.rows,
	                total:data.total	           
	             });	     
	           },"json");
	           $("#dg").datagrid('loading');
	       }); 
	   });
	   
	</script>

  </head>
  
  <body>
    <div></div>
  <!-- <form action="showMenu.do?methodName=showMenu">
   <h3>菜单列表</h3>
   <p>${msq} </p>
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  		<tr> 
  			<td>编号</td>
  			<td>菜单名字</td>
  			<td>地址</td>
  			<td>是否展示</td>
  			<td>菜单级别</td>
  			<td>上级菜单</td>
  		</tr> 		
  		<c:forEach items="${showList}" var="m">
  			<tr >
  				<td>${m.mid} </td>
  				<td>${m.name} </td>
  				<td>${m.url} </td>
  				<td> 
  					<c:if test="${m.isshow==1}">展示</c:if>
  					<c:if test="${m.isshow==0}">不展示</c:if>
  				</td>
  				<td>
  					<c:if test="${m.level==1}">一级菜单</c:if>
  					<c:if test="${m.level==2}">二级菜单</c:if>
  					<c:if test="${m.level==3}">三级菜单</c:if>
  				</td> 

  				<td>${m.parentid} </td>
  			</tr>		
  		</c:forEach>	
  	 </table>
  	 </form>-->  
  </body>
</html>
