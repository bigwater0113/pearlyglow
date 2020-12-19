package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.join.MyDeliveryVo;
import kr.co.peralyglow.DAO.myDeliveryDao;
@WebServlet("/MyDelivery")
public class MyDeliveryController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		int pNum=Integer.parseInt(req.getParameter("pNum"));
		myDeliveryDao dao=myDeliveryDao.getInstance();
		MyDeliveryVo vo=dao.select(id, pNum);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("index.jsp?spage=myPage/myPage.jsp&mpage=myDelivery.jsp").forward(req, resp);
		
	}
}
