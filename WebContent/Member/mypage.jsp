<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/mypage.jsp</title>
</head>
<body>
<h1>마이페이지</h1>
<form method="post" action="${pageContext.request.contextPath}/Member/list">
	아이디<input type="text" name="m_id" value="${vo.id}" disabled="disabled"><br>
	비밀번호 <input type="password" name="m_pwd" value="${vo.pwd}" disabled="disabled"><br>
	이름 <input type="text" name="m_name" value="${vo.name}" disabled="disabled"><br>
	생년월일 <input type="text" name="m_birth" value="${vo.birth}" disabled="disabled"><br>
	성별 <input type="text" name="m_gender" value="${vo.gender}" disabled="disabled"><br>
	이메일 <input type="email" name="m_email" value="${vo.email}" disabled="disabled"><br>
	전화번호 <input type="text" name="m_phone" value="${vo.phone}" disabled="disabled"><br>
	회원주소 <input type="text" name="m_addr" value="${vo.address}" disabled="disabled"><br>
	휴먼계정 <input type="text" name="m_issleep" value="${vo.issleep}" disabled="disabled"><br>
	최근접속 <input type="text" name="m_recent" value="${vo.recentAcc}" disabled="disabled"><br>
	<input type="button" value="수정" onclick="location.href='${pageContext.request.contextPath}/Member/update?id=${vo.id}'">
	<input type="button" value="회원탈퇴" onclick="location.href='${pageContext.request.contextPath}/Member/delete?id=${vo.id}'">
</form>

<h1>나의 문의글</h1>
<table border="1" width="1000">
	<tr style="text-align: center">
		<th>문의글 번호</th>
		<th>작성자</th>
		<th>문의 제품 </th>
		<th>문의 종류 </th>
		<th>문의 제목 </th>
		<th>문의글 비밀번호 </th>
		<th width="200">문의 내용 </th>
		<th>수정</th>
		<th>삭제</th>
		<th>답변</th>
	</tr>
	
<c:forEach var="qvo" items="${list }">
	<tr>
		<th>${qvo.ibNum }</th>
		<th>${qvo.id }</th>
		<th>${qvo.iNum }</th>
		<th>${qvo.qCategory }</th>
		<th>${qvo.qTitle }</th>
		<th>${qvo.ibPwd }</th>
		<th><a href="${pageContext.request.contextPath}/Board/detail?ibnum=${qvo.ibNum}">${qvo.ibContent }</a></th>
		<th><a href="${pageContext.request.contextPath}/Board/update?ibnum=${qvo.ibNum}">수정</a></th>
		<th><a href="${pageContext.request.contextPath}/Board/delete?ibnum=${qvo.ibNum}">삭제</a></th>
		<c:choose>
			<c:when test="${empty qvo.ans }">
				<th>답변대기중</th>
			</c:when>
			<c:otherwise>
				<th>${qvo.ans }</th>
			</c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/Member/main.jsp">홈</a>

</body>
</html>