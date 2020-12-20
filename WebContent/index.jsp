<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 	div#index_wrap{margin:auto;width:1400px;overflow:hidden;} 
 	#index_header{width:1200px;height:100px;} 
 	#index_main{width:1200px;float:left;}
 	#index_aside{margin-left:10px;width:130px;height:600px;position:relative;top:00px;background-color: pink;
 		float:left;}
 	#index_aside div {padding:5px;border:1px solid black;}
 	#index_footer{width:1200px;height:400px;} 
 	.index_visit{text-align: right;font-weight:bold;font-size: 17px;}
</style>
</head>
<body>
<%
	String spage=request.getParameter("spage");
	String mpage=request.getParameter("mpage");
	String ppage=request.getParameter("ppage");
	if(spage==null){
		spage="myPage/myPage.jsp";
	}
	if(mpage==null){
		mpage="testinfo.jsp";
	}
	if(ppage==null){
		ppage="quickView.jsp";
	}
%>
<div id="index_wrap">
	<div id="index_header">
		<%@include file="header.jsp" %>
	</div>
	
	<div id="index_main">
<%-- 	${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=info.jsp --%>
		<jsp:include page="<%=spage %>"/>
	</div>
	<div id="index_aside">
		<div border="1">
			<p class="index_visit">전체 방문자${totalCnt }</p>
			<p class="index_visit">오늘 방문자${todayCnt }</p>
		</div>
		<div>
			<c:choose>
				<c:when test="${recentViewItem[0]==null }">
					최근본 상품이 없습니다.
				</c:when>
				<c:otherwise>
					<c:forEach var="str" items="${recentViewItem }">
						<p class="footer_visit">${str }</p>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
	<div id="index_footer">
		<%@include file="footer.jsp" %>
	</div>
</div>

</body>
</html>