<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#st_wrap {
	width: 898px;
	font-family: 'Noto Serif KR', serif;
}

#st_itemArea {
	display: flex;
	text-align: center;
}

#st_itemSearchTable {
	width: 882px;
}

#st_itemSearchTable td {
	width: 341px;
}
#st_itemSearchTable th {
	width: 100px;
	text-align: center;
}
</style>
</head>
<body>
	<div id="st_wrap">
		<h1>상품 관리</h1>
		<form action="${pageContext.request.contextPath }/stockSearchController" method="post">
			<div id="st_itemSearchArea">
				<table border="1" id="st_itemSearchTable">
					<tr>
						<th>카테고리</th>
						<td><select name="searchCategory" class="form-control form-control-sm">
								<option value="categoryAll">:: 선택 ::</option>
								<option value="earring" <c:if test="${searchCategory == 'earring' }"> selected </c:if>> Earring</option>
								<option value="bracelet" <c:if test="${searchCategory == 'bracelet' }"> selected </c:if>>Bracelet</option>
								<option value="necklace" <c:if test="${searchCategory == 'necklace' }"> selected </c:if>>Necklace</option>
								<option value="ring" <c:if test="${searchCategory == 'ring' }"> selected </c:if>>Ring</option>
						</select></td>
						<th>성별</th>
						<td><select name="searchGender" class="form-control form-control-sm">
								<option value="genderAll">:: 선택 ::</option>
								<option value="W" <c:if test="${searchGender == 'woman' }"> selected </c:if>>W</option>
								<option value="M" <c:if test="${searchGender == 'man' }"> selected </c:if>>M</option>
						</select></td>
					</tr>
					<tr>
						<th>색상</th>
						<td><select name="searchColor" class="form-control form-control-sm">
								<option value="colorAll">:: 선택 ::</option>
								<c:forEach var="color" items="${colorList }">
									<option value="${color }" <c:if test="${searchColor == color }"> selected </c:if>>${color }</option>
								</c:forEach>
						</select></td>
						<th>재질</th>
						<td><select name="searchMaterial" class="form-control form-control-sm">
								<option value="materialAll">:: 선택 ::</option>
								<c:forEach var="material" items="${materialList }">
									<option value="${material }" <c:if test="${searchMaterial == material }"> selected </c:if>>${material }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>검색조건</th>
						<td>
						<select class="form-control form-control-sm" style="width: 100px; display: inline-block;">
								<option>상품명</option>
						</select> 
						<input type="text" name="searchText" value="${searchText }" style="width: 200px;"> <input type="submit" value="검색"></td>
						<th>재고여부</th>
						<td><input type="text" name="searchStock" value="${searchStock }" style="width: 50px;">개 이하</td>
					</tr>
				</table>
			</div>
		</form>

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
					<th>삭제</th>
				</tr>
				<c:forEach var="list" items="${list }">
					<tr>
						<td width="150px">${list.iName }</td>
						<td><img alt="" src="${list.iThumbnail }" width="100"
							height="100"></td>
						<td>\<fmt:formatNumber value="${list.price }" pattern="#,###,###"/>원
						<!-- <td>${list.price }\</td>-->
						<td>${list.iSale }%</td>
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
			<br>
		</div>
		<c:if test="${page > 10 }">
			<c:choose>
				<c:when test="${type != 'search' }">
					<a href="${pageContext.request.contextPath }/stockController?page=${startPageNum-1}">[이전]</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/stockSearchController?page=${startPageNum-1}">[이전]</a>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${page == i }">
					<span>${i }</span>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${type != 'search' }">
							<a href="${pageContext.request.contextPath }/stockController?page=${i}"> ${i } </a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath }/stockSearchController?page=${i}"> ${i } </a>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${endPageNum < maxPageNum }">
			<c:choose>
				<c:when test="${type != 'search' }">
					<a href="${pageContext.request.contextPath }/stockController?page=${endPageNum + 1}">[다음]</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/stockSearchController?page=${endPageNum + 1}">[다음]</a>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>