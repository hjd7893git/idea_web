
function delet(f,obj){	//ɾ��������¼
		if(confirm("��ȷ��Ҫɾ�������¼��?")){
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
			    		alert("ɾ���ɹ�!");
			    		$(obj).parent("td").parent("tr").remove();
			    	}else{
			    		alert("ɾ��ʧ��!");
			    	};
				}
			});
		}else{
			return;
		}
	}