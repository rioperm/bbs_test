<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<title>Join</title>

<script type="text/javascript">
$(function() {
    $('.joinBtn').click(function() {
    	var form = $('#joinForm');
    	var checkID = $('#check').text();
    	var checkPW = $('#member_pw').val();
    	
    	if(checkID==""||checkID==null||checkID.trim()=="불가능"){
    		alert("아이디 확인 (빈값 또는 중복)");
    		$('#member_id').focus();
    	}else if(checkPW==""||checkPW==null){
    		alert("비밀번호 입력");
    		$('#member_pw').focus();
    	}else{
    		if(checkID.trim()=="사용가능"){
    			alert("ID [ "+$('#member_id').val()+" ] 으로 가입 되셨습니다.");
        		form.submit();
        	}else{
				alert("아이디 중복으로 인해 가입 불가");    
				$('#member_id').focus();
				return false;
        	}
    	}	
    	});
});
</script>
<body>
	가입하기 <input type="button" value="로그인" onclick="location.href='/test/login.do'">
	<form name="joinForm" id="joinForm" action="/test/joinOk.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="member_id" id="member_id" size="20" onkeyup="checkIdAjax()"><span id="check"></span></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="member_pw" id="member_pw" size="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="가입" class="joinBtn"> 
					<input type="reset" value="초기화"> 
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>