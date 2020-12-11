<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testview.jsp</title>
</head>
<body>
<%
	String item=URLEncoder.encode("품번4","utf-8");
	Cookie cookie=new Cookie("item4",item);
	cookie.setPath("/");
	cookie.setMaxAge(30);//쿠키유지시간 30초 text용
	response.addCookie(cookie);
%>

<a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=recentView.jsp">최근본상품</a>
</body>
</html>