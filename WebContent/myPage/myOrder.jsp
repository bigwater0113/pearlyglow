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
		text-shadow:3px 3px 4px black;
		color:white;
	}
	table{margin:auto;}
</style>
<div id="myOrder_wrap">
	<div id="myOrder_main">
		<h1>주문내역</h1>
	</div>
	<div id="myOrder_table">
		<table border="1">
			<tr>
				<th>아이디</th>	<!-- purchase -->
				<th>구매번호</th>	<!-- purchase -->
				<th>품번</th>	<!-- purchase -->
				<th>이미지명</th> <!-- items_image -->
				<th>상품 명</th>	<!-- items -->
				<th>총금액</th>	<!-- purchase -->
				<th>제품출고상태</th>	<!-- purchase -->
				<th>날짜</th>	<!-- purchase -->
				<th>배송정보</th>
				<th>상세정보</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<td>${vo.id }</td>
				<td>${vo.pNum }</td>
				<td>${vo.iNum }</td>
				<td>${vo.imgName }</td>
				<td>${vo.iName }</td>
				<td>${vo.pTotal }</td>
				<td>${vo.pStatus }</td>
				<td>${vo.pDate }</td>
			</c:forEach>
		</table>
	</div>
</div>