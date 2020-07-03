package com.xml.web.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.xml.web.exception.XMLException;
import com.xml.web.utilty.Response;

@ControllerAdvice
public class ExcpController {

	@ExceptionHandler(value = XMLException.class)
	public ResponseEntity<Response> getExcp(XMLException xmlException) {
		Timestamp instant = Timestamp.from(Instant.now());
		System.out.println("time===" + instant);
		Response response = new Response();
		response.setResponseType("Error");

		response.setResponseCode("SAX Exception");

		response.setResponseMsg(xmlException.getExcpMessage());

		response.setStatusCode(HttpStatus.BAD_REQUEST);

		response.setTimestamp(instant.toString());
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}
}
