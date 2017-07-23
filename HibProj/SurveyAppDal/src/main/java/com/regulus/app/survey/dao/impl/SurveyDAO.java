package com.regulus.app.survey.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.regulus.app.survey.dao.iface.AbstractSurveyAppDAO;
import com.regulus.app.survey.dao.iface.ISurveyDAO;
import com.regulus.app.survey.entities.Survey;
import com.regulus.app.survey.entities.User;
import com.regulus.app.survey.util.SAConstants;

/**
 * This is implementation class of the interface ISurveyDAO
 * 
 * @author Omkar P
 *
 */
public class SurveyDAO extends AbstractSurveyAppDAO implements ISurveyDAO {

	private Logger logger = Logger.getLogger(SurveyDAO.class);
	
	public SurveyDAO() {
		logger.debug("Start of SurveyDAO()");
		init();
		logger.debug("End of SurveyDAO()");
		
	}
	public List<Survey> getAllSurveys() {
		// TODO Auto-generated method stub
		logger.debug("Start of getAllSurveys()");
		this.session.beginTransaction();
		Query getAllSurveysQuery = this.session.getNamedQuery(SAConstants.NQUERY_SURVEY_GETALL_SURVEYS_KEY);
		List<Survey> surveys = getAllSurveysQuery.list();
		logger.debug(surveys.size()+" no of surveys were returned from the database");
		this.session.getTransaction().commit();
		logger.debug("End of getAllSurveys()");
		return surveys;
	}

	public Survey createSurvey(final Survey newSurvey) {
		// TODO Auto-generated method stub
		logger.debug("Start of createSurvey()");
		this.session.beginTransaction();
		Integer newSurveyId = (Integer)this.session.save(newSurvey);
		Survey survey = (Survey)this.session.get(Survey.class, newSurveyId.intValue());
		this.session.getTransaction().commit();
		logger.debug("End of createSurvey()");
		return survey;
	}
	
	
	public List<Survey> getAllSurveysByUser(final User user) {
		// TODO Auto-generated method stub
		logger.debug("Start of getAllSurveysByUser()");
		this.session.beginTransaction();
		final Query getAllSurveysByUserQuery = this.session.getNamedQuery(SAConstants.NQUERY_SURVEY_GETALL_SURVEY_BY_USER_KEY);
		getAllSurveysByUserQuery.setParameter(SAConstants.NQ_CONST_PARAM_SURVEY_CREATEDBY_UID, user.getSaUid());
		List<Survey> surveys = getAllSurveysByUserQuery.list();
		logger.debug(surveys.size()+" # of surveys are retrieved");
		this.session.getTransaction().commit();
		
		logger.debug("End of getAllSurveysByUser()");
		return surveys;
	}
	public Survey getSurvey(int surveyId) {
		// TODO Auto-generated method stub
		logger.debug("Start of getSurvey()");
		this.session.beginTransaction();
		Survey survey = (Survey)this.session.get(Survey.class, surveyId);
		this.session.getTransaction().commit();
		logger.debug("End of getSurvey()");
		return survey;
	}

}
