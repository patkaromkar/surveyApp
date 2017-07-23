package com.regulus.app.survey.surveyapp;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.regulus.app.survey.dao.impl.SurveyDAO;
import com.regulus.app.survey.dao.impl.SurveyStatusDAO;
import com.regulus.app.survey.dao.impl.UserDAO;
import com.regulus.app.survey.entities.Survey;
import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.entities.User;
import com.regulus.app.survey.exceptions.SurveyStatusNotFoundException;
import com.regulus.app.survey.util.SAConstants;
import com.regulus.app.survey.util.SADALUtil;

import junit.framework.TestCase;

/**
 * This is Junit test class to verify the functionality of the SurveyDAO
 * 
 * @author Omkar P
 *
 */
public class TestSurveyDAO extends TestCase {

	private SurveyDAO surveyDAO = null;
	private UserDAO userDAO = null;
	private SurveyStatusDAO statusDAO = null;
	
	private Logger logger = Logger.getLogger(TestSurveyDAO.class);
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of setUp()");
		super.setUp();
		this.surveyDAO = new SurveyDAO();
		this.userDAO = new UserDAO();
		this.statusDAO = new SurveyStatusDAO();
		
		SurveyStatus ss1 = new SurveyStatus();
		ss1.setSaSurveyStatusName(SAConstants.SS_STATUS_OPEN);
		SurveyStatus ss2 = new SurveyStatus();
		ss2.setSaSurveyStatusName(SAConstants.SS_STATUS_CLOSED);
		SurveyStatus ss3 = new SurveyStatus();
		ss3.setSaSurveyStatusName(SAConstants.SS_STATUS_DRAFT);
		SurveyStatus ss4 = new SurveyStatus();
		ss4.setSaSurveyStatusName(SAConstants.SS_STATUS_DELETED);
		this.statusDAO.createSurveyStatus(ss1);
		this.statusDAO.createSurveyStatus(ss2);
		this.statusDAO.createSurveyStatus(ss3);
		this.statusDAO.createSurveyStatus(ss4);
		
		User adminUser = new User();
		adminUser.setEmail("x@x.x");
		adminUser.setSaIsAdmin(true);
		adminUser.setSaUfirstName(SADALUtil.getRandomWord(5));
		adminUser.setSaULastName(SADALUtil.getRandomWord(5));
		adminUser.setSaUsername("asd");
		adminUser.setSaPassword("asd");
		//this.userDAO.createUser(adminUser);
		
		Survey survey = new Survey();
		survey.setSaSurveyCreatedBy(adminUser);
		survey.setSaSurveyCreatedOn(Calendar.getInstance().getTime());
		survey.setSaSurveyTitle("This is a test or dummy survey");
		survey.setSaSS(ss1);
		this.surveyDAO.createSurvey(survey);
		
		survey = new Survey();
		survey.setSaSurveyCreatedBy(adminUser);
		survey.setSaSurveyCreatedOn(Calendar.getInstance().getTime());
		survey.setSaSurveyTitle("This is another test or dummy survey created by Admin");
		
		survey.setSaSS(ss2);
		this.surveyDAO.createSurvey(survey);
		
		survey = new Survey();
		survey.setSaSurveyCreatedBy(adminUser);
		survey.setSaSurveyCreatedOn(Calendar.getInstance().getTime());
		survey.setSaSurveyTitle("One more dummy survey by admin");		
		survey.setSaSS(ss3);
		this.surveyDAO.createSurvey(survey);
		
		logger.debug("End of setUp()");
		
	}
	
	public void testCreateSurvey() throws SurveyStatusNotFoundException {
		logger.debug("Start of testCreateSurvey()");
		User adminUser = new User();
		adminUser.setEmail("xx@xx.xx");
		adminUser.setSaIsAdmin(true);
		adminUser.setSaUfirstName(SADALUtil.getRandomWord(5));
		adminUser.setSaULastName(SADALUtil.getRandomWord(5));
		adminUser.setSaUsername("1asd1");
		adminUser.setSaPassword("1asd1");
		//this.userDAO.createUser(adminUser);
		
		Survey survey = new Survey();
		survey.setSaSurveyCreatedBy(adminUser);
		survey.setSaSurveyCreatedOn(Calendar.getInstance().getTime());
		survey.setSaSurveyTitle("This is another test or dummy survey");
		
		SurveyStatus ss = this.statusDAO.getSurveyStatus(SAConstants.SS_STATUS_OPEN);
		survey.setSaSS(ss);
		
		this.surveyDAO.createSurvey(survey);
		logger.debug("End of testCreateSurvey()");
		
	}
	
	public void testGetAllSurveys(){
		logger.debug("Start of testGetAllSurveys()");
		List<Survey> surveys = this.surveyDAO.getAllSurveys();
		assertEquals("Expected No of surveys not retrieved", 3, surveys.size());
		logger.debug("End of testGetAllSurveys()");
		
	}
	
	
	public void testGetAllSurveysByUser() {
		logger.debug("Start of testGetAllSurveysByUser()");
		User u = new User();
		u.setSaUid(6);
		List<Survey> surveys = this.surveyDAO.getAllSurveysByUser(u);
		assertEquals("Expected No of surveys not retrieved", 3, surveys.size());
		
		logger.debug("End of testGetAllSurveysByUser()");
		
	}
	
	
	public void testGetSurveyById() {
		logger.debug("Start of testGetSurveyById()");
		Survey survey = this.surveyDAO.getSurvey(7);
		assertNotNull("Expected survey is not found !", survey);
		assertEquals("Expected survey is not found some other survey is found", 7, survey.getSaSid());
		logger.debug("End of testGetSurveyById()");
		
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of tearDown()");
		super.tearDown();
		this.surveyDAO.closeDAO();
		this.userDAO.closeDAO();
		this.statusDAO.closeDAO();
		logger.debug("End of tearDown()");
	}
	
	
}
