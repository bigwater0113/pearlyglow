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

@WebServlet("/itemListController")
public class ItemListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
			type = "woman";
		
		itemsDAO dao = itemsDAO.getInstance();
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();
		String url = "";
		
		if (type.equals("woman")) {
			list = dao.selectGender("W");
			url = "Woman.jsp";
		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp?spage=" + url).forward(req, resp);
	} 
}
