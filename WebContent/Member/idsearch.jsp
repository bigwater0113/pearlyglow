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
</head>
<body>
<h1>아이디 찾기</h1>
이름 <input type="text" id="i_name"><br>
이메일 <input type="email" id="i_email"><br>
<input type="button" value="찾기" onclick="search()">
 <div id="i_result"></div>
 <input type="button" value="뒤로가기" onclick="backPage()">
</body>
</html>