package com.yll.mapper;

import com.yll.mapper.impl.UserMapperSupportImpl;
import com.yll.pojo.User;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class UserMapperTest {

	@Test
	public void selectUser() throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-mybatis.xml");
		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		System.out.println(userMapper.selectUser());
		UserMapper mapper = context.getBean("userMapperSupport", UserMapper.class);
		System.out.println(mapper.selectUser());

	}
}