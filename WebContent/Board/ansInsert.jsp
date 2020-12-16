<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/Board/ansInsert.jsp</title>
</head>
<body>
<h1>답글등록하기</h1>
<form method="get" action="${pageContext.request.contextPath }/board/insert">
	<!-- 답글인 경우 부모글에 대한 정보가 파라미터로 서버에 전송된다. -->
	<input type="hidden" name="ibnum" value="${param.ibnum }">
	<input type="hidden" name="ref" value="${param.ref }">
	<input type="hidden" name="lev" value="${param.lev }">
	<input type="hidden" name="step" value="${param.step }">
	작성자<br>
	<input type="text" name="id" value="${id }" readonly="readonly"><br>
	답글내용<br>
	<textarea name="ans" rows="5" cols="50"></textarea><br>
	<input type="submit" value="등록">
</form>
</body>
</html>