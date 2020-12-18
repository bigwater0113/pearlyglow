<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/list.jsp</title>
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<h1>문의 게시판</h1>
<a href="${pageContext.request.contextPath}/Board/list">전체 문의글 목록</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="${pageContext.request.contextPath}/index.jsp?spage=main.jsp">홈</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="${pageContext.request.contextPath}/index.jsp?spage=Board/ans">답변글 작성 완료 목록</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="${pageContext.request.contextPath}/index.jsp?spage=Board/unans">답변글 미작성 목록</a>

<table border="1" width="1000">
	<tr style="text-align: center">
		<th>문의글 번호</th>
		<th>작성자</th>
		<th>문의 제품 </th>
		<th>문의 종류 </th>
		<th>문의 제목 </th>
		<c:if test="${id== 'admin' }">
			<th>문의글 비밀번호 </th>
		</c:if>
		<th width="300">문의 내용 </th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
<c:forEach var="vo" items="${list }">
	<tr>
		<th>${vo.ibNum }</th>
		<th>${vo.id }</th>
		<th>${vo.iNum }</th>
		<th>${vo.qCategory }</th>
		<th>${vo.qTitle }</th>
		<c:if test="${id== 'admin' }">
			<th>${vo.ibPwd }</th>
		</c:if>

		<th style="text-align: left;">
			<c:choose>
				<c:when test="${!empty vo.ibPwd }">
					<c:choose>
						<c:when test="${vo.id==id || id=='admin' || vo.ibPwd==pwd }">
							<c:if test="${vo.lev>0 }"> <%-- 답글인 경우 들여쓰기 하기 --%>
								<c:forEach var="i" begin="1" end="${vo.lev }">
									&nbsp;&nbsp;
								</c:forEach>
								[답글]<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${vo.ibNum}">${vo.ans }</a>
							</c:if>
							<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${vo.ibNum}">${vo.ibContent }</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/index.jsp?spage=Board/secret.jsp">비밀글입니다.</a>	
						</c:otherwise>
					</c:choose>	
				</c:when>
				
				<c:otherwise>
					<c:if test="${vo.lev>0 }"> <%-- 답글인 경우 들여쓰기 하기 --%>
						<c:forEach var="i" begin="1" end="${vo.lev }">
							&nbsp;&nbsp;
						</c:forEach>
						[답글]<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${vo.ibNum}">${vo.ans }</a>
					</c:if>
					<a href="${pageContext.request.contextPath}/Board/detail?ibnum=${vo.ibNum}">${vo.ibContent }</a>
				</c:otherwise>
			</c:choose>	
		</th>
		<th>
			<c:if test="${vo.id==id || id=='admin'}">
				<c:choose>
					<c:when test="${empty vo.ans }">
						<a href="${pageContext.request.contextPath}/Board/update?ibnum=${vo.ibNum}">문의글 수정</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/Board/A_update?ibnum=${vo.ibNum}">답글 수정</a>
					</c:otherwise>
				</c:choose>
			</c:if>
		</th>
		<th>
			<c:if test="${vo.id==id || id=='admin'}">
				<a href="${pageContext.request.contextPath}/Board/delete?ibnum=${vo.ibNum}">삭제</a>
			</c:if>
		</th>
	</tr>
</c:forEach>
</table>
<!-- 페이징처리 -->
<div>
	<c:if test="${startPageNum>10 }">
		<a href="${pageContext.request.contextPath}/Board/list?pageNum=${startPageNum-1}&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<a href="${pageContext.request.contextPath}/Board/list?pageNum=${i}&field=${field}&keyword=${keyword}">[${i }]</a> 
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${pageContext.request.contextPath}/Board/list?pageNum=${endPageNum+1}&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>

<div>
	<form method="post" action="${pageContext.request.contextPath}/Board/list">
		<select name="field">
			<option value="id" <c:if test="${field=='id' }">selected</c:if>>작성자</option>
			<option value="iNum" <c:if test="${field=='iNum' }">selected</c:if>>제품번호</option>
			<option value="qCategory" <c:if test="${field=='qCategory' }">selected</c:if>>문의종류</option>
			<option value="ibDate" <c:if test="${field=='ibDate' }">selected</c:if>>작성날짜</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>
</body>
</html>