package com.regulus.app.survey.util;

public interface SAConstants {

	/*************************************************************************************************************************/
	/*********************************************Constants for Exception Messages********************************************/
	/*************************************************************************************************************************/
	String DAL_EX_SESSION_NOT_CREATED_MSG = "Session is not created. It is null at the moment. "
			+ "Please create session first and then try to close it. Cannot close a null session.";
	String DAL_EX_UNSUPPORTED_QUERYPARAM = "The data type of the query parameter = \"{0}\" is \"{1}\" which is not supported "
			+ "by the DAL of Survey App. The supported types are int, short, float, double, long, boolean and String.";
	String DAL_EX_UNSUPPORTED_QUERYPARAM_GETUSER = "The data type of the query parameter = \"{0}\" is \"{1}\" which is not supported "
			+ "by the DAL of Survey App. The supported types for getting user by Username and Password is String.";
	String DAL_EX_SURVEY_STATUS_NOT_FOUND_MSG = "Survey status = {0} is not found in the database.";
	String DAL_EX_QUESTION_TYPE_NOT_FOUND_MSG = "Question type = {0} is not found in the database.";
	/*************************************************************************************************************************/
	
	
	/*************************************************************************************************************************/
	/***********************************************Constants for Named Queries***********************************************/
	/*************************************************************************************************************************/
	// USERDAO constants
	String NQ_CONST_PARAM_USERNAME				= "paramUsername";
	String NQ_CONST_PARAM_PASSWORD				= "paramPassword";
	String NQ_CONST_PARAM_FNAME_WILDCARD		= "paramFnameWC";
	String NQ_CONST_PARAM_LNAME_WILDCARD		= "paramLnameWC";
	String NQ_CONST_PARAM_EMAIL					= "paramEmail";
	String NQ_CONST_PARAM_ISADMIN				= "paramIsAdmin";
	String NQ_CONST_PARAM_UID					= "paramUid";
	String NQUERY_USER_GETALLUSERS_KEY 			= "User.getAllUsers";
	String NQUERY_USER_GETALLUSERS 				= "from User";
	String NQUERY_USER_GETUSER_BY_UNAME_PWD_KEY	= "User.getUserByUnameNPwd";
	String NQUERY_USER_GETUSER_BY_UNAME_PWD		= "from User u where u.saUsername = :"+NQ_CONST_PARAM_USERNAME+" and u.saPassword = :"+NQ_CONST_PARAM_PASSWORD;
	String NQUERY_USER_GETUSER_FNAME_LIKE_KEY	= "User.getUserByFnameLike";
	String NQUERY_USER_GETUSER_FNAME_LIKE		= "from User u where u.saUfirstName like :"+NQ_CONST_PARAM_FNAME_WILDCARD;
	String NQUERY_USER_GETUSER_LNAME_LIKE_KEY	= "User.getUserByLnameLike";
	String NQUERY_USER_GETUSER_LNAME_LIKE		= "from User u where u.saULastName like :"+NQ_CONST_PARAM_LNAME_WILDCARD;
	String NQUERY_USER_GETUSER_NAME_LIKE_KEY	= "User.getUserByNameLike";
	String NQUERY_USER_GETUSER_NAME_LIKE		= "from User u where u.saUfirstName like :"+NQ_CONST_PARAM_FNAME_WILDCARD+" and u.saULastName like :"+NQ_CONST_PARAM_LNAME_WILDCARD;
	String NQUERY_USER_GETUSER_BY_EMAIL_KEY		= "User.getUserByEmail";
	String NQUERY_USER_GETUSER_BY_EMAIL			= "from User u where u.email = :"+NQ_CONST_PARAM_EMAIL;
	String NQUERY_USER_GETUSER_BY_ADMIN_KEY		= "User.getUserByIsAdmin";
	String NQUERY_USER_GETUSER_BY_ADMIN			= "from User u where u.saIsAdmin = :"+NQ_CONST_PARAM_ISADMIN;
	String NQUERY_USER_DELETEUSER_BY_ID_KEY		= "User.deleteByUId";
	String NQUERY_USER_DELETEUSER_BY_ID			= "delete from User where saUid = :"+NQ_CONST_PARAM_UID;
	
