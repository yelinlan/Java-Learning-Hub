package com.yll.springbootbase;

import com.yll.springbootbase.pojo.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootbaseApplicationTests {
	@Autowired
	private People people;

	@Test
	void contextLoads() {
		System.out.println(people);
	}

}
