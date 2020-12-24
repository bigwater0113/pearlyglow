package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.QnABoardVo;
import kr.co.peralyglow.DAO.BoardDao;

@WebServlet("/Board/boardInfo")
public class BoardInfoController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		String id = (String)req.getSession().getAttribute("id");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		BoardDao dao = new BoardDao();
		ArrayList<QnABoardVo> list = dao.myinfo(id,startRow,endRow);
		int pageCount=(int)Math.ceil(dao.myinfoGetCount(id)/10.0);
		System.out.println("pageCouont:"+pageCount);
		int startPageNum=(pageNum-1)/10*10+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list",list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
//		System.out.println(pageNum);
//		System.out.println(pageCount);
//		System.out.println(startPageNum);
//		System.out.println(endPageNum);
		req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/mypage.jsp").forward(req, resp);
	}
}
