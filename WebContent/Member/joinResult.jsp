<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/joinResult.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${code=='success' }">
		<h1>회원가입 성공!!!</h1>
	</c:when>
	<c:otherwise>
		<h1>오류로 인해 회원가입 실패!!!</h1>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/index.jsp?spage=main.jsp">홈</a>
</body>
</html>