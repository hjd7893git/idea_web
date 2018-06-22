<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>员工添加</title>
<script type="text/javascript">
  	var b=true;//设置全局跳转标志
	var xmlHttp;//首先设子xmlhttp类型
	var flag=false;
	function createXMLHttp(){
		if (window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
			}else{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	function checkUserid(userid){
			createXMLHttp();//获取类型
			xmlHttp.open("post","check?userid="+userid);//准备好传递过去的参数和页面url
			xmlHttp.onreadystatechange=checkUseridCallback;//回调函数，
			xmlHttp.send(null);//将请求发送给服务端，并接受回应信息
		}
	function checkUseridCallback(){
			if(xmlHttp.readyState==4){//相应以完成，可以访问服务端响应并使用它
				if(xmlHttp.status==200){//正常状态码
					var s=xmlHttp.responseText;//接受服务端的文本数据，只读，
					if(s=="true"){
						document.getElementById("msg").innerHTML="用户名重复,不能提交!!!请重新输入新的用户名";
						b = false;
					}else{
						document.getElementById("msg").innerHTML="用户名可以使用";
						b=true;
					}
				}
			}
		}
	//密码判断非空实现
	function ChenkForm(){
		var name=document.getElementById("username").value;
		  var pass=document.getElementById("password").value;
		  if(name==""&&pass==""){
				alert("用户名和密码都不能为空！请确是否正确输入~");
				b=false;
			}else if(name==""&&pass!=""){
					alert("用户名不能为空!");
					b=false;
				}else if(pass==""&&name!=""){
					alert("密码不能为空!");
					b=false;
				}
		return b;
	}
</script>
  </head>
  <body>
<form action="#" method="post" onsubmit="return ChenkForm()">
 
   <table width="380" height="120" border="2" align="center">
   <tr>
    <th colspan="3" scope="col">添加信息</th>
  </tr>
   <tr><td align="center" colspan="3"><font color="red" size="5" ><span id="msg"></span></font></td></tr>
     <tr>
       <td width="73" scope="col">用户名：</td>
       <td colspan="2" scope="col"><input type="text" name="employee.username" id="username" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>密&nbsp;&nbsp;码：</td>
       <td colspan="2"><input type="text"  name="employee.password" id="password"/></td>
     </tr>
     <tr>
       <td>性别：</td>
       <td width="101">男
       <input type="radio" name="employee.gender" value="MAN" checked="checked"/></td>
       <td width="115">女
       <input type="radio" name="employee.gender" value="WOMEN"/></td>
     </tr>
     <tr>
       <td>年龄：</td>
       <td colspan="2"><input type="text" name="username" id="username2" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>语文成绩：</td>
       <td colspan="2"><input type="text" name="username2" id="username3" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>数学成绩：</td>
       <td colspan="2"><input type="text" name="username3" id="username4" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>英语成绩：</td>
       <td colspan="2"><input type="text" name="username4" id="username5" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>理综成绩：</td>
       <td colspan="2"><input type="text" name="username5" id="username6" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td>文综成绩：</td>
       <td colspan="2"><input type="text" name="username6" id="username7" onblur="checkUserid(this.value)"/></td>
     </tr>
     <tr>
       <td><input  type="button" value="确定" onmouseover="ChenkForm()" onclick="add()"/></td>
       <td><input type="reset" value="取消"/></td>
       <td><input type="button" onclick="RTA()" value="返回"></td>
     </tr>
   </table>
   </form>
  </body>
</html>
