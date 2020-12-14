<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/pwdsearch.html</title>
<script type="text/javascript">
	var xhr = null;
	function search() {
		var id = document.getElementById("p_id").value;
		var name = document.getElementById("p_name").value;
		var email = document.getElementById("p_email").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','${pageContext.request.contextPath}/Member/pwd.jsp?id='+id+'&name='+name+'&email='+email,true);
		xhr.send();
	}
	function callback() {
		if(xhr.readyState==4 && xhr.status==200){
			var html=xhr.responseText;
			var div=document.getElementById("p_result");
			div.innerHTML=html;
		}
	}
</script>
</head>
<body>
<h1>비밀번호찾기</h1>
아이디 <input type="text" id="p_id"><br>
이름 <input type="text" id="p_name"><br>
이메일 <input type="email" id="p_email"><br>
<input type="button" value="찾기" onclick="search()">
 <div id="p_result"></div>
  <input type="button" value="뒤로가기" onclick="backPage()">
</body>
</html>