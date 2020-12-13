package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.MembersVo;
import kr.co.peralyglow.DAO.MembersDao;

@WebServlet("/Member/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("j_id");
		String pwd1 = req.getParameter("j_pwd1");
		String pwd2 = req.getParameter("j_pwd2");
		String name= req.getParameter("j_name");
		String yy = req.getParameter("j_yy");
		String mm = req.getParameter("j_mm");
		String dd = req.getParameter("j_dd");
		String date = yy+"-"+mm+"-"+dd;
		Date birth = Date.valueOf(date);
		String gender = req.getParameter("j_gender");
		String email = req.getParameter("j_email");
		String phone = req.getParameter("j_phone");
		String addr = req.getParameter("j_addr");
		MembersVo vo = new MembersVo(id, pwd1, name, birth, gender, email, phone, addr, "N", null);
		MembersDao dao = new MembersDao();
		String resultCode="success";
		int n = dao.insert(vo);
		if(n<1) {
			resultCode="fail";
		}
		
		req.setAttribute("code", resultCode);
		req.getRequestDispatcher("/index.jsp?spage=Member/result.jsp").forward(req, resp);
	}
}
