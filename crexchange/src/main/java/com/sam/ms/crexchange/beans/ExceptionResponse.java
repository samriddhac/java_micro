package com.sam.ms.crexchange.beans;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private Date time;
	private String description;
	
	public ExceptionResponse(String message, Date time, String description) {
		super();
		this.message = message;
		this.time = time;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", time=" + time + ", description=" + description + "]";
	}
}
