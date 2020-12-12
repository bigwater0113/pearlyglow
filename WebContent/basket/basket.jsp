<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	#s_wrap {
		border: 1px solid gray;
		width: 900px;
	}
	#s_itemArea {
		display: flex;
		justify-content: center;
	}
	#s_tableHeader {
		background-color: #d3d3d3;
	}
	#s_itemTable td{
		border-bottom: 1px solid gray;
		border-top: 1px soild gray;
	}
	#s_itemTable th{
		border-bottom: 1px solid gray;
		border-top: 1px soild gray;
	}
</style>
</head>
<body>
	<div id="s_wrap">
		<h2>상품 목록 </h2>
		<div id="s_itemArea">
			<table id="s_itemTable">
				<tr id="s_tableHeader">
					<th><input type="checkbox" id="s_selectAll"> </th>
					<th>이미지 </th>
					<th>상품정보 </th>
					<th>판매가 </th>
					<th>수량 </th>
					<th>총금액 </th>
				</tr>
				<c:forEach var="list" items="${list }">
				<tr>
					<td width="30"><input type="checkbox" id="s_selectAll"> </td>
					<td width="150" height="150"><img alt="" src="${list.imgName }" width="150" height="150"> </td>
					<td width="400">
						<p>${list.iCategory } </p>
						<a href="#">${list.iName }</a>
						<p>옵션 : ${list.iGender }/${list.color }/${list.iSize } </p>
					</td>
					<td width="100" style="text-align: center">${list.price } </td>
					<td width="50" style="text-align: center">${list.sbCnt } </td>
					<td width="100" style="text-align: center">${list.price * list.sbCnt } </td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<input type="button" value="선택삭제">
		<input type="button" value="전체삭제"> <br>
		<input type="button" value="주문하기">
	</div>
</body>
</html>