package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.pearlyglow.vo.ReviewBoardVo;
import kr.co.peralyglow.DAO.ReviewboardDao;
@WebServlet("/review_board/delete")
public class ReviewDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int pdNum=Integer.parseInt(req.getParameter("pdNum"));
		ReviewboardDao dao=ReviewboardDao.getInstance();
		int n=dao.delete(pdNum);
		if(n>0) {
			req.getRequestDispatcher("../MyReview?status=").forward(req, resp);
		}else {
			req.getRequestDispatcher("../MyReview?status=").forward(req, resp);
		}
	}
}
