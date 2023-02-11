package com.ohspaces.bookmyspace.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BookSpaceException extends Exception {

	private static final long serialVersionUID = 8354926990541607414L;

	private HttpStatus status;

	private String code;

	public BookSpaceException(String code, String message) {
		super(message);
		this.code = code;
		this.status = HttpStatus.BAD_REQUEST;
	}

	public BookSpaceException(String code, String message, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
