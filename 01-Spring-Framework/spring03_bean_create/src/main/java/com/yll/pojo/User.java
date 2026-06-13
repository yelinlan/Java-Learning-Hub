package com.yll.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;

	public User() {
		System.out.println("User无参构造");
	}

	public User(String name) {
		this.name = name;
		System.out.println("User有参构造");
	}

	public void show() {
		System.out.println("name= " + name);
	}

}