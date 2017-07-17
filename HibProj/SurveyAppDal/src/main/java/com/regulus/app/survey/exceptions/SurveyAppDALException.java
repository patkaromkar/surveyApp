package com.regulus.app.survey.exceptions;

/**
 * This exception represents exception thrown by the DAL of the application.
 * 
 * @author Omkar P
 *
 */
public class SurveyAppDALException extends RuntimeException {

	public SurveyAppDALException(final String message) {
		super(message);
	}
	
	public SurveyAppDALException(final String message, final Throwable rootCause) {
		super(message, rootCause);
	}
}
