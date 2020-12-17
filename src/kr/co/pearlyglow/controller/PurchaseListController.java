package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.join.Items_purchase_pdetailVo;
import kr.co.peralyglow.DAO.PurchaseListDao;

@WebServlet("/purchaselist")
public class PurchaseListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		String p_date1=req.getParameter("purchaselist_date1");
		String p_date2=req.getParameter("purchaselist_date2");
//		String id=(String)req.getSession().getAttribute("id");
		String id="test";
		String saveDir=req.getServletContext().getRealPath("/img");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		PurchaseListDao dao=PurchaseListDao.getInstance();
		
		ArrayList<Items_purchase_pdetailVo> list=dao.pList(startRow,endRow,p_date1,p_date2,id);
		int pageCount=(int)Math.ceil(dao.getCount(p_date1,p_date2,id)/10.0);
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
		req.getRequestDispatcher("index.jsp?spage=myPage/myPage.jsp&mpage=../purchase_list/purchaselist.jsp").forward(req, resp);
//		req.getRequestDispatcher("/purchase_list/purchaselist.jsp").forward(req, resp);
		
		}
	}
