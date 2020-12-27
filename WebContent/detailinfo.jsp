<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
/* 	* {font-size: 14px;} */
 	#main{width:1200px; display: flex; justify-content: center; font-family: 'Noto Serif KR', serif;} 
 	#main #left {width:200px;background-color: white;float:left;}
	#main #middle {width:800px;float:left;}
	#main #right {width:200px;background-color: white;float:right;}
	#main #middle #top{width:100%; margin-bottom: 800px;}
	#main #middle #core{width:100%; height: auto;background-color: white; text-align: center;}
	#main #middle #core #revlist{width:100%; height: auto;}
	#main #middle #bottom{width:100%; margin-bottom: 300px; text-align: center; margin-top:150px; background-color: white;}
	#main #middle #top #image1{width: 350px; height:100%; float: left; background-color: white;}
	#main #middle #top #detail{width: 50%; background-color: white;float: right;}
	#main #middle #top #image1 #img1{ width: 350px;  } 
 	#main #middle #top #detail #title{width: 100%; background-color: white;} 
 	#main #middle #top #detail #nbso{width: 100%; background-color: white;} 
 	#main #middle #top #detail #nbso li{list-style: none;display: inline-block;font-size: 10px;border:1px solid black;}
 	#main #middle #top #detail #description{width: 100%;height: 90%; background-color: white; margin-top: 20px;} 
 	#main #middle #top #detail #description #text{width: 100%;height: 100%; background-color: white;}
 	#main #middle #top #detail #description #text #detailText {height: 70%;}
 	#main #middle #top #detail #description #text #optionText {height: 30%;}
 	#main #middle #top #detail #description #text p{font-size: 16px; } 
 	#main #middle #top #detail #description #text span{font-size: 13px; color: gray;} 
 	#main #middle #top #detail #description #option{width: 100%;height: 30%; background-color: white;} 
 	#main #middle #top #detail #description #option #buy{border-radius: 8px; background-color: #333333;color:white;border:none ;width: 150px;height: 40px;} 
 	#main #middle #top #detail #description #option #wish{border-radius: 8px; background-color: white;border:1px solid gray;width: 150px;height: 40px;} 
 	#main #middle #top #detail #description #option #plus{border-radius:4px; background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
 	#main #middle #top #detail #description #option #count{border-radius:4px; background-color: white;border: 1px solid lightgray;width: 80px;height: 40px;} 
 	#main #middle #top #detail #description #option #minus{border-radius:4px; background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
	#main #middle #core #image2{width: 100%;height: auto; background-color: white;}
 	#main #middle #core #image2 #img2{ width: 800px; height: 800px; object-fit: cover;}
	#main #middle #core #image2 #img3{ width: 800px; height: 800px; object-fit: cover;}
	#main #middle #core #image2 #img4{ width: 800px; height: 800px; object-fit: cover;}
	/* object-fit: cover ;	가로세로 비율은 유지하면서 컨테이너에 꽉 차도록 설정 */
	#discription {margin-top: 150px;}
	
</style>
</head>
<%
	String spage=request.getParameter("spage");
	String mpage=request.getParameter("mpage");
	if(spage==null){
		spage="detailinfo.jsp";
	}
	if(mpage==null){
		mpage="review_board/list.jsp";
	}
%>
<body>
	<div id="main">
		<div id="middle">
			<div id="top">
				<div id="image1">
					<img alt="제품이미지" src=${vo.iThumbnail } id="img1">
				</div>
				<div id="detail">
					<div id="title">
						<h2>${vo.iName }</h2>
					</div>
					<div id="nbso"> <!-- new best soldout -->
						<ul>
							<li>NEW</li>
							<li>BEST</li>
							<li>Sold out</li>
						</ul>
					</div>
					<div id="description">
						<div id="text">
							<div id="detailText">
								<h6><fmt:formatNumber value="${vo.price }" pattern="#,###,###"/>원 </h6>
								<br><br>
								<p>${vo.kDetail }</p> 
