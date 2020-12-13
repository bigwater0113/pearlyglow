<%@page import="kr.co.pearlyglow.db.DBCPBean"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String id = null;
	try{
		con = DBCPBean.getConn();
		String sql = "select * from members where name=? and email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			id = rs.getString("id");	
		}
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		DBCPBean.close(con, pstmt, rs);
	}
	if(id!=null){
%>
	<h1>회원님의 아이디 : <%=id %></h1>
<%
	}else{
%>
	<h1>조회하신 정보는 없습니다.</h1>
<%
	}
%>