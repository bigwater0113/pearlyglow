package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.PurchaseDao;
import kr.co.peralyglow.DAO.StockDao;
import kr.co.peralyglow.DAO.itemsDAO;
import kr.co.peralyglow.DAO.pDetailDao;

@WebServlet("/orderController")
public class OrderController extends HttpServlet{
	
	StockDao sDao = StockDao.getInstance();
	itemsDAO iDao = itemsDAO.getInstance();
	PurchaseDao pDao = PurchaseDao.getInstance();
	pDetailDao pdDao = pDetailDao.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] iNumArray = req.getParameterValues("iNum");
		String[] sbCntArray = req.getParameterValues("sbCnt");
		String[] priceArray = req.getParameterValues("price");
		String[] pTotalArray = req.getParameterValues("pTotal");
		String id = (String) req.getSession().getAttribute("id");
		String receiver = req.getParameter("receiverName");
		String receiverEmail = req.getParameter("rEmail1") + req.getParameter("rEmail2");
		String receiverPhone = req.getParameter("rPhone1") + req.getParameter("rPhone2") + req.getParameter("rPhone3");
		String pAddress = req.getParameter("rAddr");
		String pWay = req.getParameter("way");
		
		for (int i=0; i<iNumArray.length; i++) {
			
			int iNum = Integer.parseInt(iNumArray[i]);
			int sbCnt = Integer.parseInt(sbCntArray[i]);
			int price = Integer.parseInt(priceArray[i]);
			int pTotal = Integer.parseInt(pTotalArray[i]);
			
			// 재고테이블 추가 (출고)
			sDao.insert(iNum, 2, sbCnt);
			// 상품테이블 수정 (총 수량)
			iDao.updateTotal(iNum, sbCnt);
			// 구매내역테이블 추가
			int purchaseNextVal = pDao.insertAndReturnSeqVal(id, receiver, receiverEmail, receiverPhone, pAddress, pWay, pTotal);
			// 구매내역 상세테이블 추가
			pdDao.insert(purchaseNextVal, iNum, sbCnt, price);
		}
		
		
		
	}
}
