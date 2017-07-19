package com.regulus.app.survey.dao.iface;

import java.util.List;
import java.util.Map;

import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.entities.User;

/**
 * This interface is used to represent the UserDAO to perform operations like create, delete, modify or get survey status
 * 
 * @author Omkar P
 *
 */
public interface ISurveyStatus {

	public SurveyStatus createSurveyStatus(final SurveyStatus newSurveyStatus);
	
	public User getSurveyStatus(final int surveyStatusID);
	
	public boolean deleteSurveyStatus(final int uId, final String paramName, final String queryName);
	
	public boolean modifySurveyStatus(final User user);
	
	public List<User> getUserList(final Map<String, Object> params, final String queryName);
	
	public List<User> getAllSurveyStatuses();
	
}
