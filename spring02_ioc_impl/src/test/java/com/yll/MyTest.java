package com.yll;

import com.yll.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@项目名称: learnspring
 *@类名称: MyTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/21 15:57
 **/
public class MyTest {

	@Test
	public void testBean(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Hello bean = (Hello) context.getBean("myHello");
		System.out.println(bean);
	}

}