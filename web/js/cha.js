
	function cha(){//≤È’“
		hidediv();
		$.ajax({ 
			url: "SSH?flag=2", 
			async:true,
			cache:false,
			data:{findid:$('#find').val()},
			dataType:"html",
			timeout:2000,
			type:"post",
			success: function(date){
		    	$('#apDiv2').html(date);
			}
		});
	}