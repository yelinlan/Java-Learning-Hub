package com.yll.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Student {
	private String name;
	private String wife;
	private Address address;
	private String[] books;
	private List<String> hobbys;
	private Map<String, String> card;
	private Set<String> games;
	private Properties info;
}