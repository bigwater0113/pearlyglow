package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.BoardDao;

@WebServlet("/Board/InsertPage")
public class BoardInsertPageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao=new BoardDao();
		ArrayList<ItemsVo> list = dao.iNumList();
		req.setAttribute("list",list);
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			req.getRequestDispatcher("../index.jsp?spage=Board/insert.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.getRequestDispatcher("../index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/insert.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("../index.jsp?spage=myPage/myPage.jsp&mpage=../Board/insert.jsp").forward(req, resp);
		}
	}
}
