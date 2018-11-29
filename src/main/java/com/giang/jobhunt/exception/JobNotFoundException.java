package com.giang.jobhunt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JobNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4895037526302495577L;
	private static final String message = "The job that's you're looking for is not exist.";

	public JobNotFoundException() {
		super(message);
	}

}
