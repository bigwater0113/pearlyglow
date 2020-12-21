package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.MembersVo;
import kr.co.pearlyglow.vo.join.ShoppingBasket_ItemsVo;
import kr.co.peralyglow.DAO.MembersDao;
import kr.co.peralyglow.DAO.basketDAO;

@WebServlet("/orderFormController")
public class OrderFormController extends HttpServlet{
	
	basketDAO dao = basketDAO.getInstance();
	MembersDao mDao = new MembersDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] items = req.getParameterValues("item");
		String id = (String) req.getSession().getAttribute("id");
		
		MembersVo member = mDao.select(id);
		ArrayList<ShoppingBasket_ItemsVo> list = new ArrayList<ShoppingBasket_ItemsVo>();
		
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
			int sbCnt = vo.getSbCnt();
			
			list.add(new ShoppingBasket_ItemsVo(sbNum, id, iNum, sbCnt, iSale, iName, price, iGender, iCategory, color, iSize, iThumbnail, total));
		}
		
		req.setAttribute("list", list);
		req.setAttribute("member", member);
		req.getRequestDispatcher("/index.jsp?spage=orderForm.jsp").forward(req, resp);
	}
}
