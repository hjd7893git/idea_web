function add(){//添加
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
					alert("添加成功");
					findAll();//-------------这里使用就可以
				}else{
					alert("添加失败！");
				}
			}
		});
	}