package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.BoardDao;


@WebServlet("/Board/delete")
public class BoardDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("ibnum"));
		BoardDao dao = new BoardDao();
		int n=dao.delete(num);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/Board/list");
		}else {
			req.setAttribute("code","fail");
			req.getRequestDispatcher("/Board/result.jsp").forward(req, resp);
		}
	}
}
