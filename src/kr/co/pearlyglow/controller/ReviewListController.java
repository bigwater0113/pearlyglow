package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.join.Reviewboard_Purchase_pDetail_ItemsVo;
import kr.co.peralyglow.DAO.ReviewboardDao;
@WebServlet("/rlist")
public class ReviewListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
//		String id=(String)req.getSession().getAttribute("id");
		String id="admin";
		String saveDir=req.getServletContext().getRealPath("/upload");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ReviewboardDao dao=ReviewboardDao.getInstance();
		
		ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> list=dao.rList(startRow,endRow,id);
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);
		int startPageNum=(pageNum-1)/10*10+1; 
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("saveDir", saveDir);
		req.setAttribute("id", id);
		req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp&mpage=../review_board/list.jsp").forward(req, resp);
//		req.getRequestDispatcher("/review_board/list.jsp").forward(req, resp);
	}
}
