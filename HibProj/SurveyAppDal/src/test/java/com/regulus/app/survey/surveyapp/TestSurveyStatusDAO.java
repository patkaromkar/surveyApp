package com.regulus.app.survey.surveyapp;

import java.util.List;

import org.apache.log4j.Logger;

import com.regulus.app.survey.dao.impl.SurveyStatusDAO;
import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.exceptions.SurveyStatusNotFoundException;
import com.regulus.app.survey.util.SAConstants;

import junit.framework.TestCase;

/**
 * This is JUnit test case class which verifies the public methods of SurveyStatusDAO
 * 
 * @author Omkar P
 *
 */
public class TestSurveyStatusDAO extends TestCase {

	Logger logger = Logger.getLogger(TestSurveyStatusDAO.class);
	SurveyStatusDAO ssDAO = null;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of setUp()");
		super.setUp();
		ssDAO = new SurveyStatusDAO();
		int i = 0;
		for (;i < 4;i++) {
			SurveyStatus ss = new SurveyStatus();
			switch(i) {
				case 0 : 
					ss.setSaSurveyStatusName(SAConstants.SS_STATUS_OPEN);
					break;
				case 1 : 
					ss.setSaSurveyStatusName(SAConstants.SS_STATUS_DRAFT);
					break;
				case 2 : 
					ss.setSaSurveyStatusName(SAConstants.SS_STATUS_CLOSED);
					break;
				case 3 : 
					ss.setSaSurveyStatusName(SAConstants.SS_STATUS_DELETED);
					break;
			}
			
			this.ssDAO.createSurveyStatus(ss);
		}
		logger.debug("End of setUp()");
	}
	
	
	public void testGetSS() {
		logger.debug("Start of testGetSS()");
		SurveyStatus ss = this.ssDAO.getSurveyStatus(2);
		assertEquals("Expected Survey status is not retrieved", SAConstants.SS_STATUS_DRAFT, ss.getSaSurveyStatusName());
		logger.debug("End of testGetSS()");
		
	}
	
	public void testGetSSByName() throws SurveyStatusNotFoundException {
		logger.debug("Start of testGetSSByName()");
		SurveyStatus ss = this.ssDAO.getSurveyStatus(SAConstants.SS_STATUS_DRAFT);
		assertEquals("Expected Survey status is not retrieved", SAConstants.SS_STATUS_DRAFT, ss.getSaSurveyStatusName());
		logger.debug("End of testGetSSByName()");
		
	}
	
	public void testCreateSS() {
		logger.debug("Start of testCreateSS()");
		SurveyStatus ss = new SurveyStatus();
		ss.setSaSurveyStatusName("testState");
		SurveyStatus ss2 = this.ssDAO.createSurveyStatus(ss);
		assertEquals("The survey status do not match !!!", ss.getSaSurveyStatusName(), ss2.getSaSurveyStatusName());
		logger.debug("End of testCreateSS()");
	}
	
	
	public void testDeleteSS() {
		logger.debug("Start of testDeleteSS()");
		boolean isSurveyStatusDeleted = this.ssDAO.deleteSurveyStatus(3, 
				SAConstants.NQ_CONST_PARAM_SS_ID);
		logger.debug("Is the survey deleted  ? = "+isSurveyStatusDeleted);
		assertEquals("The survey status is not deleted since the delete result is not as expected", true, isSurveyStatusDeleted);
		
		logger.debug("End of testDeleteSS()");
	}
	
	public void testModifySS() {
		logger.debug("Start of testModifySS()");
		SurveyStatus ss = new SurveyStatus();
		ss.setSaSurveyStatusId(2);
		ss.setSaSurveyStatusName(SAConstants.SS_STATUS_DRAFT.toUpperCase()+"XX");
		boolean result = this.ssDAO.modifySurveyStatus(ss);
		assertEquals("The survey status is not modified", true, result);
		logger.debug("End of testModifySS()");
		
	}
	
	public void testGetAllSS() {
		logger.debug("Start of testGetAllSS()");
		List<SurveyStatus> listOfSS = this.ssDAO.getAllSurveyStatuses();
		assertEquals("Exactly 4 different survey statuses were expected", 4, listOfSS.size());
		logger.debug("End of testGetAllSS()");
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of tearDown()");
		super.tearDown();
		logger.debug("End of tearDown()");
		
	}
	
	
}
