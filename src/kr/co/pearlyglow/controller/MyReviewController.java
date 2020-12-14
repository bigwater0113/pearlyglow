package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import kr.co.pearlyglow.vo.join.MyReviewVo;
import kr.co.peralyglow.DAO.myReviewDao;
@WebServlet("/MyReview")
public class MyReviewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status=req.getParameter("status");
		myReviewDao dao=myReviewDao.getInstance();
		ArrayList<MyReviewVo> list=dao.MR_list();
		if(status==null || status.equals("")) {
			req.setAttribute("respStatus", "1");
			req.setAttribute("list", list);
			req.getRequestDispatcher("index.jsp?spage=myPage/myPage.jsp&mpage=myReview.jsp").forward(req, resp);
		}
		if(status.equals("1")) {
			resp.setContentType("text/xml;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print("<result>");
			for(MyReviewVo vo:list) {
				pw.print("<review>");
				pw.print("<id>" + vo.getId() + "</id>");
				pw.print("<pNum>" + vo.getpNum() + "</pNum>");
				pw.print("<pStatus>" + vo.getpStatus() + "</pStatus>");
				pw.print("<pDate>" + vo.getpDate() + "</pDate>");
				pw.print("<pdNum>" + vo.getPdNum() + "</pdNum>");
				pw.print("<iNum>" + vo.getiNum() + "</iNum>");
				pw.print("<iName>" + vo.getiName() + "</iName>");
				pw.print("<iThumbnail>" + vo.getiThumbnail() + "</iThumbnail>");
				pw.print("<pCnt>" + vo.getpCnt() + "</pCnt>");
				pw.print("<pPay>" + vo.getpPay() + "</pPay>");
				pw.print("<score>" + vo.getScore() + "</score>");
				pw.print("<rbContent>" + vo.getRbContent() + "</rbContent>");
				pw.print("<saveName>" + vo.getSaveName() + "</saveName>");
				pw.print("<rDate>" + vo.getrDate() + "</rDate>");
				pw.print("</review>");
			}
			pw.print("</result>");
			pw.close();
		}else if(status.equals("2")) {
			JSONArray arr=new JSONArray();
			for(MyReviewVo vo:list) {
				JSONObject json=new JSONObject();
				json.put("id", vo.getId());
				json.put("pNum", vo.getpNum());
				json.put("pStatus", vo.getpStatus());
				json.put("pDate", vo.getpDate());
				json.put("pdNum", vo.getPdNum());
				json.put("iNum", vo.getiNum());
				json.put("iName", vo.getiName());
				json.put("iThumbnail", vo.getiThumbnail());
				json.put("pCnt", vo.getpCnt());
				json.put("pPay", vo.getpPay());
				json.put("score", vo.getScore());
				json.put("rbContent", vo.getRbContent());
				json.put("saveName", vo.getSaveName());
				json.put("rDate", vo.getrDate());
				arr.put(json);
			}
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print(arr.toString());
			pw.close();
		}
	}
}
