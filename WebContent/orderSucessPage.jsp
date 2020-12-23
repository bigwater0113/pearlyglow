<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>감사합니다.</h1>
	<h2>고객님의 주문이 정상적으로 처리되었습니다.</h2>
	
	<input type="button" onclick="location.href='${pageContext.request.contextPath}/Main'" value="메인으로">
	<input type="button" onclick="location.href='${pageContext.request.contextPath}/myOrder?page=1&pDate=0'" value="주문내역">
</body>
</html>