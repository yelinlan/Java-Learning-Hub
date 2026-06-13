package com.yll;

import com.yll.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@项目名称: learnspring
 *@类名称: MyTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/21 16:49
 **/
public class MyTest {

	@Test
	public void testPojo(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) context.getBean("userByName");
		user.show();
	}

}