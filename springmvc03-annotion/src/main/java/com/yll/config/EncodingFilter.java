package com.yll.config;

import javax.servlet.*;
import java.io.IOException;

/**
 *@项目名称: learnspringmvc
 *@类名称: EncodingFilter
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/22 21:51
 **/
public class EncodingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		filterChain.doFilter(req,resp);
	}
}