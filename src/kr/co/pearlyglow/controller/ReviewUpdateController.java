package kr.co.pearlyglow.controller;

import java.io.File;
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
@WebServlet("/review_board/update")
public class ReviewUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pdNum=Integer.parseInt(req.getParameter("pdNum"));
		ReviewboardDao dao=ReviewboardDao.getInstance();
		ReviewBoardVo vo=dao.reviewInfo(pdNum);
		req.setAttribute("vo", vo);
		req.setAttribute("isUpdate", true);
		req.getRequestDispatcher("../index.jsp?spage=review_board/insert.jsp&pdNum="+pdNum).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir=req.getServletContext().getRealPath("/review_board/upload");
		ReviewboardDao dao=ReviewboardDao.getInstance();
		MultipartRequest mr=new MultipartRequest(
				req,
				saveDir,
				1024*1014*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		int pdNum=Integer.parseInt(mr.getParameter("insert_pdnum"));
		int score=Integer.parseInt(mr.getParameter("insert_score"));
		String rbContent=mr.getParameter("insert_content");
		String orgfileName=mr.getOriginalFileName("insert_addfile");
		String savefileName=mr.getFilesystemName("insert_addfile");
		if(orgfileName!=null) {
			ReviewBoardVo infoVo=dao.reviewInfo(pdNum);
			new File(saveDir + File.separator + infoVo.getSaveName()).delete();
		}
		ReviewBoardVo vo=new ReviewBoardVo(0, pdNum, score, rbContent, orgfileName, savefileName, null);
		int n=dao.update(vo);
		if(n>0) {
			req.getRequestDispatcher("../MyReview?status=").forward(req, resp);
		}else {
			req.getRequestDispatcher("../index.jsp?spage=review_board/insert.jsp&pdNum="+pdNum).forward(req, resp);
		}
	}
}
