package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/QuickView")
public class QuickViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		itemsDAO dao = itemsDAO.getInstance();
		int iNum = Integer.parseInt(req.getParameter("iNum"));

		ItemsVo vo = dao.select(iNum);
		Items_imageVo img = dao.selectImg(iNum);
//		req.setAttribute("vo", vo);
//		req.setAttribute("image", img);
//		req.getRequestDispatcher("/index.jsp?spage=main.jsp&ppage=quickView.jsp").forward(req, resp);
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<result>");
		pw.print("<ItemsVo>");
		pw.print("<iNum>"+vo.getiNum()+"</iNum>");
		pw.print("<iName>"+vo.getiName()+"</iName>");
		pw.print("<price>"+vo.getPrice()+"</price>");
		pw.print("<iSale>"+vo.getiSale()+"</iSale>");
		pw.print("<iGender>"+vo.getiGender()+"</iGender>");
		pw.print("<iCategory>"+vo.getiCategory()+"</iCategory>");
		pw.print("<color>"+vo.getColor()+"</color>");
		pw.print("<iSize>"+vo.getiSize()+"</iSize>");
		pw.print("<weight>"+vo.getWeight()+"</weight>");
		pw.print("<material>"+vo.getMaterial()+"</material>");
		pw.print("<kDetail>"+vo.getkDetail()+"</kDetail>");
		pw.print("<eDetail>"+vo.geteDetail()+"</eDetail>");
		pw.print("<iThumbnail>"+vo.getiThumbnail()+"</iThumbnail>");
		pw.print("<total>"+vo.getTotal()+"</total>");
		pw.print("<bodyText>"+vo.getBodyText()+"</bodyText>");
		pw.print("<caution>"+vo.getCaution()+"</caution>");
		pw.print("</ItemsVo>");
		pw.print("<Items_imageVo>");
		pw.print("<imgNum>"+img.getImgNum()+"</imgNum>");
		pw.print("<iNum>"+img.getiNum()+"</iNum>");
		pw.print("<file1>"+img.getFile1()+"</file1>");
		pw.print("<file2>"+img.getFile2()+"</file2>");
		pw.print("<file3>"+img.getFile3()+"</file3>");
		pw.print("</Items_imageVo>");
		pw.print("</result>");
	}
}
