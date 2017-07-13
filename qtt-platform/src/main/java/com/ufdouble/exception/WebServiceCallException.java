package com.ufdouble.exception;

/**
 * ClassName: WebServiceCallException  
 * (自定义异常)
 * @author zhangtian  
 * @version
 */
public class WebServiceCallException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public WebServiceCallException() {
		super() ;
	}
	
	public WebServiceCallException(String errorInfo) {
		super(errorInfo) ;
	}
}
