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
<a href="${pageContext.request.contextPath }/Board/InsertPage">문의등록</a> 
<table border="1">
	<tr style="text-align: center">
		<th>문의 제품 </th>
		<th>문의 종류 </th>
		<th width="100">문의 제목 </th>
		<th>비밀번호 </th>
		<th width="150">문의 내용 </th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
<c:forEach var="qvo" items="${list }">
	<tr>
		<th>${qvo.iNum }</th>
		<th>${qvo.qCategory }</th>
		<th>${qvo.qTitle }</th>
		<th>${qvo.ibPwd }</th>
		
		<th style="text-align: left;">
			<c:choose>
				<c:when test="${qvo.lev>0 }"> <%-- 답글인 경우 들여쓰기 하기 --%>
					<c:forEach var="i" begin="1" end="${qvo.lev }">
						&nbsp;&nbsp;
					</c:forEach>
					[답글]<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${qvo.ibNum}">${qvo.ans }</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${qvo.ibNum}">${qvo.ibContent }</a>
				</c:otherwise>
			</c:choose>
		</th>
		<th>
			<c:if test="${qvo.id==id || id=='admin'}">
				<a href="${pageContext.request.contextPath}/Board/update?ibnum=${qvo.ibNum}">수정</a>
			</c:if>
		</th>
		<th>
			<c:if test="${qvo.id==id || id=='admin'}">
				<a href="${pageContext.request.contextPath}/Board/delete?ibnum=${qvo.ibNum}">삭제</a>
			</c:if>	
		</th>
	</tr>
</c:forEach>
</table>
</body>
</html>