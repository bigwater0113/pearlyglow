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
<h1 style="text-align: center;">문의글 등록</h1>
<form method="post" action="${pageContext.request.contextPath }/Board/insert" enctype="multipart/form-data" style="text-align: center;">
	<label style="width: 150px">작성자</label><input type="text" name="i_id" value="${id }" readonly="readonly" class="form-control" style="display: inline-block; width: 300px;"><br>
	<label style="width: 150px">문의 제품</label><select id="i_num" name="i_num" class="form-control" style="display: inline-block; width: 300px;">
		<option value="0">일반문의</option>
		<c:forEach var="vo" items="${list }">
			<option value="${vo.iNum }">상품번호:${vo.iNum } / 상품명:${vo.iName }</option>
		</c:forEach>
	</select><br>
	<label style="width: 150px">문의 종류</label><select id="i_qCategory" name="i_qCategory" class="form-control" style="display: inline-block; width: 300px;">
          <option value="일반문의">일반문의</option>
          <option value="배송문의">배송문의</option>
          <option value="상품문의">상품문의</option>
          <option value="반품문의">반품문의</option>
          <option value="교환문의">교환문의</option>
          <option value="환불문의">환불문의</option>
    </select><br>
    <label style="width: 150px">문의제목</label><input type="text" name="i_qTitle" class="form-control" style="display: inline-block; width: 300px;"><br>
	<label style="width: 150px">문의 내용</label><textarea name="i_content" rows="5" cols="50" class="form-control" style="display: inline-block; width: 300px;"></textarea><br>
	<label style="width: 150px">첨부파일</label><input type="file" name="i_file" class="btn btn-secondary" style="display: inline-block; width: 300px;"><br>
	<label style="width: 150px">문의글 비밀번호</label><input type="password" name="i_pwd" class="form-control" style="display: inline-block; width: 300px;"><br>
	<input type="submit" value="등록" class="btn btn-black" style="width: 300px;">
</form>
</body>
</html>