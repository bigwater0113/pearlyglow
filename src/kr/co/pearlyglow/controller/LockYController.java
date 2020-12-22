package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/lockY")
public class LockYController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] id = req.getParameterValues("mem");
		if(id==null || id.equals("")) {
			resp.sendRedirect(req.getContextPath()+"/Member/list");
		}else {
			MembersDao dao=new MembersDao();
			for(int i=0 ; i<id.length; i++) {
				dao.lockY(id[i]);
			}
			req.getRequestDispatcher("/Member/list").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MembersDao dao=new MembersDao();
		int n = dao.lockY(id);
		if(n>0) {
			req.getRequestDispatcher("/Member/list").forward(req, resp);
		}else {
			req.setAttribute("code","fail");
			req.getRequestDispatcher("/index.jsp?spage=Member/result.jsp").forward(req, resp);
		}
		
	}
}
