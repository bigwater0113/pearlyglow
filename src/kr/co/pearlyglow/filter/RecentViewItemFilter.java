package kr.co.pearlyglow.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.peralyglow.DAO.itemsDAO;

public class RecentViewItemFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		Cookie[] cooks = req.getCookies();
		if (cooks != null) {
			itemsDAO dao = itemsDAO.getInstance();
			ArrayList<ItemsVo> list=new ArrayList<ItemsVo>();
//			String[] values = new String[5];
//			int index = 0;
			for (Cookie cook : cooks) {
				String name = cook.getName();
				String value = cook.getValue();
				if (name.startsWith("item")) {
					value = URLDecoder.decode(value, "utf-8");
					System.out.println(value);
//					values[index++]=value;
					if(value!=null) {
						ItemsVo vo = dao.select(Integer.parseInt(value));
						list.add(vo);
					}
				}
			}
			session.setAttribute("recentViewItem", list);
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
