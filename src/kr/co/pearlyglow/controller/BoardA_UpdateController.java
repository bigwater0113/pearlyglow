package kr.co.pearlyglow.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.BoardDao;
import kr.co.pearlyglow.vo.QnABoardVo;




@WebServlet("/Board/A_update")
public class BoardA_UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("ibnum"));
		BoardDao dao=new BoardDao();
		QnABoardVo vo = dao.getinfo(num);
		req.setAttribute("board", vo);
		req.getRequestDispatcher("/index.jsp?spage=Board/A_updateForm.jsp").forward(req, resp);
		//req.getRequestDispatcher("/Board/A_updateForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("a_num"));
		BoardDao dao=new BoardDao();
		int n = dao.u_answer(num, req.getParameter("a_content"));
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code","fail");
		}
		req.getRequestDispatcher("/index.jsp?spage=Board/result.jsp").forward(req, resp);
		//req.getRequestDispatcher("/Board/result.jsp").forward(req, resp);

	}
}
