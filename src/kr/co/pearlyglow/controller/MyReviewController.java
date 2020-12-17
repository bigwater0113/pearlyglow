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
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null && !(spageNum.equals(""))){
			pageNum=Integer.parseInt(spageNum);
		}
//		int startRow=(pageNum-1)*10+1;
//		int endRow=startRow+9;
		int startRow=pageNum;
		int endRow=startRow;
		myReviewDao dao=myReviewDao.getInstance();
		ArrayList<MyReviewVo> list=dao.MR_list();
		list=dao.MR_list_BA(status,startRow,endRow);
//			int pageCount=(dao.getCount(status)/10)+1;
		int pageCount=dao.getCount(status);
		int startPageNum=(pageNum-1)/10*10+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		if(status.trim()==null || status.trim().equals("")) {
//			req.setAttribute("respStatus", "1");
			req.setAttribute("list", list);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("startPageNum", startPageNum);
			req.setAttribute("endPageNum", endPageNum);
			req.getRequestDispatcher("index.jsp?spage=myPage/myPage.jsp&mpage=myReview.jsp").forward(req, resp);
		}
		if(status.equals("1")) {
			list=dao.MR_list_BA(status,startRow,endRow);
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
			pw.print("<pageDiv>");
			pw.print("<pageNum>" + pageNum + "</pageNum>");
			pw.print("<pageCount>" + pageCount + "</pageCount>");
			pw.print("<startPageNum>" + startPageNum + "</startPageNum>");
			pw.print("<endPageNum>" + endPageNum + "</endPageNum>");
			pw.print("</pageDiv>");
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
			JSONObject respJson=new JSONObject();
			respJson.put("arr", arr);
			respJson.put("pageNum", pageNum);
			respJson.put("pageCount", pageCount);
			respJson.put("startPageNum", startPageNum);
			respJson.put("endPageNum", endPageNum);
			resp.setContentType("text/plain;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print(respJson.toString());
			pw.close();
		}
	}
}
