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
	#sellerPage_Menu{width:200px;height:400px;float:left;padding:20px;}
	#sellerPage_Menu h2{font-weight:bold; color:#555555;font-family: 'Noto Serif KR', serif;}
	#sellerPage_Menu a{color:black;text-decoration: none; font-weight:bold;
		 color:#CCCCCC;font-family: 'Noto Serif KR', serif;}
	#sellerPage_Menu a:hover{color:#888888;}
	#sellerPage_section{width:1000px; float:left; padding-top:20px;}
	
</style>
<div id="sellerPage_wrap">
	<div id="sellerPage_Menu">
		<h2>SellerPage</h2>
		<br>
		<h4><a href="${pageContext.request.contextPath }/sales?group=category&year=2020&month=12">매출관리</a></h4>
		<h4><a href="${pageContext.request.contextPath }/soldlist">판매내역</a></h4>
		<h4><a href="${pageContext.request.contextPath }/stockController">상품관리</a></h4>
		<h4><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../seller/insertItem.jsp">상품등록</a></h4>
		<h4><a href="${pageContext.request.contextPath }/Member/list">회원관리</a></h4>
		<h4><a href="${pageContext.request.contextPath }/Board/list">문의</a></h4>
	</div>
	<div id="sellerPage_section">
		<jsp:include page="<%=mpage %>"/>
	</div>
</div>
