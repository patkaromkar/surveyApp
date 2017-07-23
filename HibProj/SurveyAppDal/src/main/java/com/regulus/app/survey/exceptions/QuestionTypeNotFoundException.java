package com.regulus.app.survey.exceptions;

import java.text.MessageFormat;

import com.regulus.app.survey.util.SAConstants;

public class QuestionTypeNotFoundException extends Exception {

	public QuestionTypeNotFoundException(final String ssName) {
		super(MessageFormat.format(SAConstants.DAL_EX_QUESTION_TYPE_NOT_FOUND_MSG, ssName));
	}
}
