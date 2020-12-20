<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var msg=${msg};
	if(msg!=""){
		alert(msg);
	}
</script>
<div id="reviewlist_wrap">
	<div id="reviewlist_main">
		<h1>리뷰</h1>
		<h3>평점:${avg }</h3>
	</div>
	<div id="reviewlist_editlist">
		<form action="${pageContext.request.contextPath }/rdelete" method="post">
				<c:if test="${id == 'admin' }">
					<input type="submit" value="삭제" name="reviewlist_delete">
				</c:if>
			<input type="submit" value="평점 ▲" name="reviewlist_desc">
			<input type="submit" value="평점 ▼" name="reviewlist_asc">
		</form>
	</div>
	<div id="reviewlist_table">
		<table border="1" width="900">
			<tr>
			<c:if test="${id == 'admin' }">
				<th><input type="checkbox" id="allcheck"></th>
			</c:if>
				<th>아이디</th>
				<th>상품명</th>
				<th>이미지</th>
				<th>리뷰내용</th>
				<th>평점</th>
				<th>구매날짜</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<c:if test="${id == 'admin' }">
						<td><input type="checkbox" name="checkk" value=${vo.pdnum }></td>
					</c:if>
						<td>${vo.buyerid }</td>
						<td>${vo.iname}</td>
						<td><img src="${pageContext.request.contextPath}/upload/${vo.savename }" style="width: 200px;"></td>
						<td>${vo.rbcontent}</td>
						<td>${vo.score}</td>
						<td>${vo.pdate}</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<div id="reviewlist_paging">
		<c:if test="${startPageNum>10 }">
			<a href="${pageContext.request.contextPath }/rlist?pageNum=${startPageNum-1 }&id=${id}">이전</a>
		</c:if>	
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<a href="${pageContext.request.contextPath }/rlist?pageNum=${i }&id=${id}">[${i }]</a>
		</c:forEach>
		<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/rlist?pageNum=${endPageNum+1 }&id=${id}">다음</a>
		</c:if>	
	</div>
</div>
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