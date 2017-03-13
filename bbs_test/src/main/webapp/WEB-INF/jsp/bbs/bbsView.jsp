<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>전체보기</title>
	<link href="<c:url value="/resources/css/bbs.css" />" rel="stylesheet">
	<script type="text/javascript">
		$(function() {
	        $('.viewTd').click(function() {
	        	var clickId = $(this).attr("id");
	        	$('#readId').val(clickId);
	        	 
	        	var bbsF = $('#footerForm');
	        	bbsF.attr("action","bbsRead.do");
	        	bbsF.submit();
	        	 
	        });
	        
	        $('#selectNumberPerPage').change(function() {
	        	var value = $(this).val();
	        	$('#numberPerPage').val(value);
	        	var bbsF = $('#footerForm');
	        	bbsF.attr("action","bbs.do");
	        	bbsF.submit();
	        });
	        
	        $('.pageLink').click(function(){
	        	var value = $(this).attr("id");
	        	$('#viewPage').val(value);
	        	var bbsF = $('#footerForm');
	        	bbsF.attr("action","bbs.do");
	        	bbsF.submit();
	        });
	        
	        $('.pageLinkSpan').click(function(){
	        	var value = $(this).attr("id");
	        	$('#pageLinkSpan').val(value);
	        	var bbsF = $('#footerForm');
	        	bbsF.attr("action","bbs.do");
	        	bbsF.submit();
	        });
	        
	        $('.writeBtn').click(function(){
	        	var bbsF = $('#footerForm');
	        	bbsF.attr("action","bbsWrite.do");
	        	bbsF.submit();
	        });
	    });
	</script>
</head>
<body>
	<div id="bbs_div" style="padding:10px;">
	<h1>
		작성 글 확인
		<input type="button" value="글쓰기" class="writeBtn">
	</h1>
		<%-- <div>페이지 당 갯수 
			<select name="selectNumberPerPage" id="selectNumberPerPage">
				<option value="10" <c:if test="${numberPerPage eq 10}">selected="selected"</c:if>>10</option>
				<option value="20" <c:if test="${numberPerPage eq 20}">selected="selected"</c:if>>20</option>
				<option value="30" <c:if test="${numberPerPage eq 30}">selected="selected"</c:if>>30</option>
			</select>
			<span style="float:right;">전체 글 갯수 : ${totalCount}</span>
		</div> --%>
		<table border="1" style="text-align:center;">
			<tr>
				<td style="width:10%;">번호</td>
				<td style="width:30%;">제목</td>
				<td style="width:10%;">작성일</td>
				<td style="width:10%;">작성자</td>
			</tr>
	 		<c:forEach items="${bbsList}" var="bbsList">
	 			<c:set var="date" value="${fn:split(bbsList.bbs_date,' ')}"/>
				<tr>
					<td class="viewTd" id="${bbsList.bbs_id}"><c:out value="${bbsList.bbs_id}"/></td>
					<td class="viewTd" id="${bbsList.bbs_id}"><c:out value="${bbsList.bbs_title}"/></td>
					<c:forEach var="frontDate" items="${date}" varStatus="d">
						<c:if test="${d.count==1}">
							<td class="viewTd" id="${bbsList.bbs_id}"><c:out value="${frontDate}"/></td>
						</c:if>	
					</c:forEach>
					<td class="viewTd" id="${bbsList.bbs_id}"><c:out value="${bbsList.member_id}"/></td>
				</tr> 
			</c:forEach>
		</table>
	</div>
</body>
</html>
