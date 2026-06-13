package com.yll.proxy.javaproxy;

import com.yll.proxy.service.UserService;
import com.yll.proxy.service.impl.UserServiceImpl;

public class JdkProxyTest {

	public static void main(String[] args) {
		System.out.println("*JDK动态代理*");
		/*基于接口和实现类*/
		//创建被代理的实例对象
		UserService service = new UserServiceImpl();
		//创建InvocationHandler对象
		ProxyInvocationHandler proxy = new ProxyInvocationHandler();
		//设置要代理的对象
		proxy.setTarget(service);
		//动态生成代理类
		UserService renterProxy = (UserService) proxy.getProxy();

		 renterProxy.add();

		 //基于接口
		InterfaceInvocationHandler<UserService> proxy2 = new InterfaceInvocationHandler<>(UserService.class);
		UserService renterProxy2 =  proxy2.getProxy();
		renterProxy2.add();

	}

}
