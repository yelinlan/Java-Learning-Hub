package com.yll.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
@ToString
public class People {
	private String name;
	/*@Autowired 不需要提供set方法，就可以完成注入*/
	//会先byType注入，如果有多个相同类型，就按byName注入
	//require 默认为true,找不到bean就报错。false：找不到bean也没问题
	@Autowired(required = true)
	private Dog dog;
	//@Qualifier(value = "cat")  按指定beanid加载bean
	@Autowired()
	@Qualifier(value = "cat")
	private Cat cat;
	//@Resource() 先按名字装配，再按类型装配
	//@Autowired() 先按类型装配，再按名字装配，需配合@Qualifier()使用
}