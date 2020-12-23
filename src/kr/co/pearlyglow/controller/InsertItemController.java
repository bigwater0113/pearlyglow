package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.StockDao;
import kr.co.peralyglow.DAO.insertItemDAO;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/insertItemController")
public class InsertItemController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String saveDir = req.getServletContext().getRealPath("/basket/upload");
		insertItemDAO dao = insertItemDAO.getInstance();
		StockDao sDao = StockDao.getInstance();
		itemsDAO iDao = itemsDAO.getInstance();
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
		int total = Integer.parseInt(mr.getParameter("total"));
		String bodyText = mr.getParameter("bodyText");
		String caution = mr.getParameter("caution");
		
		int items_seq_nextval = 0;
		
		// 등록일때 (수정이 아닐때)
		if (mr.getOriginalFileName("thumbnail") != null) {
			String saveFileName = mr.getFilesystemName("thumbnail");
			String savePath = saveDir = req.getContextPath() + "/basket/upload/" + saveFileName;
			items_seq_nextval = dao.insert(new ItemsVo(0, iName, iPrice, 0, iGender, iCategory, iColor, iSize, iWeight, iMaterial, iKdetail, iEdetail, savePath, total, bodyText, caution));
			sDao.insert(items_seq_nextval, 1, total);
		}
		
		String file1SavePath = null;
		String file2SavePath = null;
		String file3SavePath = null;
		
		if (mr.getOriginalFileName("file1") != null) {
			file1SavePath = saveDir = req.getContextPath() + "/basket/upload/" + mr.getFilesystemName("file1");
		}
		
		if (mr.getOriginalFileName("file2") != null) {
			file2SavePath = saveDir = req.getContextPath() + "/basket/upload/" + mr.getFilesystemName("file2");
		}
		
		if (mr.getOriginalFileName("file3") != null) {
			file3SavePath = saveDir = req.getContextPath() + "/basket/upload/" + mr.getFilesystemName("file3");
		}
		
		dao.insertImg(file1SavePath, file2SavePath, file3SavePath, items_seq_nextval);
		
		resp.sendRedirect(req.getContextPath() + "/stockController");
	}
}
