package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.QnABoardVo;
import kr.co.peralyglow.DAO.BoardDao;

@WebServlet("/Board/boardInfo")
public class BoardInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BoardDao dao = new BoardDao();
		ArrayList<QnABoardVo> list = dao.myinfo(id);
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/mypage.jsp").forward(req, resp);
	}
}
