package com.yll.proxy.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceInvocationHandler<T> implements InvocationHandler {
	//被代理类的对象
	private Class<T> target;

	public InterfaceInvocationHandler(Class<T> target) {
		this.target = target;
	}

	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, this);
	}

	/**
	 * proxy:代表动态代理对象
	 * method：代表正在执行的方法
	 * args：代表调用目标方法时传入的实参
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		//代理过程中插入其他操作
		log(method.getName());
		return "";
	}

	private void log(String name) {
		System.out.println("执行了方法："+name);
	}


}
