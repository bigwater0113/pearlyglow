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
	
	// 검색 X, 전체 목록 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("id");
		
		/*
		if (!id.equals("admin")) {
			// 되돌아가기
		}
		*/
		
		String tpage = req.getParameter("page");
		
		int page = 0;
		int startItemNum = 0;
		int endItemNum = 0;
		int startPageNum = 0;
		int endPageNum = 0;
		int maxPageNum = 0;
		
		if (tpage != null && !tpage.equals("")) {
			page = Integer.parseInt(req.getParameter("page"));
		} else {
			page = 1;
		}
		
		startItemNum = (page * 10) - 9;
		endItemNum = startItemNum + 9;
		maxPageNum = (int) Math.ceil(dao.getTotalMaxNum() / 10.0);
		startPageNum = (page - 1) / 10 * 10 + 1;
		endPageNum = startPageNum + 9;
		if (endPageNum > maxPageNum) {
			endPageNum = maxPageNum;
		}
		
		ArrayList<ItemsVo> list = dao.selectAll();
		ArrayList<String> colorList = dao.selectOptionList("color");
		ArrayList<String> materialList = dao.selectOptionList("material");
		req.setAttribute("list", list);
		req.setAttribute("colorList", colorList);
		req.setAttribute("materialList", materialList);
		req.setAttribute("page", page);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("maxPageNum", maxPageNum);
		req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../seller/stockControll.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchCategory = req.getParameter("searchCategory");
		String searchGender = req.getParameter("searchGender");
		String searchColor = req.getParameter("searchColor");
		String searchMaterial = req.getParameter("searchMaterial");
		String searchStock = req.getParameter("searchStock");
		String searchText = req.getParameter("searchText");
		
		ArrayList<ItemsVo> list = dao.selectSearchItems(searchCategory, searchGender, searchColor, searchMaterial, searchStock, searchText);
		req.setAttribute("list", list);
		req.setAttribute("searchCategory", searchCategory);
		req.setAttribute("searchGender", searchGender);
		req.setAttribute("searchColor", searchColor);
		req.setAttribute("searchMaterial", searchMaterial);
		req.setAttribute("searchStock", searchStock);
		req.setAttribute("searchText", searchText);
		req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../seller/stockControll.jsp").forward(req, resp);
	}
}
