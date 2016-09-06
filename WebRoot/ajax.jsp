<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<style type="text/css">
	    .bt{
	       display:block;
	       width:100px;
	       height:30px;
	       background-color:fuchsia;
	       margin-left: 10px;
	       text-align: center;
	       padding-top: 10px;
	       border-radius: 50px;
	    }
	    .bt:hover{
			opacity: 0.7;/*透明程度*/
			cursor: pointer;/*鼠标放在上面变成手指*/
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript">
	   $(function(){
	       $(".bt").click(function(){
	           /*$.ajax({
	               type   : 'POST';
	               url    :'<%=basePath%>testAJAX.do',
	               data   :{methodName=testAJAX},
	               dataType: 'text',
	               success:function(data){
	                  alert(data);
	               }
	            });
	            
	            $.get('<%=basePath%>testAJAX.do',{methodName:'testAJAX'},function(data){
	               alert(data);
	            },"text");
	            
	            //JSON街上
	            $.getJSON('<%=basePath%>testAJAX.do',{methodName:'testAJAX'},function(data){
	               alert(data.address+"--->"+data.name);
	            });*/
	            
	            
	            $.post('<%=basePath%>testAJAX.do',{methodName:'testAJAX'},function(data){
	                //var o  =eval("("+data+")");//将json格式的字符串转换为json对象
	                alert(data.address+"======>"+data.name);
	            },'json');
	       });
	   
	   });
	   
	</script>

  </head>
  
  <body>
    
     <div id="d">
			<span class="bt">吃嘎嘎了</span>
	 </div>
  </body>
</html>
