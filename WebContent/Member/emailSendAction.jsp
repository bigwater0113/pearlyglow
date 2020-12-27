<%@page import="kr.co.peralyglow.DAO.SHA256"%>
<%@page import="kr.co.peralyglow.DAO.Gmail"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>

<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String host ="http://localhost:8081/a_semi_Project/Member/";
	String from ="aa";
	String to = request.getParameter("email");
	String subject = "이메일 인증";
	int code = SHA256.getSHA256(to).hashCode();
	String content = " [이메일 인증 진행하세요] "+"<a href='" + host + "emailResult.jsp?code=" + code + "'>이메일 인증하기</a>";
	//"<a href='" + host + "emailCheckAction.jsp?code="+new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";
	Properties p = new Properties();
	p.put("mail.smtp.user",from);
	p.put("mail.smtp.host","smtp.googlemail.com");
	p.put("mail.smtp.port","465");
	p.put("mail.smtp.starttls.enable","true");
	p.put("mail.smtp.auth","true");
	p.put("mail.smtp.debug","true");
	p.put("mail.smtp.socketFactory.port","465");
	p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	PrintWriter pw = response.getWriter();
	try{
		Authenticator auth = new Gmail();
		Session ses = Session.getInstance(p, auth);
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses);
		msg.setSubject(subject);
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr);
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr);
		msg.setContent(content,"text/html;charset=UTF-8");
		Transport.send(msg);
		//request.getRequestDispatcher("/Member/emailResult.jsp").forward(request, response);
	}catch(Exception e){
		pw.println("<script>");
		pw.println("alert('이메일 인증 오류!!!')");
		pw.println("</script>");
		//e.printStackTrace();
	}
	response.setContentType("text/xml;charset=utf-8");
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<data>");
	pw.print("<code>" + code +"</code>");
	pw.print("</data>");
%>