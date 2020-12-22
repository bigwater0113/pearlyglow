<%@page import="kr.co.peralyglow.DAO.basketDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   
  
   var sxhr=null;
	function getList() {
		var find = document.getElementById("h_searchBox").value;
		if(find.trim()==""){
			var sdiv = document.getElementById("h_result");
			sdiv.innerHTML="";
			sdiv.style.display="none";
			return;
		}
		sxhr=new XMLHttpRequest();
		sxhr.onreadystatechange=scallback;
		sxhr.open('get', '${pageContext.request.contextPath}/SearchList?find='+find, true);
		sxhr.send();
	}
	function scallback() {
		if(sxhr.readyState==4 && sxhr.status==200){
			//console.log('success');
			var sxml = sxhr.responseXML;
			var list = sxml.getElementsByTagName("str");
			var len = list.length;
			var str = "";
			var sdiv = document.getElementById("h_result");
			if(len>0){
				for(let i=0; i<len; i++){
					let sug = list[i].textContent;
					str += "<a href=\"javascript:insert('"+ sug + "')\">" + sug + "</a><br>";
				}
				sdiv.innerHTML=str;
				sdiv.style.display="block";
			}else{
				sdiv.innerHTML="";
				sdiv.style.display="none";
			}
		}
	}
	
	function insert(sug) {
		document.getElementById("h_searchBox").value=sug;
		var sdiv =document.getElementById("h_result");
		sdiv.style.display="none";
		sdiv.innerHTML="";
		document.getElementById("h_searchBox").focus();
	}
	
	function onEnter() {
		var keyCode = window.event.keyCode;
		if(keyCode==13){
			hsearch();
		}
	}
	
	function hsearch() {
		let s = document.getElementById("h_searchBox").value;
		location.href = "${pageContext.request.contextPath }/itemListController?type="+s;
	}
		
	window.onload = function () {
		var body = document.getElementsByTagName("body")[0];
		body.addEventListener("click", function(e) {
			var sdiv =document.getElementById("h_result");
			sdiv.style.display="none";
			sdiv.innerHTML="";
		}, false);
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
   display: flex;
   
}

#h_right #h_rleft{
   margin-left: 20px;
   margin-top: 40px;
}
#h_right #h_rleft #h_searchBox {
   margin-left: 20px;
   width: 130px;
   height: 30px;
   border-top: none;
   border-left: none;
   border-right: none;
}
#h_right #h_rleft #h_temp{
   width: 180px;
}
#h_right #h_rleft #h_result{
   width: 180px;
   border: 1px solid blue; 
   background-color:white;
/*    height: 100px; */
   font-size: 20px;
   display:none;
   overflow:auto;
   position:absolute;
}
#h_right #h_rcenter{
   margin-left: 20px;
   margin-top: 40px;
}

#h_right #h_rright{
   margin-left: 20px;
   margin-top: 40px;
}
</style>
<%
   String id = (String) session.getAttribute("id");
   basketDAO dao = basketDAO.getInstance();
   int basketTotalCount = dao.getTotalCount(id);
%>
<div id="h_wrap">
   <div id="h_header">
      <div id="h_left">
         <img alt="" src="${pageContext.request.contextPath}/images/menuIcon.png" id="h_menuBtn" onclick="slide()">
         <c:if test="${empty sessionScope.id }">
         	<a href="${pageContext.request.contextPath}/index.jsp?spage=Member/join.jsp" style="font-size: 25px; text-decoration: none;">회원가입</a>
         </c:if>
         <c:if test="${!empty sessionScope.id }">
            <span style="color:red;font-size:1.2em">${id }님 반갑습니다.</span>&nbsp;&nbsp;
            <c:choose>
               <c:when test="${id=='admin' }">
                  <a href="${pageContext.request.contextPath}/index.jsp?spage=/sellerPage/sellerPage.jsp">판매자페이지</a>
               </c:when>
               <c:otherwise>
                  <a href="${pageContext.request.contextPath}/Member/info?id=${id }">마이페이지</a>
               </c:otherwise>
            </c:choose>
         </c:if>
      </div>
      <div id="h_center">
         <img alt="" src="${pageContext.request.contextPath}/images/logo.PNG" id="h_logo" onclick="location.href='${pageContext.request.contextPath}/index.jsp?spage=main.jsp'">
      </div>
      <div id="h_right">
         <div id = "h_rleft">
               <input type="text" id="h_searchBox" placeholder="SEARCH" style="margin: 0" onkeyup="getList()"  onkeydown="javascript:onEnter()"><input type="button" value="검색" onclick="hsearch()"><br>
            <div id="h_result"></div>
            <div id="h_temp"></div>
         </div>
         
         <div id = "h_rcenter">   
            <a href="${pageContext.request.contextPath}/basketController" id="h_bag">BAG(<%=basketTotalCount %>)</a>
         </div>
         <div id = "h_rright">   
            <c:choose>
               <c:when test="${empty sessionScope.id }">
               <a href="${pageContext.request.contextPath}/index.jsp?spage=Member/login.jsp" id="h_login">LOGIN</a>
               </c:when>
               <c:otherwise>
               <a href="${pageContext.request.contextPath}/Member/logout" id="h_login">LOGOUT</a>
               </c:otherwise>
            </c:choose>
         </div>
      </div>
   </div>
   <div id="h_menu">
      <div id="h_moreMenu1">
         <h2>
            <a href="${pageContext.request.contextPath }/index.jsp?spage=main.jsp">PEARLYGLOW</a>
         </h2>
         <a href="">ABOUT</a> <a href="">INSTARGRAM</a> <a href="">FACEBOOK</a>
         <a href="${pageContext.request.contextPath }/index.jsp?spage=myPage/myPage.jsp">MYPAGE</a>
         <a href="${pageContext.request.contextPath }/index.jsp?spage=sellerPage/sellerPage.jsp">SELLERPAGE</a>
         <a href="${pageContext.request.contextPath }/Board/list">QnA게시판</a>
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
         <a href="${pageContext.request.contextPath }/itemListController?type=earring">EARRING</a>
         <a href="${pageContext.request.contextPath }/itemListController?type=bracelet">BRACELET</a> 
         <a href="${pageContext.request.contextPath }/itemListController?type=necklace">NECKLACE</a>
         <a href="${pageContext.request.contextPath }/itemListController?type=ring">RING</a>
      </div>
   </div>
</div>