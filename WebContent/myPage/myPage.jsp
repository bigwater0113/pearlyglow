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
	#myPage_section{width:900px; float:left;}
	
</style>
<div id="myPage_wrap">
	<div id="myPage_Menu">
		<h1>마이페이지</h1>
		<h2><a href="${pageContext.request.contextPath }/Member/info?id=${id }">내 정보</a></h2>
		<h2><a href="${pageContext.request.contextPath }/purchaselist?id=${id }">구매내역</a></h2>
		<h2><a href="${pageContext.request.contextPath }/myOrder?pDate=0">주문내역</a></h2>
		<h2><a href="${pageContext.request.contextPath }">장바구니</a></h2>
		<h2><a href="${pageContext.request.contextPath }/MyReview?status=">내 리뷰</a></h2>
		<h2><a href="${pageContext.request.contextPath }/Board/boardInfo?id=${id }">내 문의</a></h2>
		<h2><a href="${pageContext.request.contextPath }/recentView">최근본상품</a></h2>
		<h2><a href="">회원탈퇴</a></h2>
	</div>
	<div id="myPage_section">
		<jsp:include page="<%=mpage %>"/>
	</div>
</div>
