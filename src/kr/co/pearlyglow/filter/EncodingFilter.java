package kr.co.pearlyglow.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * [ Filter ]
 * - 클라이언트의 요청을 중간에 가로채서 요청페이지로 가기전에 특정작업을 수행함
 *   수행 후 요청페이지로 갈 수도 있고 필터에서 다른페이지로 이동도 가능하다.
 * - 만드는 방법
 *   1) Filter인터페이스를 상속받아 doFilter메소드에서 처리할 작업을 구현한다. // import javax.servlet.Filter;
 *   2) web.xml에 필터매핑을 설정하거나 또는 어노테이션으로 설정한다.
 */
public class EncodingFilter implements Filter{
	String encoding=null;
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(encoding!=null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			response.setContentType("text/xml;charset="+encoding);
		}else {
			//인코딩하기
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setContentType("text/xml;charset=utf-8");
		}
		//다음에 실행할 필터가 있으면 수행하고 없으면 클라이언트가 요청한 페이지로 이동
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//web.xml에 설정된 초기화 파라미터값 읽어오기
		encoding=filterConfig.getInitParameter("encoding");
	}

}
