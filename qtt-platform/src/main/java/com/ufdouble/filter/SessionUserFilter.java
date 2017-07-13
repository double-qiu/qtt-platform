package com.ufdouble.filter;  

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ufdouble.sso.SessionUser;
import com.ufdouble.sso.SessionUserHelper;


public class SessionUserFilter implements Filter {

	static Logger logger = Logger.getLogger(SessionUserFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		SessionUser user = SessionUserHelper.getUser(req.getSession());
		if(user == null){
			res.sendRedirect(req.getContextPath() + "/logout.do");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
  
