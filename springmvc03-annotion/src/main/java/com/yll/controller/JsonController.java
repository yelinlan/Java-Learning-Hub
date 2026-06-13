package com.yll.controller;

import cn.hutool.json.JSONUtil;
import com.yll.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/json")
public class JsonController {

	@ResponseBody//不走视图解析器 返回字符串
	@GetMapping("getUserJson")
	public String getUserJson() {
		User user = new User(1, "李四", "123");
		return JSONUtil.toJsonStr(user);
	}

}