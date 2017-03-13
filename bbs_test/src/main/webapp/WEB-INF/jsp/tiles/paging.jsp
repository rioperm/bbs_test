<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form name="footerForm" id="footerForm" action="bbs.do" method="get">
	<input type="hidden" value="test" name="readId" id="readId"/>
	<input type="hidden" value="${numberPerPage}" name="numberPerPage" id="numberPerPage"/>
	<input type="hidden" value="${viewPage}" name="viewPage" id="viewPage"/>
	<input type="hidden" value="${pageLinkSpan}" name="pageLinkSpan" id="pageLinkSpan"/>
	<div style="text-align:center;width:100%;">
		<c:if test="${startPage ne 1}"><span id="pageLeft" class="pageLinkSpan">&lt;</span></c:if>
		&nbsp;
		<c:forEach begin="${startPage}" end="${lastPage}" var="pageNum" varStatus="pageNumStatus">
			&nbsp;<span id="<c:out value="${pageNum}"/>" class="pageLink <c:if test="${viewPage eq pageNumStatus.index}">boldFont</c:if>">${pageNumStatus.index}</span>&nbsp;<c:if test="${!pageNumStatus.last}">|</c:if>				
		</c:forEach>
		&nbsp;
 		<c:if test="${totalPage ne lastPage}">
 		 ... <span id="<c:out value="${totalPage}"/>" class="pageLink">${totalPage} </span>
 		&nbsp;&nbsp;
 		<span id="pageRight" class="pageLinkSpan"> &gt;</span>
 		</c:if>
	</div>
</form>