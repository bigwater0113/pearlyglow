<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="purchaselist_wrap">
	<div id="purchaselist_main">
		<h1>${sessionScope.id}님의 구매 내역</h1>
	</div>
	<div id="purchaselist_table">
		<table border="1" width="900">
			<tr>
				<th>상품이미지</th>
				<th>구매번호</th>
				<th>상세 구매번호</th>
				<th>상품명</th>
				<th>상품별 수량</th>
				<th>상품별 구매 금액</th>
				<th>총 구매 금액</th>
				<th>구매날짜</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td><img src="${vo.ithumbnail }" style="width: 100px; height: 100px;"
					 onclick="location.href='${pageContext.request.contextPath}/detailInfoController?iNum=${vo.inum }';"></td>
					<td>${vo.pnum }</td>
					<td>${vo.pdnum }</td>
					<td>${vo.iname}</td>
					<td>${vo.pcnt}</td>
					<td>${vo.ppay}</td>
					<td>${vo.ptotal}</td>
					<td>${vo.pdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="purchaselist_paging">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath }/purchaselist?pageNum=${startPageNum-1 }">이전</a>
		</c:if>	
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<a href="${pageContext.request.contextPath }/purchaselist?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/purchaselist?pageNum=${endPageNum+1 }">다음</a>
		</c:if>	
	</div>
	<div id="purchaselist_search">
		<form method="post" action="${pageContext.request.contextPath }/purchaselist">
			기간선택<input type="date" value="${p_date1 }" id="purchaselist_date" name="purchaselist_date1">~<input type="date" value="${p_date2 }" id="purchaselist_date" name="purchaselist_date2">
		<input type="submit" value="검색">
		</form>
	</div>
</div>