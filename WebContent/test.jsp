<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 쿠키 제거 용도. -->
<html>
<head>
<meta charset="UTF-8">
<title>test.jsp</title>
</head>
<body>
<%
	int cookieCnt=0;
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
		for(Cookie cook:cooks){
			cook.setPath("/");
			cook.setMaxAge(0);
			response.addCookie(cook);
		}
	}
%>
</body>
</html>
