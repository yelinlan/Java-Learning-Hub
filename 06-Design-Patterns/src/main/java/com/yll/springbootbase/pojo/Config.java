package com.yll.springbootbase.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Config {
	@Value("${spring.name}")
	private String appName;
	@Value("${server.port}")
	private int port;
}