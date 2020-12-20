package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.StockSearchVo;
import kr.co.peralyglow.DAO.itemsDAO;


@WebServlet("/stockSearchController")
public class StockSearchController extends HttpServlet{
	
	itemsDAO dao = itemsDAO.getInstance();
	StockSearchVo vo = null;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tpage = req.getParameter("page");

		int page = 0;
		int startItemNum = 0;
		int endItemNum = 0;
		int startPageNum = 0;
		int endPageNum = 0;
		int maxPageNum = 0;
		
		String searchCategory = "";
		String searchGender = "";
		String searchColor = "";
		String searchMaterial = "";
		String searchStock = "";
		String searchText = "";
		
		if (tpage != null && !tpage.equals("")) {
			page = Integer.parseInt(req.getParameter("page"));
			searchCategory = vo.getSearchCategory();
			searchGender = vo.getSearchGender();
			searchColor = vo.getSearchColor();
			searchMaterial = vo.getSearchMaterial();
			searchStock = vo.getSearchStock();
			searchText = vo.getSearchText();
		} else {
			vo = new StockSearchVo();
			page = 1;
			searchCategory = req.getParameter("searchCategory");
			searchGender = req.getParameter("searchGender");
			searchColor = req.getParameter("searchColor");
			searchMaterial = req.getParameter("searchMaterial");
			searchStock = req.getParameter("searchStock");
			searchText = req.getParameter("searchText");
			vo.setSearchCategory(searchCategory);
			vo.setSearchGender(searchGender);
			vo.setSearchColor(searchColor);
			vo.setSearchMaterial(searchMaterial);
			vo.setSearchStock(searchStock);
			vo.setSearchText(searchText);
		}

		startItemNum = (page * 10) - 9;
		endItemNum = startItemNum + 9;
		maxPageNum = (int) Math.ceil(dao.getSearchMaxNum(searchCategory, searchGender, searchColor, searchMaterial, searchStock, searchText, startItemNum, endItemNum) / 10.0);
		startPageNum = (page - 1) / 10 * 10 + 1;
		endPageNum = startPageNum + 9;
		if (endPageNum > maxPageNum) {
			endPageNum = maxPageNum;
		}

		ArrayList<ItemsVo> list = dao.selectSearchItems(searchCategory, searchGender, searchColor, searchMaterial,
				searchStock, searchText, startItemNum, endItemNum);
		req.setAttribute("list", list);
		req.setAttribute("searchCategory", searchCategory);
		req.setAttribute("searchGender", searchGender);
		req.setAttribute("searchColor", searchColor);
		req.setAttribute("searchMaterial", searchMaterial);
		req.setAttribute("searchStock", searchStock);
		req.setAttribute("searchText", searchText);
		req.setAttribute("page", page);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("maxPageNum", maxPageNum);
		req.setAttribute("type", "search");
		req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../seller/stockControll.jsp")
				.forward(req, resp);
	}
}
