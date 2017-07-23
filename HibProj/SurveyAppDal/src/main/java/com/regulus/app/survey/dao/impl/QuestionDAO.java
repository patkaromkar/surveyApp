package com.regulus.app.survey.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.regulus.app.survey.dao.iface.AbstractSurveyAppDAO;
import com.regulus.app.survey.dao.iface.IQuestionDAO;
import com.regulus.app.survey.entities.Question;
import com.regulus.app.survey.entities.Survey;
import com.regulus.app.survey.util.SAConstants;

public class QuestionDAO extends AbstractSurveyAppDAO implements IQuestionDAO {

	private final Logger logger = Logger.getLogger(QuestionDAO.class);
	
	public QuestionDAO() {
		logger.debug("Start of QuestionDAO()");
		init();
		logger.debug("End of QuestionDAO()");
	}
	public Question createQuestion(Question newQuestion) {
		// TODO Auto-generated method stub
		logger.debug("Start of createQuestion()");
		this.session.beginTransaction();
		Integer newQuestionId = (Integer)this.session.save(newQuestion);
		Question question = (Question)this.session.get(Question.class, newQuestionId.intValue());
		this.session.getTransaction().commit();
		logger.debug("End of createQuestion()");
		return question;
	}

	public boolean deleteQuestion(final int qId, final String paramName) {
		// TODO Auto-generated method stub
		logger.debug("Start of deleteQuestion()");
		this.session.beginTransaction();
		Query deleteQuestionQuery = this.session.getNamedQuery(SAConstants.NQUERY_QUESTION_DELETE_Q_BY_ID_KEY);
		deleteQuestionQuery.setInteger(paramName, qId);
		int result = deleteQuestionQuery.executeUpdate();
		this.session.getTransaction().commit();
		
		logger.debug("End of deleteQuestion()");
		return (result==0)?false:true;
	}

	public boolean modifyQuestion(Question questionToBeModified) {
		// TODO Auto-generated method stub
		logger.debug("Start of modifyQuestion()");
		this.session.beginTransaction();
		
		boolean result = false;
		
		Question questionToBeUpdated = (Question) this.session.get(Question.class, 
				questionToBeModified.getqId());
		if (null != questionToBeUpdated) {
			this.session.merge(questionToBeModified);
			result = true;
		} else {
			result = false;
		}
		
		this.session.getTransaction().commit();
		logger.debug("Is Update of Question successful ? "+result);
		logger.debug("End of modifyQuestion()");
		return result;
	}

	public List<Question> getAllQuestionsBySurvey(Survey survey) {
		// TODO Auto-generated method stub
		logger.debug("Start of getAllQuestionsBySurvey()");
		this.session.beginTransaction();
		Query getQuestionsBySurveyQuery = this.session.getNamedQuery(SAConstants.NQUERY_QUESTION_GETALLQS_BY_SURVEY_KEY);
		getQuestionsBySurveyQuery.setParameter(SAConstants.NQ_CONST_PARAM_SURVEY_ID, survey.getSaSid());
		List<Question> questions = getQuestionsBySurveyQuery.list();
		this.session.getTransaction().commit();
		
		logger.debug("End of getAllQuestionsBySurvey()");
		return questions;
	}
	
	public Question getQuestion(final int qId) {
		// TODO Auto-generated method stub
		logger.debug("Start of getQuestion()");
		this.session.beginTransaction();
		Question question = (Question)this.session.get(Question.class, qId);
		this.session.getTransaction().commit();
		logger.debug("End of getQuestion()");
		
		return question;
	}	
	
}
