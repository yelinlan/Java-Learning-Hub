package com.yll.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BeforeLog implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("默认切面：请求信息：");
		System.out.println("method = " + method + ", args = " + Arrays.deepToString(args) + ", target = " + target);
	}
}