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
			// �α��� �������� �̵�
		}
		
		String iNumNullCheck = req.getParameter("iNum");
		
		// ��ٱ��� ���
		if (iNumNullCheck != null) {
			
			int iNum = Integer.parseInt(req.getParameter("iNum"));
			int sbCnt = Integer.parseInt(req.getParameter("sbCnt"));
			int n = dao.insert(id, iNum, sbCnt);
			if (n > 0) {
				// ��ٱ��� ��� ����
			} else {
				// ��ٱ��� ��� ����
			}
		}
		// ��ٱ��� ��ȸ
		else {
			ArrayList<ShoppingBasket_ItemsVo> list = dao.selectAll(id);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/basket/basket.jsp").forward(req, resp);
		}
		
		
	}
}
