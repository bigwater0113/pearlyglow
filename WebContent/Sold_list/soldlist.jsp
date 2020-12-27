<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#soldlist_wrap {width:1000px;}
.table{width:960px;margin:auto;}
.table td, .table th{
	padding: 0px;
}
#soldlist_main{
	font-weight:bold;
	text-align:center;
    color:#555555;
}
#soldlist_paging{
	text-align: center;
	}
#soldlist_search{
	text-align: right;
}
</style>
<div id="soldlist_wrap">
	<div id="soldlist_main">
		<h1>판매 내역</h1>
	</div>
	<br>
	<div id="soldlist_table">
		<table class="table table-hover">
			<tr>
				<th>구매번호</th>
				<th>상세번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>수량</th>
				<th>금액</th>
				<th>총 금액</th>
				<th>구매자ID</th>
				<th>구매날짜</th>
			</tr>
				<c:set var="pNumEq" value="0"/>
			<c:forEach var="vo" items="${list }">
				<c:if test="${vo.pnum!=pNumEq }">
					<tr>
						<td colspan="9" style="border-top:1px solid black"></td>
					</tr>
				</c:if>
				<tr>
					<c:choose>
						<c:when test="${vo.pnum!=pNumEq }">
							<td>${vo.pnum }</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<td>${vo.pdnum}</td>
					<td><img src="${vo.ithumbnail }" style="width: 100px; height: 100px;"></td>
					<td>${vo.iname}</td>
					<td>${vo.pcnt}</td>
					<c:choose>
						<c:when test="${vo.pnum!=pNumEq }">
							<td>${vo.ppay}</td>
							<td>${vo.ptotal}</td>
							<td>${vo.id}</td>
							<td>${vo.pdate}</td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<c:set var="pNumEq" value="${vo.pnum }"/>
			</c:forEach>
		</table>
	</div>
	<div id="soldlist_paging">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath }/soldlist?pageNum=${startPageNum-1 }">이전</a>
		</c:if>	
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<a href="${pageContext.request.contextPath }/soldlist?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/soldlist?pageNum=${endPageNum+1 }">다음</a>
		</c:if>	
	</div>
	<div id="soldlist_search">
		<form method="post" action="${pageContext.request.contextPath }/soldlist">
			아이디 <input type="text" class="form-control" id="soldlist_idsearch" name="soldlist_idsearch" value="${searchid }" style="width: 200px; display: inline-block;">
		<input type="submit" class="btn btn-secondary btn-sm" value="검색">
		</form>
	</div>
</div>