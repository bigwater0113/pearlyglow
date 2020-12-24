<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/mypage.jsp</title>
</head>
<body>
<h1 style="text-align: center;">마이페이지</h1>
<form method="post" action="${pageContext.request.contextPath}/Member/list" style="text-align: center;">
	<label style="width: 100px;">아이디</label><input type="text" name="m_id" value="${vo.id}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control" ><br>
	<label style="width: 100px;">비밀번호 </label><input type="password" name="m_pwd" value="${vo.pwd}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">이름</label><input type="text" name="m_name" value="${vo.name}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">생년월일 </label><input type="text" name="m_birth" value="${vo.birth}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">성별 </label><input type="text" name="m_gender" value="${vo.gender}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">이메일 </label><input type="email" name="m_email" value="${vo.email}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">전화번호</label><input type="text" name="m_phone" value="${vo.phone}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">회원주소</label><input type="text" name="m_addr" value="${vo.address}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">휴면계정</label><input type="text" name="m_issleep" value="${vo.issleep}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br>
	<label style="width: 100px;">최근접속 </label><input type="text" name="m_recent" value="${vo.recentAcc}" disabled="disabled" style="width: 300px; padding: 0px; display: inline-block;" class="form-control"><br><br>
	<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath}/Member/update?id=${vo.id}'" class="btn btn-secondary" >&nbsp;&nbsp;
	<input type="button" value="회원탈퇴" onclick="location.href='${pageContext.request.contextPath}/Member/delete?id=${vo.id}'" class="btn btn-black">
</form>
</body>
</html>