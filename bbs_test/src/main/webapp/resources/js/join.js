function checkIdAjax() {
	var id = $('#member_id').val();
	$.ajax({
		type : "POST",
		url : "/test/checkId.do",
		data : {
			"checkId" : id
		},
		success : function(data) {
			if ($trim(data) == "YES") {
				alert("가입가능(중복없음)");
				$('#check').html('<font color="red">사용가능</font>');
			} else {
				alert("YES 아님 중복됨");
				$('#check').html('<font color="blue">불가능</font>');
			}
		}
	})
}
