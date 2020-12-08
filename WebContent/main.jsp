<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- main.jsp -->
<style>
/*
	#mainTop{width:1400px;height:450px;background-color: blue;}
	#menu{width:200px;height:400px;float: left;display:none;background-color: yellow;}
	#mainSlide{width:1200px;height:400px;float: left;background-color: lightgreen;position:absolute;overflow:hidden;
	z-index: 200;}
	#imgDiv{width:6025px;height:400px;float: left;background-color: lightgreen;position:absolute;
	z-index: 201;}
	.slideImg{width:1200px;height:400px;}
	#category{width:1200px;height:450px;background-color: grey;}
	#categoryLeft{width:780px;height:400px;background-color: red;float: left;}
	#categoryRight{width:420px;height:400px;background-color: green;float: left;}
	#categoryRightTop{width:420px;height:200px;background-color: orange;}
	#categoryRightTop div{width:190px;height:190px;margin-left:20px;float:left;background-color: lightgreen;}
	#categoryRightBottom{width:420px;height:200px;background-color: purple;}
	#categoryRightBottom div{width:190px;height:190px;margin-top:10px;margin-left:20px;float:left;background-color: lightblue;}
	#mdPick{width:1200px;height:800px;background-color: green;}
	#mainItemList{margin:auto;text-align: center;}
	#mainItemList td{padding:20px;background-color: lightgreen;}
	#mainItemList a{color:black;text-decoration: none; font-weight:bold;}
	#instagramBanner{width:1200px;height:400px;background-color: lightgreen;}
	#instagramRecommends{margin:auto;}
	#instagramRecommends td{padding:10px;background-color: lightblue;}
	*/
	#mainTop{width:1400px;height:450px;}
/* 	#menu{width:200px;height:400px;float: left;display:none;} */
	#mainSlide{width:1200px;height:400px;float: left;position:relative;overflow:hidden;}
	#imgDiv{width:6025px;height:400px;float: left;position:relative;}
	.slideImg{width:1200px;height:400px;}
	#category{width:1200px;height:450px;}
	#categoryLeft{width:780px;height:400px;float: left;}
	#categoryRight{width:420px;height:400px;float: left;}
	#categoryRightTop{width:420px;height:200px;}
	#categoryRightTop div{width:190px;height:190px;margin-left:20px;float:left;}
	#categoryRightBottom{width:420px;height:200px;}
	#categoryRightBottom div{width:190px;height:190px;margin-top:10px;margin-left:20px;float:left;}
	#mdPick{width:1200px;height:800px;}
	#mainItemList{margin:auto;text-align: center;}
	#mainItemList td{padding:20px;}
	#mainItemList a{color:black;text-decoration: none; font-weight:bold;}
	#instagramBanner{width:1200px;height:400px;}
	#instagramRecommends{margin:auto;}
	#instagramRecommends td{padding:10px;}
</style>
<div>
	<div id="mainTop">
		<div id="mainSlide">
			<div id="imgDiv">
				<img src="images/001.png" class="slideImg" onclick="location.href =''">
				<img src="images/002.png" class="slideImg" onclick="location.href =''">
				<img src="images/003.png" class="slideImg" onclick="location.href =''">
				<img src="images/004.png" class="slideImg" onclick="location.href =''">
				<img src="images/001.png" class="slideImg" onclick="location.href =''">
			</div>
		</div>
	</div>
	<div id="category">
		<div id="categoryLeft" onclick="location.href =''">
			<img src="images/011.png"  style="width:780px;height:400px;">
			<span style="position:relative;left:300px; top:-230px;color:white; font-size:40px;font-weight:bold;disabled:disabled;">2020 FW</span>
		</div>
		<div id="categoryRight">
			<div id="categoryRightTop">
				<div id="categoryRTL" onclick="location.href =''" >
					<img src="images/021.png"style="width:190px;height:190px;">
					<span style="position:relative;left:60px; top:-110px;color:white; font-size:14px;font-weight:bold;">EARRING</span>
					<span style="position:relative;left:-5px;top:-85px;color:white; font-size:14px;">collection</span>
				</div>
				<div id="categoryRTR" onclick="location.href =''">
					<img src="images/022.png"style="width:190px;height:190px;">
					<span style="position:relative;left:60px; top:-110px;color:white; font-size:14px;font-weight:bold;">BRACELET</span>
					<span style="position:relative;left:-10px;top:-85px;color:white; font-size:14px;">collection</span>
				</div>
			</div>
			<div id="categoryRightBottom">
				<div id="categoryRBL" onclick="location.href =''" >
					<img src="images/023.png"style="width:190px;height:190px;">
					<span style="position:relative;left:60px; top:-110px;color:white; font-size:14px;font-weight:bold;">NECKLACE</span>
					<span style="position:relative;left:-10px;top:-85px;color:white; font-size:14px;">collection</span>
				</div>
				<div id="categoryRBR">
					<img src="images/024.png"style="width:190px;height:190px;">
					<span style="position:relative;left:80px; top:-110px;color:white; font-size:14px;font-weight:bold;">RING</span>
					<span style="position:relative;left:25px;top:-85px;color:white; font-size:14px;">collection</span>
				</div>
			</div>
		</div>
	</div>
	<div id="mdPick">
		<table id="mainItemList" width="800">
			<caption style="height:20px; padding:30px; font-weight:bold; font-size:20px; ">MD's PICK</caption>
			<tr>	
				<c:forEach var="i" begin="1" end="6">
					<td>
						<div>
							<img src="images/03${i }.png" onclick="location.href =''"
								style="border:1px solid grey;width:220px;height:220px;">
							<input type="button" value="Quick View" style="position:relative; top:-30px;"><br>
							<c:choose>
								<c:when test="${i%3==1 }">
									<a href="">Coin Layered Set</a><br>
									148,000원
								</c:when>
								<c:when test="${i%3==2 }">
									<a href="">LINK multi Bracelet</a><br>
									128,000원
								</c:when>
								<c:when test="${i%3==0 }">
									<a href="">Initial Long Necklace</a><br>
									120,000원
								</c:when>
								
							</c:choose>
							
						</div>
					</td>
					<c:if test="${i==3 }">
						</tr>
						<tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div id="instagramBanner">
		<table id="instagramRecommends" width="800">
		<caption style="height:50px; padding:30px; font-weight:bold; font-size:20px; ">#pearlyglow<br>
		recommends</caption>
			<tr>
				<c:forEach var="i" begin="1" end="5">
					<td>
						<div>
							<img src="images/04${i }.png" onclick="location.href =''"
								style="width:180px;height:180px;">
							<span style="position:relative;left:5px; top:-35px;color:white;">@pearlyglow</span>
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>
<script>
	var i=0;
	var delay=0;
	setInterval(moveMainImg, 2);
	function moveMainImg(){
		var imgDiv=document.getElementById("imgDiv");
		imgDiv.style.left=i+"px";
		delay++;
		if(delay<3000/2){
			
		}else{
			i-=2;
			if(delay==(3000/2)+(1204/2)){
				delay=0;
				
			}
		}
		if(i<-4800){
			i=0;
			delay=0;
		}
	}
</script>