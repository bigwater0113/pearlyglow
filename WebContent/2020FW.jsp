<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<style type="text/css">
#left2{
	float:left;
/* 	position: absolute; */
/* 	top:500px; */
/* 	left:75px; */
}
#right2{
	float:left;
/* 	position: absolute; */
/* 	top:500px; */
/* 	left: 675px; */
}

img {
  width: 100%;
  height: 100%;
}
.box{
	display: none;
}
#box{
	display: inline-block;
	width: 500px;
	height: 500px;
 	position: relative; 
 	top: -800px; 
 	left: 350px; 
}

.text{
	display: none;
}
#text{
	display: inline-block;
 	position: absolute; 
 	top: 480px; 
 	left: 370px; 
	width:150px;
	z-index: 1;
}
</style>
</head>
<body>
<div>
	<div id="left2">
		<table style="height: 1200px; width:600px;">
			<tr height="300px">
				<td width="300px"><img src="images/스크린샷 2020-09-27 오후 9.06.51.png" class="small"></td>
				<td width="300px"><img src="images/19.jpg" class="small"></td>
			</tr>
			<tr height="300px">
				<td width="300px"><img src="images/37d7d0d156fe49b868aaef71ab32bca9.jpg" class="small"></td>
				<td width="300px"><img src="images/스크린샷 2020-09-27 오후 9.06.21.png" class="small"></td>
			</tr>
			<tr height="600px">
				<td colspan="2"><img src="images/021-470x705.jpg" class="small"></td>
			</tr>
		</table>
	</div>
	
	<div id="right2">
		<table style="height: 1200px; width:600px;">
			<tr height="300px">
				<td width="300px"><img src="images/6da5c511a07475a22274fac754dc537b.jpg" class="small"></td>
				<td width="300px"><img src="images/jewelry8-705x705.jpg" class="small"></td>
			</tr>
			<tr height="600px">
				<td colspan="2"><img src="images/1a08dfe6c2722e56cfb98883e3a671a9.jpg" class="small"></td>
			</tr>
			<tr height="300px">
				<td width="300px"><img src="images/8339d1b7a58dc1e188416a6a56d79389.jpg" class="small"></td>
				<td width="300px"><img src="images/be8ecb677a32dc49b6169be2b0691dc1.jpg" class="small"></td>
			</tr>
		</table>
	</div>
</div>

<div class = "box">
	<img alt="큰사진" src="images/1.png" class="big">
		<div class="text"><h5>클릭하면 사라져요...</h5></div>
</div>

<script type="text/javascript">
	window.onload = function(){
		var small = document.getElementsByClassName("small");
		var big = document.getElementsByClassName("big")[0];
		for(var i = 0 ; i < small.length; i++){
			small[i].addEventListener("click",function(e){
				var box =document.getElementsByClassName("box")[0];
				box.id = "box";
				var text = document.getElementsByClassName("text")[0];
				text.id = "text";
				
				var boxImg = box.getElementsByTagName("img")[0];
				boxImg.src = e.target.src;
				for(var i = 0 ; i < small.length; i++){
					small[i].style.opacity="0.5";
				}
			},false);
			
			big.addEventListener("click", function(e) {
				var box =document.getElementsByClassName("box")[0];
				box.id = "";
				var boxImg = box.getElementsByTagName("img")[0];
				boxImg.src = "";
				for(var i = 0 ; i < small.length; i++){
					small[i].style.opacity="1.0";
				}
			}, false);
		}
	}

	
</script>
</body>
</html>