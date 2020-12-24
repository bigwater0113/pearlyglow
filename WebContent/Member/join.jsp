<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member/login.jsp</title>
<style type="text/css">
form{
		margin: 0 auto;
		padding-left: 300px;
	}
h1{
	text-align: center;
}

.j_h3{
	display:inline;
}
.j_div{
	/*padding-bottom:100px;*/
	display:inline
}
.j_label{
	display:inline-block;
	width: 300px;
}
</style>


<script type="text/javascript">
	var xhr=null;
	function checkid() {
		var id = document.getElementById("j_id").value;
		if(id.trim()==""){
			document.getElementById("j_idcheck").innerHTML="아이디를 입력하세요.";
			return;
		}
		
		//아이디는 영문/숫자 4~10자
		if(id.length<4 || id.length>10){
			document.getElementById("j_idcheck").innerHTML="아이디는 4~10자리로 설정해주세요.";
			return;
		}else if(id.length>=4 && id.length<=10){
			document.getElementById("j_idcheck").innerHTML="";
		}
		
		for(let i=0; i<id.length; i++){
			if(!(('0'<=id.charAt(i) && id.charAt(i)<='9') || ('a'<=id.charAt(i) && id.charAt(i)<='z') || ('A'<=id.charAt(i) && id.charAt(i)<='Z'))){
				document.getElementById("j_idcheck").innerHTML="아이디는 영문과 숫자로만 입력해주세요...";
				return;
			}
		}
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get','${pageContext.request.contextPath}/Member/idcheck.jsp?id='+id,true);
		xhr.send();
	}
	
	function callback() {
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var span = document.getElementById("j_idcheck");
			var using = xml.getElementsByTagName("using")[0].firstChild.nodeValue;
			//console.log(using);
			if(eval(using)==true){
				span.innerHTML="이미 사용중인 아이디입니다.";
			}else if(using=='false'){
				span.innerHTML="사용 가능 한 아이디입니다.";
			}
		}
	}
	
	function checkpwd1(){
		var pwd1 = document.getElementById("j_pwd1").value;
		
		//비밀번호는 영문/숫자 4~8자
		if(pwd1.length<4 || pwd1.length>8){
			document.getElementById("j_pwd1check").innerHTML="비밀번호는 4~8자리로 설정해주세요.";
			return;
		}else if(pwd1.length>=4 && pwd1.length<=8){
			document.getElementById("j_pwd1check").innerHTML="사용가능한 비밀번호입니다.";
		}
		
		for(let i=0; i<pwd1.length; i++){
			if(!(('0'<=pwd1.charAt(i) && pwd1.charAt(i)<='9') || ('a'<=pwd1.charAt(i) && pwd1.charAt(i)<='z') || ('A'<=pwd1.charAt(i) && pwd1.charAt(i)<='Z'))){
				document.getElementById("j_pwd1check").innerHTML="비밀번호는 영문과 숫자로만 입력해주세요...";
				return;
			}
		}
	}
	
	function checkpwd2(){
		var pwd1 = document.getElementById("j_pwd1").value;
		var pwd2 = document.getElementById("j_pwd2").value;
		if(pwd1!=pwd2){
			document.getElementById("j_pwd2check").innerHTML="비밀번호가 일치 하지않아요..."
			return;
		}else{
			document.getElementById("j_pwd2check").innerHTML="비밀번호가 일치해요"
				return;
		}
	}
	
	function sendEmail(){
		var email = document.getElementById("j_email").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=ecallback;
		xhr.open('get','${pageContext.request.contextPath}/Member/emailSendAction.jsp?email='+email,true);
		xhr.send();
	}
	function ecallback() {
		if(xhr.readyState==4 && xhr.status==200){
			var div=document.getElementById("j_emailcheck");
			div.innerHTML="이메일 인증이 완료되었습니다.";
		}
	}
</script>


