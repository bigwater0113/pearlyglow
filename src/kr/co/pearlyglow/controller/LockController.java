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

@WebServlet("/Member/lock")
public class LockController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MembersDao dao=new MembersDao();
		ArrayList<MembersVo> list=dao.lock();
		
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index.jsp?spage=Member/lock.jsp").forward(req, resp);
	}
}
