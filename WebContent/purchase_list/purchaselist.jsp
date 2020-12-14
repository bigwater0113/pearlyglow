<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/purchase_list/purchaselist.jsp</title>
</head>
<body>
<h1>${id}님의 구매 내역</h1>
<div>
	<a href=""></a>
</div>
<div>
	<table border="1" width="900">
		<tr>
		<c:if test="${id == admin}">
			<th><input type="checkbox" id="purchaselist_delcheck" name="purchaselist_delcheck"></th>
		</c:if>
			<th>구매번호</th>
			<th>상세 구매번호</th>
			<th>상품명</th>
			<th>상품이미지</th>
			<th>상품별 수량</th>
			<th>상품별 구매 금액</th>
			<th>총 구매 금액</th>
			<th>구매날짜</th>
			<th>리뷰작성</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<c:if test="${id == admin}">
					<td><input type="checkbox" id="purchaselist_delcheck" name="purchaselist_delcheck"></td>
				</c:if>
					<td>${vo.pnum }</td>
					<td>${vo.iname}</td>
					<td>${vo.pcnt}</td>
					<td>${vo.ppay}</td>
					<td>${vo.ptotal}</td>
					<td>${vo.pdate}</td>
					<td><a href="/reviewboard/insert.jsp">리뷰작성</a></td>
				</tr>
		</c:forEach>
	</table>
</div>
<div>
	페이징처리!!!..ㅋ
</div>
</body>
</html>