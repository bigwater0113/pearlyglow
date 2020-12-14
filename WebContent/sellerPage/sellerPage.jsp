<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String mpage=request.getParameter("mpage");
	if(mpage==null){
		mpage="testinfo.jsp";
	}
%>
<style>
	*{margin:0px;padding:0px;}
	#sellerPage_wrap{width:1200px; margin:auto;}
	#sellerPage_Menu{width:260px;height:400px;float:left;padding:20px;}
	#sellerPage_Menu a{color:black;text-decoration: none; font-weight:bold;}
	#sellerPage_section{width:900px;height:1000px;float:left;}
	
</style>
<div id="sellerPage_wrap">
	<div id="sellerPage_Menu">
		<h1>판매자페이지</h1>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage.jsp&mpage=testinfo.jsp">매출관리</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage.jsp&mpage=testinfo.jsp">상품관리</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage.jsp&mpage=testinfo.jsp">회원관리</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage.jsp&mpage=testinfo.jsp">문의</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage.jsp&mpage=testinfo.jsp">판매내역</a></h2>
	</div>
	<div id="sellerPage_section">
		<jsp:include page="<%=mpage %>"/>
	</div>
</div>
