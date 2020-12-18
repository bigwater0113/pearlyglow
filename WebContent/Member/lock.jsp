<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/lock.jsp</title>
</head>
<body>
<h1>장기간 미접속 회원 명단</h1>
<form action="${pageContext.request.contextPath }/Member/lockY" method="post">
	<table border="1" width="1000">
		<tr>
			<th><input type="checkbox" id="allMember"></th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년원일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>핸드폰</th>
			<th>주소</th>
			<th>휴먼계정</th>
			<th>최근접속</th>
			<th>삭제</th>
			<th>수정</th>
			<th>휴면계정변경</th>
		</tr>
		<c:forEach var="vo" items="${requestScope.list }">
			<tr>
				<td><input type="checkbox" name="mem" value="${vo.id }"></td>
				<td>${vo.id }</td>
				<td>${vo.pwd }</td>
				<td>${vo.name }</td>
				<td>${vo.birth }</td>
				<td>${vo.gender }</td>
				<td>${vo.email }</td>
				<td>${vo.phone }</td>
				<td>${vo.address }</td>
				<td>${vo.issleep }</td>
				<td>${vo.recentAcc }</td>
				<!-- 번호에 해당하는 회원을 삭제하고 목록페이지로 이동하기 -->
				<td><a href="${pageContext.request.contextPath}/Member/listDelete?id=${vo.id}">삭제</a></td>
				<td><a href="${pageContext.request.contextPath}/Member/update?id=${vo.id}">수정</a></td>
				<td>
					<c:choose>
						<c:when test="${vo.issleep eq 'Y' }">
							<a href="${pageContext.request.contextPath}/Member/lockN?id=${vo.id }">휴면계정 해제</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/Member/lockY?id=${vo.id }">휴면계정 등록</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="확인">
</form>
<a href="${pageContext.request.contextPath}/index.jsp?spage=Member/list">회원관리</a>

<script type="text/javascript">
	var check = 0;
	document.getElementById("allMember").addEventListener('click', function(e) {
		var mem = document.getElementsByName("mem");
		//console.log(check); //0일때 체크박스 클릭, 1이면 체크박스 풀기
		for (let i=0; i<mem.length; i++) {
			if (check == 0) {
				mem[i].checked = true;	
			} else {
				mem[i].checked = false;
			}
		}
		if (check == 0) {
			check = 1;
		} else {
			check = 0;
		}
	}, true)
</script>
</body>
</html>