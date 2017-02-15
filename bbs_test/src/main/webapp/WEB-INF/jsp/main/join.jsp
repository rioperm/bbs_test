<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<title>Join</title>
<body>
	가입하기 <input type="button" value="로그인" onclick="location.href='/test/login.do'">
	<form name="joinForm" id="joinForm" action="/test/joinOk.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input name="member_id" id="member_id" size="20" onkeyup="checkIdAjax()"><span id="check"></span></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="member_pw" id="member_pw" size="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입"> 
					<input type="reset" value="초기화"> 
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>