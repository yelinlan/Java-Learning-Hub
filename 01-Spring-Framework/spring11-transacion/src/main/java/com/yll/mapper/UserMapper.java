package com.yll.mapper;


import com.yll.pojo.User;

import java.util.List;

public interface UserMapper {

	List<User> selectUser();
	int insert(User user);
	int delete(String name);

}