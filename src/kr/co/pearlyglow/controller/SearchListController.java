package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/SearchList")
public class SearchListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String find = req.getParameter("find");
		find=find.toLowerCase();
		itemsDAO dao = itemsDAO.getInstance();
		ArrayList<String> keyword = dao.searchList();
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<list>");
		for(String s:keyword) {
			
			if(s.toLowerCase().startsWith(find,s.indexOf(find))){
				pw.print("<str>" + s + "</str>");
			}
		}
		pw.print("</list>");
	}
	//http://localhost:8081/a_semi_Project/SearchList?find=r
}
