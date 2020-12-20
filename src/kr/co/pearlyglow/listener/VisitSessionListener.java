package kr.co.pearlyglow.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import kr.co.peralyglow.DAO.VisitCountDao;

public class VisitSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		visitCnt(se);
	}

	public void visitCnt(HttpSessionEvent se) {
		VisitCountDao dao=VisitCountDao.getInstance();
		dao.setTotalCnt();
		int totalCnt=dao.getTotalCnt();
		int todayCnt=dao.getTodayCnt();
		HttpSession session=se.getSession();
		session.setAttribute("totalCnt", totalCnt);
		session.setAttribute("todayCnt", todayCnt);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
