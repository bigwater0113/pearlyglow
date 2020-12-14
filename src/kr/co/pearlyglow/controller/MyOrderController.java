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
		myOrderDao dao=myOrderDao.getInstance();
		ArrayList<MyOrder_Purchase_ItemsVo> list=dao.PI_list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp?spage=myPage.jsp&mpage=myOrder.jsp").forward(req, resp);
	}
}
