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
@WebServlet("/Main")
public class MainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		itemsDAO dao=itemsDAO.getInstance();
		ArrayList<ItemsVo> list=dao.selectAll(1,6);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp?spage=main.jsp").forward(req, resp);
		
	}
}
