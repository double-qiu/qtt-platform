package com.ufdouble.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: WebServiceCallAction  
 * (WebService客户端调用专用接口，拦截接口调用失败异常)
 * @author zhangtian  
 * @version
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceCallAction {

}
