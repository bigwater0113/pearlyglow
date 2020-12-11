<%@page import="kr.co.pearlyglow.db.DBCPBean"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String pwd = null;
	try{
		con = DBCPBean.getConn();
		String sql = "select * from members where id=? and name=? and email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			pwd = rs.getString("pwd");	
		}
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		DBCPBean.close(con, pstmt, rs);
	}
	if(id!=null){
%>
	<h1>회원님의 비밀번호 : <%=pwd %></h1>
<%
	}else{
%>
	<h1>조회하신 정보는 없습니다.</h1>
<%
	}
%>