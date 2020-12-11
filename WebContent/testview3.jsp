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
	int cookieCnt=0;
	String[] names=new String[5];
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
	for(Cookie cook:cooks){
		String name=cook.getName();
		if(name.startsWith("item")){
			names[cookieCnt++]=name;
		}
	}
	if(cookieCnt==5){
		Cookie c=new Cookie(names[0],null);
		c.setPath("/");
		c.setMaxAge(0);
		response.addCookie(c);
	}
	}
	String item=URLEncoder.encode("품번3","utf-8");
	Cookie cookie=new Cookie("item3",item);
	cookie.setPath("/");
	cookie.setMaxAge(30);//쿠키유지시간 30초 text용
	response.addCookie(cookie);
%>

<a href="${pageContext.request.contextPath}/recentView">최근본상품</a>
<a href="testview4.jsp">4</a>
</body>
</html>