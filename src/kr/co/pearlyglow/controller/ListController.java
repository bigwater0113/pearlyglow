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

@WebServlet("/Member/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MembersDao dao=new MembersDao();
		ArrayList<MembersVo> list=dao.list();
		
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index.jsp?spage=Member/list.jsp").forward(req, resp);
	}
}
