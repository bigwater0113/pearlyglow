package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/itemUpdateController")
public class ItemUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		itemsDAO dao = itemsDAO.getInstance();
		
		ItemsVo vo = dao.select(iNum);
		req.setAttribute("vo", vo);
		req.setAttribute("work", "update");
		req.getRequestDispatcher("/seller/insertItem.jsp").forward(req, resp);
	}
}
