package com.regulus.app.survey.surveyapp;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.regulus.app.survey.dao.impl.QTypeDAO;
import com.regulus.app.survey.dao.impl.QuestionDAO;
import com.regulus.app.survey.dao.impl.SurveyDAO;
import com.regulus.app.survey.dao.impl.SurveyStatusDAO;
import com.regulus.app.survey.entities.Question;
import com.regulus.app.survey.entities.QuestionType;
import com.regulus.app.survey.entities.Survey;
import com.regulus.app.survey.entities.SurveyStatus;
import com.regulus.app.survey.entities.User;
import com.regulus.app.survey.exceptions.QuestionTypeNotFoundException;
import com.regulus.app.survey.util.SAConstants;
import com.regulus.app.survey.util.SADALUtil;

import junit.framework.TestCase;

public class TestQuestionDAO extends TestCase {

	Logger logger = Logger.getLogger(TestQuestionDAO.class);
	private QuestionDAO questionDAO = null;
	private SurveyDAO surveyDAO = null;
	private SurveyStatusDAO statusDAO = null;
	private QTypeDAO qTypeDAO = null;
	
	
	protected void setUp() throws Exception {
		logger.debug("Start of setup()");
		super.setUp();
		this.questionDAO = new QuestionDAO();
		this.surveyDAO = new SurveyDAO();
		this.statusDAO = new SurveyStatusDAO();
		this.qTypeDAO = new QTypeDAO();
		
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
		
		
		QuestionType qType = new QuestionType();
		qType.setSaQuestionType(SAConstants.QTYPE_MCQ);
		this.qTypeDAO.createQuestionType(qType);
		
		qType = new QuestionType();
		qType.setSaQuestionType(SAConstants.QTYPE_SCQ);
		this.qTypeDAO.createQuestionType(qType);
		
		User adminUser = new User();
		adminUser.setEmail("x@x.x");
		adminUser.setSaIsAdmin(true);
		adminUser.setSaUfirstName(SADALUtil.getRandomWord(5));
		adminUser.setSaULastName(SADALUtil.getRandomWord(5));
		adminUser.setSaUsername("asd");
		adminUser.setSaPassword("asd");
		
		Survey survey = new Survey(); // survey id = 7
		survey.setSaSurveyCreatedBy(adminUser);
		survey.setSaSurveyCreatedOn(Calendar.getInstance().getTime());
		survey.setSaSurveyTitle("This is a test or dummy survey");
		survey.setSaSS(ss1);
		this.surveyDAO.createSurvey(survey);
		
		
		qType = this.qTypeDAO.getQuestionType(SAConstants.QTYPE_MCQ);
		survey = this.surveyDAO.getSurvey(7);
		Question q = new Question();
		
		q.setqTitle(SADALUtil.getRandomWord(8)+"     "+SADALUtil.getRandomWord(10)+"    "+SADALUtil.getRandomWord(5)+" ?");
		q.setqType(qType);
		q.setqBelongsToSurvey(survey);
		
		Question q2 = this.questionDAO.createQuestion(q);
		
		logger.debug("End of setup()");
	}

	public void testCreateQuestion() throws QuestionTypeNotFoundException {
		logger.debug("Start of testCreateQuestion()");
		Question q = null;
		int i = 0;
		int noOfQuestions = 5;
		String[] qTitle = new String[noOfQuestions];
		QuestionType qType = this.qTypeDAO.getQuestionType(SAConstants.QTYPE_MCQ);
		Survey survey = this.surveyDAO.getSurvey(7);
		for (; i < noOfQuestions; i++) {
			q = new Question();
			qTitle[i] = SADALUtil.getRandomWord(8)+"     "+SADALUtil.getRandomWord(10)+"    "+SADALUtil.getRandomWord(5)+" ?";
			q.setqTitle(qTitle[i]);
			q.setqType(qType);
			q.setqBelongsToSurvey(survey);
			
			Question q2 = this.questionDAO.createQuestion(q);
			
			assertEquals("Questions do not match, which means, question is not created correctly", q.getqTitle(),q2.getqTitle());
		}
		
		logger.debug("End of testCreateQuestion()");
		
	}
	
	
	public void testDeleteQuestion() {
		logger.debug("Start of testDeleteQuestion()");
		boolean isDelSuccessfull = this.questionDAO.deleteQuestion(9, SAConstants.NQ_CONST_PARAM_QUESTION_ID);
		assertEquals("Delete is unsucessfull as the result is not expected",  true, isDelSuccessfull);
		logger.debug("End of testDeleteQuestion()");
		
	}
	
	public void testModifyQuestion() {
		logger.debug("Start of testModifyQuestion()");
		
		String newQuestionTitle = "This is a dummy question to be used for modifying the question ?!";
		Question q = this.questionDAO.getQuestion(9);
		q.setqTitle(newQuestionTitle);
		boolean result = this.questionDAO.modifyQuestion(q);
		logger.debug("Is update successful ? "+result);
		q = this.questionDAO.getQuestion(9);
		assertEquals("Update did not take place correctly as the question title does not match", newQuestionTitle, q.getqTitle());
		
		logger.debug("End of testModifyQuestion()");
		
		
	}
	
	public void testGetAllQuestionBySurvey() {
		logger.debug("Start of testGetAllQuestionBySurvey()");
		Survey s = new Survey();
		s.setSaSid(7);
		List<Question> questions = this.questionDAO.getAllQuestionsBySurvey(s);
		assertEquals("Expected no of questions not obtained from DB", 1, questions.size());
		logger.debug("End of testGetAllQuestionBySurvey()");
		
	}
	
	
	protected void tearDown() throws Exception {
		logger.debug("Start of tearDown()");
		this.questionDAO.closeDAO();
		this.surveyDAO.closeDAO();
		this.statusDAO.closeDAO();
		this.qTypeDAO.closeDAO();
		logger.debug("End of tearDown()");
		super.tearDown();
	}

}
