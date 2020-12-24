<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

#s_wrap {
	width: 960px;
	font-family: 'Noto Serif KR', serif;
}

#s_itemArea {
	display: flex;
	justify-content: center;
}

#s_tableHeader {
	
}

#s_itemTable td {
	border-bottom: 1px solid gray;
	border-top: 1px soild gray;
	font-size: 14px;
}

#s_itemTable span {
	font-size: 12px;
	color: solid gray;
}

#s_itemTable th {
	border-bottom: 1px solid gray;
	border-top: 1px soild gray;
}

#s_buttonArea {
	text-align: center;
}

#iName {
}

</style>
</head>
<body>
	<div id="s_wrap">
		<h2 style="text-align: center;">장바구니 목록</h2>
		<form method="post">
			<div id="s_itemArea">
				<table id="s_itemTable" class="table table-hover">
					<tr id="s_tableHeader">
						<th width="32" height="24"><input type="checkbox" id="s_selectAll" checked="checked"></th>
						<th width="100" height="24">이미지</th>
						<th width="402" height="24">상품정보</th>
						<th width="102" height="24">판매가</th>
						<th width="52" height="24">수량</th>
						<th width="102" height="24">총금액</th>
					</tr>
					<c:forEach var="list" items="${list }">
						<c:set var="totalPrice" value="${totalPrice + (list.price * list.sbCnt) }" />
						<tr>
							<td width="30"><input type="checkbox" id="${list.sbNum }" class="ck" name="item" value="${list.sbNum }" checked></td>
							<td width="100" height="100"><img alt=""
								src="${list.iThumbnail }" width="100" height="100"
								onclick="location.href='${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }'"></td>
							<td width="400">
								<strong>
									<a id="iName" href="${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }">${list.iName }</a>
								</strong> <br>
								<span>Category : ${list.iCategory }</span> <br>
								<span>Gender : ${list.iGender } </span> <br>
								<span>Color : ${list.color } </span> <br>
								<span>Size : ${list.iSize } </span></td>
							<td width="100"><fmt:formatNumber value="${list.price }" pattern="#,###,###"/>원 </td>
							<td style="display: none"> <input type="text" name="sbCnt" value="${list.sbCnt }"> </td>
							<td width="50">${list.sbCnt }</td>
							<td width="100"><fmt:formatNumber value="${list.price * list.sbCnt }" pattern="#,###,###"/>원 </td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" style="text-align: right;">합계 : <fmt:formatNumber value="${totalPrice}" pattern="#,###,###"/>원</td>
					</tr>
				</table>
			</div>
			<div id="s_buttonArea">
				<input type="submit" value="선택삭제" id="deleteChoose" class="btn btn-secondary" style="width: 100px; height: 50px;" formaction="${pageContext.request.contextPath }/basketController" onclick="isChecked(event)"> 
				<input type="submit" value="주문하기" class="btn btn-light" style="width: 100px; height: 50px;" formaction="${pageContext.request.contextPath }/orderFormController" onclick="isChecked(event)">
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	var check = 0;

	document.getElementById("s_selectAll").addEventListener('click',
			function(e) {
				var item = document.getElementsByName("item");
				for (let i = 0; i < item.length; i++) {
					if (check == 0) {
						item[i].checked = false;
					} else {
						item[i].checked = true;
					}
				}
				if (check == 0) {
					check = 1;
				} else {
					check = 0;
				}
			}, true)
	
	function isChecked(e) {
		
		var checkbox = document.getElementsByName("item");
		var count = 0;
		
		for (let i=0; i<checkbox.length; i++) {
			if (checkbox[i].checked) {
				count++;	
			}
		}
		
		if (count <= 0) {
			e.preventDefault();
			alert("선택된 상품이 없습니다.");
		}
	}
</script>
</html>