<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>글수정</title>
	<link href="<c:url value="/resources/css/bbs.css" />" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>
</head>

<body>
<h1>
	글 수정
</h1>
	<form id="modifyForm" name="modifyForm" action="/test/bbsModifyOk.do" method="post">
		<c:if test="${empty modifyBbs}">
			삭제되었거나 없는 글 입니다.
			<input type="button" value="처음으로" Onclick="window.location='/test/bbs.do'">
		</c:if>
			<table border="1" style="text-align:center;">
			<tr>
				<td style="width:70;">번호</td>
				<td style="width:150;"><input type="text" readonly name="modifyId" value="${modifyBbs.bbs_id}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${modifyBbs.bbs_title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${modifyBbs.bbs_content}"></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${modifyBbs.bbs_date}</td>
			</tr>
			<tr>
				<td colspan='2'>
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1)">
					<input type="submit" value="수정하기">
				</td>
			</tr>
				</table>
	</form>
	
</body>
</html>
