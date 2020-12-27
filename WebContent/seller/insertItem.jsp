<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#i_wrap {
	display: flex;
	width: 1000px;
	justify-content: center;
	/*vertical-align: middle;*/
	font-family: 'Noto Serif KR', serif;
	font-size: 14px;
}

#i_wrap td {
}

#i_wrap th {
	width: 100px;
}

#i_name {
	width: 745px;
}

#line2 input {
	width: 80px;
	margin: 0 auto;
}

#line2 td {
	width: 200px;
}

#line3 input {
	width: 80px;
}

i_itemWriteArea {
	width: 800px;
}

#buttonArea {
	text-align: center;
}

</style>
</head>
<body>
	<h1 style="text-align: center;">상품 기본정보</h1>
	<div id="i_wrap">
		<c:choose>
			<c:when test="${work == 'update' }">
				<form action="${pageContext.request.contextPath }/itemUpdateController?iNum=${vo.iNum}" method="post">
			</c:when>
			<c:otherwise>
				<form action="${pageContext.request.contextPath }/insertItemController" method="post" enctype="multipart/form-data">
			</c:otherwise>
		</c:choose>
			<div id="i_writeArea">
				<table style="table-layout: fixed; width: 800px;" class="table table-hover" id="i_itemWriteArea">
					<tr id="line1">
						<th>상품명</th>
						<td width="750" colspan="7"><input type="text" id="i_name" name="i_name" value="${vo.iName }"></td>
					</tr>
					<tr id="line2">
						<th>가격</th>
						<td><input type="text" id="i_price" name="i_price" value="${vo.price }"></td>
						<th>성별</th>
						<td><select id="i_gender" name="i_gender">
								<option value="M" <c:if test="${vo.iGender == 'M' }"> selected </c:if>>M</option>
								<option value="W" <c:if test="${vo.iGender == 'W' }"> selected </c:if>>W</option>
						</select></td>
						<th>카테고리</th>
						<td><select id="i_category" name="i_category">
								<option value="ring" <c:if test="${vo.iCategory == 'ring' }"> selected </c:if>>ring</option>
								<option value="bracelet" <c:if test="${vo.iCategory == 'bracelet' }"> selected </c:if>>bracelet</option>
								<option value="necklace" <c:if test="${vo.iCategory == 'necklace' }"> selected </c:if>>necklace</option>
								<option value="earring" <c:if test="${vo.iCategory == 'earring' }"> selected </c:if>>earring</option>
						</select></td>
						<th>색상</th>
						<td><input type="text" id="i_color" name="i_color" value="${vo.color }"></td>
					</tr>
					<tr id="line3">
						<th>중량</th>
						<td><input type="text" id="i_weight" name="i_weight" value="${vo.weight }">
						</td>
						<th>사이즈</th>
						<td><input type="text" id="i_size" name="i_size" value="${vo.iSize }">
						</td>
						<th>재질</th>
						<td><input type="text" id="i_material" name="i_material" value="${vo.material }"></td>
						<th>재고 </th>
						<td><input type="text" id="total" name="total" value="${vo.total }"></td>
					</tr>
					<tr>
						<th>한국어 설명</th>
						<td colspan="7"><textarea rows="10" cols="90" id="i_kdetail"
								name="i_kdetail">${vo.kDetail }</textarea></td>
					</tr>
					<tr>
						<th>영어 설명</th>
						<td colspan="7"><textarea rows="10" cols="90" id="i_edetail"
								name="i_edetail">${vo.eDetail }</textarea></td>
					</tr>
					<tr>
						<th>본문 글</th>
						<td colspan="7"><textarea rows="10" cols="90" id="bodyText"
								name="bodyText">${vo.bodyText }</textarea></td>
					</tr>
					<tr>
						<th>취급 주의사항</th>
						<td colspan="7"><textarea rows="10" cols="90" id="caution"
								name="caution">${vo.caution }</textarea></td>
					</tr>
				
				<c:if test="${work != 'update' }">
					<tr>
						<th>썸네일 이미지</th>
						<td>
							<input type="file" name="thumbnail" value="C:\Users\이희권\Desktop\1.png">
						</td>
					</tr>
					<tr>
						<th>본문 이미지</th>
						<td>
							<input type="file" name="file1">
							<input type="file" name="file2">
							<input type="file" name="file3">
						</td>
					</tr>
				</c:if>
				</table>
			</div>
			<div id="buttonArea">
				<c:choose>
					<c:when test="${work == 'update' }">
						<input type="submit" value="수정" class="btn btn-light">
					</c:when>
					<c:otherwise>
						<input type="submit" value="등록" class="btn btn-secondary">
						<input type="button" value="취소" class="btn btn-light">
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>
</body>
</html>





