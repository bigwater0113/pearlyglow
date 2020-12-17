package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/stockController")
public class StockController extends HttpServlet{
	
	itemsDAO dao = itemsDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		
		/*
		if (!id.equals("admin")) {
			// 되돌아가기
		}
		*/
		
		ArrayList<ItemsVo> list = dao.selectAll();
		req.setAttribute("list", list);
		//req.getRequestDispatcher("/seller/stockControll.jsp").forward(req, resp);
		req.getRequestDispatcher("/seller/stockControll.jsp").forward(req, resp);
	}
}
