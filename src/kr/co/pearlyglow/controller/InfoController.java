package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.pearlyglow.vo.MembersVo;
import kr.co.pearlyglow.vo.QnABoardVo;
import kr.co.peralyglow.DAO.BoardDao;
import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/info")
public class InfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MembersDao dao=new MembersDao();
		MembersVo vo=dao.getinfo(id);
		
		BoardDao bdao = new BoardDao();
		ArrayList<QnABoardVo> list = bdao.myinfo(id);
		
		req.setAttribute("vo",vo);
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Member/mypage.jsp").forward(req, resp);
	}
}
