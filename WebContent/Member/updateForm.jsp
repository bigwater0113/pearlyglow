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

<h1 style="text-align: center;">회원정보수정하기</h1><br>
<form method="post" action="${pageContext.request.contextPath}/Member/update" style="text-align: center;">
	<label style="width: 100px">비밀번호</label> <input type="password" name="u_pwd" value="${member.pwd}" class="form-control" style="width: 500px; display: inline-block;"><br>
	<label style="width: 100px">이메일</label> <input type="email" name="u_email" value="${member.email}" class="form-control" style="width: 500px; display: inline-block;"><br>
	<label style="width: 100px">전화번호</label> <input type="text" name="u_phone" value="${member.phone}" class="form-control" style="width: 500px; display: inline-block;"><br>
	<label style="width: 100px">회원주소</label> <input type="text" name="u_addr" value="${member.address}" class="form-control" style="width: 500px; display: inline-block;"><br>
	<label style="width: 100px">휴먼계정</label> <input type="text" name="u_issleep" value="${member.issleep}" disabled="disabled" class="form-control" style="width: 500px; display: inline-block;"><br><br>
	<input type="submit" value="저장" class="btn btn-black" style="width: 300px;">
	<input type="hidden" name="u_id" value="${member.id}"><br>
</form>
</body>
</html>