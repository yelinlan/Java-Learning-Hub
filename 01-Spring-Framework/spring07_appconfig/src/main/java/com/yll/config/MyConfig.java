package com.yll.config;

import com.yll.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//等价于 <beans >
//    	<bean class="com.yll.pojo.People" id="people"/>
//		</beans>


@Configuration
//@ComponentScan("com.yll.pojo")//手动扫描包，会有默认值，可不写这个注解
public class MyConfig {

	//默认id = getUser
	@Bean
	public User getUser(){
		return new User();
	}

}