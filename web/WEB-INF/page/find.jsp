<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>员工列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
  <table width="750" height="200" border="2" align="center">
  <tr><td colspan="11"><center><h1><font color="red">查找的结果</font></h1></center></td></tr>
  <tr>
    <th height="40" scope="col">姓名</th>
    <th height="40" scope="col">密码</th>
    <th height="40" scope="col">性别</th>
    <th height="40" scope="col">年龄</th>
    <th height="40" scope="col">语文成绩</th>
    <th height="40" scope="col">数学成绩</th>
    <th height="40" scope="col">英语成绩</th>
    <th height="40" scope="col">文综成绩</th>
    <th height="40" scope="col">理综成绩</th>
    <th height="40" colspan="2" scope="col">操作</th>
  </tr>
  <tr>
   <td align="center">${key.username}</td>
	    <td align="center">${key.password}</td>
	    <td align="center">${key.gender}</td>
	    <td align="center">${key.age}</td>
	    <td align="center">${key.yw}</td>
	    <td align="center">${key.sx}</td>
	    <td align="center">${key.yy}</td>
	    <td align="center">${key.wz}</td>
	    <td align="center">${key.lz}</td>
	    <td align="center"><input type="button" value="修改" id="modify" onclick="mod('${key.username}','${key.password}','${key.gender}','${key.age}','${key.yw}','${key.sx}','${key.yy}','${key.wz}','${key.lz}')"/></td>
      	<td align="center"><input type="button" value="删除" id="delete" onclick="delet('${key.username}',this)"/></td>
  </tr>
	</table>
  </body>
</html>
