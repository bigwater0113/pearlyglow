<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>
<h1>상세글보기</h1>
<table border="1" width="600">
	<tr>
		<th>문의글 번호</th>
		<th>${vo.ibNum }</th>
	</tr>
	<tr>
		<th>작성자</th>
		<th>${vo.id }</th>
	</tr>
	<tr>
		<th>문의 제품</th>
		<th> ${vo.iNum }</th>
	</tr>
	<tr>
		<th>문의글 내용</th>
		<th><textarea rows="5" cols="50" readonly="readonly">${vo.ibContent }</textarea></th>
	</tr>
	<tr>
		<th>비밀글 비밀번호</th>
		<th> ${vo.ibPwd }</th>
	</tr>
	<tr>
		<th>작성날짜</th>
		<th> ${vo.ibDate }</th>
	</tr>
	<tr>
		<th>문의글 답변</th>
		<th><textarea rows="5" cols="50" readonly="readonly">${vo.ans }</textarea></th>
	</tr>
	<tr>
		<th>답글 작성날짜</th>
		<th> ${vo.ansDate }</th>
	</tr>
	<tr>
		<td colspan="2"><a href="${pageContext.request.contextPath }/Board/ansInsert.jsp?ibnum=${vo.ibnum }&ref=${vo.ref }&lev=${vo.lev }&step=${vo.step }">답글</a></td>
	</tr>
</table>
<a href="${pageContext.request.contextPath }/Member/main.jsp">홈으로</a>
</body>
</html>