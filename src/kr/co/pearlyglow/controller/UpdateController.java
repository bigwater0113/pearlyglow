package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.MembersVo;
import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MembersDao dao=new MembersDao();
		MembersVo vo = dao.getinfo(id);
		
		req.setAttribute("member", vo);
		req.getRequestDispatcher("/index.jsp?spage=Member/updateForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		MembersDao dao=new MembersDao();
		MembersVo vo = new MembersVo(req.getParameter("u_id"), req.getParameter("u_pwd"), null, null, null, req.getParameter("u_email"), req.getParameter("u_phone"), req.getParameter("u_addr"), req.getParameter("u_issleep"), null);
		int n =dao.update(vo);
		if(n>0) {
			req.setAttribute("code", "success");
			//resp.sendRedirect(req.getContextPath()+"/Member/list");
		}else {
			req.setAttribute("code","fail");
		}
		req.getRequestDispatcher("/index.jsp?spage=Member/result.jsp").forward(req, resp);
	}
}
