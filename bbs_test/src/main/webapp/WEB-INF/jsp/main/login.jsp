<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	로그인하기 <input type="button" value="신규가입" onclick="location.href='/test/join.do'">
	<form name="loginForm" id="loginForm" action="/test/loginOk.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input name="member_id" id="member_id" size="20"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input name="member_pw" id="member_pw" size="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"> 
					<input type="reset" value="초기화"> 
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>