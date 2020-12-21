package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.SalesDataVo;
import kr.co.peralyglow.DAO.SalesDao;
@WebServlet("/sales")
public class SalesController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calendar calendar=Calendar.getInstance();
		int year=2020;
		int month=12;
		int currentDay=0;
//		System.out.println(calendar.get(calendar.YEAR));
//		System.out.println(calendar.get(calendar.MONTH)+1);
//		System.out.println(calendar.get(calendar.DAY_OF_MONTH));
		int currentYear=calendar.get(calendar.YEAR);
		int currentMonth=calendar.get(calendar.MONTH)+1;
		if(year==currentYear && month==currentMonth) {
			currentDay=calendar.get(calendar.DAY_OF_MONTH);
		}else {
			calendar.set(calendar.YEAR, year);
			calendar.set(calendar.MONTH, month-1);
			currentDay=calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		}
		ArrayList<SalesDataVo> list=new ArrayList<SalesDataVo>();
		SalesDao dao=SalesDao.getInstance();
		for(int day=1;day<=currentDay;day++) {
			String sDate=year+"/"+month+"/"+day;
			int earring=dao.getSalesMonth("earring","", year, month,day);
			int bracelet=dao.getSalesMonth("bracelet","", year, month,day);
			int necklace=dao.getSalesMonth("necklace","", year, month,day);
			int ring=dao.getSalesMonth("ring","", year, month,day);
			int man=dao.getSalesMonth("","M", year, month,day);
			int woman=dao.getSalesMonth("","W", year, month,day);
			int total=dao.getSalesMonth("","", year, month,day);
			list.add(new SalesDataVo(sDate,earring, bracelet, necklace, ring, man, woman, total));
		}
		req.setAttribute("salesData", list);
		req.getRequestDispatcher("index.jsp?spage=sellerPage/sellerPage.jsp&mpage=sales.jsp").forward(req, resp);
	}
}
