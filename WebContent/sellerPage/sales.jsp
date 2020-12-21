<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sales.jsp -->
<div id="sales_wrap">
	<div id="sales_title">
		<h1>매출관리</h1>
	</div>
	<div id="myOrder_table">
		<table border="1" width="900">
			<tr>
				<th rowspan="2">날짜</th>
				<th colspan="4">카테고리</th>
				<th colspan="2">Gender</th>
				<th rowspan="2">총매출</th>
			</tr>
			<tr>
				
				<th>earring</th>
				<th>bracelet</th>
				<th>necklace</th>
				<th>ring</th>
				<th>Man</th>
				<th>Woman</th>
				
			</tr>
			<c:forEach var="data" items="${salesData }">
				<tr>
					<td>${data.sDate }</td>
					<td>${data.earring }\</td>
					<td>${data.bracelet }\</td>
					<td>${data.necklace }\</td>
					<td>${data.ring }\</td>
					<td>${data.man }\</td>
					<td>${data.woman }\</td>
					<td>${data.total }\</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>