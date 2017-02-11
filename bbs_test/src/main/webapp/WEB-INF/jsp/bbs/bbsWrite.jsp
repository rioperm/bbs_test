<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>
	글쓰기
</h1>
	<form id="bbsWriteForm" action="/test/bbsWriteOk.do" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input name="title" id="title" size="30"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="content" id="content" size="30"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="확인">
					<input type="reset" value="초기화">
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>