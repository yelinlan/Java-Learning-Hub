package com.yll.controller;

import com.yll.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *@项目名称: learnspringmvc
 *@类名称: UserController
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 21:16
 **/
@Controller
@RequestMapping("/user")
public class UserController {
	//@RequestParam要求名字必须一致，否则报错，与mybatis @param注解类似
	@GetMapping("/name")
	public String getName(@RequestParam("username") String name, Model model){
		model.addAttribute("msg",name);
		return "welcome";
	}
	@GetMapping("/add")
	public String add(User user,Model model){
		model.addAttribute("msg",user);
		return "welcome";
	}

}