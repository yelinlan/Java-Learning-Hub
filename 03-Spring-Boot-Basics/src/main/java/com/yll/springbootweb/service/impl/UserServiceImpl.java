package com.yll.springbootweb.service.impl;

import com.yll.springbootweb.mapper.UserMapper;
import com.yll.springbootweb.pojo.User;
import com.yll.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getList() {
		return userMapper.getList();
	}
}