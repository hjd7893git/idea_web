function mod(a,b,c,d,e,f,g,h,i){//�޸���ʾ
		showdiv1();
		$('#m_n').val(a);	//��ԭ�е���Ϣ���ص��޸�ҳ����
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
	
function xiu(){//�޸���Ϣ
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
					alert("�޸ĳɹ���")
					findAll();//-------------����ʹ�þͿ���
				}else{
					alert("�޸�ʧ�ܣ�");
				}
			}
		});
	}
