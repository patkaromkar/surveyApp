package com.regulus.app.survey.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.regulus.app.survey.dao.iface.AbstractSurveyAppDAO;
import com.regulus.app.survey.dao.iface.ISurveyStatus;
import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.util.SAConstants;

/**
 * This DAO class is an implementation of the ISurveyStatus.
 * 
 * @author Omkar P
 *
 */
public class SurveyStatusDAO extends AbstractSurveyAppDAO implements ISurveyStatus {

	private final Logger logger = Logger.getLogger(SurveyStatusDAO.class);
	
	public SurveyStatusDAO() {
		logger.debug("Start of SurveyStatusDAO()");
		init();
		logger.debug("End of SurveyStatusDAO()");
	}
	
	public SurveyStatus createSurveyStatus(SurveyStatus newSurveyStatus) {
		// TODO Auto-generated method stub
		logger.debug("Start of createSurveyStatus()");
		this.session.beginTransaction();
		Integer newSurveyStatusId = (Integer)this.session.save(newSurveyStatus);
		this.session.getTransaction().commit();
		
		this.session.beginTransaction();
		SurveyStatus ss = (SurveyStatus)this.session.get(SurveyStatus.class, newSurveyStatusId.intValue());
		this.session.getTransaction().commit();
		
		logger.debug("End of createSurveyStatus()");
		return ss;
	}

	public SurveyStatus getSurveyStatus(int surveyStatusID) {
		// TODO Auto-generated method stub
		logger.debug("Start of getSurveyStatus()");
		this.session.beginTransaction();
		SurveyStatus ss = (SurveyStatus)this.session.get(SurveyStatus.class, surveyStatusID);
		this.session.getTransaction().commit();
		
		logger.debug("End of getSurveyStatus()");
		return ss;
	}

	public boolean deleteSurveyStatus(int ssId, String paramName) {
		// TODO Auto-generated method stub
		logger.debug("Start of deleteSurveyStatus()");
		this.session.beginTransaction();
		Query deleteSSQuery = this.session.getNamedQuery(SAConstants.NQUERY_SS_DELETE_SS_KEY);
		deleteSSQuery.setInteger(paramName, ssId);
		int result = deleteSSQuery.executeUpdate();
		this.session.getTransaction().commit();
		
		logger.debug("End of deleteSurveyStatus()");
		return (result==0)?false:true;
	}

	public boolean modifySurveyStatus(SurveyStatus surveyStatus) {
		// TODO Auto-generated method stub
		logger.debug("Start of modifySurveyStatus()");
		this.session.beginTransaction();
		boolean result = false;
		
		SurveyStatus surveyStatusToBeUpdated = (SurveyStatus) this.session.get(SurveyStatus.class, 
				surveyStatus.getSaSurveyStatusId());
		if (null != surveyStatusToBeUpdated) {
			this.session.merge(surveyStatus);
			result = true;
		} else {
			result = false;
		}
		
		this.session.getTransaction().commit();
		logger.debug("Is Update of SurveyStatus successful ? "+result);
		logger.debug("End of modifySurveyStatus()");
		return result;
	}

	
	public List<SurveyStatus> getAllSurveyStatuses() {
		// TODO Auto-generated method stub
		logger.debug("Start of getAllSurveyStatuses()");
		this.session.beginTransaction();
		Query getAllSSQuery = this.session.getNamedQuery(SAConstants.NQUERY_SS_GETALLSS_KEY);
		List<SurveyStatus> sses = getAllSSQuery.list();
		this.session.getTransaction().commit();
		logger.debug("End of getAllSurveyStatuses()");
		return sses;
	}

	
}
