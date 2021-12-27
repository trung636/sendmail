package com.spring.security.service.imp;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dto.UserDTO;
import com.spring.security.mapping.UserMapper;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper modelMapper;

	@Override
	public UserDTO save(UserDTO udto) {
		User user = modelMapper.toEntity(udto);
		User usave = userRepository.save(user);
		return modelMapper.toDTO(usave);
	}

	@Override
	public UserDTO findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		Optional<User> users = userRepository.findById(user.getId());
		UserDTO udto = null;
		if (users.isPresent()) {
			udto = modelMapper.toDTO(users.get());
		}
		return udto;
	}

	@Override
	public UserDTO logger(UserDTO udto) {

		User user = userRepository.findByEmail(udto.getEmail());
		if (user == null) {
			return null;

		}
		if (user.getPassword().equals(udto.getPassword())) {
			return modelMapper.toDTO(user);
		}

		return null;
	}

	@Override
	public String checkLogin(UserDTO u, HttpSession session) {
		User udto = userRepository.findByEmail(u.getEmail());
		session.setMaxInactiveInterval(60*60*24);
		session.setAttribute("email", udto.getEmail());
		session.setAttribute("name", udto.getUsername());
		session.setAttribute("id", udto.getId());
		session.setAttribute("phone", udto.getPhone());
		session.setAttribute("url", udto.getUrl());
		return "Success";
	}

}
