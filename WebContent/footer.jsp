<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- footer.jsp -->
<%-- top 값만 바꿔주기  --%>
<style>
	.footer_visit{text-align: right;font-weight:bold;font-size: 17px;}
</style>
<div style="width: 1200px; height: 200px; text-align: center;left top pos">
	<p class="footer_visit">전체 방문자${totalCnt }</p>
	<p class="footer_visit">오늘 방문자${todayCnt }</p>
	<c:forEach var="str" items="${recentViewItem }">
		<p class="footer_visit">${str }</p>
	</c:forEach>
	<div></div>
		<h1>중앙 HTA</h1>
		<h1>SEMI PROJECT</h1>
		<br> <br> <br>
		<div
			style="width: 290px; height: 390px; text-align: center; float: left;">
			<h1>윤태수</h1>
			<br> <br>
			<h2>010</h2>
			<h2>2672</h2>
			<h2>3749</h2>
		</div>
		<div
			style="width: 290px; height: 390px; text-align: center; float: left;">
			<h1>정다은</h1>
			<br> <br>
			<h2>010</h2>
			<h2>3403</h2>
			<h2>9411</h2>
		</div>
		<div
			style="width: 290px; height: 390px; text-align: center; float: left;">
			<h1>이희권</h1>
			<br> <br>
			<h2>010</h2>
			<h2>9984</h2>
			<h2>0867</h2>
		</div>
		<div
			style="width: 290px; height: 390px; text-align: center; float: left;">
			<h1>심재우</h1>
			<br> <br>
			<h2>010</h2>
			<h2>4446</h2>
			<h2>6037</h2>
		</div>
	</div>
</div>
