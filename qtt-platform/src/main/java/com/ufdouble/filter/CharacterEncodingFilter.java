package com.ufdouble.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CharacterEncodingFilter implements Filter {

	private String encoding;

	private boolean forceEncoding = false;

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		String forceEncodingStr = config.getInitParameter("forceEncoding");
		if (StringUtils.isNotBlank(forceEncodingStr)) {
			forceEncoding = Boolean.parseBoolean(forceEncodingStr);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
				response.setCharacterEncoding(this.encoding);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
