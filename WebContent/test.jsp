<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="https://tracker.delivery/#/kr.epost/1111111111111" target="_blank">배송조회</a>
</body>
</html>

<div id="quickView_wrap">
		<div id="image1">
			<img alt="반지상세" src=${vo.iThumbnail } id="img1">
		</div>
		<div id="detail">
			<div id="title">
				<h4>${vo.iName }</h4>
			</div>
			<div id="nbso">
				<!-- new best soldout -->
				<ul>
					<li>NEW</li>
					<li>BEST</li>
					<li>Sold out</li>
				</ul>
			</div>
			<div id="description">
				<div id="text">
					<div id="detailText"><p>${vo.kDetail }</p><br><p>${vo.eDetail }</p></div>
					<div id="optionText">
						<span>Gender: ${vo.iGender } </span> <br> <span>Category:
							${vo.iCategory } </span> <br> <span>Color: ${vo.color } </span> <br>
						<span>Size: ${vo.iSize } / Weight: ${vo.weight } / Material:
							${vo.material } </span>
					</div>
				</div>
				<div id="option">
					<input type="button" value="-" onclick="changeM(event);" id="minus"><input
						type="text" name="count" value="1" id="count"><input
						type="button" value="+" onclick="changeP(event);" id="plus">
					<br>
					<br> <input type="button" value="구매하기" id="buy"> <input
						type="button" value="장바구니" id="wish" onclick="putBasketResult()"><br>
					<span id="resultSpan"></span>
				</div>
			</div>
		</div>
	</div>