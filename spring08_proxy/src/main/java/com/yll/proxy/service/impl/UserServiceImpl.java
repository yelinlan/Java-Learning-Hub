package com.yll.proxy.service.impl;

import com.yll.proxy.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public void add() {
		System.out.println("新增了一条数据");
	}

	@Override
	public void del() {
		System.out.println("删除了一条数据");
	}

	@Override
	public void update() {
		System.out.println("更新了一条数据");
	}

	@Override
	public void query() {
		System.out.println("查询了一条数据");
	}
}