	// SURVEYSTATUSDAO constants
	String NQ_CONST_PARAM_SS_ID			= "paramSSId";
	String NQUERY_SS_GETALLSS_KEY		= "SurveyStatus.getALLSS";
	String NQUERY_SS_GETALLSS			= "from SurveyStatus";
	String NQUERY_SS_DELETE_SS_KEY		= "SurveyStatus.deleteSSById";
	String NQUERY_SS_DELETE_SS			= "delete from SurveyStatus ss where ss.saSurveyStatusId = :"+NQ_CONST_PARAM_SS_ID;
	String NQ_CONST_PARAM_SS_NAME		= "paramSSname";
	String NQUERY_SS_GET_SS_BY_NAME		= "from SurveyStatus where saSurveyStatusName = :"+NQ_CONST_PARAM_SS_NAME;
	String NQUERY_SS_GET_SS_BY_NAME_KEY	= "SurveyStatus.getSSBySSName";
	
	
	// QUESTIONTYPE constants
	String NQ_CONST_PARAM_QTYPE_ID				= "paramQTypeId";
	String NQUERY_QTYPE_GETALL_QTYPES_KEY 		= "QuestionType.getAllQTypes";
	String NQUERY_QTYPE_GETALL_QTYPES			= "from QuestionType";
	String NQUERY_QTYPE_DELETE_QTYPE_KEY		= "QuestionType.deleteQTypeById";
	String NQUERY_QTYPE_DELETE_QTYPE			= "delete from QuestionType qType where qType.saQuestionTypeId = :"+NQ_CONST_PARAM_QTYPE_ID;
	String NQ_CONST_PARAM_QTYPE_NAME			= "paramQTypeName";
	String NQUERY_QTYPE_GETQTYPE_BY_NAME_KEY	= "QuestionType.getQTypeByName";
	String NQUERY_QTYPE_GETQTYPE_BY_NAME		= "from QuestionType where saQuestionType = :"+NQ_CONST_PARAM_QTYPE_NAME;
	
	
	// SURVEY constants
	String NQ_CONST_PARAM_SURVEY_CREATEDBY_UID 		= NQ_CONST_PARAM_UID;
	String NQUERY_SURVEY_GETALL_SURVEYS				= "from Survey";
	String NQUERY_SURVEY_GETALL_SURVEYS_KEY			= "Survey.getAllSurveys";
	String NQUERY_SURVEY_GETALL_SURVEY_BY_USER_KEY	= "Survey.getAllSurveysByUser";
	String NQUERY_SURVEY_GETALL_SURVEY_BY_USER		= "from Survey s where s.saSurveyCreatedBy.saUid = :"+NQ_CONST_PARAM_SURVEY_CREATEDBY_UID;
	
	
	// Question constants
	String NQ_CONST_PARAM_QUESTION_ID 				= "paramQId";
	String NQ_CONST_PARAM_SURVEY_ID					= "paramSurveyId";
	String NQUERY_QUESTION_DELETE_Q_BY_ID_KEY 		= "Question.deleteQById";
	String NQUERY_QUESTION_DELETE_Q_BY_ID 			= "delete from Question q where q.qId = :"+SAConstants.NQ_CONST_PARAM_QUESTION_ID;
	String NQUERY_QUESTION_GETALLQS_BY_SURVEY_KEY	= "Question.getAllQuestionsBySurvey";
	String NQUERY_QUESTION_GETALLQS_BY_SURVEY		= "from Question q where q.qBelongsToSurvey.saSid = :"+NQ_CONST_PARAM_SURVEY_ID;
	
	/*************************************************************************************************************************/
	
	
	
	/*************************************************************************************************************************/
	/********************************************Constants for DAL logic ************************************************/
	/*************************************************************************************************************************/
	String SS_STATUS_OPEN 		= "Open";
	String SS_STATUS_DRAFT 		= "Draft";
	String SS_STATUS_CLOSED		= "Closed";
	String SS_STATUS_DELETED 	= "Deleted";
	
	String QTYPE_MCQ = "MCQ";
	String QTYPE_SCQ = "SCQ";
	
	/*************************************************************************************************************************/
	
	
}
