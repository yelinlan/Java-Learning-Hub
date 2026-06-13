package com.yll.springbootbase.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "people")
public class People {
	//单独导入某一个的方式
	@Email
	private String name;
	private int age;
	private Boolean happy;
	private Date birth;
	private Map<String,Object> maps;
	private List<Object> lists;
	private Dog dog;
}