package com.regulus.app.survey.dao.iface;

import java.util.List;

import com.regulus.app.survey.entities.Survey;
import com.regulus.app.survey.entities.User;

/**
 * This interface represents methods of DAO to work with Survey
 * 
 * @author Omkar P
 *
 */
public interface ISurveyDAO {

	public List<Survey> getAllSurveys();
	
	public Survey createSurvey(final Survey newSurvey);
	
	public List<Survey> getAllSurveysByUser(final User user);
	
	public Survey getSurvey(final int surveyId);
	
}
