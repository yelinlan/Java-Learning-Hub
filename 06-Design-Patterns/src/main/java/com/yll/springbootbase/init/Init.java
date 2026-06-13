package com.yll.springbootbase.init;

import com.yll.springbootbase.pojo.Config;
import com.yll.springbootbase.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *@项目名称: springbootbase
 *@类名称: Init
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/25 18:48
 **/
@Component
@Order(value=2)
public class Init implements CommandLineRunner {

	@Autowired
	private People people;
	@Autowired
	private Config config;


	/**
	 * Callback used to run the bean.
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------读取配置的yml--------------");
		System.out.println(config);
		System.out.println(people);
		System.out.println("----------------读取完成--------------");
	}
}