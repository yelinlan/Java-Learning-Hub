package com.yll.mapper.impl;

import com.yll.mapper.UserMapper;
import com.yll.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 *@项目名称: learnspring
 *@类名称: UserMapperSupportImpl
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 12:48
 **/
public class UserMapperSupportImpl extends SqlSessionDaoSupport implements UserMapper {
	@Override
	public List<User> selectUser() {
		return getSqlSession().getMapper(UserMapper.class).selectUser();
	}
}