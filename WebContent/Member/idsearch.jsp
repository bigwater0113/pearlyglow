<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/idsearch.html</title>
<script type="text/javascript">
	var xhr = null;
	function search() {
		var name = document.getElementById("i_name").value;
		var email = document.getElementById("i_email").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','${pageContext.request.contextPath}/Member/id.jsp?name='+name+'&email='+email,true);
		xhr.send();
	}
	function callback() {
		if(xhr.readyState==4 && xhr.status==200){
			var html=xhr.responseText;
			var div=document.getElementById("i_result");
			div.innerHTML=html;
		}
	}
	function backPage(){
		history.go(-1);
	}
</script>
<style type="text/css">
	h1, form{
		width: 300px;
		margin: 0 auto;
		text-align: center;
	}
	
</style>
</head>
<body>
<h1>아이디 찾기</h1><br>
<form>
이름 <input type="text" id="i_name" autofocus="autofocus"><br><br>
이메일 <input type="email" id="i_email"><br><br>
<input type="button" value="찾기" onclick="search()" style="width: 200px;">
 <div id="i_result"></div>
 <input type="button" value="뒤로가기" onclick="backPage()" style="width: 200px;">
</form>
</body>
</html>