package kr.co.pearlyglow.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import kr.co.pearlyglow.vo.join.ShoppingBasket_ItemsVo;
import kr.co.peralyglow.DAO.basketDAO;

@WebServlet("/basketController")
public class basketController extends HttpServlet{
	
	basketDAO dao = basketDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
	
		String id = (String) session.getAttribute("id");

		
		if (id == null) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp?spage=Member/login.jsp");
		} else {
			
			String iNumNullCheck = req.getParameter("iNum");
			
			// ��ٱ��� ���
			if (iNumNullCheck != null) {
				int iNum = Integer.parseInt(req.getParameter("iNum"));
				int sbCnt = Integer.parseInt(req.getParameter("sbCnt"));
				int n = dao.insert(id, iNum, sbCnt);
				
				JSONObject json = new JSONObject();
				
				// ��ٱ��� ��� ����
				if (n > 0) {
					json.put("result", "true");
				}
				// ��ٱ��� ��� ����
				else {
					json.put("result", "false");
				}
				
				resp.setContentType("text/plain; charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print(json);
			}
			// ��ٱ��� ��ȸ
			else {
				ArrayList<ShoppingBasket_ItemsVo> list = dao.selectAll(id);
				req.setAttribute("list", list);
				req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../basket/basket.jsp").forward(req, resp);
			}
		}
	}
	
	// ��ٱ��� ����
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] params = req.getParameterValues("item");
		int n = 0;
		
		for (String i : params) {
			n = dao.delete(Integer.parseInt(i));
		}
		
		resp.sendRedirect(req.getContextPath() + "/basketController");
	}
}
