<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/Board/insert.jsp</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<h1>문의글 등록</h1>
<form method="post" action="${pageContext.request.contextPath }/Board/insert" enctype="multipart/form-data">
	작성자 <input type="text" name="i_id" value="${id }" readonly="readonly"><br>
	문의 제품
	<select id="i_num" name="i_num">
		<c:forEach var="vo" items="${list }">
			<option value="${vo.iNum }">상품번호:${vo.iNum } / 상품명:${vo.iName }</option>
		</c:forEach>
	</select><br>
	<select id="i_qCategory" name="i_qCategory">
          <option value="일반문의">일반문의</option>
          <option value="배송문의">배송문의</option>
          <option value="상품문의">상품문의</option>
          <option value="반품문의">반품문의</option>
          <option value="교환문의">교환문의</option>
          <option value="환불문의">환불문의</option>
    </select>
       문의제목 <input type="text" name="i_qTitle"><br>
	문의 내용<textarea name="i_content" rows="5" cols="50"></textarea><br>
	첨부파일<input type="file" name="i_file"><br>
	문의글 비밀번호 <input type="password" name="i_pwd"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>