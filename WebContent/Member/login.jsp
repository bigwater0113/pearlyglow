<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/login.jsp</title>
<style type="text/css">
	h1, form{
		width: 300px;
		margin: 0 auto;
		text-align: center;
	}
	
</style>
</head>
<body>
<h1>회원로그인</h1><br>
<form method="post" action="${pageContext.request.contextPath}/Member/login">
	<label style="width: 100px">아이디</label> <input type="text" id="l_id" name="l_id" autofocus="autofocus" class="form-control" placeholder="User Id"><br><br>
	<label style="width: 100px">비밀번호</label> <input type="password" id="l_pwd" name="l_pwd" class="form-control" placeholder="Password"><br>
	<div style="font-size: 17px; color:red;">${errMsg }</div>
	<button type="submit" class="btn btn-black">Login</button>&nbsp;&nbsp;
	<input type="button" value="Sign up" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/join.jsp'"><br><br>
	<input type="button" value="아이디찾기" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/idsearch.jsp'">&nbsp;&nbsp;
	<input type="button" value="비밀번호찾기" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=Member/pwdsearch.jsp'">
</form>
</body>
</html>



