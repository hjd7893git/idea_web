function add(){//���
		hidediv2();
		$.ajax({ 
			url:"employee/add.action",
			async:true,
			cache:false,
			data:{name:$('#username').val(),pass:$('#password').val(),sex:$(':checked').val(),
			age:$('#username2').val(),
			yw:$('#username3').val(),
			sx:$('#username4').val(),
			yy:$('#username5').val(),
			lz:$('#username6').val(),
			wz:$('#username7').val()},
			dataType:"html",
			timeout:2000,
			type:"post",
			success: function(date){
				if(date=="true"){
					alert("��ӳɹ�");
					findAll();//-------------����ʹ�þͿ���
				}else{
					alert("���ʧ�ܣ�");
				}
			}
		});
	}