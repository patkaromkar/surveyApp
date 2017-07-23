package com.regulus.app.survey.dao.iface;

import java.util.List;

import com.regulus.app.survey.entities.Question;
import com.regulus.app.survey.entities.Survey;

/**
 * This interface represents the DAO interface to work with Questions in Survey
 * 
 * @author Omkar P
 *
 */
public interface IQuestionDAO {

	public Question createQuestion(final Question newQuestion);
	public boolean deleteQuestion(final int qId, final String paramName);
	public boolean modifyQuestion(final Question questionToBeModified);
	public List<Question> getAllQuestionsBySurvey(final Survey survey);
	public Question getQuestion(final int qId);
	
	
}
