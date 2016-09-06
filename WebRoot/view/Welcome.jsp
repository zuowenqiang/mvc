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
    
    <title>My JSP 'easyui.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
     function addTab(title,url){
			$('#tables').tabs('add',{
				title: title,
				selected: true,
				closable: true,
				content : "<iframe width='100%' height='100%'  frameborder='0' scrolling='auto' src='"+url+"'></iframe>"
			});
			
		}
		setInterval("linkweb.innerHTML='系统时间:'+new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
    </script>
    <style type="text/css">
        #linkweb{width:700px;height:50px;font-size:20px;color:aqua;}
    </style>
  </head>
  
  <body class="easyui-layout"> 
    <div id="upper">
          <h2>欢迎使用,${loginUser.userName}</h2>
    </div>  
    <div data-options="region:'north',split:true" style="height:100px;">
        <div id="linkweb"></div>
    </div>   
    <div data-options="region:'west',title:'系统菜单',split:true" style="width:100px;">
	    <!--<div id="aa" class="easyui-accordion" style="width:300px;" data-options="fit:true">   
		    <div title="网页菜单" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
		                 
			</div>   
		    <div title="未开通" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
		     <h4>功能未开通</h4>		           
		    </div>   
		    <div title="未开通">   
		     <h3>功能未开通</h3>    
			</div>   
		</div> -->
	  <ul id="tt" class="easyui-tree">   
		   <c:forEach items="${menuList}"var="m2">
	           <c:if test="${m2.level==2}">
	             <li>
	                <span>${m2.name}</span>
	                <ul>
	                   <c:forEach items="${menuList}" var="m3">
	                     <c:if test="${m3.parentid==m2.mid}">
	                        <li><a href="javascript:void(0);" onclick="addTab('${m3.name}','${basepath}${m3.url}')">${m3.name}</a></li>
	                     </c:if>
	                   </c:forEach>
	                </ul>
	             </li>
	           </c:if>
	         </c:forEach>
	   </ul>     
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	     <div id="tables" class="easyui-tabs" style="width:500px;"data-options="fit:true">   
		    <div title="欢迎使用" style="padding:20px;"closable="true";>   
		        <h1 style="text-align:center;">欢迎使用本系统！</h1>  
		    </div>     
	    </div>        
    </div>   
</body>  
</html>
