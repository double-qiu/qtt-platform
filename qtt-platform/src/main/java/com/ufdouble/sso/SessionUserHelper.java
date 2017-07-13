package com.ufdouble.sso;

import javax.servlet.http.HttpSession;

import com.kcfy.platform.common.model.SessionUserVO;
import com.ufdouble.constant.Constants;
import com.ufdouble.sso.SessionUser;
public class SessionUserHelper {

//	public static void buildSessionUser(Saml2SignResponse saml2SignResponse, HttpSession session) {
//		SessionUser sessionUser = new SessionUser(saml2SignResponse.getSessionIndex(), saml2SignResponse.getUsername(), saml2SignResponse.getUid());
//		session.setAttribute(Constants.SESSION_USER, sessionUser);
//		buildSessionUserVO(sessionUser, session);
//	}

	public static void buildSessionUser(SessionUser sessionUser, HttpSession session) {
		session.setAttribute(Constants.SESSION_USER, sessionUser);
		buildSessionUserVO(sessionUser, session);
	}

	private static void buildSessionUserVO(SessionUser sessionUser, HttpSession session) {
		SessionUserVO sessionUserVO = new SessionUserVO();
		sessionUserVO.setId(sessionUser.getUid());
		sessionUserVO.setNatureName(sessionUser.getUsername());
		sessionUserVO.setUserName(sessionUser.getUsername());
		session.setAttribute(com.kcfy.platform.client.Constants.CLIENT_SESSION_NAME, sessionUserVO);
	}

	public static SessionUser getUser(HttpSession session) {
		Object user = session.getAttribute(Constants.SESSION_USER);
		return user == null ? null : (SessionUser) user;
	}

}
