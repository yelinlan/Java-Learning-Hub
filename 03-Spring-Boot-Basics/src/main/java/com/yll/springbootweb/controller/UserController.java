package com.yll.springbootweb.controller;

import com.yll.springbootweb.pojo.User;
import com.yll.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public List<User> getList(){
		return userService.getList();
	}

}