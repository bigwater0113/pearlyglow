<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board/mypage.jsp</title>
</head>
<body>
<h1>나의 문의글</h1>
<table border="1">
	<tr style="text-align: center">
		<th>문의글 번호</th>
		<th>작성자</th>
		<th>문의 제품 </th>
		<th>문의 종류 </th>
		<th width="100">문의 제목 </th>
		<th>문의글 비밀번호 </th>
		<th width="150">문의 내용 </th>
		<th>수정</th>
		<th>삭제</th>
		<th width="150">답변</th>
	</tr>
	
<c:forEach var="qvo" items="${list }">
	<tr>
		<th>${qvo.ibNum }</th>
		<th>${qvo.id }</th>
		<th>${qvo.iNum }</th>
		<th>${qvo.qCategory }</th>
		<th>${qvo.qTitle }</th>
		<th>${qvo.ibPwd }</th>
		<th><a href="${pageContext.request.contextPath}/Board/detail?ibnum=${qvo.ibNum}">${qvo.ibContent }</a></th>
		<th><a href="${pageContext.request.contextPath}/Board/update?ibnum=${qvo.ibNum}">수정</a></th>
		<th><a href="${pageContext.request.contextPath}/Board/delete?ibnum=${qvo.ibNum}">삭제</a></th>
		<c:choose>
			<c:when test="${empty qvo.ans }">
				<th>답변대기중</th>
			</c:when>
			<c:otherwise>
				<th>${qvo.ans }</th>
			</c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>