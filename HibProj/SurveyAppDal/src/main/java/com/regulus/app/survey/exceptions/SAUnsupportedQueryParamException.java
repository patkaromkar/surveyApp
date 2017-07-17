package com.regulus.app.survey.exceptions;

import java.text.MessageFormat;

public class SAUnsupportedQueryParamException extends RuntimeException {

	private SAUnsupportedQueryParamException() {
		
	}
	
	public SAUnsupportedQueryParamException(final String message,
			final String paramName, final String paramType) {
		super(MessageFormat.format(message, paramName, paramType));
	}
}
