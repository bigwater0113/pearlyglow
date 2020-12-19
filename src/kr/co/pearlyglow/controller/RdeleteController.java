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
		ReviewboardDao dao=ReviewboardDao.getInstance();
		String[] params=req.getParameterValues("checkk");
		int n=0;
		for(String i : params) {
			n=dao.delete(Integer.parseInt(i));
		}
		if(n>0) {
			req.setAttribute("msg", "삭제성공!");
			req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "삭제실패!");
			req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
		}
	}
}
