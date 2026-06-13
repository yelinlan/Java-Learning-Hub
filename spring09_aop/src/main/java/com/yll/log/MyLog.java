package com.yll.log;

public class MyLog {
	public void before(){
		System.out.println("自定义切面方式：执行前");
	}
	public void after(){
		System.out.println("自定义切面方式：执行后");
	}
}