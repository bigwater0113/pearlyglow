package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.peralyglow.DAO.LoginDao;


@WebServlet("/Member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("l_id");
		String pwd= req.getParameter("l_pwd");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id",id);
		map.put("pwd",pwd);
		LoginDao dao = new LoginDao();
		boolean a = dao.isMember(map);
		if(a) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath()+"/index.jsp?spage=Member/main.jsp");
		}else {
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 맞지 않아요!");
			req.getRequestDispatcher("/index.jsp?spage=Member/login.jsp").forward(req, resp);
		}
	}
}
