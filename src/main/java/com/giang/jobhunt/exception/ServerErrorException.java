package com.giang.jobhunt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1902018638154569943L;
	private static final String message = "Sorry, the server has some errors. We will fix them as soon as possible.";

	public ServerErrorException() {
		super(message);
	}

}
