package com.spring.security.dto;

public class MailDTO {

	private int id;

	private String sendTime;


	private String sendContend;

	private String sendTo;

	private String subject;

	private String sendFrom;

	private int unable;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
