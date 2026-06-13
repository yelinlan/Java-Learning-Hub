package com.yll.springbootweb.mapper;

import com.yll.springbootweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *@项目名称: springbootweb
 *@类名称: UserMapper
 *@类描述:
 *@创建人: yll
 *@创建时间: 2022/12/6 23:20
 **/
@Mapper
public interface UserMapper {

	List<User> getList();


}