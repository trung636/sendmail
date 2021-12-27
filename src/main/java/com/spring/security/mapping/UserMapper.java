package com.spring.security.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.security.dto.UserDTO;
import com.spring.security.model.User;

@Component
public class UserMapper implements IMapping<User, UserDTO> {

	@Autowired
	public ModelMapper modelMapper;

	@Override
	public UserDTO toDTO(User t) {
		return modelMapper.map(t, UserDTO.class);
	}

	@Override
	public User toEntity(UserDTO d) {
		return modelMapper.map(d, User.class);
	}

}
