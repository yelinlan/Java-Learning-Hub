package com.yll.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*等价于<aop:aspect ref="myLog"></aop:aspect>*/
@Aspect
public class AnnotionPointCut {

	/*
	*等价于<aop:before method="before" pointcut-ref="point"/>
	* <aop:pointcut id="point" expression="execution(* com.yll.service.UserService.*(..))"/>
	* */
	@Before("execution(* com.yll.service.UserService.*(..))")
	public void before(){
		System.out.println("=========注解方式：方法执行前========");
	}

	@After("execution(* com.yll.service.UserService.*(..))")
	public void after(){
		System.out.println("=========注解方式：方法执行后========");
	}

	@Around("execution(* com.yll.service.UserService.*(..))")
	public void around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("=========注解方式：环绕前========");
		Object proceed = point.proceed();
		System.out.println("=========注解方式：环绕后========");
	}

}