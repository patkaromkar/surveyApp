package com.regulus.app.survey.exceptions;

import java.text.MessageFormat;

import com.regulus.app.survey.util.SAConstants;

public class SurveyStatusNotFoundException extends Exception {

	public SurveyStatusNotFoundException(final String ssName) {
		super(MessageFormat.format(SAConstants.DAL_EX_SURVEY_STATUS_NOT_FOUND_MSG, ssName));
	}
}
