package com.yll;

import com.yll.pojo.Student;
import com.yll.pojo.Worker;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@项目名称: learnspring
 *@类名称: MyTest
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/21 17:37
 **/
public class MyTest {

	@Test
	public void testDi(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student);
	}

	/**
	 * <ul>
	 * <li>方法名： testPNameSpace </li>
	 * <li>功能描述： 测试p命名空间 本质set注入</li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/21 18:13   </li>
	 * </ul>
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testPNameSpace(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("workerbeans.xml");
		Worker worker = (Worker) context.getBean("worker");
		System.out.println(worker);
	}

	/**
	 * <ul>
	 * <li>方法名： testCNameSpace </li>
	 * <li>功能描述：测试c命名空间 本质constructor注入  </li>
	 * <li>创建人  夜林蓝    </li>
	 * <li>创建时间    2022/11/21 18:17   </li>
	 * </ul>
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testCNameSpace(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("workerbeans.xml");
		Worker worker = (Worker) context.getBean("worker1");
		System.out.println(worker);
	}

}