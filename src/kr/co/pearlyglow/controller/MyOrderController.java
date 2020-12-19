package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.join.MyOrder_Purchase_ItemsVo;
import kr.co.peralyglow.DAO.myOrderDao;
@WebServlet("/myOrder")
public class MyOrderController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		String id=(String)req.getSession().getAttribute("id");
		int pDate=Integer.parseInt(req.getParameter("pDate"));
		int pageNum=1;
		if(spageNum!=null && !(spageNum.equals(""))){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
//		int startRow=pageNum;
//		int endRow=startRow;
		myOrderDao dao=myOrderDao.getInstance();
		ArrayList<MyOrder_Purchase_ItemsVo> list=dao.PI_list(id,pDate,startRow,endRow);
		int pageCount=(dao.getCount(id,pDate)/10)+1;
//		int pageCount=dao.getCount(id);
		int startPageNum=(pageNum-1)/10*10+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.getRequestDispatcher("index.jsp?spage=myPage/myPage.jsp&mpage=myOrder.jsp").forward(req, resp);
	}
}
