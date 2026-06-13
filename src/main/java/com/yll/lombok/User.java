package com.yll.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 *@项目名称: proxy_practice
 *@类名称: User
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/11/17 22:50
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String uid;
	private String name;
	private String sex;
}