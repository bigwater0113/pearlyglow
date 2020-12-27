<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/emailResult.jsp</title>
</head>
<body>
<%
	String code = request.getParameter("code");
%>
<h1>이메일 인증 인증번호</h1>
<h3><%=code %></h3>
<button type="button" onclick="window.close()"><span>확인</span></button>

</body>
</html>