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
public class ItemListController extends HttpServlet {

	itemsDAO dao = itemsDAO.getInstance();

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
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
		
		startItemNum = (page * 12) - 11;
		endItemNum = startItemNum + 11;

		if (type.equals("woman")) {
			ArrayList<ItemsVo> list = dao.selectGenderPageContents(startItemNum, endItemNum, "W");
			maxPageNum = (int) Math.ceil(dao.getGenderMaxNum("W") / 12.0);
			req.setAttribute("list", list);
		}else if (type.equals("man")) {
			ArrayList<ItemsVo> list = dao.selectGenderPageContents(startItemNum, endItemNum, "M");
			maxPageNum = (int) Math.ceil(dao.getGenderMaxNum("M") / 12.0);
			req.setAttribute("list", list);
		} else if (type.equals("earring")) {
			ArrayList<ItemsVo> list = dao.selectCategoryPageContents(startItemNum, endItemNum, "earring");
			maxPageNum = (int) Math.ceil(dao.getCategoryMaxNum("earring") / 12.0);
			req.setAttribute("list", list);
		} else if (type.equals("bracelet")) {
			ArrayList<ItemsVo> list = dao.selectCategoryPageContents(startItemNum, endItemNum, "bracelet");
			maxPageNum = (int) Math.ceil(dao.getCategoryMaxNum("bracelet") / 12.0);
			req.setAttribute("list", list);
		} else if (type.equals("necklace")) {
			ArrayList<ItemsVo> list = dao.selectCategoryPageContents(startItemNum, endItemNum, "necklace");
			maxPageNum = (int) Math.ceil(dao.getCategoryMaxNum("necklace") / 12.0);
			req.setAttribute("list", list);
		} else if (type.equals("ring")) {
			ArrayList<ItemsVo> list = dao.selectCategoryPageContents(startItemNum, endItemNum, "ring");
			maxPageNum = (int) Math.ceil(dao.getCategoryMaxNum("ring") / 12.0);
			req.setAttribute("list", list);
		}
		
		startPageNum = (page - 1) / 10 * 10 + 1;
		endPageNum = startPageNum + 9;
		if (endPageNum > maxPageNum) {
			endPageNum = maxPageNum;
		}


		req.setAttribute("page", page);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("maxPageNum", maxPageNum);
		req.setAttribute("type", type);
		req.getRequestDispatcher("/index.jsp?spage=itemList.jsp").forward(req, resp);
	}
}
