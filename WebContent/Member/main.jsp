<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/main.jsp</title>
</head>
<body>
<ul>
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<li><a href="${pageContext.request.contextPath}/index.jsp?spage=Member/login.jsp">회원로그인</a></li>
		</c:when>
		<c:otherwise>
			<li>
				<span style="color:red;font-size:0.8em">${id }님 반갑습니다.</span>
				<a href="${pageContext.request.contextPath}/Member/info?id=${id }">마이페이지</a>
				<a href="${pageContext.request.contextPath}/Member/logout">로그아웃</a>
			</li>
		</c:otherwise>
	</c:choose>
	<li><a href="${pageContext.request.contextPath}/index.jsp?spage=Member/join.jsp">회원가입</a></li>
	<li><a href="${pageContext.request.contextPath}/Member/list">회원목록</a></li>
</ul>
</body>
</html>