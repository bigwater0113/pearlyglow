<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myOrder.jsp -->
<style>
	#myOrder_wrap{
		width:960px;
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
	table{margin:auto;text-align:center;}
	#myOrder_table th{background-color: #AAAAAA;height:30px;border:4px solid white;}
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
		<table width="960">
			<tr>
<!--  				<th>아이디</th>	 -->
				<th>구매번호</th>	
<!-- 				<th>품번</th>	 -->
				<th>이미지명</th> 
				<th>상품 명</th>	
				<th>상품별금액</th>	
				<th>제품출고상태</th>	
				<th>날짜</th>	
				<th>배송정보</th>
				<th>배송링크</th>
			</tr>
			<c:set var="pNumEq" value="0"/>
			<c:forEach var="vo" items="${list }">
				<c:if test="${vo.pNum!=pNumEq }">
					<tr>
						<td colspan="8" style="border-top:1px solid black"></td>
					</tr>
				</c:if>
				<tr>
<%-- 					<td>${vo.id }</td> --%>
					<c:choose>
						<c:when test="${vo.pNum!=pNumEq }">
							<td>${vo.pNum }</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
<%-- 					<td>${vo.iNum }</td> --%>
					<td><img src="${vo.iThumbnail }" style="width:100px;height:100px;"></td>
					<td>${vo.iName }</td>
					<td>${vo.pPay }</td>
					<c:choose>
						<c:when test="${vo.pNum!=pNumEq }">
							<td>${vo.pStatus }</td>
							<td>${vo.pDate }</td>
							<td><a href="${pageContext.request.contextPath }/MyDelivery?pNum=${vo.pNum}">배송조회</a></td>
							<td><a href="https://tracker.delivery/#/kr.epost/1111111111111" target="_blank">배송링크</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</c:otherwise>
					</c:choose>
<%-- 					<td>${vo.pStatus }</td> --%>
<%-- 					<td>${vo.pDate }</td> --%>
<%-- 					<td><a href="${pageContext.request.contextPath }/MyDelivery?pNum=${vo.pNum}">배송조회</a></td> --%>
<!-- 					<td><a href="https://tracker.delivery/#/kr.epost/1111111111111" target="_blank">배송링크</a></td> -->
				</tr>
				<c:set var="pNumEq" value="${vo.pNum }"/>
			</c:forEach>
		</table>
	</div>
	<div id="myOrder_pageDiv">
		<c:choose>
			<c:when test="${startPageNum>10 }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath }/myOrder?pageNum=${startPageNum-1}&pDate=${pDate}">이전</a>]
			</c:when>
			<c:otherwise>
				[이전]
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i==pageNum}"><%-- 현재페이지인경우 (색상 다르게 표시) --%>
					<a href="${pageContext.request.contextPath }/myOrder?pageNum=${i}&pDate=${pDate}"><span style="color:gray">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/myOrder?pageNum=${i}&pDate=${pDate}"><span style="color:blue">[${i }]</span></a>
				</c:otherwise>
			</c:choose> 
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum<pageCount }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath }/myOrder?pageNum=${endPageNum+1}&pDate=${pDate}">다음</a>]
			</c:when>
			<c:otherwise>
				[다음]
			</c:otherwise>
		</c:choose>
	</div>
</div>