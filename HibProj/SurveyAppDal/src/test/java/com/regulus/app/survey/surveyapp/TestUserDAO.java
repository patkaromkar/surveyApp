package com.regulus.app.survey.surveyapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.regulus.app.survey.dao.impl.UserDAO;
import com.regulus.app.survey.entities.User;
import com.regulus.app.survey.util.SAConstants;
import com.regulus.app.survey.util.SADALUtil;

import junit.framework.TestCase;

/**
 * This is JUnit test case class which verifies the public methods of UserDAO
 * 
 * @author Omkar P
 *
 */
public class TestUserDAO extends TestCase {

	Logger logger = Logger.getLogger(TestUserDAO.class);
	private UserDAO userDAO = null;
	private int i = 0;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of setUp()");
		super.setUp();
		this.userDAO = new UserDAO();
		User u = null;
		i = 0;
		for(; i<10; i++) {
			u = new User();
			u.setSaUfirstName(SADALUtil.getRandomWord(9));
			u.setSaULastName(SADALUtil.getRandomWord(9));
			u.setSaUsername("asd"+i);
			u.setSaPassword("asd"+(i*2));
			u.setEmail(SADALUtil.getRandomWord(9));
			
			if (i == 2) {
				u.setSaUfirstName("Zeaasd1");
				u.setEmail("zeus@a.me");
			} else if (i == 3) {
				u.setSaUfirstName("aRasd1Mic");
			} else if (i == 4) {
				u.setSaUfirstName("asd1Dond");
				u.setSaULastName("Dondasd1");
			} 
			
			u.setSaIsAdmin((i%2==0?true:false));
			
			this.userDAO.createUser(u);
		}
		logger.debug("End of setUp()");
	}
	
	/**
	 * Test method to verify creation of user using UserDAO
	 * 
	 */
	public void testCreateUser() {
		logger.debug("Start of testCreateUser()");
		User u = new User();
		u.setSaUfirstName(SADALUtil.getRandomWord(9));
		u.setSaULastName(SADALUtil.getRandomWord(9));
		u.setSaUsername("asd11");
		u.setSaPassword("asd22");
		u.setEmail(SADALUtil.getRandomWord(9));
		u.setSaIsAdmin(true);
		
		this.userDAO.createUser(u);
		
		logger.debug("End of testCreateUser()");		
	}
	
	/**
	 * Test method to verify if all users can be retrieved from the database
	 * 
	 */
	public void testGetAllUsers() {
		logger.debug("Start of testGetAllUsers()");
		
		final List<User> users = this.userDAO.getAllUsers();
		assertEquals("As per expectation expected no of users were not retrieved", i, users.size());
		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		logger.debug("End of testGetAllUsers()");
		
	}
	
	/**
	 * Test method to verify if user can be retrieved from database for given username and pwd
	 * 
	 */
	public void testGetUserByUnameNPwd() {
		logger.debug("Start of testGetUser()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_USERNAME, "asd1");
		queryParams.put(SAConstants.NQ_CONST_PARAM_PASSWORD, "asd2");
		
		final List<User> users = this.userDAO.getUserList(queryParams, SAConstants.NQUERY_USER_GETUSER_BY_UNAME_PWD_KEY);

		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		
		assertEquals("Expected user is not retrieved !!!", false, users.get(0).isSaIsAdmin());
		
		logger.debug("End of testGetUser()");
	}

	/**
	 * Test method to verify if user can be retrieved from database for given firstname with wildcards around it
	 * 
	 */
	public void testGetUserByFnameLike() {
		logger.debug("Start of testGetUserByFnameLike()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_FNAME_WILDCARD, "%asd1%");
		
		final List<User> users = this.userDAO.getUserList(queryParams, SAConstants.NQUERY_USER_GETUSER_FNAME_LIKE_KEY);

		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		
		assertEquals("Expected No of users is not retrieved !!!", 3, users.size());
		
		logger.debug("End of testGetUserByFnameLike()");
	}
	
	
	/**
	 * Test method to verify if user can be retrieved from database for given lastname with wildcards ONLY before it
	 * 
	 */
	public void testGetUserByLnameLike() {
		logger.debug("Start of testGetUserByLnameLike()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_LNAME_WILDCARD, "%asd1");
		
		final List<User> users = this.userDAO.getUserList(queryParams, SAConstants.NQUERY_USER_GETUSER_LNAME_LIKE_KEY);

		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		
		assertEquals("Expected No of users is not retrieved !!!", 1, users.size());
		
		logger.debug("End of testGetUserByLnameLike()");
	}

	
	/**
	 * Test method to verify  if user can be retrieved from database for given email address
	 * 
	 */
	public void testGetUserByEmail() {
		logger.debug("Start of testGetUserByEmail()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_EMAIL, "zeus@a.me");
		
		final List<User> users = this.userDAO.getUserList(queryParams, SAConstants.NQUERY_USER_GETUSER_BY_EMAIL_KEY);

		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		
		assertEquals("Expected User is not retrieved !!!", "asd2", users.get(0).getSaUsername());
		
		logger.debug("End of testGetUserByEmail()");
	}

	

	/**
	 * Test method to verify if all admin users can be retrieved from database using parameters 
	 * 
	 */
	public void testGetUserByIsAdmin() {
		logger.debug("Start of testGetUserByIsAdmin()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_ISADMIN, true);
		
		final List<User> users = this.userDAO.getUserList(queryParams, SAConstants.NQUERY_USER_GETUSER_BY_ADMIN_KEY);

		for (User user : users) {
			logger.debug("User id : "+user.getSaUid()+", First Name = "+user.getSaUfirstName()+", is admin ? = "+user.isSaIsAdmin());
		}
		
		assertEquals("Expected # of Users are not retrieved !!!", 5, users.size());
		
		logger.debug("End of testGetUserByIsAdmin()");
	}

	/**
	 * Test method to verify if user can be deleted
	 * 
	 */
	public void testDeleteUser() {
		logger.debug("Start of testDeleteUser()");
		
		User user2BeDeleted = new User();
		user2BeDeleted.setSaUid(222);
		boolean isUserDeleted = this.userDAO.deleteUser(user2BeDeleted);
		
		logger.debug("Is user deletion successfull ? "+isUserDeleted);
		
		logger.debug("End of testDeleteUser()");
		
	}
	
	/**
	 * Test method to verify if user can be deleted
	 * 
	 */
	public void testDeleteUser2() {
		logger.debug("Start of testDeleteUser()");
		
		boolean isUserDeleted = this.userDAO.deleteUser(3, SAConstants.NQ_CONST_PARAM_UID, SAConstants.NQUERY_USER_DELETEUSER_BY_ID_KEY);
		
		logger.debug("Is user deletion successfull ? "+isUserDeleted);
		
		logger.debug("End of testDeleteUser()");
		
	}
	
	
	/**
	 * Test method to verify if user can be retrieved from database for given username and pwd
	 * 
	 */
	public void testGetUserByUnameNPwd2() {
		logger.debug("Start of testGetUserByUnameNPwd2()");
				
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(SAConstants.NQ_CONST_PARAM_USERNAME, "asd1");
		queryParams.put(SAConstants.NQ_CONST_PARAM_PASSWORD, "asd2");
		
		final User user = this.userDAO.getUser(queryParams, SAConstants.NQUERY_USER_GETUSER_BY_UNAME_PWD_KEY);
		assertNotNull("User object is expected, but what obtained is null !!!", user);
		
		logger.debug("End of testGetUserByUnameNPwd2()");
	}
	
	
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Start of tearDown()");
		super.tearDown();
		userDAO.closeDAO();
		logger.debug("End of tearDown()");
	}
}
