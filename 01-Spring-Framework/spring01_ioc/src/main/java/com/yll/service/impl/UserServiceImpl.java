package com.yll.service.impl;

import com.yll.dao.UserDao;
import com.yll.dao.impl.UserDaoImpl;
import com.yll.service.UserService;

public class UserServiceImpl implements UserService {

	//1、自行创建对象(像是硬编码),当需求复杂时，会频繁修改这段代码，创建不同对象。不利于解耦，并且具有侵入性
	//private final UserDao userDao = new UserDaoImpl();
	//2、不再自行创建对象，对象由调用接口传入，【动态】实现对象的改变。需求变化时，不需要修改代码，实现解耦
	//减少了代码侵入性，减少了频繁修改代码的工作量
	//3、整个过程对象的创建由service方法实现者变为了service方法调用者，发生了180度的转变。即控制反转(IOC)
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void getUser() {
		userDao.getUser();
	}
}