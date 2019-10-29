package com.in.om;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MyFilter1
 */
@WebFilter("/OrderServlet")
public class MyFilter1 implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		// �����������ڳ�ʼ��ʱ���ã���������һЩ��ʼ������
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// ���������û�����������͵�ǰ������������·��ƥ�䣬�÷����ᱻ����
		HttpServletRequest request =(HttpServletRequest)req;
		String username = (String) request.getSession().getAttribute("username");
		if(username ==null){
			request.getRequestDispatcher("/login.jsp").forward(request, resp);
			return;
		}
		else{
			request.getRequestDispatcher("/order.jsp").forward(request, resp);
}
		chain.doFilter(request, resp);
	}

	public void destroy() {
		// ����������������ʱ�Զ����ã��ͷ���Դ
	}
}
