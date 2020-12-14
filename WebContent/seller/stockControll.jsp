<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="st_wrap">
		<h2 style="text-align: center;">상품 목록</h2>
		<form action="${pageContext.request.contextPath }/stockController" method="post">
			<div id="st_itemArea">
				<table id="st_itemTable">
					<tr id="st_tableHeader">
						<th>상품명</th>
						<th>썸네일</th>
						<th>가격</th>
						<th>할인</th>
						<th>성별</th>
						<th>카테고리</th>
						<th>색상</th>
						<th>사이즈</th>
						<th>무게</th>
						<th>재질</th>
						<th>재고</th>
						<th>관리</th>
					</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td>${list.iName }</td>
							<td><img alt="" src="${list.iThumbnail }" width="150" height="150"></td>
							<td>${list.iPrice }</td>
							<td>${list.iSale }></td>
							<td>${list.iGender }></td>
							<td>${list.iCategory }></td>
							<td>${list.color }></td>
							<td>${list.iSize }></td>
							<td>${list.weight }></td>
							<td>${list.meterial }></td>
							<td>${list.iName }></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</body>
</html>