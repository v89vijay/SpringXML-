package com.xml.web.exception;

import org.springframework.stereotype.Component;

@Component
public class XMLException extends RuntimeException {

	private static final long serialVersionUID = -3061200203220014375L;

	private String excpMessage;

	public String getExcpMessage() {
		return excpMessage;
	}

	public void setExcpMessage(String excpMessage) {
		this.excpMessage = excpMessage;
	}

	@Override
	public String toString() {
		return "XMLException [excpMessage=" + excpMessage + "]";
	}
}
