<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myReview.jsp -->
<style>
	#myReview_wrap{
		width:960px;
	}
	#myReview_main{
		text-align:center;
		margin-bottom:20px;
	}
	#myReview_main h1{
		font-weight:bold;
		color:#555555;
	}
	#myReview_tap a{
		color:black;
		font-size:20px;
		text-decoration: none;
	}
	#myReview_tap a:hover{
		font-weight:bold;
	}
	#myReview_tap{margin-left:20px; margin-bottom:15px;}
	table{margin-left:20px;text-align:center;}
	#myReview_BATable th{background-color: #AAAAAA;height:30px;}
	#myReview_pageDiv{text-align:center;}
</style>
<div id="myReview_wrap">
	<div id="myReview_main">
		<h1>REVIEW</h1>
	</div>
	<div id="myReview_tap">
		<a href="javascript:beforeRe(1)">작성 가능한 리뷰</a> |
		<a href="javascript:afterRe(1)">내가 작성한 리뷰</a>
	</div>
	<div id="myReview_table">
		<table id="myReview_BATable"  class="table table-hover" width="960">
			<tr>
<!-- 				<th>아이디</th> -->
				<th>이미지</th>
				<th>품명</th>
				<th>구매갯수</th>
				<th>구매날짜</th>
<!-- 				<th>금액</th> -->
				<th>리뷰작성</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
<%-- 					<td>${vo.id }</td> --%>
					<td><img src="${vo.iThumbnail }" style="width:100px;height:100px"></td>
					<td>${vo.iName }</td>
					<td>${vo.pCnt }</td>
					<td>${vo.pDate }</td>
<%-- 					<td>${vo.pPay }</td> --%>
					<td><a href='${pageContext.request.contextPath}/index.jsp?spage=review_board/insert.jsp&pdNum=${vo.pdNum}'>리뷰작성</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div id="myReview_pageDiv">
		<c:choose>
			<c:when test="${startPageNum>10 }"><%--이전 페이지가 있는 경우 --%>
				[<a href="javascript:beforeRe(${startPageNum-1 })">이전</a>]
			</c:when>
			<c:otherwise>
				[이전]
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i==pageNum}"><%-- 현재페이지인경우 (색상 다르게 표시) --%>
					<a href="javascript:beforeRe(${i })"><span style="color:gray">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="javascript:beforeRe(${i })"><span style="color:blue">[${i }]</span></a>
				</c:otherwise>
			</c:choose> 
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum<pageCount }"><%--이전 페이지가 있는 경우 --%>
				[<a href="javascript:beforeRe(${endPageNum+1 })">다음</a>]
			</c:when>
			<c:otherwise>
				[다음]
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<br>
	<br>
	
