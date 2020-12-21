package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;
import kr.co.pearlyglow.vo.join.Reviewboard_Purchase_pDetail_ItemsVo;
import kr.co.peralyglow.DAO.ReviewboardDao;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/detailInfoController")
public class DetailInfoController extends HttpServlet{
	
	itemsDAO dao = itemsDAO.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		
		ItemsVo vo = dao.select(iNum);
		Items_imageVo img = dao.selectImg(iNum);
		
		String spageNum=req.getParameter("pageNum");
		String id=(String)req.getSession().getAttribute("id");
//		String id="admin";
		String del=req.getParameter("reviewlist_delete");
		String rsDesc=req.getParameter("reviewlist_desc");
		String rsAsc=req.getParameter("reviewlist_asc");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ReviewboardDao dao=ReviewboardDao.getInstance();
		
		ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> list=dao.rList(rsDesc,rsAsc,startRow,endRow,id);
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);
		int startPageNum=(pageNum-1)/10*10+1; 
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		int avg=dao.getAvg();
		req.setAttribute("avg", avg);
		req.setAttribute("list", list);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("id", id);
		
		if(del!=null && !del.equals("")) {
			String[] params=req.getParameterValues("checkk");
			int n=0;
			for(String i : params) {
				n=dao.delete(Integer.parseInt(i));
			}
			if(n>0) {
				req.setAttribute("msg", "삭제성공!");
				req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "삭제실패!");
				req.getRequestDispatcher("index.jsp?spage=detailinfo.jsp?mpage=review_board/list.jsp").forward(req, resp);
			}
		}
		
		req.setAttribute("vo", vo);
		req.setAttribute("image", img);
		req.getRequestDispatcher("/index.jsp?spage=detailinfo.jsp").forward(req, resp);
	}
}
