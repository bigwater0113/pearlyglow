<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#o_wrap {
		width: 1100px;
		margin-left: auto;
		margin-right: auto;
		text-align: center;
		font-family: 'Noto Serif KR', serif;
	}
	#itemsArea {
		padding: 15px;
		display: inline-block;
	}
	#itemsTable {
		width: 1000px;
		margin-left: auto;
		margin-right: auto;
	}
	#personArea {
		display: inline-block;
	}
	#personTable {
		width: 1000px;
		margin-left: auto;
		margin-right: auto;
	}
	#personTable td {
		text-align: left;
	}
	#orderPriceArea {
		padding: 15px;
		display: inline-block;
	}
	#orderPriceTable {
		width: 1000px;
	}
	
	#name_tr input{
		width: 100px;
	}
	#phone_tr input {
		width: 40px;
	}
	#email_tr input {
		width: 100px;
	}
	#addr_tr input {
		width: 400px;
	}
</style>
</head>
<body>
	<div id="o_wrap">
		<h2>주문/결제</h2>
		<form action="${pageContext.request.contextPath }/orderController" method="post">
			<fieldset id="itemsArea">
				<table id="itemsTable" class="table table-hover">
					<tr>
						<th width="100">썸네일</th>
						<th width="400">상품정보</th>
						<th width="100">수량</th>
						<th width="100">할인율</th>
						<th width="150">상품금액</th>
						<th width="150">주문금액</th>
					</tr>
					<c:forEach var="list" items="${list }" varStatus="status">
						<tr>
							<td style="display: none;">
								<input type="text" name="iNum" value="${list.iNum }">
								<input type="text" name="sbCnt" value="${sbCnt[status.index] }">
								<input type="text" name="price" value="${list.price }">
								<input type="text" name="pTotal" value="${sbCnt[status.index] * list.price }">
								<c:if test="${before == 'basket' }">
									<input type="text" name="sbNum" value="${list.sbNum }">
								</c:if>
							</td>	
							<td><img alt="" src="${list.iThumbnail }" style="width: 100px; height: 100px;"></td>
							<td>${list.iName }</td>
							<td>${sbCnt[status.index] }</td> 
							<td>${list.iSale }%</td>
							<td><fmt:formatNumber value="${list.price }" pattern="#,###,###"/>원</td>
							<td><fmt:formatNumber value="${sbCnt[status.index] * list.price }" pattern="#,###,###"/>원</td> 
							<c:set var="totalPrice" value="${totalPrice + (sbCnt[status.index] * list.price) }"/>
						</tr>
					</c:forEach>
				</table>
			</fieldset>
			<fieldset id="personArea">
				<table id="personTable" class="table table-hover">
					<tr>
						<th width="100"> </th>
						<th width="450">수령인 정보 </th>
						<th width="450">구매자 정보 </th>
					</tr>
					<tr id="name_tr">
						<th>수령인 </th>
						<td><input type="text" name="receiverName"> </td>
						<td><input type="text" name="senderName" value="${member.name }"> </td>
					</tr>
					<tr id="phone_tr">
						<th>휴대전화 </th>
						<td><input type="text" value="010" name="rPhone1">-<input type="text" name="rPhone2">-<input type="text" name="rPhone3"> </td>
						<td><input type="text" value="${fn:substring(member.phone,0,3) }" name="sPhone1">-<input type="text" value="${fn:substring(member.phone,3,7) }" name="sPhone2">-<input type="text" value="${fn:substring(member.phone,7,11) }" name="sPhone3"> </td>
					</tr>
					<tr id="email_tr">
						<th>이메일 </th>
						<td><input type="text" name="rEmail1">@<input type="text" name="rEmail2"> </td>
						<td><input type="text" value="${fn:split(member.email,'@')[0] }" name="sEmail1">@<input type="text" value="${fn:split(member.email,'@')[1] }" name="sEmail2"> </td>
					</tr>
					<tr id="addr_tr">
						<th>배송 주소</th>
						<td>
							<input type="text" placeholder="상세 주소를 입력해주세요" name="rAddr">
						</td>
						<td>
							<input type="text" placeholder="상세 주소를 입력해주세요" name="sAddr" value="${member.address }">
						</td>
					</tr>
					<tr>
						<td colspan="3"> <input type="checkbox" id="sameInfo">구매자 정보와 수령인 정보가 일치합니다. </td>
					</tr>
				</table>
			</fieldset>
			<fieldset id="orderPriceArea">
				<table id="orderPriceTable" class="table table-hover">
					<tr>
						<th>총 상품가격 </th>
						<td> <fmt:formatNumber value="${totalPrice}" pattern="#,###,###"/>원 </td>
					</tr>
					<tr>
						<th>할인금액 </th>
						<td> 0원 </td>
					</tr>
					<tr>
						<th>총 결제금액 </th>
						<td> <fmt:formatNumber value="${totalPrice}" pattern="#,###,###"/>원 </td>
					</tr>
					<tr>
						<th>결제수단 </th>
						<td>
							<input type="radio" name="way" value="현금" checked="checked">계좌이체
							<input type="radio" name="way" value="카드">신용/체크카드
						</td>
					</tr>
				</table>
			</fieldset>
			<br>
			<input type="submit" value="주문완료" class="btn btn-secondary btn-lg">
		</form>
	</div>
</body>
<script type="text/javascript">

		var checkbox = document.getElementById("sameInfo");

		checkbox.addEventListener('click', function(e) {
			if (checkbox.checked){
				var name = document.getElementsByName("senderName")[0].value;
				document.getElementsByName("receiverName")[0].value = name;
				
				var p1 = document.getElementsByName("sPhone1")[0].value;
				var p2 = document.getElementsByName("sPhone2")[0].value;
				var p3 = document.getElementsByName("sPhone3")[0].value;
				document.getElementsByName("rPhone1")[0].value = p1;
				document.getElementsByName("rPhone2")[0].value = p2;
				document.getElementsByName("rPhone3")[0].value = p3;
				
				var email1 = document.getElementsByName("sEmail1")[0].value;
				var email2 = document.getElementsByName("sEmail2")[0].value;
				document.getElementsByName("rEmail1")[0].value = email1;
				document.getElementsByName("rEmail2")[0].value = email2;
				
				var addr = document.getElementsByName("sAddr")[0].value;
				document.getElementsByName("rAddr")[0].value = addr;
			} else {
				document.getElementsByName("receiverName")[0].value = "";
				document.getElementsByName("rPhone1")[0].value = "";
				document.getElementsByName("rPhone2")[0].value = "";
				document.getElementsByName("rPhone3")[0].value = "";
				document.getElementsByName("rEmail1")[0].value = "";
				document.getElementsByName("rEmail2")[0].value = "";
				document.getElementsByName("rAddr")[0].value = "";
				
			}
		}, true)
</script>
</html>