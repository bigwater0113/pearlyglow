package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.MembersVo;
import kr.co.pearlyglow.vo.join.ShoppingBasket_ItemsVo;
import kr.co.peralyglow.DAO.MembersDao;
import kr.co.peralyglow.DAO.basketDAO;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/orderFormController")
public class OrderFormController extends HttpServlet{
	
	basketDAO dao = basketDAO.getInstance();
	itemsDAO iDao = itemsDAO.getInstance();
	MembersDao mDao = new MembersDao();
	
	//detailInfo에서 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		int[] sbCnt = {Integer.parseInt(req.getParameter("sbCnt"))};
		String id = (String) req.getSession().getAttribute("id");
		//int price = Integer.parseInt(req.getParameter("price"));
		
		MembersVo member = mDao.select(id);
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();
		ItemsVo vo = iDao.select(iNum);
		list.add(vo);
		
		req.setAttribute("list", list);
		req.setAttribute("sbCnt", sbCnt);
		req.setAttribute("member", member);
		req.getRequestDispatcher("/index.jsp?spage=orderForm.jsp").forward(req, resp);
	}
	
	//장바구니에서 이동
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] items = req.getParameterValues("item");
		String id = (String) req.getSession().getAttribute("id");
		int[] sbCntArray = Arrays.stream(req.getParameterValues("sbCnt")).mapToInt(Integer::parseInt).toArray();
		
		MembersVo member = mDao.select(id);
		ArrayList<ShoppingBasket_ItemsVo> list = new ArrayList<ShoppingBasket_ItemsVo>();
		
		int sbCnt = 0;
		int i = 0;
		for (String item : items) {
			int sbNum = Integer.parseInt(item);
			ShoppingBasket_ItemsVo vo = dao.select(id, sbNum);
			int iNum = vo.getiNum();
			int iSale = vo.getiSale();
			String iName = vo.getiName();
			int price = vo.getPrice();
			String iGender = vo.getiGender();
			String iCategory = vo.getiCategory();
			String color = vo.getColor();
			String iSize = vo.getiSize();
			String iThumbnail = vo.getiThumbnail();
			int total = vo.getTotal();
			sbCnt = vo.getSbCnt();
			
			list.add(new ShoppingBasket_ItemsVo(sbNum, id, iNum, sbCnt, iSale, iName, price, iGender, iCategory, color, iSize, iThumbnail, total));
		}
		
		req.setAttribute("list", list);
		req.setAttribute("member", member);
		req.setAttribute("sbCnt", sbCntArray);
		req.setAttribute("before", "basket");
		req.getRequestDispatcher("/index.jsp?spage=orderForm.jsp").forward(req, resp);
	}
}
