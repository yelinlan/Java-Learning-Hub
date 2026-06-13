package com.yll;

import com.yll.pojo.People;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@项目名称: learnspring
 *@类名称: MyTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/21 19:54
 **/
public class MyTest {
	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		People people = (People) context.getBean("people");
		people.getCat().shout();
		people.getDog().shout();
	}
}