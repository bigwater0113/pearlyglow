package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.pearlyglow.vo.join.ShoppingBasket_ItemsVo;
import kr.co.peralyglow.DAO.basketDAO;

@WebServlet("/basketController")
public class basketController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// test
		session.setAttribute("id", "dlgmlrnjs09");
		
		basketDAO dao = basketDAO.getInstance();
		String id = (String) session.getAttribute("id");
		
		
		if (id == null) {
			// 로그인 페이지로 이동
		}
		
		String iNumNullCheck = req.getParameter("iNum");
		
		// 장바구니 담기
		if (iNumNullCheck != null) {
			
			int iNum = Integer.parseInt(req.getParameter("iNum"));
			int sbCnt = Integer.parseInt(req.getParameter("sbCnt"));
			int n = dao.insert(id, iNum, sbCnt);
			if (n > 0) {
				// 장바구니 담기 성공
			} else {
				// 장바구니 담기 실패
			}
		}
		// 장바구니 조회
		else {
			ArrayList<ShoppingBasket_ItemsVo> list = dao.selectAll(id);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/basket/basket.jsp").forward(req, resp);
		}
		
		
	}
}
