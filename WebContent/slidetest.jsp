<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>slidetest.jsp</title>
<style>
	*{margin:0px;padding:0px;}
	#outBox{width:1200px;height:100px;background-color:green;
	position:absolute;left:50px;top:150px;overflow:hidden;}
	#box1{width:1200px;height:200px;background-color: red;
	position:absolute;top:-100px;}
	#menu{width:1200px;height:100px;background-color: blue;
	position:absolute;}
</style>
</head>
<body>
<div id="outBox">
	<div id="box1">
		<div id="menu">
		
		</div>
	</div>
</div>
<input type="button" value="움직여" onclick="moveStart()">
<textarea rows="5" cols="30" style="overflow:scroll;"></textarea>
<script>
	var i=0;
	function moveStart(){
		setInterval(moveDiv, 5);
	}
	function moveDiv(){
		
		var menu=document.getElementById("menu");
		menu.style.top=i+"px";
		if(i<100){
			i+=1;
		}
	}
</script>
</body>
</html>