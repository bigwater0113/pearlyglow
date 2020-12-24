<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>

<h1 style="text-align: center;">문의글 수정</h1>
<form method="post" action="${pageContext.request.contextPath }/Board/update" enctype="multipart/form-data" style="text-align: center;">
	<label style="width: 150px">작성자</label><input type="text" name="u_id" value="${requestScope.board.id }" readonly="readonly" class="form-control" style="display: inline-block; width: 300px;"><br>
	<label style="width: 150px">문의 제품</label><select id="u_num" name="u_num" class="form-control" style="display: inline-block; width: 300px;">
		<option <c:if test="${empty requestScope.board.qCategory}">selected </c:if>>일반문의</option>
		<c:forEach var="vo" items="${list }">
			<option value="${vo.iNum }" <c:if test="${requestScope.board.iNum eq vo.iNum }">selected </c:if>>상품번호:${vo.iNum } / 상품명:${vo.iName }</option>
		</c:forEach>
	</select><br>
	<label style="width: 150px;">문의종류</label><select id="u_qCategory" name="u_qCategory" class="form-control" style="display: inline-block; width: 300px;">
          <option value="배송문의" <c:if test="${requestScope.board.qCategory eq '배송문의' }">selected </c:if>>배송문의</option>
          <option value="상품문의" <c:if test="${requestScope.board.qCategory eq '상품문의' }">selected </c:if>>상품문의</option>
          <option value="반품문의" <c:if test="${requestScope.board.qCategory eq '반품문의' }">selected </c:if>>반품문의</option>
          <option value="교환문의" <c:if test="${requestScope.board.qCategory eq '교환문의' }">selected </c:if>>교환문의</option>
          <option value="환불문의" <c:if test="${requestScope.board.qCategory eq '환불문의' }">selected </c:if>>환불문의</option>
          <option value="일반문의" <c:if test="${requestScope.board.qCategory eq '일반문의' }">selected </c:if>>일반문의</option>
    </select><br>
    <label style="width: 150px">문의제목</label><input type="text" name="u_qTitle" value="${requestScope.board.qTitle}" class="form-control" style="display: inline-block; width: 300px;"><br>
	<label style="width: 150px">문의 내용</label><textarea name="u_content" rows="5" cols="50" class="form-control" style="display: inline-block; width: 300px;">${requestScope.board.ibContent}</textarea><br>
	<label style="width: 150px">첨부파일</label><input type="file" name="u_file" class="btn btn-secondary" style="width: 300px;"><br>
	<label style="width: 150px">문의글 비밀번호</label><input type="password" name="u_pwd" value="${requestScope.board.ibPwd}" class="form-control" style="display: inline-block; width: 300px;">
	<input type="hidden" name="u_ibnum" value="${requestScope.board.ibNum}">
	<input type="hidden" name="u_ref" value="${requestScope.board.ref}">
	<input type="hidden" name="u_lev" value="${requestScope.board.lev}">
	<input type="hidden" name="u_step" value="${requestScope.board.step}"><br>
	<input type="submit" value="수정" class="btn btn-black" style="width: 300px; margin-left: 70px;">
</form>
</body>
</html>