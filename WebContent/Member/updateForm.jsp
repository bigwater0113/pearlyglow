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

<h1>회원정보수정하기</h1>
<form method="post" action="${pageContext.request.contextPath}/Member/update">
	비밀번호 <input type="password" name="u_pwd" value="${member.pwd}"><br>
	이메일 <input type="email" name="u_email" value="${member.email}"><br>
	전화번호 <input type="text" name="u_phone" value="${member.phone}"><br>
	회원주소 <input type="text" name="u_addr" value="${member.address}"><br>
	휴먼계정 <input type="text" name="u_issleep" value="${member.issleep}" disabled="disabled"><br>
	<input type="submit" value="저장">
	<input type="hidden" name="u_id" value="${member.id}"><br>
</form>
</body>
</html>