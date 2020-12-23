package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.peralyglow.DAO.BoardDao;
import kr.co.pearlyglow.vo.QnABoardVo;

@WebServlet("/Board/ans")
public class BoardAnsController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		BoardDao dao=new BoardDao();
		ArrayList<QnABoardVo> list=dao.ansList(startRow, endRow);
		int pageCount=(int)Math.ceil(dao.AnsgetCount()/10.0);
		int startPageNum=(pageNum-1)/10*10+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("page", "ans");
		req.setAttribute("list",list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
		HttpSession session = req.getSession(true);
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			req.getRequestDispatcher("/index.jsp?spage=Board/list.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/list.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/list.jsp").forward(req, resp);
		}
	}
}
