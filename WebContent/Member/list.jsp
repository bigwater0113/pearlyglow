<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<table border="1" width="1000">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>생년원일</th>
		<th>성별</th>
		<th>이메일</th>
		<th>핸드폰</th>
		<th>주소</th>
		<th>휴먼계정</th>
		<th>최근접속</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.id }</td>
			<td>${vo.pwd }</td>
			<td>${vo.name }</td>
			<td>${vo.birth }</td>
			<td>${vo.gender }</td>
			<td>${vo.email }</td>
			<td>${vo.phone }</td>
			<td>${vo.address }</td>
			<td>${vo.issleep }</td>
			<td>${vo.recentAcc }</td>
			<!-- 번호에 해당하는 회원을 삭제하고 목록페이지로 이동하기 -->
			<td><a href="${pageContext.request.contextPath}/Member/delete?id=${vo.id}">삭제</a></td>
			<td><a href="${pageContext.request.contextPath}/Member/update?id=${vo.id}">수정</a></td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/index.jsp?spage=main.jsp">홈</a>
</body>
</html>





