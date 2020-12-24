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
		text-align: center;
	}
	
</style>
</head>
<body>
<h1>아이디 찾기</h1><br>
<form style="text-align: center;">
<label style="width: 100px;">이름</label><input type="text" id="i_name" autofocus="autofocus" class="form-control" style="width: 300px; display: inline-block;"><br><br>
<label style="width: 100px;">이메일</label><input type="email" id="i_email" class="form-control" style="width: 300px; display: inline-block;"><br><br>
<div id="i_result" style="width: 500px; margin-left: 350px;"></div>
<input type="button" value="찾기" onclick="search()" style="width: 200px; height:50px; inline-block;" class="btn btn-black">
<input type="button" value="뒤로가기" onclick="backPage()" style="width: 200px; height:50px; display: inline-block;" class="btn btn-secondary btn-lg">
</form>
</body>
</html>