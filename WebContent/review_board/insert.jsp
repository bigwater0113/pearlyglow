<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/review_board/insert.jsp</title>
<style>
 	#insert_main{width:1200px; height: 1700px;}
 	#insert_main #insert_left {width:200px; height:100%; background-color: pink;float:left;}
	#insert_main #insert_middle {width:800px; height:100%; background-color: lightgreen;float:left;}
	#insert_main #insert_right {width:200px; height:100%; background-color: yellow;float:right;} 
	.insert_label {width: 100px;display:inline-block; }
	.insert_label1 {width: 70px;display:inline-block; position:relative; top: -1030px;}
	#insert_main #insert_id{ width: 200px; height: 20px;}
	#insert_main #insert_pdnum{ width: 200px; height: 20px;}
	#insert_main #insert_score{ width: 200px; height: 20px;}
	#insert_main .insert_btn{position:relative; float: right; right: 80px;}
</style>
</head>
<body>
<div id="insert_main">
	<div id="insert_left">
	</div>
	<div id="insert_middle">
		<h1>리뷰작성</h1>
		<form action="${pageContext.request.contextPath }/insert.do" method="post" enctype="multipart/form-data">
		
			<!-- 세션에 저장된 아이디 받아오기 -->
			<label for="insert_id" class="insert_label">아이디</label><input type="text" id="insert_id" name="insert_id" value="${id}" readonly="readonly"><br>
			
			<!-- 구매상세내역테이블 >> 구매상세번호 받아오기 -->
			<div id="insert_num">
				<label for="insert_pdnum" class="insert_label">구매상세번호</label><input type="text" id="insert_pdnum" name="insert_pdnum" value="${purchaselist_pdnum }" readonly="readonly">
			</div>
			<label for="insert_score" class="insert_label">평가점수</label><input type="text" id="insert_score" name="insert_score"><br>
			<label class="insert_label">첨부파일</label>
			<input type="file" name="insert_addfile" size="80"><br>
			
			<label for="insert_content" class="insert_label1">내용</label><textarea id="insert_content" name="insert_content" rows="70" cols="90"></textarea><br>
			
			<!-- 마이페이지 구매내역 페이지로 -->
			<input type="button" value="취소" onclick="location.href ='${pageContext.request.contextPath}/purchase_list/purchaselist.jsp'" id="insert_back" name="insert_back" class="insert_btn">
			
			<!-- /insert.do 컨트롤러로 -->
			<input type="submit" value="저장" id="insert_save" name="insert_save" class="insert_btn">
		</form>		
	</div>
	<div id="insert_right">
	</div>
</div>
</body>
</html>