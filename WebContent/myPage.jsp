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
	#myPage_wrap{width:1200px; margin:auto;}
	#myPage_Menu{width:260px;height:400px;float:left;padding:20px;}
	#myPage_Menu a{color:black;text-decoration: none; font-weight:bold;}
	#myPage_section{width:900px;height:1000px;float:left;}
	
</style>
<div id="myPage_wrap">
	<div id="myPage_Menu">
		<h1>마이페이지</h1>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=testinfo.jsp">내 정보</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=testinfo.jsp">구매내역</a></h2>
		<h2><a href="${pageContext.request.contextPath }/myOrder">주문내역</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=testinfo.jsp">장바구니</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=testinfo.jsp">내 리뷰</a></h2>
		<h2><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=testinfo.jsp">내 문의</a></h2>
		<h2><a href="${pageContext.request.contextPath }/recentView">최근본상품</a></h2>
		<h2><a href="">회원탈퇴</a></h2>
	</div>
	<div id="myPage_section">
		<jsp:include page="<%=mpage %>"/>
	</div>
</div>
