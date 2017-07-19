package com.regulus.app.survey.dao.iface;

import com.regulus.app.survey.entities.SurveyStatus;

/**
 * This interface is used to represent the UserDAO to perform operations like create, delete, modify or get survey status
 * 
 * @author Omkar P
 *
 */
public interface ISurveyStatus {

	public SurveyStatus createSurveyStatus(final SurveyStatus newSurveyStatus);
	
}
