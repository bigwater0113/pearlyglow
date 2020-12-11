<%@page import="java.util.Stack"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- recentView -->
<div>
<h2>최근 본 상품</h2>

<%-- 
<%
	//String a=URLDecoder.decode("한글","UTF-8");
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
// 	ArrayList<String> list=new ArrayList<>();
	String[] names=new String[5];
	String[] values=new String[5];
	boolean find=false;
	int index=0;
	for(Cookie cook:cooks){
		String name=cook.getName();
		String value=cook.getValue();
		if(name.startsWith("item")){
			find=true;
			value=URLDecoder.decode(value,"utf-8");
// 			if(index<5){
// 				names[index]=name;
				values[index++]=value;
// 			}else{
// 				System.out.println(names[0]);
// 				Cookie c=new Cookie(names[0],null);
// 				c.setPath("/");
// 				c.setMaxAge(0);
// 				response.addCookie(c);
				
// 				for(int i=1;i<values.length;i++){
// 					names[i-1]=names[i];
// 					System.out.println("========");
// 					System.out.println(names[0]);
// 					System.out.println(names[1]);
// 					System.out.println(names[2]);
// 					System.out.println(names[3]);
// 					System.out.println(names[4]);
// 					System.out.println("========");
// 					values[i-1]=values[i];
// 				}
// 				names[values.length-1]=name;
// 				values[values.length-1]=value;
// 				System.out.println("========");
// 				System.out.println(names[0]);
// 				System.out.println(names[1]);
// 				System.out.println(names[2]);
// 				System.out.println(names[3]);
// 				System.out.println(names[4]);
// 				System.out.println("========");
// 			}
		}
	}
	request.setAttribute("values",values);
	
%>
		<c:forEach var="item" items="${values }">
			<c:if test="${!empty item }">
				<p>11 : ${item }</p>
			</c:if>
		</c:forEach>
	
<%
	if(!find){
%>
	<p>최근본 상품이 없어요.</p>
<%
	}
	}
%>

--%>






<%--
	<c:forEach var="cook" items="${cooks }">
		<c:set var="name" value="${cook.getName() }"/>
		<c:set var="value" value="${cook.getValue() }"/>
		<c:if test="${name.startsWith("item") }">
			<c:set var="value" value=URLDecoder.decode(${value },"utf-8")/>
				<p>최근본 상품이 있어요.</p>
			<c: set var="find" value="true"/>
		</c:if>
	</c:forEach>
	<c:if test="${find=='false' }"/>
	<p>최근본 상품이 없어요.</p>
	
--%>
	<c:forEach var="item" items="${values }">
			<c:if test="${!empty item }">
				<p>11 : ${item }</p>
			</c:if>
	</c:forEach>
<br>
<br>
<br>
<a href="testview1.jsp">쿠키넣기1</a><br>
<a href="testview2.jsp">쿠키넣기2</a><br>
<a href="testview3.jsp">쿠키넣기3</a><br>
<a href="testview4.jsp">쿠키넣기4</a><br>
<a href="testview5.jsp">쿠키넣기5</a><br>
<a href="testview6.jsp">쿠키넣기6</a><br>
</div>