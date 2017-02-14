<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script type="text/javascript">
	function go_login(){
		alert("세션이 없음");
		location.href="/test/login.do";
	}
</script>
<body <c:if test="${empty sessionScope.loginYn}">onload="go_login()"</c:if>>
</body>