</head>
<body>
<h1>회원가입</h1><br>
<form action="${pageContext.request.contextPath}/Member/join" method="post">
<!-- wrapper -->
<div id="j_wrapper">

	<!-- content-->
	<div id="j_content">
	
	<!-- ID -->
		<div class="j_div">
		    <h3 class="j_h3"><label class="j_label">아이디</label></h3>
		    <span><input type="text" id="j_id" name="j_id" maxlength="20" onkeyup="checkid()" autofocus="autofocus" class="form-control" style="width: 300px; padding: 0px; display: inline-block;"></span>
		    <span id="j_idcheck"></span>
		</div> <br><br>
	
		<!-- PW1 -->
		<div class="j_div">
		    <h3 class="j_h3"><label class="j_label">비밀번호</label></h3>
		    <span>
		        <input type="password" id="j_pwd1" name="j_pwd1"maxlength="20" onkeyup="checkpwd1()"  class="form-control" style="width: 300px; padding: 0px; display: inline-block;">
				<span id="j_pwd1check"></span>
		    </span>
		</div><br><br>
	
		<!-- PW2 -->
		<div class="j_div">
		    <h3 class="j_h3"><label class="j_label">비밀번호 재확인</label></h3>
		    <span>
		        <input type="password" id="j_pwd2" name="j_pwd2" maxlength="20" onkeyup="checkpwd2()"  class="form-control" style="width: 300px; padding: 0px; display: inline-block;">
		    </span>
		    <span id="j_pwd2check"></span>
		</div><br><br>
	
		<!-- NAME -->
		<div class="j_div">
		    <h3 class="j_h3"><label class="j_label">이름</label></h3>
		    <span>
		        <input type="text" id="j_name" name="j_name" maxlength="20"  class="form-control" style="width: 300px; padding: 0px; display: inline-block;"> 
		    </span>
		</div><br><br>
	
		<!-- ADDR -->
		<div class="j_div">
		    <h3 class="j_h3"><label class="j_label" style="vertical-align: top;">주소</label></h3>
		    <span>
		    	<textarea rows="3" cols="30" id="j_addr" name="j_addr" style="resize: none; width: 300px; padding: 0px; display: inline-block;"  class="form-control"></textarea>
		    </span>
		</div><br><br>	
	
		<!-- BIRTH -->
		<div class="j_div">
			<h3 class="j_h3"><label class="j_label">생년월일</label></h3>
		
		    <div class="j_div">
		        <!-- BIRTH_YY -->
				<div class="j_div">
				    <span>
				        <input type="text" id="j_yy" name="j_yy" maxlength="4" placeholder="년(4자)"  class="form-control" style="width: 140px; padding: 0px; display: inline-block;">
				    </span>
				</div>
	
				<!-- BIRTH_MM -->
				<div class="j_div">
				    <span>
				        <select id="j_mm" name="j_mm"  class="form-control" style="width: 50px; padding: 0px; display: inline-block;">
				            <option>월</option>
				            <option value="01">1</option>
				            <option value="02">2</option>
				            <option value="03">3</option>
				            <option value="04">4</option>
				            <option value="05">5</option>
				            <option value="06">6</option>
				            <option value="07">7</option>
				            <option value="08">8</option>
				            <option value="09">9</option>                                    
				            <option value="10">10</option>
				            <option value="11">11</option>
				            <option value="12">12</option>
				        </select>
				    </span>
				</div>
	
				<!-- BIRTH_DD -->
			    <div class="j_div">
			        <span>
			            <input type="text" id="j_dd" name="j_dd" maxlength="2" placeholder="일"  class="form-control" style="width: 100px; padding: 0px; display: inline-block;">
			        </span>
			    </div>
			</div>
		</div><br><br>
	
	    <!-- GENDER -->
	    <div class="j_div">
	        <h3 class="j_h3"><label class="j_label">성별</label></h3>
	        <span>
	            <select id="j_gender" name="j_gender"  class="form-control" style="width: 300px; padding: 0px; display: inline-block;">
	                <option>성별</option>
	                <option value="M">남자</option>
	                <option value="W">여자</option>
	            </select>                            
	        </span>
	    </div><br><br>
	
	    <!-- EMAIL -->
	    <div class="j_div">
	        <h3 class="j_h3"><label class="j_label">본인확인 이메일</label></h3>
	        <span>
	            <input type="email" id="j_email" name="j_email" class="form-control" style="width: 300px; padding: 0px; display: inline-block;">
	        </span>
	      	<button type="button" id="j_btnEmail", onclick="sendEmail()" class="btn btn-secondary"><span>이메일 인증</span></button>
	    	<span id="j_emailcheck"></span>
	    </div><br><br>
	
	    <!-- MOBILE -->
	    <div class="j_div"> 
	        <h3 class="j_h3"><label class="j_label">휴대전화</label></h3>
	        <span>
	            <input type="tel" id="j_phone" name="j_phone" maxlength="16" placeholder="전화번호 입력"  class="form-control" style="width: 300px; padding: 0px; display: inline-block;">
	        </span> 
	    </div><br><br>
	
	    <!-- JOIN BTN-->
	    <div class="j_div">
	        <input type="submit" id="j_btnJoin" value="Sign Up" class="btn btn-black" style="width: 500px; margin-left: 50px;">
	    </div>
	    
	</div> 
	<!-- content-->
</div> 
<!-- wrapper -->
</form>
</body>
</html>