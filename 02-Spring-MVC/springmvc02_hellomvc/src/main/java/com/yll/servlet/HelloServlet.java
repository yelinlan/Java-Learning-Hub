package com.yll.servlet;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@项目名称: learnspringmvc
 *@类名称: controller
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 16:01
 **/
public class HelloServlet implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String method = req.getParameter("method");
		if ("add".equals(method)) {
			modelAndView.addObject("msg", "【add】");
		}
		if ("delete".equals(method)) {
			modelAndView.addObject("msg", "【delete】");
		}
		modelAndView.setViewName("test");
		return modelAndView;
	}
}