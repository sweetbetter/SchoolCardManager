package com.exam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter("/EncodingFilter")

@WebFilter(urlPatterns = { "/*" })
public class CheckLoginFilter implements Filter {

    public CheckLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1.强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getRequestURI();
		//System.out.println("请求路径："+path);
		// 2.1判断当前用户是否登录
		//如果是登陆界面就放行..  包含css也放行
		 if (path.indexOf("/login") > -1 ||path.indexOf("css") > -1)
		 {
				chain.doFilter(request, response);
	     }
		 else if(req.getSession().getAttribute("id")==null)
		{
			//跳转到登陆界面
			resp.sendRedirect("/schoolCardManager/AdminView/login.jsp");
		}else {
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
