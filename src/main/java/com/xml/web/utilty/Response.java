package com.xml.web.utilty;

import org.springframework.http.HttpStatus;

public class Response {

	private String responseType;
	private String responseCode;
	private String responseMsg;
	private HttpStatus statusCode;
	private String timestamp;

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Response [responseType=" + responseType + ", responseCode=" + responseCode + ", responseMsg="
				+ responseMsg + ", statusCode=" + statusCode + ", timestamp=" + timestamp + "]";
	}
}
