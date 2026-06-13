package com.yll.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AfterLog implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("默认切面：返回信息：");
		System.out.println(
				"returnValue = " + returnValue + ", method = " + method + ", args = " + Arrays.deepToString(args)
						+ ", target = " + target);
	}
}