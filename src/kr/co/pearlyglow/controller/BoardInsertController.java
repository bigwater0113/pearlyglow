package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.peralyglow.DAO.BoardDao;
import kr.co.pearlyglow.vo.QnABoardVo;

@WebServlet("/Board/insert")
public class BoardInsertController extends HttpServlet{
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
		
		String id = mr.getParameter("i_id");
		int inum=0;
		
		if(mr.getParameter("i_num")!=null && !(mr.getParameter("i_num").equals(""))) {
			inum =Integer.parseInt(mr.getParameter("i_num"));
		}
		String qCategory = mr.getParameter("i_qCategory");
		String qTitle = mr.getParameter("i_qTitle");
		String content = mr.getParameter("i_content");
		String pwd = null;
		if(req.getParameter("pwd")!=null) {
			pwd = mr.getParameter("pwd");
		}
		int ref=0;
		int lev=0;
		int step=0;
		QnABoardVo vo = new QnABoardVo(0, id, inum, qCategory, qTitle, pwd, content, orgfileName, savefileName, null, null, null, ref, lev, step);
		BoardDao dao = new BoardDao();
		int n = dao.insert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.getRequestDispatcher("/Board/result.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String ibnum = req.getParameter("ibnum");
		String id = req.getParameter("id");
		String ans = req.getParameter("ans");
		int num=0;
		int ref=0;
		int lev=0;
		int step=0;
		if(ibnum!=null && !ibnum.equals("")) { // 답글인경우
			num=Integer.parseInt(ibnum);
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
			step=Integer.parseInt(req.getParameter("step"));
		}
		QnABoardVo vo = new QnABoardVo(num, id, 0, null, null, null, null, null, null, null, ans, null, ref, lev, step);
		BoardDao dao=new BoardDao();
		int n = dao.insert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
	}
}
