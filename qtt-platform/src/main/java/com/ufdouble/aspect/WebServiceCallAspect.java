package com.ufdouble.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ufdouble.exception.WebServiceCallException;


/**
 * ClassName: WebServiceCallAspect  
 * (接口调用异常拦截切面)
 * @author zhangtian  
 * @version
 */
@Component
@Aspect
public class WebServiceCallAspect {
	
	@Pointcut("@annotation(com.ufdouble.annotation.WebServiceCallAction)")
	public void callInterfacePointCut(){}
	
	@AfterThrowing(pointcut = "callInterfacePointCut()", throwing = "callError")
	public void cutException(JoinPoint joinPoint, WebServiceCallException callError) {
		String className = joinPoint.getTarget().getClass().getName() ;
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature() ;
		String methodName = methodSignature.getName() ;
		callError = new WebServiceCallException("执行类"+className+"的"+methodName+"方法，调用webservice接口异常，接口通信故障！") ;
		callError.printStackTrace();
	}
}
