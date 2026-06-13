package com.yll.mapper.impl;

import com.yll.mapper.UserMapper;
import com.yll.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
	@Override
	public List<User> selectUser() {
		int insert = insert(User.builder().name("黄敏").pwd("123").build());
		int a =1/0;
		delete("黄敏");
		return getSqlSession().getMapper(UserMapper.class).selectUser();
	}

	@Override
	public int insert(User user) {
		return getSqlSession().getMapper(UserMapper.class).insert(user);
	}

	@Override
	public int delete(String name) {
		return getSqlSession().getMapper(UserMapper.class).delete(name);
	}
}