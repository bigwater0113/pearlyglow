<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="reviewlist_wrap">
	<div id="reviewlist_main">
		<h1>${id}님의 구매 내역</h1>
	</div>
	<div id="reviewlist_table">
		<table border="1" width="900">
			<tr>
				<th>구매번호</th>
				<th>상세 구매번호</th>
				<th>상품명</th>
				<th>상품이미지</th>
				<th>상품별 수량</th>
				<th>상품별 구매 금액</th>
				<th>총 구매 금액</th>
				<th>구매날짜</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
						<td>${vo.pnum }</td>
						<td>${vo.pdnum}</td>
						<td>${vo.iname}</td>
						<td>${vo.ithumbnail}</td>
						<td>${vo.pcnt}</td>
						<td>${vo.ptotal}</td>
						<td>${vo.pdate}</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<div id="reviewlist_paging">
		페이징처리~~~~~~~~~~~~~~~
	</div>
</div>