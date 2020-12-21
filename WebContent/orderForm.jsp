<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#itemsArea {
		display: flex;
		justify-content: center;
		text-align: center;
	}
	#personArea {
		display: flex;
		justify-content: center;
		text-align: center;
	}
</style>
</head>
<body>
	<div id="o_wrap">
		<h2>주문/결제</h2>
		<fieldset id="itemsArea">
			<legend style="font-size: 20px;">주문목록</legend>
			<table border="1">
				<tr>
					<th width="100">썸네일</th>
					<th width="450">상품정보</th>
					<th width="100">수량</th>
					<th width="100">할인율</th>
					<th width="150">상품금액</th>
					<th width="150">주문금액</th>
				</tr>
				<c:forEach var="list" items="${list }">
					<tr>
						<td><img alt="" src="${list.iThumbnail }" style="width: 100px; height: 100px;"></td>
						<td>${list.iName }</td>
						<td>${list.sbCnt }</td>
						<td>${list.iSale }%</td>
						<td>\ ${list.price }원</td>
						<td>\ ${list.sbCnt * list.price }원</td>
						<c:set var="totalPrice" value="${totalPrice + (list.sbCnt * list.price) }"/>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		<fieldset id="personArea">
			<legend style="font-size: 20px;">수령/구매자 정보</legend>
			<table border="1">
				<tr>
					<th width="100"> </th>
					<th width="400">수령인 정보 </th>
					<th width="400">구매자 정보 </th>
				</tr>
				<tr>
					<th>수령인 </th>
					<td><input type="text"> </td>
					<td><input type="text" value="${member.name }"> </td>
				</tr>
				<tr>
					<th>휴대전화 </th>
					<td><input type="text" value="010">-<input type="text">-<input type="text"> </td>
					<td><input type="text" value="${fn:substring(member.phone,0,3) }">-<input type="text" value="${fn:substring(member.phone,3,7) }">-<input type="text" value="${fn:substring(member.phone,7,11) }"> </td>
				</tr>
				<tr>
					<th>이메일 </th>
					<td><input type="text">@<input type="text"> </td>
					<td><input type="text" value="${fn:split(member.email,'@')[0] }">@<input type="text" value="${fn:split(member.email,'@')[1] }"> </td>
				</tr>
				<tr>
					<th>배송 주소</th>
					<td>
						<input type="text"> <br>
						<input type="text" placeholder="상세 주소를 입력해주세요">
					</td>
					<td>
						<input type="text" value="${member.address }"> <br>
						<input type="text" placeholder="상세 주소를 입력해주세요">
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			총 상품가격 ${totalPrice } 원 + 할인 0원 = 총 주문금액 ${totalPrice } 원
		</fieldset>
	</div>
</body>
</html>