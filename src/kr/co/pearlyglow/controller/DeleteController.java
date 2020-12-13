package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.peralyglow.DAO.MembersDao;


@WebServlet("/Member/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MembersDao dao=new MembersDao();
		int n=dao.delete(id);
		if(n>0) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath()+"/Member/logout");
		}else {
			req.setAttribute("code","fail");
			req.getRequestDispatcher("/index.jsp?spage=Member/result.jsp").forward(req, resp);
		}
	}
}







