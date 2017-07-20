package com.regulus.app.survey.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.regulus.app.survey.dao.iface.AbstractSurveyAppDAO;
import com.regulus.app.survey.dao.iface.IQTypeDAO;
import com.regulus.app.survey.entities.QuestionType;
import com.regulus.app.survey.util.SAConstants;

/**
 * This DAO class is an implementation of the IQTypeDAO.
 * 
 * @author Omkar P
 *
 */
public class QTypeDAO extends AbstractSurveyAppDAO implements IQTypeDAO {

	private final Logger logger = Logger.getLogger(QTypeDAO.class);
	
	public QTypeDAO() {
		logger.debug("Start of QTypeDAO()");
		init();
		logger.debug("End of QTypeDAO()");
	}
	public QuestionType createQuestionType(QuestionType newQuestionType) {
		// TODO Auto-generated method stub
		logger.debug("Start of createQuestionType()");
		this.session.beginTransaction();
		Integer newQuestionTypeId = (Integer)this.session.save(newQuestionType);
		this.session.getTransaction().commit();
		
		this.session.beginTransaction();
		QuestionType questionType = (QuestionType)this.session.get(QuestionType.class, newQuestionTypeId.intValue());
		this.session.getTransaction().commit();
		logger.debug("End of createQuestionType()");
		return questionType;
	}

	public QuestionType getQuestionType(int questionTypeID) {
		// TODO Auto-generated method stub
		logger.debug("Start of getQuestionType()");
		this.session.beginTransaction();
		QuestionType questionType = (QuestionType)this.session.get(QuestionType.class, questionTypeID);
		this.session.getTransaction().commit();
		logger.debug("End of getQuestionType()");
		
		return questionType;
	}

	public boolean deleteQuestionType(int qTypeId, String paramName) {
		// TODO Auto-generated method stub
		logger.debug("Start of deleteQuestionType()");
		this.session.beginTransaction();
		Query deleteQtypeQuery = this.session.getNamedQuery(SAConstants.NQUERY_QTYPE_DELETE_QTYPE_KEY);
		deleteQtypeQuery.setInteger(paramName, qTypeId);
		int result = deleteQtypeQuery.executeUpdate();
		this.session.getTransaction().commit();
		
		logger.debug("End of deleteQuestionType()");
		
		return (result==0)?false:true;
	}

	public boolean modifyQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		logger.debug("Start of modifyQuestionType()");
		this.session.beginTransaction();
		boolean result = false;
		
		QuestionType questionTypeToBeUpdated = (QuestionType) this.session.get(QuestionType.class, 
				questionType.getSaQuestionId());
		if (null != questionTypeToBeUpdated) {
			this.session.merge(questionType);
			result = true;
		} else {
			result = false;
		}
		
		this.session.getTransaction().commit();
		logger.debug("Is Update of QuestionType successful ? "+result);
		
		logger.debug("End of modifyQuestionType()");
		
		return result;
	}

	public List<QuestionType> getAllQuestionTypes() {
		// TODO Auto-generated method stub
		logger.debug("Start of getAllQuestionTypes()");
		this.session.beginTransaction();
		Query getAllQTypeQuery = this.session.getNamedQuery(SAConstants.NQUERY_QTYPE_GETALL_QTYPES_KEY);
		List<QuestionType> questionTypes = getAllQTypeQuery.list();
		this.session.getTransaction().commit();
		logger.debug("End of getAllQuestionTypes()");
		
		return questionTypes;
	}

}
