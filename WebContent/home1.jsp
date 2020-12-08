<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home1.jsp</title>
<style type="text/css">
#left2{
	position: absolute;
	left:75px;
	top:100px;
	width:600px;
	height: 2000px;
}
#right2{
	position: absolute;
	left:725px;
	top:100px;
	width:600px;
	height: 2000px;
}
#text1{
	position: absolute;
	left:180px;
	top:900px;
	width: 200px;
}
#text2{
	position: absolute;
	left:230px;
	top:900px;
	width: 200px;
}
</style>
</head>
<body>
<div id="left2" onclick="location.href='';">
<img src="images/007-470x705.jpg">
<div id="text1"><h1 style="color:white; font-size: 50px">Woman</h1></div>
</div>

<div id="right2" onclick="location.href=''">
<img src="images/003-470x705.jpg">
<div id="text2"><h1 style="color:white; font-size: 50px">Man</h1></div>
</div>
</body>
</html>