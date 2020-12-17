package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/detailInfoController")
public class DetailInfoController extends HttpServlet{
	
	itemsDAO dao = itemsDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		
		ItemsVo vo = dao.select(iNum);
		Items_imageVo img = dao.selectImg(iNum);
		
		req.setAttribute("vo", vo);
		req.setAttribute("image", img);
		req.getRequestDispatcher("/index.jsp?spage=detailinfo.jsp").forward(req, resp);
	}
}
