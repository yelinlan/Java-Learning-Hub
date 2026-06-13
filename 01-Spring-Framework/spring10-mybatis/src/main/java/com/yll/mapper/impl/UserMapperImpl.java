package com.yll.mapper.impl;

import com.yll.mapper.UserMapper;
import com.yll.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 *@项目名称: learnspring
 *@类名称: UserMapperImpl
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 12:43
 **/
public class UserMapperImpl implements UserMapper {

	private SqlSessionTemplate sessionTemplate;

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public List<User> selectUser() {
		UserMapper mapper = sessionTemplate.getMapper(UserMapper.class);
		return mapper.selectUser();
	}
}