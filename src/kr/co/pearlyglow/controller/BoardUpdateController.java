package kr.co.pearlyglow.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.peralyglow.DAO.BoardDao;
import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.QnABoardVo;




@WebServlet("/Board/update")
public class BoardUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("ibnum"));
		BoardDao dao=new BoardDao();
		QnABoardVo vo = dao.getinfo(num);
		req.setAttribute("board", vo);
		ArrayList<ItemsVo> list = dao.iNumList();
		req.setAttribute("list",list);
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null || id.equals("")) {
			req.getRequestDispatcher("../index.jsp?spage=Board/updateForm.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.getRequestDispatcher("../index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/updateForm.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("../index.jsp?spage=myPage/myPage.jsp&mpage=../Board/updateForm.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		ServletContext cxt = getServletContext();
		String saveDir=cxt.getRealPath("/Board/upload");
		MultipartRequest mr=new MultipartRequest(
					req, saveDir, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy()
		);
		String orgfileName=mr.getOriginalFileName("i_file");
		String savefileName=mr.getFilesystemName("i_file");
		System.out.println(saveDir);
		
		int num=Integer.parseInt(mr.getParameter("u_ibnum"));
		BoardDao dao=new BoardDao();
		int inum=0;
		if(mr.getParameter("i_num")!=null && !(mr.getParameter("i_num").equals(""))) {
			inum =Integer.parseInt(mr.getParameter("i_num"));
			
		}
		String qCategory = mr.getParameter("u_qCategory");
		String qTitle = mr.getParameter("u_qTitle");
		int ref = Integer.parseInt(mr.getParameter("u_ref"));
		int lev = Integer.parseInt(mr.getParameter("u_lev"));
		int step = Integer.parseInt(mr.getParameter("u_step"));
		QnABoardVo vo = new QnABoardVo(num, mr.getParameter("u_id"), inum, qCategory, qTitle, mr.getParameter("u_pwd"), mr.getParameter("u_content"), orgfileName, savefileName, null, null, null, ref, lev, step);
		int n =dao.update(vo);
		if(n>0) {
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("id");
			req.getRequestDispatcher("/Board/list").forward(req, resp);
		}else {
			req.setAttribute("code","fail");
			HttpSession session = req.getSession(true);
			String id = (String)session.getAttribute("id");
			if(id==null || id.equals("")) {
				req.getRequestDispatcher("/index.jsp?spage=Board/result.jsp").forward(req, resp);
			}else if(id.equals("admin")) {
				req.getRequestDispatcher("/index.jsp?spage=sellerPage/sellerPage.jsp&mpage=../Board/result.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/index.jsp?spage=myPage/myPage.jsp&mpage=../Board/result.jsp").forward(req, resp);
			}
		}
	}
}
