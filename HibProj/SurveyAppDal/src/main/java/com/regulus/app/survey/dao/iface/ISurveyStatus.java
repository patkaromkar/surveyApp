package com.regulus.app.survey.dao.iface;

import java.util.List;

import com.regulus.app.survey.entities.SurveyStatus;

/**
 * This interface is used to represent the SurveyStatusDAO to perform operations like create, delete, modify or get survey status
 * 
 * @author Omkar P
 *
 */
public interface ISurveyStatus {

	public SurveyStatus createSurveyStatus(final SurveyStatus newSurveyStatus);
	
	public SurveyStatus getSurveyStatus(final int surveyStatusID);
	
	public boolean deleteSurveyStatus(final int ssId, final String paramName);
	
	public boolean modifySurveyStatus(final SurveyStatus surveyStatus);
	
	public List<SurveyStatus> getAllSurveyStatuses();
	
}
