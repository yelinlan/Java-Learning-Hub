package com.yll.service.impl;

import com.yll.dao.impl.UserDaoImpl;
import com.yll.dao.impl.UserDaoMysqlImpl;
import com.yll.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {

	@Test
	public void getUser() {
		//未使用spring管理bean,需要手动创建对象
		//UserServiceImpl userService = new UserServiceImpl();
		//userService.setUserDao(new UserDaoMysqlImpl());
		//userService.getUser();

		//使用spring管理bean，spring帮我们创建对象
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService bean = (UserService) context.getBean("userService");
		bean.getUser();
	}
}