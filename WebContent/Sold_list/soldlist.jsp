<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="soldlist_wrap">
	<div id="soldlist_main">
		<h1>판매 내역</h1>
	</div>
	<div id="soldlist_table">
		<table border="1" width="900">
			<tr>
				<th>구매자ID</th>
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
					<td>${vo.id}</td>
					<td><img src="${vo.ithumbnail }" style="width: 200px;"></td>
					<td>${vo.pnum}</td>
					<td>${vo.pdnum}</td>
					<td>${vo.iname}</td>
					<td>${vo.pcnt}</td>
					<td>${vo.ppay}</td>
					<td>${vo.ptotal}</td>
					<td>${vo.pdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="soldlist_paging">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath }/soldlist?pageNum=${startPageNum-1 }">이전</a>
		</c:if>	
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<a href="${pageContext.request.contextPath }/soldlist?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/soldlist?pageNum=${endPageNum+1 }">다음</a>
		</c:if>	
	</div>
	<div id="soldlist_search">
		<form method="post" action="${pageContext.request.contextPath }/soldlist">
			아이디<input type="text" id="soldlist_idsearch" name="soldlist_idsearch" value="${searchid }">
		<input type="submit" value="검색">
		</form>
	</div>
</div>