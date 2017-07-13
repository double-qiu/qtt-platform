package com.ufdouble.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ufdouble.sso.SessionUser;
import com.ufdouble.sso.SessionUserHelper;


public class LogoutServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getLogger(LogoutServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		SessionUser user = SessionUserHelper.getUser(session);
		if(user != null){
			try {
				String redirectUrl="";
				session.invalidate();
				response.sendRedirect(redirectUrl);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}
	
}
