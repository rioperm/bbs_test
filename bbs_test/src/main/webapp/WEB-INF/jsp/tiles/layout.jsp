<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layout</title>
<tiles:insertAttribute name="sessionCheck"/>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>
<body>
	<table border="1" align="center" width="60%;" style="padding:20px;">
		<tr>
			<td height="30">
				<c:if test="${!empty sessionScope.sessionMessage}">&nbsp;&nbsp;
				<font color="red">${sessionScope.sessionMessage}</font></c:if>
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="main"/></td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="footer"/></td>
		</tr> 
	</table>
</body>
</html>