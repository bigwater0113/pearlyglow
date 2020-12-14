<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 	#main{width:1200px;height:3000px;} 
	#main #left {width:200px;height:100%;background-color: white;float:left;}
	#main #middle {width:800px;height:100%;float:left;}
	#main #right {width:200px;height:100%;background-color: white;float:right;}
	#main #middle #top{width:100%;height:20%; margin-bottom: 70px;}
	#main #middle #core{width:100%;height:65%; background-color: white; text-align: center;}
	#main #middle #bottom{width:100%;height:15% ;background-color: white;}
	#main #middle #top #image1{width: 50%;height: 100%;float: left; text-align: center;background-color: white;}
	#main #middle #top #detail{width: 50%;height: 100%; background-color: white;float: right;}
	#main #middle #top #image1 #img1{ width: 460px; height: 460px; } 
 	#main #middle #top #detail #title{width: 100%;height: 5%; background-color: white;} 
 	#main #middle #top #detail #nbso{width: 100%;height: 5%; background-color: white;} 
 	#main #middle #top #detail #nbso li{list-style: none;display: inline-block;font-size: 10px;border:1px solid black;}
 	#main #middle #top #detail #description{width: 100%;height: 90%; background-color: white;} 
 	#main #middle #top #detail #description #text{width: 100%;height: 70%; background-color: white;} 
 	#main #middle #top #detail #description #text p{font-size: 11px;} 
 	#main #middle #top #detail #description #option{width: 100%;height: 30%; background-color: white;} 
 	#main #middle #top #detail #description #option #buy{background-color: #333333;color:white;border:none ;width: 150px;height: 40px;} 
 	#main #middle #top #detail #description #option #wish{background-color: white;border:1px solid gray;width: 150px;height: 40px;} 
 	#main #middle #top #detail #description #option #plus{background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
 	#main #middle #top #detail #description #option #count{background-color: white;border: 1px solid lightgray;width: 80px;height: 40px;} 
 	#main #middle #top #detail #description #option #minus{background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
	#main #middle #core #image2{width: 100%;height: 50%; background-color: white;}
	#main #middle #core #image2 #img2{ width: 800px; height: 800px; object-fit: cover;} 
	#main #middle #core #image2 #img3{ width: 395px; height: 400px; object-fit: cover;}
	#main #middle #core #image2 #img4{ width: 395px; height: 400px; object-fit: cover;}
	/* object-fit: cover ;	가로세로 비율은 유지하면서 컨테이너에 꽉 차도록 설정 */
	#main #middle #bottom{text-align: center;}
	
</style>
</head>
<body>
	<div id="main">
		<div id="left">
		</div>
		<div id="middle">
			<div id="top">
				<div id="image1">
					<img alt="반지상세" src="images/jewelry26-705x705.jpg" id="img1">
				</div>
				<div id="detail">
					<div id="title">
						<h4>Pentagon Bold Ring Large Gold & Silver</h4>
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
							<br>
							<p>펜타곤 형태의 구조적인 실루엣의 링 제품입니다.<br>
							볼드한 디테일의 골드와 실버링을 함께 레이어드한 제품입니다.<br>
							남성,여성 두 가지 사이즈입니다.</p>
							<br>
							<p>Pentagon shaped ring. Layered with gold and silver<br>
							colored bold rings.<br>
							Comes in Male and Female size.<br>
							Gold & Silver comes in one set.</p>
						</div>
						<div id="option">
							<select style="width: 300px; height: 40px;">
								<option value="msg" style="font-color:gray;background-color: graytext;">옵션을 선택해주세요.</option>
								<option value="white">white</option>
								<option value="gold">gold</option>
							</select><br>
							<input type="button" value="-"onclick="changeM(event);"id="minus"><input type="text" name="count" value="1" id="count"><input type="button" value="+" onclick="changeP(event);" id="plus">
							<br><br>
							<input type="button" value="구매하기" id="buy">
							<input type="button" value="장바구니" id="wish" onclick="putBasketResult()"><br>
							<span id="resultSpan"></span>
						</div>
					</div>
				</div>
			</div>
			<div id="core">
				<div id="image2">
					<img alt="반지상세" src="images/Tom-of-Fuxx-Bracelet.jpg" id="img2"><br>
					<img alt="팔찌1" src="images/jewelry26-1.jpg" id="img3">
					<img alt="팔찌2" src="images/jewelry26-2.jpg" id="img4">
					<p>스와로브스키 진주</p>
					<p>체인 및 링크 92.5% 실버</p>
				</div>
				<div id="discription">
				</div>
			</div>
			<div id="bottom">
				<p>펜타곤 형태의 구조적인 실루엣의 링 제품입니다.<br>
							볼드한 디테일의 골드와 실버링을 함께 레이어드한 제품입니다.<br>
							남성,여성 두 가지 사이즈입니다.</p>
				<p>펜타곤 형태의 구조적인 실루엣의 링 제품입니다.<br>
				볼드한 디테일의 골드와 실버링을 함께 레이어드한 제품입니다.<br>
				남성,여성 두 가지 사이즈입니다.</p>
				<p>펜타곤 형태의 구조적인 실루엣의 링 제품입니다.<br>
							볼드한 디테일의 골드와 실버링을 함께 레이어드한 제품입니다.<br>
							남성,여성 두 가지 사이즈입니다.</p>
				<p>펜타곤 형태의 구조적인 실루엣의 링 제품입니다.<br>
							볼드한 디테일의 골드와 실버링을 함께 레이어드한 제품입니다.<br>
							남성,여성 두 가지 사이즈입니다.</p>
			</div>
		</div>
		<div id="right">
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
		xhr.open('get', '${pageContext.request.contextPath}/basketController?iNum=3&sbCnt=' + sbCnt, true);
		xhr.send();
	}
</script>
</body>
</html>