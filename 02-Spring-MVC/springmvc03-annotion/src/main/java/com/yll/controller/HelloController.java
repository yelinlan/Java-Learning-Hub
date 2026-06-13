package com.yll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

	//走视图解析器 会拼接前后缀 prefix=/WEB-INF/  suffix=.jsp
	@GetMapping("/hello")
	public String hello() {
		return "welcome";
	}

	//不走视图解析器 不会拼接前后缀
	@GetMapping("/forward")
	public String forward() {
		return "forward:/forward.jsp";
	}
	//不走视图解析器
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/redirect.jsp";
	}
}