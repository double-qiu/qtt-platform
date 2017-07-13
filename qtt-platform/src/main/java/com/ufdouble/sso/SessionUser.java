package com.ufdouble.sso;

public class SessionUser {
	
	private String sessionIndex;
    private String username;
    private String uid;
    private String ticket;
    
    public SessionUser(){}
    
	public SessionUser(String sessionIndex, String username, String uid, String ticket) {
		super();
		this.sessionIndex = sessionIndex;
		this.username = username;
		this.uid = uid;
		this.ticket = ticket;
	}

	public SessionUser(String sessionIndex, String username, String uid) {
		this.sessionIndex = sessionIndex;
		this.username = username;
		this.uid = uid;
	}
	public String getSessionIndex() {
		return sessionIndex;
	}
	public void setSessionIndex(String sessionIndex) {
		this.sessionIndex = sessionIndex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
