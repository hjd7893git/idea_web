<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
   
<html>
<head>
<script type="text/javascript" src="js/Add.js"></script>
<script type="text/javascript" src="js/xiu_Ajax.js"></script>
<script type="text/javascript" src="js/findAll.js"></script>
<script type="text/javascript" src="js/delet.js"></script>
<script type="text/javascript" src="js/cha.js"></script>
<script type="text/javascript" src="js/other.js"></script>
<script type="text/javascript" src="js/Zhezhao.js"></script>
 <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
  <!-- form action="employee/xiu.action" method="get"> 
 	<input type="submit" value="s">
 </form>  -->
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){//页面加载完之后自动调用这里面的方法
		
			$('#adda').click(function(){
				showdiv2();
			});
			$('#addc').click(function(){
				showdiv();
			});
			$("#addx").click(function(){
				findAll();//这是使用失败
			});
		findAll();
	});
</script>
<!-- <input id="btnshow" type="button" value="Show" onclick="showdiv();"/> -->
<div id="bg"></div>
<div id="show"><jsp:include page="page/find.html"></jsp:include></div>
<div id="show1"><jsp:include page="page/modify.html"></jsp:include></div>
<div id="show2"><jsp:include page="page/employeeAdd.jsp"></jsp:include></div>
<!-- <input id="btnclose" type="button" value="Close" onclick="hidediv();"/> -->

<table width="760" height="407" border="2" align="center">
  <tr>
    <th height="56" colspan="5"  scope="col" ><h1><font color="red">学生成绩管理</font></h1></th>
  </tr>
  <tr>
    <th height="316" colspan="5" scope="col">
	    	<div id="apDiv2">
				<div id="im">
					<h1><font color=#2828FF>正在很努力努力的为您加载...请稍后</font></h1>
			  		<img src="image/loading.gif" width="640" height="450"/>
			 	</div>
			</div>
			
    </th>
  </tr>
  <tr>
    <td align="center"><input type="button" name="add4" id="addx" value="显示信息" /></td>
    <td align="center"><input type="button" name="button" id="adda" value="增加信息" /></td>
    <td align="center"><input type="button" name="add2" id="addc" value="查询信息" /></td>
  </tr>
</table>
	<input type="hidden" id="id"/>	<!--修改传参的标志  -->
</body>
<body><br></body>
</html>