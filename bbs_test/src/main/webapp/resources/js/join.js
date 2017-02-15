function checkIdAjax() {
	var id = $('#member_id').val();
	$.ajax({
		type : "POST",
		url : "/test/checkId.do",
		data : {
			"checkId" : id
		},
		success : function(data) {
			if (data.trim() == "YES") {
				$('#check').html('<font color="red"> 사용가능</font>');
			} else if(data.trim() == "NO") {
				$('#check').html('<font color="blue"> 불가능</font>');
			} 
		}
	})
}
