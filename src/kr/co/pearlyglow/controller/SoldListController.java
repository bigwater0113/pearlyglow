package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.join.Items_purchase_pdetailVo;
import kr.co.peralyglow.DAO.SoldListDao;

@WebServlet("/soldlist")
public class SoldListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");
		String searchid=req.getParameter("soldlist_idsearch");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		SoldListDao dao=SoldListDao.getInstance();
		
		ArrayList<Items_purchase_pdetailVo> list=dao.sList(startRow,endRow,searchid);
		int pageCount=(int)Math.ceil(dao.getCount(searchid)/10.0);
		System.out.println(pageCount);
		int startPageNum=(pageNum-1)/10*10+1; 
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("searchid", searchid);
		req.getRequestDispatcher("index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Sold_list/soldlist.jsp").forward(req, resp);
		
		}
	}
