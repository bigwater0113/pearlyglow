package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.MembersVo;
import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/info")
public class InfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MembersDao dao=new MembersDao();
		String id = req.getParameter("id");
		MembersVo vo=dao.getinfo(id);
		req.setAttribute("vo",vo);
		req.getRequestDispatcher("/index.jsp?spage=Member/mypage.jsp").forward(req, resp);
	}
}
