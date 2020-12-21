<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sales.jsp -->
<div id="sales_wrap">
	<div id="sales_title">
		<h1>매출관리</h1>
	</div>
	<div id="sales_form">
		<form action="">
			<span>분류</span>
			<select id="group" name="group" onchange="javascript:searchSales()">
				<option value="category" <c:if test="${group=='category' }">selected</c:if>>category</option>
				<option value="gender" <c:if test="${group=='gender' }">selected</c:if>>gender</option>
			</select>
			<select id="year" name="year" onchange="javascript:searchSales()">
				<c:forEach var="i" begin="2010" end="2020">
					<option value="${i} " <c:if test="${year==i }">selected</c:if>>${i}</option>
				</c:forEach>
			</select>
			<span>년</span>
			<select id="month" name="month" onchange="javascript:searchSales()">
				<option value="" <c:if test="${month=='' }">selected</c:if>>-</option>
				<c:forEach var="i" begin="1" end="12">
					<option value="${i}" <c:if test="${month==i }">selected</c:if>>${i}</option>
				</c:forEach>
			</select>
			<span>월</span>
		</form>
	</div>
	<div id="myOrder_table">
	<c:choose>
		<c:when test="${group=='category' }">
			<table border="1" width="900">
				<tr>
					<th rowspan="2">날짜</th>
					<th colspan="4">카테고리</th>
					<th rowspan="2">매출</th>
				</tr>
				<tr>
					<th>earring</th>
					<th>bracelet</th>
					<th>necklace</th>
					<th>ring</th>
				</tr>
				<c:set var="totalSale" value="0"/>
				<c:forEach var="data" items="${salesData }">
					<tr>
						<td>${data.sDate }</td>
						<td>${data.earring }\</td>
						<td>${data.bracelet }\</td>
						<td>${data.necklace }\</td>
						<td>${data.ring }\</td>
						<td>${data.total }\</td>
						<c:set var="totalSale" value="${totalSale+data.total }"/>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"></td>
					<td>총액 : ${totalSale } \</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table border="1" width="900">
				<tr>
					<th rowspan="2">날짜</th>
					<th colspan="2">Gender</th>
					<th rowspan="2">총매출</th>
				</tr>
				<tr>
					<th>Man</th>
					<th>Woman</th>
				</tr>
				<c:set var="totalSale" value="0"/>
				<c:forEach var="data" items="${salesData }">
					<tr>
						<td>${data.sDate }</td>
						<td>${data.man }\</td>
						<td>${data.woman }\</td>
						<td>${data.total }\</td>
						<c:set var="totalSale" value="${totalSale+data.total }"/>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"></td>
					<td>총액 : ${totalSale } \</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
		
		
	</div>
</div>
<script>
	function searchSales(){
		var group=document.getElementById("group").value;
		var year=document.getElementById("year").value;
		var month=document.getElementById("month").value;
		location.href="${pageContext.request.contextPath}/sales?group="+group+"&year="+year+"&month="+month;
		
	}
</script>