function findAll(){	//�������е���Ϣ
		$.ajax({ 
			url: "SSH?flag=0", 
			async:true,
			cache:false,
			dataType:"html",
			timeout:2000,
			type:"post",
			success: function(date){
				  $('#apDiv2').html(date);
 		    	
			}
		});
	
	}