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

<h1>문의글 수정</h1>
<form method="post" action="${pageContext.request.contextPath }/Board/update" enctype="multipart/form-data">
	작성자 <input type="text" name="u_id" value="${requestScope.board.id }" readonly="readonly"><br>
	문의 제품 <input type="text" name="u_num" value="${requestScope.board.iNum}"><br>
	<select id="u_qCategory" name="u_qCategory">
          <option>문의종류</option>
          <option value="배송문의">배송문의</option>
          <option value="상품문의">상품문의</option>
          <option value="반품문의">반품문의</option>
          <option value="교환문의">교환문의</option>
          <option value="환불문의">환불문의</option>
          <option value="일반문의">일반문의</option>
    </select>
       문의제목 <input type="text" name="u_qTitle"><br>
	문의 내용<textarea name="u_content" rows="5" cols="50">${requestScope.board.ibContent}</textarea><br>
	첨부파일<input type="file" name="u_file"><br>
	문의글 비밀번호 <input type="password" name="u_pwd" value="${requestScope.board.ibPwd}">
	<input type="hidden" name="u_ibnum" value="${requestScope.board.ibNum}"><br>
	<input type="submit" value="수정">
</form>
</body>
</html>