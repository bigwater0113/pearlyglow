package kr.co.pearlyglow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.peralyglow.DAO.DeliveryDAO;
import kr.co.peralyglow.DAO.PurchaseDao;
import kr.co.peralyglow.DAO.StockDao;
import kr.co.peralyglow.DAO.basketDAO;
import kr.co.peralyglow.DAO.itemsDAO;
import kr.co.peralyglow.DAO.pDetailDao;

@WebServlet("/orderController")
public class OrderController extends HttpServlet{
	
	StockDao sDao = StockDao.getInstance();
	itemsDAO iDao = itemsDAO.getInstance();
	basketDAO bDao = basketDAO.getInstance();
	PurchaseDao pDao = PurchaseDao.getInstance();
	pDetailDao pdDao = pDetailDao.getInstance();
	DeliveryDAO dDao = new DeliveryDAO();
	
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
		
		
		int pTotal = 0;
		
		for (String total : pTotalArray) {
			pTotal += Integer.parseInt(total);
		}
		
		// ���ų������̺� �߰�
		int purchaseNextVal = pDao.insertAndReturnSeqVal(id, receiver, receiverEmail, receiverPhone, pAddress, pWay, pTotal);
		// ����������̺� �߰�
		int n4 = dDao.insert(purchaseNextVal);
		
		int n1=0, n2=0, n3=0;
		
		for (int i=0; i<iNumArray.length; i++) {
			
			int iNum = Integer.parseInt(iNumArray[i]);
			int sbCnt = Integer.parseInt(sbCntArray[i]);
			int price = Integer.parseInt(priceArray[i]);
			
			// ������̺� �߰� (���)
			n1 = sDao.insert(iNum, 2, sbCnt);
			// ��ǰ���̺� ���� (�� ����)
			n2 = iDao.updateTotal(iNum, sbCnt);
			// ���ų��� �����̺� �߰�
			n3 = pdDao.insert(purchaseNextVal, iNum, sbCnt, price * sbCnt);

		}
		
		if (n1>0 && n2>0 && n3>0 && n4>0) {
			// ��ٱ��Ͽ��� ������ ��ٱ��Ͽ� �ֹ��� ��ǰ ����
			if (req.getParameterValues("sbNum") != null && !req.getParameterValues("sbNum").equals("")) {
				String[] sbNums = req.getParameterValues("sbNum");
				
				for (String sb : sbNums) {
					int sbNum = Integer.parseInt(sb);
					bDao.delete(sbNum);
				}
			}
			resp.sendRedirect(req.getContextPath() + "/orderSucessPage.jsp");
		} else {
			// ������������ �̵�
		}
		
	}
}
