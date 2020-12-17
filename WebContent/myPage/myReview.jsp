<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- myReview.jsp -->
<style>
	#myReview_wrap{
		width:900px;
		height:700px;
	}
	#myReview_main{
		text-align:center;
		margin-bottom:20px;
	}
	#myReview_main h1{
		text-shadow:3px 3px 4px black;
		color:white;
	}
	table{margin:auto;}
</style>
<div id="myReview_wrap">
	<div id="myReview_main">
		<h1>리뷰페이지</h1>
	</div>
	<div>
		<a href="javascript:beforeRe()">작성 가능한 리뷰</a>|
		<a href="javascript:afterRe()">내가 작성한 리뷰</a>
	</div>
	<div id="myReview_table">
		<table border="1" id="myReview_BATable">
			<tr>
				<th>아이디</th>
				<th>썸네일</th>
				<th>품명</th>
				<th>구매갯수</th>
				<th>구매날짜</th>
				<th>금액</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.id }</td>
					<td>${vo.iThumbnail }</td>
					<td>${vo.iName }</td>
					<td>${vo.pCnt }</td>
					<td>${vo.pDate }</td>
					<td>${vo.pPay }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="myReview_pageDiv">
		<c:choose>
			<c:when test="${startPageNum>10 }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath}/MyReview?status=&pageNum=${startPageNum-1 }">이전</a>]
			</c:when>
			<c:otherwise>
				[이전]
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i==pageNum}"><%-- 현재페이지인경우 (색상 다르게 표시) --%>
					<a href="${pageContext.request.contextPath}/MyReview?status=&pageNum=${i }"><span style="color:gray">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/MyReview?status=&pageNum=${i }"><span style="color:blue">[${i }]</span></a>
				</c:otherwise>
			</c:choose> 
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum<pageCount }"><%--이전 페이지가 있는 경우 --%>
				[<a href="${pageContext.request.contextPath}/MyReview?status=&pageNum=${endPageNum+1 }">다음</a>]
			</c:when>
			<c:otherwise>
				[다음]
			</c:otherwise>
		</c:choose>
	</div>
	
</div>
<script>
	var xhr=null;
	var Bthead=['아이디','썸네일','품명','구매갯수','구매날짜','금액'];
	var Athead=['아이디','썸네일','품명','평가','내용','구매날짜','첨부이미지명','리뷰작성날짜'];
	function beforeRe(){
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
					var id=document.createElement("td");
					var iThumbnail=document.createElement("td");
					var iName=document.createElement("td");
					var pCnt=document.createElement("td");
					var pDate=document.createElement("td");
					var pPay=document.createElement("td");
					id.innerHTML=review[i].getElementsByTagName("id")[0].textContent;
					iThumbnail.innerHTML=review[i].getElementsByTagName("iThumbnail")[0].textContent;
					iName.innerHTML=review[i].getElementsByTagName("iName")[0].textContent;
					pCnt.innerHTML=review[i].getElementsByTagName("pCnt")[0].textContent;
					pDate.innerHTML=review[i].getElementsByTagName("pDate")[0].textContent;
					pPay.innerHTML=review[i].getElementsByTagName("pPay")[0].textContent;
					tr.appendChild(id);
					tr.appendChild(iThumbnail);
					tr.appendChild(iName);
					tr.appendChild(pCnt);
					tr.appendChild(pDate);
					tr.appendChild(pPay);
					myReview_BATable.appendChild(tr);
				}
				var pageDiv=xml.getElementsByTagName("pageDiv")[0];
				var pageNum=parseInt(pageDiv.getElementsByTagName("pageNum")[0].textContent);
				var pageCount=parseInt(pageDiv.getElementsByTagName("pageCount")[0].textContent);
				var startPageNum=parseInt(pageDiv.getElementsByTagName("startPageNum")[0].textContent);
				var endPageNum=parseInt(pageDiv.getElementsByTagName("endPageNum")[0].textContent);
				var pageDivStr="";
				if(startPageNum>10){
					pageDivStr += "[<a href=\"${pageContext.request.contextPath}/MyReview?status1=&pageNum=${startPageNum-1 }\">이전</a>] ";
				}else{
					pageDivStr += "[이전]";
				}
				for(let j=startPageNum;j<=endPageNum;j++){
					if(j==pageNum){
						pageDivStr += "<a href=\"${pageContext.request.contextPath}/MyReview?status1=&pageNum=j\"><span style=\"color:gray\">[${"+j+"}]</span></a> ";
					}else{
						pageDivStr += "<a href=\"${pageContext.request.contextPath}/MyReview?status1=&pageNum="+j+"\"><span style=\"color:blue\">["+j+"]</span></a> ";
					}
				}
				if(endPageNum<pageCount){
					pageDivStr += "[<a href=\"${pageContext.request.contextPath}/MyReview?status1=&pageNum=${endPageNum+1 }\">다음</a>] ";
				}else{
					pageDivStr += "[다음]";
				}
				myReview_pageDiv.innerHTML=pageDivStr;
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/MyReview?status=1',true);
		xhr.send();
	}
	function afterRe(){
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
					var id=document.createElement("td");
					var iThumbnail=document.createElement("td");
					var iName=document.createElement("td");
					var score=document.createElement("td");
					var rbContent=document.createElement("td");
					var pDate=document.createElement("td");
					var saveName=document.createElement("td");
					var rDate=document.createElement("td");
					id.innerHTML=respJson.arr[i].id;
					iThumbnail.innerHTML=respJson.arr[i].iThumbnail;
					iName.innerHTML=respJson.arr[i].iName;
					score.innerHTML=respJson.arr[i].score;
					rbContent.innerHTML=respJson.arr[i].rbContent;
					pDate.innerHTML=respJson.arr[i].pDate;
					saveName.innerHTML=respJson.arr[i].saveName;
					rDate.innerHTML=respJson.arr[i].rDate;
					tr.appendChild(id);
					tr.appendChild(iThumbnail);
					tr.appendChild(iName);
					tr.appendChild(score);
					tr.appendChild(rbContent);
					tr.appendChild(pDate);
					tr.appendChild(saveName);
					tr.appendChild(rDate);
					myReview_BATable.appendChild(tr);
				}
				var pageNum=parseInt(respJson.pageNum);
				var pageCount=parseInt(respJson.pageCount);
				var startPageNum=parseInt(respJson.startPageNum);
				var endPageNum=parseInt(respJson.endPageNum);
				var pageDivStr="";
				if(startPageNum>10){
					pageDivStr += "[<a href=\"${pageContext.request.contextPath}/MyReview?status=2&pageNum=${startPageNum-1 }\">이전</a>] ";
				}else{
					pageDivStr += "[이전]";
				}
				for(let j=startPageNum;j<=endPageNum;j++){
					if(j==pageNum){
						pageDivStr += "<a href=\"${pageContext.request.contextPath}/MyReview?status=2&pageNum="+j+"\"><span style=\"color:gray\">["+j+"]</span></a> ";
					}else{
						pageDivStr += "<a href=\"${pageContext.request.contextPath}/MyReview?status=2&pageNum="+j+"\"><span style=\"color:blue\">["+j+"]</span></a> ";
					}
				}
				if(endPageNum<pageCount){
					pageDivStr += "[<a href=\"${pageContext.request.contextPath}/MyReview?status2=&pageNum=${endPageNum+1 }\">다음</a>] ";
				}else{
					pageDivStr += "[다음]";
				}
				myReview_pageDiv.innerHTML=pageDivStr;
			}
		};
		xhr.open('get','${pageContext.request.contextPath}/MyReview?status=2',true);
		xhr.send();
	}
</script>