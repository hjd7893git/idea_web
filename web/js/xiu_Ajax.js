function mod(a,b,c,d,e,f,g,h,i){//修改显示
		showdiv1();
		$('#m_n').val(a);	//将原有的信息加载到修改页面上
		$('#m_p').val(b);
		$('#id').val(a);
		if(c=='MAN')
			$('#m_s').attr({checked:"checked"});
		else
			$('#m_ws').attr({checked:"checked"});
		$('#m_p2').val(d);
		$('#m_p3').val(e);
		$('#m_p4').val(f);
		$('#m_p5').val(g);
		$('#m_p6').val(h);
		$('#m_p7').val(i)
	}
	
function xiu(){//修改信息
		hidediv1();
		$.ajax({ 
			url:"employee/xiu.action", 
			async:true,
			cache:false,
			data:{id:$("#id").val(),name:$('#m_n').val(),pass:$('#m_p').val(),sex:$(':checked').val(),
			age:$('#m_p2').val(),
			yw:$('#m_p3').val(),
			sx:$('#m_p4').val(),
			yy:$('#m_p5').val(),
			lz:$('#m_p6').val(),
			wz:$('#m_p7').val()},
			dataType:"text",
			timeout:2000,
			type:"post",
			success: function(date){
				if(date=="true"){
					alert("修改成功！")
					findAll();//-------------这里使用就可以
				}else{
					alert("修改失败！");
				}
			}
		});
	}
