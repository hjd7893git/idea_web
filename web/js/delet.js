
function delet(f,obj){	//删除单条记录
		if(confirm("您确定要删除此项记录吗?")){
			$.ajax({ 
				url: "SSH?flag=1", 
				async:true,
				cache:false,
				data:{id:f},
				dataType:"text",
				timeout:2000,
				type:"post",
				success: function(date){
			    	if(date=="true"){
			    		alert("删除成功!");
			    		$(obj).parent("td").parent("tr").remove();
			    	}else{
			    		alert("删除失败!");
			    	};
				}
			});
		}else{
			return;
		}
	}