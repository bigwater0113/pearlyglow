<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/list.jsp</title>
</head>
<body>
<h1 style="text-align: center;">회원목록</h1>
<a href="${pageContext.request.contextPath}/index.jsp?spage=main.jsp" style="font-size: 20px; margin-left: 700px;">홈</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp; 
<a href="${pageContext.request.contextPath}/Member/lock" style="font-size: 20px;">200일 이상 접속 없는 명단</a>
<form method="post" name="form">
	<table border="1" class="table table-hover" style="text-align: center; font-size: 14px;">
		<tr>
			<th><input type="checkbox" id="allMember"></th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th width="80px;">이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>핸드폰</th>
			<th>주소</th>
			<th>휴면</th>
			<th>최근접속</th>
			<th>수정</th>
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
				<td><a href="${pageContext.request.contextPath}/Member/update?id=${vo.id}">수정</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="선택삭제" onclick="javascript: form.action='${pageContext.request.contextPath }/Member/listDelete'" class="btn btn-secondary">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="선택휴면계정 등록" onclick="javascript: form.action='${pageContext.request.contextPath }/Member/lockY'" class="btn btn-secondary">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="선택휴면계정 해제" onclick="javascript: form.action='${pageContext.request.contextPath }/Member/lockN'" class="btn btn-secondary">
</form>
<!-- 페이징처리 -->
<div style="text-align: center;">
	<c:if test="${startPageNum>10 }">
		<a href="${pageContext.request.contextPath}/Member/list?pageNum=${startPageNum-1}&field=${field}&keyword=${keyword}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<a href="${pageContext.request.contextPath}/Member/list?pageNum=${i}&field=${field}&keyword=${keyword}">[${i }]</a> 
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${pageContext.request.contextPath}/Member/list?pageNum=${endPageNum+1}&field=${field}&keyword=${keyword}">[다음]</a>
	</c:if>
</div>

<div style="text-align: right;">
	<form method="post" action="${pageContext.request.contextPath}/Member/list">
		<select name="field">
			<option value="id" <c:if test="${field=='id' }">selected</c:if>>아이디</option>
			<option value="name" <c:if test="${field=='name' }">selected</c:if>>이름</option>
			<option value="gender" <c:if test="${field=='gender' }">selected</c:if>>성별(M/W)</option>
			<option value="issleep" <c:if test="${field=='issleep' }">selected</c:if>>휴면계정(Y/N)</option>
		</select>
		<input type="text" name="keyword" value="${keyword }">
		<input type="submit" value="검색">
	</form>
</div>

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





