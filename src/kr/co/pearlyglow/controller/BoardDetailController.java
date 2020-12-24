package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.peralyglow.DAO.BoardDao;
import kr.co.pearlyglow.vo.QnABoardVo;


@WebServlet("/Board/detail")
public class BoardDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("ibnum");
		BoardDao dao=new BoardDao();
		QnABoardVo vo = dao.detail(Integer.parseInt(num));
		req.setAttribute("vo", vo);
		
		HttpSession session = req.getSession(true);
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			req.getRequestDispatcher("/index.jsp?spage=Board/detail.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/detail.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/detail.jsp").forward(req, resp);
		}
	}
}
