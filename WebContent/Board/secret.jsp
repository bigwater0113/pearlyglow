<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board/secret.jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Board/list">
<h1>비밀글 비밀번호 입력</h1>
<input type="text" name="pwd" width="200px"><input type="submit" value="확인">&nbsp;&nbsp;
<input type="button" value="닫기" onclick="self.close()">
</form>
</body>
</html>