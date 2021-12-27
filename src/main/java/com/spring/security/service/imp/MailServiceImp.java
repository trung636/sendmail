package com.spring.security.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.security.dto.MailDTO;
import com.spring.security.mapping.MailMapper;
import com.spring.security.model.Mail;
import com.spring.security.repository.MailRepository;
import com.spring.security.service.MailService;
import com.spring.security.utils.DateTimeFormat;
import com.spring.security.utils.ParseString;

@Service
public class MailServiceImp implements MailService {

	@Autowired
	private JavaMailSender getJavaMailSender;

	@Autowired
	private MailMapper mailMapper;

	@Autowired
	private MailRepository mailRepository;

	@Override
	@Scheduled(cron = "30 * * * * ?", zone = "Asia/Saigon")
	public void senMail() {

		List<MailDTO> lists = getListMail(1);

		if (lists == null) {
			return;
		}

		for (MailDTO mail : lists) {

			String timeSend = mail.getSendTime();
			System.out.println("date :" + timeSend);
			String result = new DateTimeFormat().now();
			System.out.println("result :" + result);
			if (timeSend.equals(result)) {

				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("trung66636@gmail.com");
				message.setTo(mail.getSendTo());
				message.setSubject("Baby!, Im Real");
				message.setText(mail.getSendContend());
				this.getJavaMailSender.send(message);
				System.out.println("hello");
				mail.setUnable(0);
				mailRepository.save(mailMapper.toEntity(mail));
			} else {
				System.out.println("hi");
			}
		}

		// Send Message!
		System.out.println();

	}

	@Override
	public void insert(MailDTO maildto) {
		maildto.setUnable(1);
		Mail mail = mailMapper.toEntity(maildto);
		mailRepository.save(mail);
	}

	@Override
	public List<MailDTO> getListMail(int i) {
		List<MailDTO> dtos = new ArrayList<MailDTO>();
		List<Mail> mails = mailRepository.findAll();
		for (var l : mails) {
			if (l.getUnable() == i) {
				dtos.add(mailMapper.toDTO(l));
			}
		}
		return dtos;
	}

	@Override
	public void senMailNow(MailDTO mdto) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mdto.getSendFrom());
		message.setTo(ParseString.toMail(mdto.getSendTo()));
		message.setSubject(mdto.getSubject());
		message.setText(mdto.getSendContend());
		this.getJavaMailSender.send(message);
		mdto.setSendTime(new DateTimeFormat().now());
		mdto.setUnable(0);
		mailRepository.save(mailMapper.toEntity(mdto));

	}

	@Override
	public MailDTO getMailById(int id) {

		Optional<Mail> optional = mailRepository.findById(id);
		MailDTO dto = null;
		if (optional.isPresent()) {
			dto = mailMapper.toDTO(optional.get());
		} else {

			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return dto;
	}

	@Override
	public void deleteEmployeeById(int id) {
		mailRepository.deleteById((int) id);
	}

}
