package com.yll.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component注解等价于<bean class="com.yll.pojo.User" id="user"/>
@Component
@Data
@Scope(value = "singleton")//可以手动配置单例
public class User {
	// @Value注解相当于<property name="name" value="大仙女林有有"/>
	@Value(value = "大仙女林有有")
	private String name;
}