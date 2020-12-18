<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myDelivery.jsp -->
<div id="myDelivery_wrap">
	<div id="myDelivery_header">
		<h1>배송조회</h1>
	</div>
	<div id="myDelivery_section">
		<div id="myDelivery_img">
			
		</div>
		<div id="myDelivery_table">
			<table border="1" width="900">
				<tr>
					<th>아이디</th>
					<th>수취인</th>
					<th>배송지</th>
					<th>구매번호</th>
					<th>택배사</th>
					<th>송장번호</th>
					<th>배송상태</th>
				</tr>
				<tr>
					<td>${vo.id }</td>
					<td>${vo.receiver }</td>
					<td>${vo.pAddress }</td>
					<td>${vo.pNum }</td>
					<td>${vo.dCompany }</td>
					<td>${vo.trackingNum }</td>
					<td>${vo.dStatus }</td>
				</tr>
			</table>
		</div>
	</div>
</div>