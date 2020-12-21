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
	border: 1px solid gray;
	width: 898px;
}

#s_itemArea {
	display: flex;
	justify-content: center;
}

#s_tableHeader {
	background-color: #d3d3d3;
}

#s_itemTable td {
	border-bottom: 1px solid gray;
	border-top: 1px soild gray;
}

#s_itemTable th {
	border-bottom: 1px solid gray;
	border-top: 1px soild gray;
}

#s_buttonArea {
	text-align: center;
}
</style>
</head>
<body>
	<div id="s_wrap">
		<h2 style="text-align: center;">장바구니 목록</h2>
		<form action="${pageContext.request.contextPath }/basketController"
			method="post">
			<div id="s_itemArea">
				<table id="s_itemTable">
					<tr id="s_tableHeader">
						<th width="32" height="24"><input type="checkbox"
							id="s_selectAll"></th>
						<th width="100" height="24">이미지</th>
						<th width="402" height="24">상품정보</th>
						<th width="102" height="24">판매가</th>
						<th width="52" height="24">수량</th>
						<th width="102" height="24">총금액</th>
					</tr>
					<c:forEach var="list" items="${list }">
						<c:set var="totalPrice" value="${totalPrice + list.price }" />
						<tr>
							<td width="30"><input type="checkbox" id="${list.sbNum }"
								class="ck" name="item" value="${list.sbNum }"></td>
							<td width="100" height="100"><img alt=""
								src="${list.iThumbnail }" width="150" height="150"
								onclick="location.href='${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }'"></td>
							<td width="400"><span>분류 : ${list.iCategory }</span>
								<p>
									<a
										href="${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }">${list.iName }</a>
								</p> <span>성별 : ${list.iGender } </span> <br> <span>색상 :
									${list.color } </span> <br> <span>사이즈 : ${list.iSize } </span></td>
							<!-- <td width="100" style="text-align: center">${list.price }\</td> -->
							<td width="100" style="text-align: center">\<fmt:formatNumber value="${list.price }" pattern="#,###,###"/>원 </td>
							<td width="50" style="text-align: center">${list.sbCnt }</td>
							<td width="100" style="text-align: center">\<fmt:formatNumber value="${list.price * list.sbCnt }" pattern="#,###,###"/>원 </td>
							<!-- <td width="100" style="text-align: center">${list.price * list.sbCnt }\</td> -->
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" style="text-align: right;">합계 : \<fmt:formatNumber value="${totalPrice}" pattern="#,###,###"/>원</td>
					</tr>
				</table>
			</div>
			<div id="s_buttonArea">
				<input type="submit" value="선택삭제" id="deleteChoose"
					style="width: 100px; height: 50px;"> <input type="button"
					value="주문하기" style="width: 100px; height: 50px;">
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	var check = 0;

	document.getElementById("s_selectAll").addEventListener('click',
			function(e) {
				console.log(check);
				var item = document.getElementsByName("item");
				for (let i = 0; i < item.length; i++) {
					if (check == 0) {
						item[i].checked = true;
					} else {
						item[i].checked = false;
					}
				}
				if (check == 0) {
					check = 1;
				} else {
					check = 0;
				}
			}, true)
</script>

<!--
<script type="text/javascript">
	function isChecked() {
		document.getElementsByName("")
	}
</script>


<script type="text/javascript">
	document.getElementById("deleteChoose").addEventListener('click', function(e) {
		var xhr = new XMLHttpRequest();
		var deleteList = document.getElementsByClassName("ck");
		var param = "";
		for (let i=0; i<deleteList.length; i++) {
			if (deleteList[i].checked){
				param += "&item=" + deleteList[i].id;
			}
		}
		
		xhr.onreadystatechange = function() {
			
		}
		xhr.open('post', '${pageContext.request.contextPath}/basketController', true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(param);
	}, true)
	
</script>
  -->
</html>