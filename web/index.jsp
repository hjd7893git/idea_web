<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tj").click(function(){
				var va = $("input[name='radio']:checked").val();
				var url;
				if(va==="1"){
					url="Login";
					
					$.ajax({
					url:url,
					data:{name:$('#3').val(),pass:$('#4').val()},
					dataType:"text",
					type:"post",
					success: function(date){
						if(date==="1"){
					    	alert("登陆成功！！");
					    	location="index0.jsp";
					    }
					    else{
					    	alert("账号或密码错误、登陆失败！！");
					    }
					}
				});
				}else{
					location="Student?name="+$('#3').val()+"&pass="+$('#4').val();
				}
				
			
		});
	});
</script>
  </head>

  <body>
 <% com.util.Id.id=1;%>
  <form name="from1">
   <table width="475" border="2" align="center">
  <tr>
    <td width="165" height="26">
	   <input type="radio" name="radio" value="1" checked="checked"/> 管理员
	</td>
    <td width="292">
	   <input type="radio" name="radio" value="2"  />学生
	</td>
  </tr>
  <tr align="center">
    <td>账号：</td>
    <td><input type="text" id="3"/> </td>
  </tr>
  <tr align="center">
    <td align="center">密码：</td>
    <td><input type="password" id="4"/> </td>
  </tr>
  <tr align="center">
    <td align="center" colspan="1"><input type="button" value="提交" id="tj"/> </td>
    <td align="center" colspan="1"><input type="reset" value="重置"/> </td>
  </tr>
</table>
</form>
  </body>
</html>
