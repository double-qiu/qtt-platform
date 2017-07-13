package com.ufdouble.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * ClassName: SpringContext  
 * (获取Bean容器对象)
 * @author zhangtian  
 * @version
 */
public class SpringContext implements ServletContextListener {
	private static WebApplicationContext springContext;

	 @Override
	 public void contextDestroyed(ServletContextEvent event) {

	 }

	 @Override
	 public void contextInitialized(ServletContextEvent event) {
	  springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	 }

	 public static WebApplicationContext getSpringContext() {
	  return springContext;
	 }

	 public static Object getBean(String name) {
	  return springContext.getBean(name);
	 }

	 public static <T> T getBean(Class<T> clazz) {
	  return springContext.getBean(clazz);
	 }
}
