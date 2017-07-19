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
	/*************************************************************************************************************************/
	
	
	/*************************************************************************************************************************/
	/***********************************************Constants for Named Queries***********************************************/
	/*************************************************************************************************************************/
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
	/*************************************************************************************************************************/
	
	
	
	
}
