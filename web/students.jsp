<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生管理</title>
    
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
  <table align="center" >
  <tr align="center"><th>成绩总览</th></tr>
  	<tr><td>姓名：<c:out value="${sh.username }"></c:out></td></tr> 	
	<tr><td>密码：<c:out value="${sh.password }"></c:out></td></tr>
	<tr><td>性别：<c:out value="${sh.gender }"></c:out></td></tr>
	<tr><td>年龄：<c:out value="${sh.age }"></c:out> </td></tr>
	<tr><td>语文成绩：<c:out value="${sh.yw }"></c:out> </td></tr>
	<tr><td>数学成绩：<c:out value="${sh.sx }"></c:out> </td></tr>
	<tr><td>英语成绩：<c:out value="${sh.yy }"></c:out> </td></tr>
	<tr><td>理综成绩：<c:out value="${sh.lz }"></c:out> </td></tr>
	<tr><td>文综成绩：<c:out value="${sh.wz }"></c:out> </td> </tr>
</table>
  </body>
</html>
