<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	var state = 0; // 닫힌상태 = 0
	var positionTop = -110;

	function slide() {

		console.log(positionTop);
		var menu = document.getElementById("h_menu");

		if (state == 0) {
			state = 1;
			var downInterval = setInterval(function() {
				menu.style.top = positionTop + "px";
				if (positionTop < 100) {
					positionTop += 2;
				} else {
					clearInterval(downInterval);
				}
			}, 5)
		} else {
			var upInterval = setInterval(function() {
				menu.style.top = positionTop + "px";
				if (positionTop > -110) {
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
* {
	margin: 0px;
	padding: 0px;
}

#h_wap a {
	color: black;
	text-decoration: none;
	font-weight: bold;
}

#h_wrap {
	width: 1200px;
	margin: 0 auto;
	position: relative;
}

#h_header {
	background-color: #ffffff;
	height: 100px;
	position: relative;
	z-index: 500;
}

#h_header div {
	width: 400px;
	height: 100px;
	float: left;
	z-index: 600;
}

#h_menu {
	top: -110px;
	display: inline-block;
	text-align: center;
	background-color: white;
	position: absolute;
	z-index: 400;
}

#h_menu div {
	float: left;
	width: 292px;
	height: 200px;
	display: flex;
	flex-direction: column;
	border: 1px solid black;
}

#h_logo {
	width: 300px;
	height: 50px;
}

#h_left {
	/*background-color: blue; */
	display: flex;
	align-items: center;
}

#h_left #h_menuBtn {
	width: 70px;
	height: 70px;
}

#h_center {
	display: flex;
	/*background-color: yellow; */
	justify-content: center;
	align-items: center;
}

#h_right {
	/* background-color: orange; */
	display: flex;
	justify-content: center;
	align-items: center;
}

#h_right #h_searchBox {
	margin: 20px;
	width: 150px;
	height: 30px;
	border-top: none;
	border-left: none;
	border-right: none;
	background-color: write;
}

#h_right #h_bag {
	margin: 20px;
}

#h_right #h_login {
	margin: 20px;
}
</style>

<div id="h_wrap">
	<div id="h_header">
		<div id="h_left">
			<img alt="" src="${pageContext.request.contextPath}/images/menuIcon.png" id="h_menuBtn" onclick="slide()">
		</div>
		<div id="h_center">
			<img alt="" src="${pageContext.request.contextPath}/images/logo.PNG" id="h_logo">
		</div>
		<div id="h_right">
			<input type="text" id="h_searchBox" placeholder="SEARCH">
			<a href="${pageContext.request.contextPath}/basketController" id="h_bag">BAG(0)</a>
			<a href="${pageContext.request.contextPath}/index.jsp?spage=Member/login.jsp" id="h_login">LOGIN</a>
		</div>
	</div>
	<div id="h_menu">
		<div id="h_moreMenu1">
			<h2>
				<a href="${pageContext.request.contextPath }/index.jsp?spage=main.jsp">PEARLYGLOW</a>
			</h2>
			<a href="">ABOUT</a> <a href="">INSTARGRAM</a> <a href="">FACEBOOK</a>
		</div>
		<div id="h_moreMenu2">
			<h2>
				<a href="">CAMPAIGN</a>
			</h2>
			<a href="${pageContext.request.contextPath }/index.jsp?spage=2020FW.jsp">2020.FW</a> <a href="">2020.SS</a> <a href="">2019.FW</a>
			<a href="">2019.SS</a>
		</div>
		<div id="h_moreMenu3">
			<h2>
				<a href="${pageContext.request.contextPath }/index.jsp?spage=WM.jsp">WO/MAN</a>
			</h2>
		</div>
		<div id="h_moreMenu4">
			<h2>
				<a href="">SHOP</a>
			</h2>
			<a href="">EARRING</a> <a href="">BRACELET</a> <a href="">NECKLACE</a>
			<a href="">RING</a>
		</div>
	</div>
</div>
