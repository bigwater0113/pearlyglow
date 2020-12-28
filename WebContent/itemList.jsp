<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
#w_textArea p {
	line-height: 0.em;
}

#w_wrap {
	width: 1200px;
	height: 1700px;
	margin: 0 auto;
	text-align: center;
}

#w_itemsArea img {
	width: 200px;
	height: 200px;
	border: 1px solid gray;
	/*display: block;*/
	margin-top: 20%;
}

#w_itemsArea {
	margin-bottom: 150px;
	text-align: center;
}

#w_itemsArea span {
	border: 1px solid black;
}

#w_textArea {
	margin-bottom: 50px;
}

#iName {
	display: -webkit-box;
	display: -ms-flexbox;
	display: box;
	max-height: 80px;
	overflow: hidden;
	vertical-align: top;
	text-overflow: ellipsis;
	word-break: break-all;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2
}
#w_itemAreaDiv {
	display: flex;
	justify-content: center;
}
</style>
<div id="w_wrap">
	<div id="w_textArea">
		<c:choose>
			<c:when test="${type == 'woman' }">
				<h3>Woman</h3>
			</c:when>
			<c:when test="${type == 'man' }">
				<h3>Man</h3>
			</c:when>
			<c:when test="${type == 'earring' }">
				<h3>Earring</h3>
			</c:when>
			<c:when test="${type == 'bracelet' }">
				<h3>Bracelet</h3>
			</c:when>
			<c:when test="${type == 'necklace' }">
				<h3>Necklace</h3>
			</c:when>
			<c:when test="${type == 'ring' }">
				<h3>Ring</h3>
			</c:when>
		</c:choose>
		<p>Over the course of the last five years,</p>
		<p>we have been telling the stories of Dante's</p>
		<p>journey through the afterworld:</p>
		<p>from the Leone Medallion,</p>
		<p>an emblem of courage and strength,</p>
		<p>to the Other Side of the World Necklace,</p>
		<p>a tale of adventure and pursuit.</p>
	</div>
	<div id="w_itemAreaDiv">
		<table id="w_itemsArea">
			<c:set var="i" value="0" />
			<c:forEach var="list" items="${list }">
				<c:set var="i" value="${i+1 }" />
					<td width="250" height="330" valign="top">
					<img alt="" src="${list.iThumbnail }" onclick="location.href='${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }'"> <br>
					<a href="${pageContext.request.contextPath }/detailInfoController?iNum=${list.iNum }" id="iName">${list.iName }</a> <br>
					<p> <fmt:formatNumber value="${list.price }" pattern="#,###,###"/>원</p>
					<c:if test="${i%4==0 }">
						<span>new</span>
					</c:if>
					<c:if test="${i%3==0 }">
						<span>sold out</span>
					</c:if>
					</td>
				<c:if test="${i%4 == 0 }">
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<c:if test="${page > 10 }">
		<a href="${pageContext.request.contextPath }/itemListController?page=${startPageNum-1}&type=${type}">이전</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${page == i }">
				<span>${i }</span>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath }/itemListController?page=${i}&type=${type}">${i }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum < maxPageNum }">
		<a href="${pageContext.request.contextPath }/itemListController?page=${endPageNum+1}&type=${type}">다음</a>
	</c:if>
</div>