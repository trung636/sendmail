package com.spring.security.utils;

public class ParseString {
	
	public static String[] toMail(String list) {
		String[] splits = list.split(",");
		return splits;
	}
}
