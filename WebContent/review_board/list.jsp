<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var msg=${msg};
	if(msg!=""){
		alert(msg);
	}
</script>
<div id="reviewlist_wrap">
	<div id="reviewlist_main">
		<h1>리뷰</h1>
		<h3>평점:</h3>
	</div>
	<div id="reviewlist_array">
		<ul style="list-style: none;">
			<li style="display: inline-block;"><a href="" style="text-decoration: none;">평점 ▲</a></li>
			<li style="display: inline-block;"><a href="" style="text-decoration: none;">평점 ▼</a></li>
		</ul>
	</div>
	<div id="reviewlist_table">
		<table border="1" width="900">
			<tr>
			<c:if test="${id == 'admin' }">
				<th><input type="checkbox"></th>
			</c:if>
				<th>아이디</th>
				<th>상품명</th>
				<th>이미지</th>
				<th>리뷰내용</th>
				<th>구매날짜</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<c:if test="${id == 'admin' }">
						<td><input type="checkbox"></td>
					</c:if>
						<td>${vo.buyerid }</td>
						<td>${vo.iname}</td>
						<td>${vo.savename}</td>
						<td>${vo.rbcontent}</td>
						<td>${vo.pdate}</td>
					</tr>
			</c:forEach>
		</table>
			<c:if test="${id == 'admin' }">
				<a href="${pageContext.request.contextPath}/rdelete">삭제</a>
			</c:if>
	</div>
	<div id="reviewlist_paging">
		페이징처리~~~~~~~~~~~~~~~
	</div>
</div>