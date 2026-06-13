package com.yll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@项目名称: learnspringmvc
 *@类名称: EncodingController
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 21:45
 **/
@Controller
@RequestMapping("/encoding")
public class EncodingController {

	@PostMapping("/str")
	public String str(String str, Model model){
		model.addAttribute("msg",str);
		return "welcome";
	}

}