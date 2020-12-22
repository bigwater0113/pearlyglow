package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.pearlyglow.vo.ReviewBoardVo;
import kr.co.peralyglow.DAO.ReviewboardDao;
@WebServlet("/insert.do")
public class Reviewboard_InsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String saveDir=req.getServletContext().getRealPath("/review_board/upload");
		
		MultipartRequest mr=new MultipartRequest(
				req,
				saveDir,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		String orgfileName=mr.getOriginalFileName("insert_addfile");
		String savefileName=mr.getFilesystemName("insert_addfile");
		int pdnum=Integer.parseInt(mr.getParameter("insert_pdnum"));
		int score=Integer.parseInt(mr.getParameter("insert_score"));
		String content=mr.getParameter("insert_content");
		ReviewBoardVo vo=new ReviewBoardVo(0,pdnum,score,content,orgfileName,savefileName,null);
		ReviewboardDao dao=ReviewboardDao.getInstance();
		int n=dao.insert(vo);
		session.setAttribute("reviewDir", saveDir);
		if(n>0) {
			req.getRequestDispatcher("/MyReview?status=").forward(req, resp);
		}else {
			req.getRequestDispatcher("index.jsp?spage=review_board/insert.jsp").forward(req, resp);
		}
	}
}
