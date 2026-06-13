package com.yll.servlet;


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
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if ("add".equals(method)) {
			req.getSession().setAttribute("msg", "【add】");
		}
		if ("delete".equals(method)) {
			req.getSession().setAttribute("msg", "【delete】");
		}
		try {
			req.getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}