<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
$(function() {
    $('.logoutBtn').click(function() {
    	if(confirm("로그 아웃 하시겠습니까?")==true){
    		window.location="/test/logout.do";
    	}else{
    		return;
    	}
    });
});
</script>

<div style="border:red 0px solid; padding:10px;">
	<c:choose>
		<c:when test="${sessionScope.loginYn == null || sessionScope.loginYn == 'N'}">
			<input type="button" value="가입하기" class="joinBtn" onclick="window.location='/test/join.do'">
			<input type="button" value="로그인" class="loginBtn" onclick="window.location='/test/login.do'">		
		</c:when>
		<c:when test="${sessionScope.loginYn == 'Y'}">
			<input type="button" value="로그아웃" class="logoutBtn">
		</c:when>
	</c:choose>
	<input type="button" value="네이버 (새창)" onclick="window.open('http://www.naver.com')">
</div>
