package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.QnABoardVo;
import kr.co.peralyglow.DAO.BoardDao;

@WebServlet("/Board/ansInsert")
public class BoardAnsInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String ibnum = req.getParameter("ibnum");
		String id = req.getParameter("id");
		String ans = req.getParameter("ans");
		int num=0;
		int ref=0;
		int lev=0;
		int step=0;
		if(ibnum!=null && !ibnum.equals("")) { // 답글인경우
			num=Integer.parseInt(ibnum);
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
			step=Integer.parseInt(req.getParameter("step"));
		}
		QnABoardVo vo = new QnABoardVo(num, id, 0, null, null, null, null, null, null, null, ans, null, ref, lev, step);
		BoardDao dao = new BoardDao();
		int n = dao.answer(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.getRequestDispatcher("/index.jsp?spage=Board/list").forward(req, resp);
	}
}
