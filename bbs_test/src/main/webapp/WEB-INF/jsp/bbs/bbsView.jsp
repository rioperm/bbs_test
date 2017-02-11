<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>전체보기</title>
	<link href="<c:url value="/resources/css/bbs.css" />" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>
	<script type="text/javascript">
		$(function() {
	        $('.viewTd').click(function() {
	           window.location.href=("/test/bbsRead.do?readId="+$(this).attr('alt'));
	        });
	    });
	</script>
</head>

<body>
<h1>
	작성 글 확인
	<input type="button" value="글쓰기" OnClick="window.location='/test/bbsWrite.do'">
</h1>
	
	<table border="1" style="text-align:center;">
		<tr>
			<td style="width:50;">번호</td>
			<td style="width:100;">제목</td>
			<td style="width:150;">작성일</td>
		</tr>
 		<c:forEach items="${bbsList}" var="bbsList">
			<tr>
				<td class="viewTd" alt="${bbsList.bbs_id}"><c:out value="${bbsList.bbs_id}"/></td>
				<td class="viewTd" alt="${bbsList.bbs_id}"><c:out value="${bbsList.bbs_title}"/></td>
				<td class="viewTd" alt="${bbsList.bbs_id}"><c:out value="${bbsList.bbs_date}"/></td>
			</tr> 
		</c:forEach>
	</table>
	
</body>
</html>
