package com.yll.nolombok;

import java.util.Objects;

/**
 *@项目名称: proxy_practice
 *@类名称: User
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/17 22:50
 **/
public class User {

	private String uid;
	private String name;
	private String sex;

	public User() {
	}

	public User(String uid, String name, String sex) {
		this.uid = uid;
		this.name = name;
		this.sex = sex;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(uid, user.uid) && Objects.equals(name, user.name) && Objects.equals(sex, user.sex);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid, name, sex);
	}
}