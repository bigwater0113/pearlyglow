<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#quickView_wrap{width:800px;height:360px;}
	#quickView_wrap #image1{width: 350px;height: 350px;float: left; /*text-align: center;*/background-color: white;}
	#quickView_wrap #detail{width: 50%;height: 100%; background-color: white;float: right;}
	#quickView_wrap #image1 #img1{ width: 350px; height: auto; } 
 	#quickView_wrap #detail #title{width: 100%; background-color: white;} 
 	#quickView_wrap #detail #nbso{width: 100%;height: 5%; background-color: white;} 
 	#quickView_wrap #detail #nbso li{list-style: none;display: inline-block;font-size: 10px;border:1px solid black;}
 	#quickView_wrap #detail #description{width: 100%;height: 90%; background-color: white; margin-top: 20px;} 
 	#quickView_wrap #detail #description #text{width: 100%;height: 100%; background-color: white;}
 	#quickView_wrap #detail #description #text #detailText {height: 70%;}
 	#quickView_wrap #detail #description #text #optionText {height: 30%;}
 	#quickView_wrap #detail #description #text p{font-size: 11px; } 
 	#quickView_wrap #detail #description #text span{font-size: 11px; color: gray;} 
 	#quickView_wrap #detail #description #option{width: 100%;height: 30%; background-color: white;} 
 	#quickView_wrap #detail #description #option #buy{background-color: #333333;color:white;border:none ;width: 150px;height: 40px;} 
 	#quickView_wrap #detail #description #option #wish{background-color: white;border:1px solid gray;width: 150px;height: 40px;} 
 	#quickView_wrap #detail #description #option #plus{background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
 	#quickView_wrap #detail #description #option #count{background-color: white;border: 1px solid lightgray;width: 80px;height: 40px;} 
 	#quickView_wrap #detail #description #option #minus{background-color: white;border: 1px solid lightgray;width: 30px;height: 44px;} 
 </style>
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
				<div id="detailText">
					<p>${vo.kDetail }</p>
					<br>
					<p>${vo.eDetail }</p>
				</div>
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