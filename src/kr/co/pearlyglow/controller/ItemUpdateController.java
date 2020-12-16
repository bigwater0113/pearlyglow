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
	
	itemsDAO dao = itemsDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		
		ItemsVo vo = dao.select(iNum);
		req.setAttribute("vo", vo);
		req.setAttribute("work", "update");
		req.getRequestDispatcher("/seller/insertItem.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		String iName = req.getParameter("i_name");
		int iPrice = Integer.parseInt(req.getParameter("i_price"));
		String iGender = req.getParameter("i_gender");
		String iCategory = req.getParameter("i_category");
		String iColor = req.getParameter("i_color");
		int iWeight = Integer.parseInt(req.getParameter("i_weight"));
		String iSize = req.getParameter("i_size");
		String iMaterial = req.getParameter("i_material");
		String iKdetail = req.getParameter("i_kdetail");
		String iEdetail = req.getParameter("i_edetail");
		int total = Integer.parseInt(req.getParameter("total"));
		
		int n = dao.update(new ItemsVo(iNum, iName, iPrice, 0, iGender, iCategory, iColor, iSize, iWeight, iMaterial, iKdetail, iEdetail, null, total));
		
		resp.sendRedirect(req.getContextPath() + "/stockController");
	}
}
