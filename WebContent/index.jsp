<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style>
/*
 	*{margin:0px;padding:0px;} 
 	div#wrap{margin:auto;width:1200px;height:2600px;overflow:hidden;} 
 	#header{width:100%;height:100px;background-color: lightpink;} 
 	#main{width:100%;height:2100px;background-color: lightblue;} 
 	#footer{width:100%;height:400px;background-color: lightpink;} 
 	*/
 	*{margin:0px;padding:0px;}
 	div#wrap{margin:auto;width:1200px;overflow:hidden;} 
 	#header{width:100%;height:100px;} 
 	#main{width:100%;
 	#footer{width:100%;height:400px;} 
</style>
</head>
<body>
<%
	String spage=request.getParameter("spage");
	String mpage=request.getParameter("mpage");
	if(spage==null){
		spage="myPage.jsp";
	}
	if(mpage==null){
		mpage="testinfo.jsp";
	}
%>
<div id="wrap">
	<div id="header">
		<%@include file="header.jsp" %>
	</div>
	<div id="main">
<%-- 	${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=info.jsp --%>
		<jsp:include page="<%=spage %>"/>
	</div>
	<div id="footer">
		<%@include file="footer.jsp" %>
	</div>
</div>
</body>
</html>