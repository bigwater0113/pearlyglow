package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/lockN")
public class LockNController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] id = req.getParameterValues("mem");
		MembersDao dao=new MembersDao();
		for(int i=0 ; i<id.length; i++) {
			dao.lockN(id[i]);
		}
		req.getRequestDispatcher("/Member/list").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MembersDao dao=new MembersDao();
		int n = dao.lockN(id);
		if(n>0) {
			req.getRequestDispatcher("/index.jsp?spage=Member/list").forward(req, resp);
			//resp.sendRedirect(req.getContextPath()+"/Member/list");
		}else {
			req.setAttribute("code","fail");
			req.getRequestDispatcher("/index.jsp?spage=Member/result.jsp").forward(req, resp);
		}
		
	}
}
