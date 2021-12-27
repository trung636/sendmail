package com.spring.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "mail")
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "sendtime")
	private String sendTime;

	@Column(name = "sendcontend")
	private String sendContend;

	@Column(name = "sendto")
	private String sendTo;

	@Column(name = "sendfrom")
	private String sendFrom;

	@Column(name = "unable")
	private int unable;

	@Column(name = "subject")
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendContend() {
		return sendContend;
	}

	public void setSendContend(String sendContend) {
		this.sendContend = sendContend;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSendFrom() {
		return sendFrom;
	}

	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}

	public int getUnable() {
		return unable;
	}

	public void setUnable(int unable) {
		this.unable = unable;
	}

}
