<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	var state = 0; // 닫힌상태 = 0
	var positionTop = -110;
	
	function slide() {
		
		console.log(positionTop);
		var menu = document.getElementById("menu");
		
		
		if (state == 0){
			state = 1;
			var downInterval = setInterval(function() {
				menu.style.top = positionTop + "px";
				if (positionTop < 100){
					positionTop += 2;
				} else {
					clearInterval(downInterval);
				}
			}, 5)
		} else {
			var upInterval = setInterval(function() {
				menu.style.top = positionTop + "px";
				if (positionTop > -110){
					positionTop -= 2;
				} else {
					clearInterval(upInterval);
				}
			}, 5)
			state = 0;
		}
		
	}
</script>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
	a{color:black;text-decoration: none; font-weight:bold;}
	#wrap1 {
		width: 1200px;
		margin: 0 auto;
		position: relative;
	}
	#header1 {
		background-color: #ffffff;
		height: 100px;
		position: relative;
		z-index: 500;
	}
	#header1 div {
		width: 400px;
		height: 100px;
		float: left;
		z-index: 600;
	}
	#menu {
		top: -110px;
		display: inline-block;
		text-align: center;
		background-color: orange;
		position: absolute;
		z-index: 400;
	}
	#menu div {
		float: left;
		width: 292px;
		height: 200px;
		display: flex;
		flex-direction : column;
		border: 1px solid black;
	}
	#logo {
		width: 300px;
		height: 50px;
	}
	
	
	
	#left {
		/*background-color: blue; */
		display: flex;
		align-items: center;
	}
	
	#left #menuBtn {
		width: 70px;
		height: 70px;
	}
	
	#center {
		display: flex;
		/*background-color: yellow; */
		justify-content: center;
		align-items: center;
	}
	#right {
		/* background-color: orange; */
		display: flex;
		justify-content: center;
		align-items: center;
	}
	#right #searchBox {
		margin: 20px;
		width: 150px;
		height: 30px;
		border-top: none;
		border-left: none;
		border-right: none;
		background-color: write;
	}
	
	#right #bag {
		margin: 20px;
	}
	
	#right #login{
		margin: 20px;
	}
</style>

<div id="wrap1">
	<div id="header1">
		<div id="left">
			<img alt="" src="images/menuIcon.png" id="menuBtn" onclick="slide()">
		</div>
		<div id="center">
			<img alt="" src="images/logo.PNG" id="logo">
		</div>
		<div id="right">
			<input type="text" id="searchBox" placeholder="SEARCH">
			<a href="" id="bag">BAG(0)</a>
			<a href="" id="login">LOGIN</a>
		</div>
	</div>
	<div id="menu">
		<div id="moreMenu1">
			<h2><a href="">PEARLYGLOW</a></h2>
			<a href="">ABOUT</a>
			<a href="">INSTARGRAM</a>
			<a href="">FACEBOOK</a>
		</div>
		<div id="moreMenu2">
			<h2><a href="">CAMPAIGN</a></h2>
			<a href="">2020.FW</a>
			<a href="">2020.SS</a>
			<a href="">2019.FW</a>
			<a href="">2019.SS</a>
		</div>
		<div id="moreMenu3">
			<h2><a href="">WO/MAN</a></h2>
		</div>
		<div id="moreMenu4">
			<h2><a href="">SHOP</a></h2>
			<a href="">EARRING</a>
			<a href="">BRACELET</a>
			<a href="">NECKLACE</a>
			<a href="">RING</a>
		</div>
	</div>
</div>