</div>
<script>
	var xhr=null;
	var Bthead=['이미지','품명','구매갯수','구매날짜','리뷰작성'];
	var Athead=['이미지','품명','평가','내용','구매날짜','리뷰첨부','리뷰작성날짜','수정','삭제'];
	function beforeRe(n){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var xml=xhr.responseXML;
				var review=xml.getElementsByTagName("review");
				var myReview_BATable=document.getElementById("myReview_BATable");
				var myReview_pageDiv=document.getElementById("myReview_pageDiv");
				//myReview_BATable 리스트 테이블 자식객체 삭제
				var childs=myReview_BATable.childNodes;//모든 자식객체 얻어오기
				for(let i=childs.length-1;i>=0;i--){//자식객체를 뒤에서 부터 삭제하기
					var child=childs.item(i);
					myReview_BATable.removeChild(child);
				}
				//myReview_pageDiv 페이징처리div 자식객체 삭제
				var childs=myReview_pageDiv.childNodes;//모든 자식객체 얻어오기
				for(let i=childs.length-1;i>=0;i--){//자식객체를 뒤에서 부터 삭제하기
					var child=childs.item(i);
					myReview_pageDiv.removeChild(child);
				}
				var tr=document.createElement("tr");
				for(let i=0;i<Bthead.length;i++){
					var th=document.createElement("th");
					th.innerHTML=Bthead[i];
					tr.appendChild(th);
				}
				myReview_BATable.appendChild(tr);
				for(let i=0;i<review.length;i++){
					var tr=document.createElement("tr");
					tr.style.borderBottom="1px solid black";
// 					var id=document.createElement("td");
					var iThumbnail=document.createElement("td");
					var iThumbnail_img=document.createElement("img");
					var iName=document.createElement("td");
					var pCnt=document.createElement("td");
					var pDate=document.createElement("td");
// 					var pPay=document.createElement("td");
					var insertReview=document.createElement("td");
					var iNum=review[i].getElementsByTagName("iNum")[0].textContent;
					var pdNum=review[i].getElementsByTagName("pdNum")[0].textContent;
// 					id.innerHTML=review[i].getElementsByTagName("id")[0].textContent;
					iThumbnail_img.src=review[i].getElementsByTagName("iThumbnail")[0].textContent;
					iThumbnail_img.style.width="100px";
					iThumbnail_img.style.height="100px";
					iThumbnail_img.addEventListener('click', function(e) {
						location.href='${pageContext.request.contextPath }/detailInfoController?iNum='+iNum;
					}, false);
					iThumbnail.appendChild(iThumbnail_img);
					iName.innerHTML=review[i].getElementsByTagName("iName")[0].textContent;
					pCnt.innerHTML=review[i].getElementsByTagName("pCnt")[0].textContent;
					pDate.innerHTML=review[i].getElementsByTagName("pDate")[0].textContent;
// 					pPay.innerHTML=review[i].getElementsByTagName("pPay")[0].textContent;
					insertReview.innerHTML="<a href='${pageContext.request.contextPath}/index.jsp?spage=review_board/insert.jsp&pdNum="+pdNum+"'>리뷰작성</a> ";
// 					tr.appendChild(id);
					tr.appendChild(iThumbnail);
					tr.appendChild(iName);
					tr.appendChild(pCnt);
					tr.appendChild(pDate);
// 					tr.appendChild(pPay);
					tr.appendChild(insertReview);
					myReview_BATable.appendChild(tr);
				}
				var pageDiv=xml.getElementsByTagName("pageDiv")[0];
				var pageNum=parseInt(pageDiv.getElementsByTagName("pageNum")[0].textContent);
				var pageCount=parseInt(pageDiv.getElementsByTagName("pageCount")[0].textContent);
				var startPageNum=parseInt(pageDiv.getElementsByTagName("startPageNum")[0].textContent);
				var endPageNum=parseInt(pageDiv.getElementsByTagName("endPageNum")[0].textContent);
				var pageDivStr="";
				if(startPageNum>10){
					pageDivStr += "[<a href=\"javascript:beforeRe("+ (startPageNum-1) +")\">이전</a>] ";
				}else{
					pageDivStr += "[이전] ";
				}
				for(let j=startPageNum;j<=endPageNum;j++){
					if(j==pageNum){
						pageDivStr += "<a href=\"javascript:beforeRe("+ (j) +")\"><span style=\"color:gray\">["+j+"]</span></a> ";
					}else{
						pageDivStr += "<a href=\"javascript:beforeRe("+ (j) +")\"><span style=\"color:blue\">["+j+"]</span></a> ";
					}
				}
				if(endPageNum<pageCount){
					pageDivStr += "[<a href=\"javascript:beforeRe("+ (endPageNum+1) +") \">다음</a>] ";
				}else{
					pageDivStr += "[다음]";
				}
				myReview_pageDiv.innerHTML=pageDivStr;
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/MyReview?status=1&pageNum='+n,true);
		xhr.send();
	}
	function afterRe(n){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var text=xhr.responseText;
				var respJson=JSON.parse(text);
				var myReview_BATable=document.getElementById("myReview_BATable");
				var myReview_pageDiv=document.getElementById("myReview_pageDiv");
				//myReview_BATable 리스트 테이블 자식객체 삭제
				var childs=myReview_BATable.childNodes;//모든 자식객체 얻어오기
				for(let i=childs.length-1;i>=0;i--){//자식객체를 뒤에서 부터 삭제하기
					var child=childs.item(i);
					myReview_BATable.removeChild(child);
				}
				//myReview_pageDiv 페이징처리div 자식객체 삭제
				var childs=myReview_pageDiv.childNodes;//모든 자식객체 얻어오기
				for(let i=childs.length-1;i>=0;i--){//자식객체를 뒤에서 부터 삭제하기
					var child=childs.item(i);
					myReview_pageDiv.removeChild(child);
				}
				var tr=document.createElement("tr");
				for(let i=0;i<Athead.length;i++){
					var th=document.createElement("th");
					th.innerHTML=Athead[i];
					tr.appendChild(th);
				}
				myReview_BATable.appendChild(tr);
				for(let i=0;i<respJson.arr.length;i++){
					var tr=document.createElement("tr");
					tr.style.borderBottom="1px solid black";
// 					var id=document.createElement("td");
					var iThumbnail=document.createElement("td");
					var iThumbnail_img=document.createElement("img");
					var iName=document.createElement("td");
					var score=document.createElement("td");
					var rbContent=document.createElement("td");
					var pDate=document.createElement("td");
					var saveName=document.createElement("td");
					var saveName_img=document.createElement("img");
					var rDate=document.createElement("td");
					var updateReview=document.createElement("td");
					var deleteReview=document.createElement("td");
					var iNum=respJson.arr[i].iNum;
					var pdNum=respJson.arr[i].pdNum;
// 					id.innerHTML=respJson.arr[i].id;
// 					iThumbnail.innerHTML=respJson.arr[i].iThumbnail;
					iThumbnail_img.src=respJson.arr[i].iThumbnail;
					iThumbnail_img.style.width="100px";
					iThumbnail_img.style.height="100px";
					iThumbnail_img.addEventListener('click', function(e) {
						location.href='${pageContext.request.contextPath }/detailInfoController?iNum='+iNum;
					}, false);
					iThumbnail.appendChild(iThumbnail_img);
					iName.innerHTML=respJson.arr[i].iName;
					score.innerHTML=respJson.arr[i].score;
					rbContent.innerHTML=respJson.arr[i].rbContent;
					pDate.innerHTML=respJson.arr[i].pDate;
// 					saveName.innerHTML=respJson.arr[i].saveName;
					saveName_img.src="${pageContext.request.contextPath}/review_board/upload/"+respJson.arr[i].saveName;
					saveName_img.style.width="100px";
					saveName_img.style.height="100px";
					saveName.appendChild(saveName_img);
					rDate.innerHTML=respJson.arr[i].rDate;
					updateReview.innerHTML="<a href='${pageContext.request.contextPath}/review_board/update?pdNum="+pdNum+"'>수정</a> ";
					deleteReview.innerHTML="<a href='${pageContext.request.contextPath}/review_board/delete?pdNum="+pdNum+"'>삭제</a> ";
// 					tr.appendChild(id);
					tr.appendChild(iThumbnail);
					tr.appendChild(iName);
					tr.appendChild(score);
					tr.appendChild(rbContent);
					tr.appendChild(pDate);
					tr.appendChild(saveName);
					tr.appendChild(rDate);
					tr.appendChild(updateReview);
					tr.appendChild(deleteReview);
					myReview_BATable.appendChild(tr);
				}
				var pageNum=parseInt(respJson.pageNum);
				var pageCount=parseInt(respJson.pageCount);
				var startPageNum=parseInt(respJson.startPageNum);
				var endPageNum=parseInt(respJson.endPageNum);
				var pageDivStr="";
				if(startPageNum>10){
					pageDivStr += "[<a href=\"javascript:afterRe("+ (startPageNum-1) +")\">이전</a>] ";
				}else{
					pageDivStr += "[이전] ";
				}
				for(let j=startPageNum;j<=endPageNum;j++){
					if(j==pageNum){
						pageDivStr += "<a href=\"javascript:afterRe("+ (j) +")\"><span style=\"color:gray\">["+j+"]</span></a> ";
					}else{
						pageDivStr += "<a href=\"javascript:afterRe("+ (j) +")\"><span style=\"color:blue\">["+j+"]</span></a> ";
					}
				}
				if(endPageNum<pageCount){
					pageDivStr += "[<a href=\"javascript:afterRe("+ (endPageNum+1) +")\">다음</a>] ";
				}else{
					pageDivStr += "[다음]";
				}
				myReview_pageDiv.innerHTML=pageDivStr;
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/MyReview?status=2&pageNum='+n,true);
		xhr.send();
	}
</script>