<!-- 								<p>아리아리랑 스리스리랑 -->
<!-- 								아라리가 났네~~아리랑 고개로 -->
<!-- 								아라리가 났네 아리랑 고개로 가신 님은 -->
<!-- 								아리아리랑 스리스리랑 -->
<!-- 								아라리가 났네~~아리랑 고개로 -->
<!-- 								아라리가 났네 아리랑 고개로 가신 님은</p> -->
								<br>
								<p>${vo.eDetail }</p>
<!-- 								<p>hello my name is daeun! -->
<!-- 								I like kyochon. -->
<!-- 								i like gyul. When will CoronaVirus be gone.. -->
<!-- 								hello my name is daeun! -->
<!-- 								I like kyochon. -->
<!-- 								i like gyul.When will CoronaVirus be gone.. -->
<!-- 								I like kyochon. -->
<!-- 								i like gyul.When will CoronaVirus be gone..I like kyochon. -->
<!-- 								i like gyul.When will CoronaVirus be gone..I like kyochon. -->
<!-- 								i like gyul.When will CoronaVirus be gone..</p> -->
							</div><br>
							<div id="optionText">
								<span>Gender: ${vo.iGender } </span> <br>
								<span>Category: ${vo.iCategory } </span> <br>
								<span>Color: ${vo.color } </span> <br>
								<span>Size: ${vo.iSize } / Weight: ${vo.weight } / Material: ${vo.material } </span> <br>
							</div><br>
						</div>
						<div id="option">
							<input type="button" value="-"onclick="changeM(event);"id="minus"><input type="text" name="count" value="1" id="count"><input type="button" value="+" onclick="changeP(event);" id="plus">
							<br><br>
							<input type="button" value="구매하기" id="buy" onclick="getForOrderFormController()">
							<input type="button" value="장바구니" id="wish" onclick="putBasketResult()"><br>
							<span id="resultSpan"></span>
						</div>
					</div>
				</div>
			</div>
			<div id="core">
				<div id="revlist">
					<jsp:include page="<%=mpage %>"/>
					<br>
					<h2>상세정보</h2>
				</div>
				<div id="image2">
					<c:if test="${image.file1 != null }">
					<img src="${image.file1 }" id="img2">
					</c:if>
					<c:if test="${image.file2 != null }">
					<img src="${image.file2 }" id="img3">
					</c:if>
					<c:if test="${image.file3 != null }">
					<img src="${image.file3 }" id="img4">
					</c:if>
				</div>
				<div id="discription">
					<p>${vo.bodyText }</p>
				</div>
			</div>
			<div id="bottom">
				<p>${vo.caution }</p>
			</div>
		</div>
	</div>
<script type="text/javascript">
	var i=parseInt(document.getElementById("count").value);
	function changeP(e){
		++i;
		count.value=i;
	}
	function changeM(e){
		if(i >1){
			i--;
			count.value=i;
		}
	}
	
	
	// 장바구니 json
	function putBasketResult() {
		var sbCnt = document.getElementById("count").value;
		console.log(sbCnt);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var json = JSON.parse(xhr.responseText);
				var resultSpan = document.getElementById("resultSpan");
				if (json.result == 'true') {
					resultSpan.innerHTML = "장바구니에 담기 성공!";
				} else {
					resultSpan.innerHTML = "내부 오류로 인해 장바구니에 담기 실패..";
				}
			}
		}
		xhr.open('get', '${pageContext.request.contextPath}/basketController?iNum=${vo.iNum}&sbCnt=' + sbCnt, true);
		xhr.send();
	}
	
	function getForOrderFormController() {
		var sbCnt = document.getElementById("count").value;
		location.href = "${pageContext.request.contextPath}/orderFormController?iNum=${vo.iNum}&sbCnt=" + sbCnt + "&price=${vo.price}";
	}
</script>
</body>
</html>