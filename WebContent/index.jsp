<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<title>index.jsp</title>
<style>
/*
 	*{margin:0px;padding:0px;} 
 	div#wrap{margin:auto;width:1200px;height:2600px;overflow:hidden;} 
 	#header{width:100%;height:100px;background-color: lightpink;} 
 	#main{width:100%;height:2100px;background-color: lightblue;} 
 	#footer{width:100%;height:400px;background-color: lightpink;} 
 	*/
 	*{margin:0px;padding:0px;}
 	div#index_wrap{margin:auto;width:1400px;overflow:hidden;} 
 	#index_header{width:1200px;height:100px; margin-bottom: 50px;} 
 	#index_main{width:1200px;float:left;}
 	#index_aside{margin-left:10px;width:130px;height:600px;position:relative;top:00px;
 		float:left;}
 	#index_aside div {padding:5px;border:1px solid black;}
 	#index_footer{width:1200px;height:400px;} 
 	.index_visit{text-align: right;font-weight:bold;font-size: 17px;}
</style>
</head>
<body>
<%
	String spage=request.getParameter("spage");
	String mpage=request.getParameter("mpage");
	String ppage=request.getParameter("ppage");
	if(spage==null){
		spage="main.jsp";
	}
	if(mpage==null){
		mpage="testinfo.jsp";
	}
	if(ppage==null){
		ppage="quickView.jsp";
	}
%>
<div id="index_wrap">
	<div id="index_header">
		<%@include file="header.jsp" %>
	</div>
	
	<div id="index_main">
<%-- 	${pageContext.request.contextPath }/index.jsp?spage=myPage.jsp&mpage=info.jsp --%>
		<jsp:include page="<%=spage %>"/>
	</div>
	<div id="index_aside">
		<div border="1">
			<p class="index_visit">전체 방문자${totalCnt }</p>
			<p class="index_visit">오늘 방문자${todayCnt }</p>
		</div>
		<c:if test="${id!='admin' }">
			<div>
				<c:choose>
					<c:when test="${recentViewItem.size()==0 }">
						최근본 상품이 없습니다.
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${recentViewItem }">
							<div id="brief${vo.iNum }" 
								style="width:100px; height:100px;position:relative;overflow:hidden;text-align: right;" 
								onmouseover="javascript:briefIn(${vo.iNum})"
								onmouseout="javascript:briefOut(${vo.iNum})"
								onclick="location.href='${pageContext.request.contextPath}/detailInfoController?iNum=${vo.iNum }'">
								<img src="${vo.iThumbnail }" style="width:100px; height:100px;"><br><br>
								<div id="textSpan${vo.iNum }_title" 
									Style="position:relative;left:0px;top:0px;text-align: left;border:0px;">
								</div>
								<div id="textSpan${vo.iNum }_price" 
									Style="position:relative;left:0px;top:0px;text-align: left;border:0px;">
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
	</div>
	<div id="index_footer">
		<%@include file="footer.jsp" %>
	</div>
</div>
<script type="text/javascript">
	var xhr=null;
	
	function briefIn(iNum){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=getData;
		xhr.open('get','${pageContext.request.contextPath}/QuickView?iNum='+iNum,true);
		xhr.send();
	}
	
	function getData(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseXML;
			var iNum=xml.getElementsByTagName("iNum")[0].textContent;
			console.log(iNum);
			var spanTitle=document.getElementById("textSpan"+iNum+"_title");
			var spanPrice=document.getElementById("textSpan"+iNum+"_price");
			var briefDiv=document.getElementById("brief"+iNum);
			console.log(spanTitle);
			console.log(briefDiv);
			var iName=xml.getElementsByTagName("iName")[0].textContent;
			console.log(iName);
			var price=xml.getElementsByTagName("price")[0].textContent;
			briefDiv.style.left="-150px";
			briefDiv.style.width="250px";
			briefDiv.style.backgroundColor="white";
			spanTitle.innerHTML=iName;
			spanTitle.style.width="130px";
			spanTitle.style.height="45px";
			spanTitle.style.left="0px";
			spanTitle.style.top="-125px";
			spanPrice.innerHTML=price+" 원";
			spanPrice.style.width="130px";
			spanPrice.style.height="25px";
			spanPrice.style.left="0px";
			spanPrice.style.top="-120px";
		}
	}
	
	function briefOut(iNum){
		var spanTitle=document.getElementById("textSpan"+iNum+"_title");
		var spanPrice=document.getElementById("textSpan"+iNum+"_price");
		var briefDiv=document.getElementById("brief"+iNum);
		briefDiv.style.left="0px";
		briefDiv.style.width="100px";
// 		briefDiv.style.backgroundColor="pink";
		spanTitle.innerHTML=""
		spanTitle.style.width="0px";
		spanTitle.style.height="0px";
		spanTitle.style.left="0px";
		spanTitle.style.top="0px";
		spanPrice.innerHTML="";
		spanPrice.style.width="0px";
		spanPrice.style.height="0px";
		spanPrice.style.left="0px";
		spanPrice.style.top="0px";
		
	}
</script>
</body>
</html>