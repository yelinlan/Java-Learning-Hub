package com.yll;

import com.yll.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@项目名称: learnspring
 *@类名称: MyTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 0:18
 **/
public class MyTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}

}