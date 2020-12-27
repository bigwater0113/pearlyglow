<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var msg=${msg};
	if(msg!=""){
		alert(msg);
	}
	
// 	var avg=${avg};
// 	console.log(avg);
</script>
<style>
	#reviewlist_editlist{float:right;}
</style>
<c:choose>
<c:when test="${avg == 0}">
	<h2>${vo.iName } 리뷰</h2>
	<p>아직 등록된 리뷰가 없습니다!</p>
</c:when>
<c:otherwise>
	<div id="reviewlist_wrap">
		<div id="reviewlist_main">
			<h2>${vo.iName }리뷰</h2>
			<h3>평점:${avg }</h3>
		</div>
<form method="post">
		<div id="reviewlist_editlist">
			<input type="hidden" name="iNum" value="${inum }" >
			<input type="hidden" name="pageNum" value="${pageNum }" >
			<c:if test="${id == 'admin' }">
				<input type="submit" class="btn btn-secondary btn-sm" value="삭제" name="reviewlist_delete" formaction="${pageContext.request.contextPath }/detailInfoController">
			</c:if>
			<input type="submit" class="btn btn-secondary btn-sm" value="평점 ▲" name="reviewlist_desc" formaction="${pageContext.request.contextPath }/detailInfoController">
			<input type="submit" class="btn btn-secondary btn-sm" value="평점 ▼" name="reviewlist_asc" formaction="${pageContext.request.contextPath }/detailInfoController">
		</div>
		<div id="reviewlist_table">
			<table class="table table-hover" >
				<tr>
				<c:if test="${id == 'admin' }">
					<th><input type="checkbox" id="allcheck"></th>
				</c:if>
					<th>아이디</th>
					<th>상품명</th>
					<th>이미지</th>
					<th>리뷰내용</th>
					<th>평점</th>
					<th>리뷰날짜</th>
				</tr>
				<c:forEach var="vvo" items="${list }">
					<c:if test="${vo.iName == vvo.iname }">
					<tr>
						<c:if test="${id == 'admin' }">
							<td><input type="checkbox" name="checkk" value=${vvo.rbnum }></td>
						</c:if>
							<td>${vvo.id }</td>
							<td>${vvo.iname}</td>
							<td><img src="${pageContext.request.contextPath}/review_board/upload/${vvo.savename }" 
											style="width: auto; height: 100px; background-size: cover;"></td>
							<td>${vvo.rbcontent}</td>
							<td>${vvo.score}</td>
							<td>${vvo.rdate}</td>
						</tr>
						</c:if>
				</c:forEach>
			</table>
		</div>
</form>
		<div id="reviewlist_paging">
			<c:if test="${startPageNum>10 }">
				<a href="${pageContext.request.contextPath }/detailInfoController?pageNum=${startPageNum-1 }&iNum=${inum }">이전</a>
			</c:if>	
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<a href="${pageContext.request.contextPath }/detailInfoController?pageNum=${i }&iNum=${inum }">[${i }]</a>
			</c:forEach>
			<c:if test="${endPageNum<pageCount }">
					<a href="${pageContext.request.contextPath }/detailInfoController?pageNum=${endPageNum+1 }&iNum=${inum }">다음</a>
			</c:if>	
		</div>
	</div>
	</c:otherwise>
</c:choose>
<script>
		var check=0;
	document.getElementById("allcheck").addEventListener("click", function(e) {
		if(check==0){
			check=1;
		}else{
			check=0;
		}
		var checkk=document.getElementsByName("checkk");
		for(var i=0;i<=checkk.length;i++){
			if(check==1){
				checkk[i].checked=true;
			}else{
				checkk[i].checked=false;
			}
		}
	}, true);
</script>