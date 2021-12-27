package com.spring.security.service;

import java.util.List;

import com.spring.security.dto.MailDTO;

public interface MailService {

	void insert(MailDTO dto);

	List<MailDTO> getListMail(int i);

	void senMail();

	void senMailNow(MailDTO mdto);

	MailDTO getMailById(int id);

	void deleteEmployeeById(int id);

}
