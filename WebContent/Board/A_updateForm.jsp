<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>

<h1>문의글 답글</h1>
<form method="post" action="${pageContext.request.contextPath }/Board/A_update">
	문의 답글<textarea name="a_content" rows="5" cols="50">${requestScope.board.ans}</textarea><br>
	<input type="hidden" name="a_num" value="${requestScope.board.ibNum}"><br>
	<input type="submit" value="확인 ">
</form>
</body>
</html>