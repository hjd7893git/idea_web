<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.hjd.page.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>员工列表</title>
    <style type="text/css">
    td {
    	size: 9;
    	font-weight: bold;
    }
    table {
	background-repeat: no-repeat;
}
    </style>
    <script type="text/javascript">
		function is(f){
			if(f<1){
				alert("超出最小页码，已调至首页！");
				location="servlet_page?pageNo=1&pageSize=8";
			}else if(isNaN(f)){//如果不为数字返回为真
				alert("请输入标准的页码！！");
				document.getElementById("C").value="";
			}else if(f>parseInt(document.getElementById("G").value)){//将字符串转换为数字类型的
				alert("超出最大页码，已调至尾页！");
				location="servlet_page?pageNo="+document.getElementById("G").value+"&pageSize=8";
			}
			else {
				location="servlet_page?pageNo="+f+"&pageSize=8";
			}
		}
</script>
    
  </head>
  <body>
  <% com.util.Id.id++;%><!--标志量加1， -->
  <input type="hidden" value=<%=((PageModel)request.getAttribute("MODEL")).getTotalPages() %> id="G"/>
  <table width="760" height="350" border="2" align="center"  background="image/1.jpg"  >
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
  <c:forEach items="${employees}" var="employee">
	  <tr>
	    <td align="center">${employee.username}</td>
	    <td align="center">${employee.password}</td>
	    <td align="center">${employee.gender}</td>
	    <td align="center">${employee.age}</td>
	    <td align="center">${employee.yw}</td>
	    <td align="center">${employee.sx}</td>
	    <td align="center">${employee.yy}</td>
	    <td align="center">${employee.wz}</td>
	    <td align="center">${employee.lz}</td>
	    <td align="center"><input type="button" value="修改" id="modify" onclick="mod('${employee.username}','${employee.password}','${employee.gender}','${employee.age}','${employee.yw}','${employee.sx}','${employee.yy}','${employee.wz}','${employee.lz}')"/></td>
      	<td align="center"><input type="button" value="删除" id="delete" onclick="delet('${employee.username}',this)"/></td>
	  </tr>
 </c:forEach>
 </table>
 <table width="760" height="60" align="center" border="1">
 <tr bgcolor="#CCCCCC">
  <td width="80">当前页：<%=((PageModel)request.getAttribute("MODEL")).getPageNo() %></td>
  <td width="51">共<%=((PageModel)request.getAttribute("MODEL")).getTotalPages() %>页</td>
  <td width="99"><a href="servlet_page?pageNo=<%=((PageModel)request.getAttribute("MODEL")).getTopPageNo() %>&pageSize=8">首页</a></td>
  <td width="99"><a href="servlet_page?pageNo=<%=((PageModel)request.getAttribute("MODEL")).getPreviousPageNo() %>&pageSize=8">上一页</a></td>
  <td width="91"><a href="servlet_page?pageNo=<%=((PageModel)request.getAttribute("MODEL")).getNextPageNo() %>&pageSize=8">下一页</a></td>
  <td width="82"><a href="servlet_page?pageNo=<%=((PageModel)request.getAttribute("MODEL")).getBottomPageNo() %>&pageSize=8">尾页</a></td>
  <td width="96">跳转<input type="text" onblur="is(this.value)" size="1" id="C">页</td>
  <td width="126">共<%=((PageModel)request.getAttribute("MODEL")).getTotalRecords() %>条记录</td>
  </tr>
</table>
  </body>
</html>
