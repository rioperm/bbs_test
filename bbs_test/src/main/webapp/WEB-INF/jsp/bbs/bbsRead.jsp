
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>글읽기</title>
	<link href="<c:url value="/resources/css/bbs.css" />" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>
	<script type="text/javascript">
		$(function() {
	        $('.delBtn').click(function() {
	        	var form = $('#readForm');
	        	form.attr('action','/test/bbsDelete.do');
	        	form.submit();
	        	
	        });
	        $('.modBtn').click(function() {
	        	window.location.href=("/test/bbsModify.do?modifyId="+$(this).attr('alt'));
	        });
	    });
	</script>
</head>

<body>
<h1>
	글 읽기
</h1>
	<form id="readForm" name="readForm" action="/test/bbsRead.do" method="post" >
		<input type="hidden" name="deleteId" value="${readOne.bbs_id}">
			<table border="1" style="text-align:center;">
			<tr>
				<td style="width:70;">번호</td>
				<td style="width:150;"><c:if test="${empty readOne}">삭제된 글 입니다.</c:if>${readOne.bbs_id}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><c:out value="${readOne.bbs_title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><c:out value="${readOne.bbs_content}"/></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><c:out value="${readOne.bbs_date}"/></td>
			</tr>
			<tr>
				<td colspan='2'>
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1)">
					<input type="button" value="수정하기" class="modBtn" alt="${readOne.bbs_id}">
					<input type="button" value="삭제하기" class="delBtn" alt="${readOne.bbs_id}">
				</td>
			</tr>
				</table>
		
	</form>
	
</body>
</html>
