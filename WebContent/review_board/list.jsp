<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var msg=${msg};
	if(msg!=""){
		alert(msg);
	}
</script>
<c:choose>
<c:when test=" ${avg ne '0' } ">

	<div id="reviewlist_wrap">
		<div id="reviewlist_main">
			<h2>${vo.iName }리뷰</h2>
			<h3>평점:${avg }</h3>
		</div>
		<div id="reviewlist_editlist">
		<form method="post">
					<c:if test="${id == 'admin' }">
						<input type="submit" value="삭제" name="reviewlist_delete" onclick="javascript:form.action='${pageContext.request.contextPath }/detailInfoController?iNum=${inum }&pageNum=${pageNum }'">
					</c:if>
				<input type="submit" value="평점 ▲" name="reviewlist_desc" onclick="javascript:form.action='${pageContext.request.contextPath }/detailInfoController?iNum=${inum }&pageNum=${pageNum }'">
				<input type="submit" value="평점 ▼" name="reviewlist_asc" onclick="javascript:form.action='${pageContext.request.contextPath }/detailInfoController?iNum=${inum }&pageNum=${pageNum }'">
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
					<th>리뷰날짜</th>
				</tr>
				<c:forEach var="vvo" items="${list }">
					<c:if test="${vo.iName == vvo.iname }">
					<tr>
						<c:if test="${id == 'admin' }">
							<td><input type="checkbox" name="checkk" value=${vvo.pdnum }></td>
						</c:if>
							<td>${vvo.id }</td>
							<td>${vvo.iname}</td>
							<td><img src="${pageContext.request.contextPath}/upload/${vvo.savename }" style="width: 200px;"></td>
							<td>${vvo.rbcontent}</td>
							<td>${vvo.score}</td>
							<td>${vvo.rdate}</td>
						</tr>
						</c:if>
				</c:forEach>
			</table>
		</div>
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

	</c:when>
	<c:otherwise>
		<h2>${vo.iName }리뷰</h2>
		<p>아직 등록된 리뷰가 없습니다!</p>
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