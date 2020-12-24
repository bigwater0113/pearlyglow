<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#purchaselist_wrap {font-family: 'Noto Serif KR', serif;}
.table td, .table th{
	padding: 0px;
}
</style>
<div id="purchaselist_wrap">
	<div id="purchaselist_main">
		<h2>${sessionScope.id}님의 구매 내역</h2>
	</div>
	<div id="purchaselist_table">
		<table class="table table-hover" border="1" width="900">
<!-- 		class="table table-hover" -->
			<tr>
				<th>구매번호</th>
				<th>상세번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>수량</th>
				<th>금액</th>
				<th>총 금액</th>
				<th>구매날짜</th>
			</tr>
			<c:set var="pNumEq" value="0"/>
			<c:forEach var="vo" items="${list }">
				<c:if test="${vo.pnum!=pNumEq }">
					<tr>
						<td colspan="8" style="border-top:1px solid black"></td>
					</tr>
				</c:if>
				<tr>
					<c:choose>
						<c:when test="${vo.pnum!=pNumEq }">
							<td>${vo.pnum }</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<td>${vo.pdnum }</td>
					<td><img src="${vo.ithumbnail }" style="width: 100px; height: 100px;"
					 onclick="location.href='${pageContext.request.contextPath}/detailInfoController?iNum=${vo.inum }';"></td>
					<td>${vo.iname}</td>
					<td>${vo.pcnt}</td>
					<c:choose>
						<c:when test="${vo.pnum!=pNumEq }">
					<td>${vo.ppay}</td>
					<td>${vo.ptotal}</td>
					<td>${vo.pdate}</td>
					</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
							<td></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<c:set var="pNumEq" value="${vo.pnum }"/>
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
			기간선택 <input type="date" class="form-control" value="${p_date1 }" id="purchaselist_date" name="purchaselist_date1" style="width: 200px; display: inline-block;"> - <input type="date" class="form-control" value="${p_date2 }" id="purchaselist_date" name="purchaselist_date2" style="width: 200px; display: inline-block;">
		<input type="submit" class="btn btn-secondary btn-sm" value="검색">
		</form>
	</div>
</div>