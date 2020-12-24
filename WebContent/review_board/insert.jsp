<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/review_board/insert.jsp</title>
<style>
 	#insert_main{width:1200px; height: 800px;}
 	#insert_main #insert_left {width:200px; height:100%; background-color: white;float:left;}
	#insert_main #insert_middle {width:800px; height:100%; background-color: white;float:left;}
	#insert_main #insert_right {width:200px; height:100%; background-color: white;float:right;} 
	.insert_label {width: 100px;display:inline-block; }
	.insert_label1 {width: 70px;display:inline-block; position:relative; top: -1030px;}
	#insert_main #insert_id{ width: 200px; height: 20px;}
	#insert_main #insert_pdnum{ width: 200px; height: 20px;}
	#insert_main #insert_score{ width: 200px; height: 20px;}
	#insert_main #insert_save{position:relative; float: right; right: 80px;}
</style>
</head>
<body>
<div id="insert_main">
	<div id="insert_left">
	</div>
	<div id="insert_middle">
		<h1>리뷰작성</h1>
		<form method="post" enctype="multipart/form-data">
		
			<!-- 세션에 저장된 아이디 받아오기 -->
			<label for="insert_id" class="insert_label">아이디</label><input type="text" class="form-control" id="insert_id" name="insert_id" value="${id}" readonly="readonly">
<%-- 					<label for="insert_id" class="insert_label">ID:</label>${id} --%>
			<!-- 구매상세내역테이블 >> 구매상세번호 받아오기 -->
			<div id="insert_num">
				<label for="insert_pdnum" class="insert_label">구매상세번호</label><input type="text" class="form-control" id="insert_pdnum" name="insert_pdnum" value="${param.pdNum }" readonly="readonly">
<%-- 					<label for="insert_pdnum" class="insert_label">Num:</label>${param.pdNum } --%>
			</div>
			<label for="insert_score" class="insert_label">평가점수</label><input type="text" class="form-control" placeholder="1~5" id="insert_score" name="insert_score" value="${vo.score }"><br>
			<label class="insert_label">첨부파일</label>
			<input type="file" name="insert_addfile">
			<c:if test="${!empty vo.saveName }">
			기존이미지<img src="${pageContext.request.contextPath }/review_board/upload/${vo.saveName}" style="width:100px;height:100px;">
			</c:if>
			<br><label for="insert_content" class="insert_label1">내용</label><textarea class="form-control" id="insert_content" name="insert_content" rows="10" cols="80">${vo.rbContent }</textarea><br>
			
			<!-- 마이페이지 구매내역 페이지로 x -> 태수 마이리뷰 > 작성하지 않은 리뷰 파트로 -->
			<input type="button" class="btn btn-secondary btn-sm" value="취소" onclick="backPage()" id="insert_save" name="insert_back">
			
			<!-- /insert.do 컨트롤러로 -->
			<c:choose>
				<c:when test="${isUpdate=='true' }">
					<input type="submit" class="btn btn-secondary btn-sm" value="수정" id="insert_save" name="insert_save" 
						formaction="${pageContext.request.contextPath }/review_board/update" style="margin-right: 3px;"> 
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn btn-secondary btn-sm" value="저장" id="insert_save" name="insert_save" 
						formaction="${pageContext.request.contextPath }/insert.do" style="margin-right: 3px;">
				</c:otherwise>
			</c:choose>
			
		</form>		
	</div>
	<div id="insert_right">
	</div>
</div>
<script type="text/javascript">
	function backPage(){
		history.go(-1);
	}
// 	function erchk(){
// 		if(document.getElementById("insert_content").value="" || document.getElementById("insert_score").value=""){
// 			alert("내용을 모두 입력해주세요.")
// 			return false;
// 		}else{
// 			document.frm.submit();
// 		}
// 	}
</script>
</body>
</html>