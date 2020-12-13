package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.insertItemDAO;

@WebServlet("/insertItemController")
public class InsertItemController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String saveDir = req.getServletContext().getRealPath("/basket/upload");
		insertItemDAO dao = insertItemDAO.getInstance();
		MultipartRequest mr = new MultipartRequest(req, saveDir, 1024 * 1024 * 10, "utf-8",
				new DefaultFileRenamePolicy());
		

		String iName = mr.getParameter("i_name");
		int iPrice = Integer.parseInt(mr.getParameter("i_price"));
		String iGender = mr.getParameter("i_gender");
		String iCategory = mr.getParameter("i_category");
		String iColor = mr.getParameter("i_color");
		int iWeight = Integer.parseInt(mr.getParameter("i_weight"));
		String iSize = mr.getParameter("i_size");
		String iMaterial = mr.getParameter("i_material");
		String iKdetail = mr.getParameter("i_kdetail");
		String iEdetail = mr.getParameter("i_edetail");

		int items_seq_nextval = dao.insert(new ItemsVo(0, iName, iPrice, iGender, iCategory, iColor, iSize, iWeight, iMaterial, iKdetail, iEdetail));
		
		Enumeration<String> e = mr.getFileNames();
		while(e.hasMoreElements()){
			String file = e.nextElement();
			String saveFileName = mr.getFilesystemName(file);
			System.out.println(saveFileName);
			String savePath = saveDir = req.getContextPath() + "/basket/upload/" + saveFileName;
			dao.insertImg(savePath, items_seq_nextval);
		}
	}
}
