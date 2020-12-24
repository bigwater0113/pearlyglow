<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board/secret.jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Board/list" style="text-align: center; margin-top: 100px;">
<h1>비밀글 비밀번호 입력</h1>
<div>
<input type="text" name="pwd" width="200px" class="form-control" placeholder="Password" style="display: inline-block; width: 300px;">
<input type="submit" value="확인" class="btn btn-black">&nbsp;&nbsp;
<input type="button" value="닫기" onclick="self.close()" class="btn btn-secondary">
</div>
</form>
</body>
</html>