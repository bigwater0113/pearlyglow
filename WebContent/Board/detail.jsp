<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>
<h1 style="text-align: center;">상세글보기</h1>
<table border="1" class="table table-hover" style="text-align: center;">
	<tr>
		<th>문의글 번호</th>
		<th>${vo.ibNum }</th>
	</tr>
	<tr>
		<th>작성자</th>
		<th>${vo.id }</th>
	</tr>
	<tr>
		<th>문의 제품</th>
		<th> ${vo.iNum }</th>
	</tr>
	<tr>
		<th>문의종류</th>
		<th>${vo.qCategory }</th>
	</tr>
	<tr>
		<th>문의제목</th>
		<th>${vo.qTitle }</th>
	</tr>
	<c:if test="${!empty vo.saveName }">
		<tr>
			<th>문의 사진</th>
			<th><img src="${pageContext.request.contextPath}/Board/upload/${vo.saveName}" style="width: 700px; height: 700px;"></th>
		</tr>
	</c:if>
	<tr>
		<th>문의글 내용</th>
		<th><textarea rows="5" cols="70" readonly="readonly">${vo.ibContent }</textarea></th>
	</tr>
	<tr>
		<th>비밀글 비밀번호</th>
		<th> ${vo.ibPwd }</th>
	</tr>
	<tr>
		<th>작성날짜</th>
		<th> ${vo.ibDate }</th>
	</tr>
	<tr>
		<th>문의글 답변</th>
		<th><textarea rows="5" cols="70" readonly="readonly">${vo.ans }</textarea></th>
	</tr>
	<tr>
		<th>답글 작성날짜</th>
		<th> ${vo.ansDate }</th>
	</tr>
	<tr>
		<c:if test="${empty id }">
			<td colspan="2"><a href="${pageContext.request.contextPath }/index.jsp?spage=Board/ansInsert.jsp?ibnum=${vo.ibNum }&inum=${vo.iNum }&qCategory=${vo.qCategory }&ibPwd=${vo.ibPwd }&ibContent=${vo.ibContent }&orgName=${vo.orgName }&saveName=${vo.saveName }&ibDate=${vo.ibDate }&ref=${vo.ref }&lev=${vo.lev }&step=${vo.step }">답글</a></td>
		</c:if>
		<c:if test="${!empty id }">
			<c:choose>
				<c:when test="${id=='admin' }">
					<td  colspan="2"><a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/ansInsert.jsp?ibnum=${vo.ibNum }&inum=${vo.iNum }&qCategory=${vo.qCategory }&ibPwd=${vo.ibPwd }&ibContent=${vo.ibContent }&orgName=${vo.orgName }&saveName=${vo.saveName }&ibDate=${vo.ibDate }&ref=${vo.ref }&lev=${vo.lev }&step=${vo.step }">답글</a></td>
				</c:when>
				<c:otherwise>
					<td  colspan="2"><a href="${pageContext.request.contextPath }/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/ansInsert.jsp?ibnum=${vo.ibNum }&inum=${vo.iNum }&qCategory=${vo.qCategory }&ibPwd=${vo.ibPwd }&ibContent=${vo.ibContent }&orgName=${vo.orgName }&saveName=${vo.saveName }&ibDate=${vo.ibDate }&ref=${vo.ref }&lev=${vo.lev }&step=${vo.step }">답글</a></td>
				</c:otherwise>
			</c:choose>
		</c:if>
		<td><a href="${pageContext.request.contextPath}/index.jsp?spage=main.jsp">홈</a></td>
	</tr>
</table>
</body>
</html>