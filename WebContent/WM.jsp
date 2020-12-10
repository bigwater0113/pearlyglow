<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
#WM_wrap{width:1200px;height:650px;}
#left2 {
	position: relative;
	margin-left:240px;
	width: 350px;
	height: 550px;
	float:left;
	background: url('images/007-470x7051.jpg') no-repeat;
	background-size: 100% 100%;
	display:flex;
	justify-content:center;
	align-items:center;
	text-shadow:3px 3px 6px black;
	color:white;
	font-size:40px;
	font-weight:bold;
}

#right2 {
	position: relative;
	margin-left:20px;
	width: 350px;
	height: 550px;
	float:left;
	background: url('images/003-470x7051.jpg') no-repeat;
	background-size: 100% 100%;
	display:flex;
	justify-content:center;
	align-items:center;
	text-shadow:3px 3px 6px black;
	color:white;
	font-size:40px;
	font-weight:bold;
}

</style>
<div id="WM_wrap">
	<div id="left2"
		onclick="location.href='${pageContext.request.contextPath }/index.jsp?spage=Woman.jsp'">
		Woman
	</div>

	<div id="right2" onclick="location.href=''">
		Man
	</div>
</div>