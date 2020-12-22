<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myOrder.jsp -->
<style>
	#myOrder_wrap{
		width:900px;
		height:700px;
	}
	#myOrder_main{
		text-align:center;
		margin-bottom:20px;
	}
	#myOrder_main h1{
		text-shadow:3px 3px 3px black;
		color:white;
	}
	#myOrder_search a{
		color:black;
		font-size:20px;
		text-decoration: none;
	}
	#myOrder_search a:hover{
		font-weight:bold;
	}
	table{margin:auto;}
</style>
<div id="myOrder_wrap">
	<div id="myOrder_main">
		<h1>ORDER</h1>
	</div>
	<div id="myOrder_search">
		<a href="${pageContext.request.contextPath }/myOrder?pDate=0">전체</a> | 
		<a href="${pageContext.request.contextPath }/myOrder?pDate=6">최근 6개월</a> | 
		<a href="${pageContext.request.contextPath }/myOrder?pDate=2020">2020</a> | 
		<a href="${pageContext.request.contextPath }/myOrder?pDate=2019">2019</a> | 
		<a href="${pageContext.request.contextPath }/myOrder?pDate=2018">2018</a>
		
	</div>
	<div id="myOrder_table">
		<table border="1" width="900">
			<tr>
				<th>아이디</th>	<!-- purchase -->
				<th>구매번호</th>	<!-- purchase -->
				<th>품번</th>	<!-- purchase -->
				<th>이미지명</th> <!-- items_image -->
				<th>상품 명</th>	<!-- items -->
				<th>상품별금액</th>	<!-- purchase -->
				<th>제품출고상태</th>	<!-- purchase -->
				<th>날짜</th>	<!-- purchase -->
				<th>배송정보</th>
				<th>배송링크</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.id }</td>
					<td>${vo.pNum }</td>
					<td>${vo.iNum }</td>
					<td>${vo.iThumbnail }</td>
					<td>${vo.iName }</td>
					<td>${vo.pPay }</td>
					<td>${vo.pStatus }</td>
					<td>${vo.pDate }</td>
					<td><a href="${pageContext.request.contextPath }/MyDelivery?pNum=${vo.pNum}">배송조회</a></td>
					<td><a href="https://tracker.delivery/#/kr.epost/1111111111111" target="_blank">배송링크</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="myOrder_pageDiv">
		<c:choose>
			<c:when test="${startPageNum>10 }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath }/myOrder?pageNum=${startPageNum-1}">이전</a>]
			</c:when>
			<c:otherwise>
				[이전]
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i==pageNum}"><%-- 현재페이지인경우 (색상 다르게 표시) --%>
					<a href="${pageContext.request.contextPath }/myOrder?pageNum=${i}"><span style="color:gray">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/myOrder?pageNum=${i}"><span style="color:blue">[${i }]</span></a>
				</c:otherwise>
			</c:choose> 
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum<pageCount }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath }/myOrder?pageNum=${endPageNum+1}">다음</a>]
			</c:when>
			<c:otherwise>
				[다음]
			</c:otherwise>
		</c:choose>
	</div>
</div>