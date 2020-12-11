package kr.co.pearlyglow.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recentView")
public class RecentViewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cooks = req.getCookies();
		if (cooks != null) {
			String[] values = new String[5];
			boolean find = false;
			int index = 0;
			for (Cookie cook : cooks) {
				String name = cook.getName();
				String value = cook.getValue();
				if (name.startsWith("item")) {
					find = true;
					value = URLDecoder.decode(value, "utf-8");
					values[index++] = value;
				}
			}
			req.setAttribute("values", values);
			req.setAttribute("find", find);
			req.getRequestDispatcher("index.jsp?spage=myPage.jsp&mpage=recentView.jsp").forward(req, resp);
		}
	}
}
