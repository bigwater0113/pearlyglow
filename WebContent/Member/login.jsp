<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/login.jsp</title>
</head>
<body>
<h1>회원로그인</h1>
<form method="post" action="${pageContext.request.contextPath}/Member/login">
	아이디 <input type="text" id="l_id" name="l_id"><br>
	비밀번호 <input type="password" id="l_pwd" name="l_pwd"><input type="submit" value="로그인"><br>
	<div style="font-size: 18px; color:red;">${errMsg }</div>
	<input type="button" value="회원가입" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/join.jsp'">
	<input type="button" value="아이디찾기" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/idsearch.jsp'">
	<input type="button" value="비밀번호찾기" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/pwdsearch.jsp'">
</form>
</body>
</html>



