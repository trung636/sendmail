package com.spring.security.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.security.dto.MailDTO;
import com.spring.security.model.Mail;

@Component
public class MailMapper implements IMapping<Mail, MailDTO> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MailDTO toDTO(Mail t) {
		return modelMapper.map(t, MailDTO.class);
	}

	@Override
	public Mail toEntity(MailDTO d) {
		return modelMapper.map(d, Mail.class);
	}

}
