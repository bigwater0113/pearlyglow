package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;
import kr.co.pearlyglow.vo.join.Reviewboard_Purchase_pDetail_ItemsVo;
import kr.co.peralyglow.DAO.ReviewboardDao;
import kr.co.peralyglow.DAO.itemsDAO;

@WebServlet("/detailInfoController")
public class DetailInfoController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		itemsDAO dao = itemsDAO.getInstance();
		ReviewboardDao dao1=ReviewboardDao.getInstance();
		int iNum = Integer.parseInt(req.getParameter("iNum"));
		boolean a=true;
		ItemsVo vo = dao.select(iNum);
		Items_imageVo img = dao.selectImg(iNum);
		
//		System.out.println(vo.getiName());
		
		String spageNum=req.getParameter("pageNum");
		String id=(String)req.getSession().getAttribute("id");
//		String id="admin";
		String del=req.getParameter("reviewlist_delete");
		String rsDesc=req.getParameter("reviewlist_desc");
		String rsAsc=req.getParameter("reviewlist_asc");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*5+1;
		int endRow=startRow+4;
		
		ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> list=dao1.rList(rsDesc,rsAsc,startRow,endRow,id);
		int pageCount=(int)Math.ceil(dao1.getCount()/5.0);
		int startPageNum=(pageNum-1)/5*5+1; 
		int endPageNum=startPageNum+4;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		System.out.println(iNum);
		double avg=dao1.getAvg(iNum);
		System.out.println(avg);
		req.setAttribute("avg", avg);
		req.setAttribute("list", list);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("id", id);
		req.setAttribute("inum", iNum);
		
		System.out.println(req.getParameterValues("checkk"));
		
		if(del!=null && !del.equals("")) {
			String[] params=req.getParameterValues("checkk");
			int n=0;
			for(String i : params) {
				n=dao1.deleteRb(Integer.parseInt(i));
			}
				if(n>0) {
					req.setAttribute("msg", "��������!");
				}else {
					req.setAttribute("msg", "��������!");
				}
			a=false;
//			System.out.println(iNum);
//			req.getRequestDispatcher("/detailInfoController?iNum=4").forward(req, resp);
			
			resp.sendRedirect(req.getContextPath()+"/detailInfoController?iNum="+iNum);
	
		}
		
		//�ֱٺ� ��ǰ ��Ű �ֱ�
		int cookieCnt=0;
		String[] names=new String[5];
		Cookie[] cooks=req.getCookies();
		if(cooks!=null){
		for(Cookie cook:cooks){
			String name=cook.getName();
			if(name.startsWith(id+"item")){
				names[cookieCnt++]=name;
			}
		}
		if(cookieCnt==5){
			Cookie c=new Cookie(names[0],null);
			c.setPath("/");
			c.setMaxAge(0);
			resp.addCookie(c);
		}
		}
		String item=URLEncoder.encode(""+iNum,"utf-8");
		Cookie cookie=new Cookie(id+"item"+iNum,item);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*365);//��Ű ���� 1��
		resp.addCookie(cookie);
		
		
		
		
		
		req.setAttribute("vo", vo);
		req.setAttribute("image", img);
		
		if(a) {
			req.getRequestDispatcher("/index.jsp?spage=detailinfo.jsp?").forward(req, resp);
		}
	
	}
}
