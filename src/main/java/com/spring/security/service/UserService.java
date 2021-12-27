package com.spring.security.service;


import javax.servlet.http.HttpSession;

import com.spring.security.dto.UserDTO;

public interface UserService {

	String checkLogin(UserDTO udto, HttpSession session);
	
	UserDTO save(UserDTO udto);

	UserDTO findByEmail(String email);
	
	UserDTO logger(UserDTO udto);
}
