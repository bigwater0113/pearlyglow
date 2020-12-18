package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.ReviewboardDao;
@WebServlet("/rdelete")
public class RdeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pdnum=Integer.parseInt(req.getParameter("pdnum"));
		ReviewboardDao dao=ReviewboardDao.getInstance();
		int n=dao.delete(pdnum);
		if(n>0) {
			req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
			req.setAttribute("msg", "삭제성공!");
		}else {
			req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
			req.setAttribute("msg", "삭제실패!");
		}
	}
}
