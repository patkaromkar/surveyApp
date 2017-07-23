package com.regulus.app.survey.surveyapp;

import java.util.List;

import org.apache.log4j.Logger;

import com.regulus.app.survey.dao.impl.QTypeDAO;
import com.regulus.app.survey.entities.QuestionType;
import com.regulus.app.survey.exceptions.QuestionTypeNotFoundException;
import com.regulus.app.survey.util.SAConstants;

import junit.framework.TestCase;

/**
 * This is JUnit test case class which verifies the public methods of SurveyStatusDAO
 * 
 * @author Omkar P
 *
 */
public class TestQTypeDAO extends TestCase {

	Logger logger = Logger.getLogger(TestQTypeDAO.class);
	private QTypeDAO qTypeDAO = null;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of setUp()");
		super.setUp();
		qTypeDAO = new QTypeDAO();
		QuestionType qType = new QuestionType();
		qType.setSaQuestionType(SAConstants.QTYPE_MCQ);
		this.qTypeDAO.createQuestionType(qType);
		
		qType = new QuestionType();
		qType.setSaQuestionType(SAConstants.QTYPE_SCQ);
		this.qTypeDAO.createQuestionType(qType);
		
		logger.debug("End of setUp()");
	}
	
	public void testCreateQType() {
		logger.debug("Start of testCreateQType()");
		QuestionType qType = new QuestionType();
		qType.setSaQuestionType("TestQ");
		QuestionType qType2 = (QuestionType)this.qTypeDAO.createQuestionType(qType);
		assertEquals("The question types do not match !!!", qType.getSaQuestionType(), qType2.getSaQuestionType());
		
		logger.debug("End of testCreateQType()");
	}
	
	public void testDeleteQType() {
		logger.debug("Start of testDeleteQType");
		boolean isQuestionTypeDeleted = this.qTypeDAO.deleteQuestionType(1,	SAConstants.NQ_CONST_PARAM_QTYPE_ID);
		logger.debug("Is the QuestionType deleted  ? = "+isQuestionTypeDeleted);
		assertEquals("The QuestionType is not deleted since the delete result is not as expected", true, isQuestionTypeDeleted);
		
		logger.debug("End of testDeleteQType");
	}
	
	public void testModifyQType() {
		logger.debug("Start of testModifyQType()");
		QuestionType qType = new QuestionType();
		qType.setSaQuestionId(2);
		qType.setSaQuestionType(SAConstants.QTYPE_SCQ.toLowerCase());
		boolean result = this.qTypeDAO.modifyQuestionType(qType);
		assertEquals("The QuestionType is not modified", true, result);
		logger.debug("End of testModifyQType()");
		
	}
	
	public void testGetAllQTypes() {
		logger.debug("Start of testGetAllQTypes()");
		List<QuestionType> listOfQuestionTypes = this.qTypeDAO.getAllQuestionTypes();
		assertEquals("Exactly 2 different QuestionTypes were expected", 2, listOfQuestionTypes.size());
		logger.debug("End of testGetAllQTypes()");
		
	}
	
	public void testGetQType() {
		logger.debug("Start of testGetQType()");
		QuestionType questionType = this.qTypeDAO.getQuestionType(2);
		assertEquals("Expected Survey status is not retrieved", SAConstants.QTYPE_SCQ, questionType.getSaQuestionType());
		logger.debug("End of testGetQType()");
		
	}
	
	public void testGetQType2() throws QuestionTypeNotFoundException {
		logger.debug("Start of testGetQType2()");
		QuestionType questionType = this.qTypeDAO.getQuestionType(SAConstants.QTYPE_MCQ);
		assertEquals("Expected Survey status is not retrieved", SAConstants.QTYPE_MCQ, questionType.getSaQuestionType());
		logger.debug("End of testGetQType2()");
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of tearDown()");
		super.tearDown();
		this.qTypeDAO.closeDAO();
		logger.debug("End of tearDown()");
	}
	
	
}
