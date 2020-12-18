<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#st_wrap {
		width: 898px;
		border: 1px solid gray;
		text-align: center;
	}
	#st_itemArea {
		display: flex;
		justify-content: center;
	}
</style>
</head>
<body>
	<div id="st_wrap">
		<h2 style="text-align: center;">상품 목록</h2>
		<form action="${pageContext.request.contextPath }/stockController" method="post">
			<div id="st_itemArea">
				<table id="st_itemTable" border="1" style="word-break: break-all">
					<tr id="st_tableHeader">
						<th width="150px">상품명</th>
						<th width="100px">썸네일</th>
						<th width="80px">가격</th>
						<th width="50px">할인</th>
						<th>성별</th>
						<th>카테고리</th>
						<th width="80px">색상</th>
						<th>사이즈</th>
						<th>무게</th>
						<th width="50px">재질</th>
						<th width="50px">재고</th>
						<th>관리</th>
						<th>삭제 </th>
					</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td width="150px">${list.iName }</td>
							<td><img alt="" src="${list.iThumbnail }" width="100" height="100"></td>
							<td>${list.price } \</td>
							<td>${list.iSale } %</td>
							<td>${list.iGender }</td>
							<td>${list.iCategory }</td>
							<td>${list.color }</td>
							<td>${list.iSize }</td>
							<td>${list.weight }</td>
							<td>${list.material }</td>
							<td>${list.total }</td>
							<td><a href="${pageContext.request.contextPath }/itemUpdateController?iNum=${list.iNum}">수정</a></td>
							<td><a href="${pageContext.request.contextPath }/itemDeleteController?iNum=${list.iNum}">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</body>
</html>