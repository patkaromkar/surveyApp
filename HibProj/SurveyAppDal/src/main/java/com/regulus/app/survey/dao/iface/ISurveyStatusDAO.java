package com.regulus.app.survey.dao.iface;

import java.util.List;

import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.exceptions.SurveyStatusNotFoundException;

/**
 * This interface is used to represent the SurveyStatusDAO to perform operations like create, delete, modify or get survey status
 * 
 * @author Omkar P
 *
 */
public interface ISurveyStatusDAO {

	public SurveyStatus createSurveyStatus(final SurveyStatus newSurveyStatus);
	
	public SurveyStatus getSurveyStatus(final int surveyStatusID);
	
	public SurveyStatus getSurveyStatus(final String surveyStatus)  throws SurveyStatusNotFoundException ;
	
	public boolean deleteSurveyStatus(final int ssId, final String paramName);
	
	public boolean modifySurveyStatus(final SurveyStatus surveyStatus);
	
	public List<SurveyStatus> getAllSurveyStatuses();
	
}
