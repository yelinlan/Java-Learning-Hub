package com.yll.mapper.impl;

import com.yll.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperImplTest {

	@Test
	public void selectUser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context.getBean("userMapper", UserMapper.class).selectUser());
	}
}