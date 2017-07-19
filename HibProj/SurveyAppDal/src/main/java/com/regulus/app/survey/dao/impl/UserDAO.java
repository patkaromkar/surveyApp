package com.regulus.app.survey.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.regulus.app.survey.dao.iface.AbstractSurveyAppDAO;
import com.regulus.app.survey.dao.iface.IUserDAO;
import com.regulus.app.survey.entities.User;
import com.regulus.app.survey.exceptions.SAUnsupportedQueryParamException;
import com.regulus.app.survey.util.SAConstants;

/**
 * This DAO class is an implementation of the IUserDAO.
 * 
 * @author Omkar P
 *
 */
public class UserDAO extends AbstractSurveyAppDAO implements IUserDAO {

	private final Logger logger = Logger.getLogger(UserDAO.class);
	
	public UserDAO() {
		logger.debug("Start of UserDAO constructor ... attempting to initialize hibernate config");
		init();
		logger.debug("End of UserDAO constructor ... hibernate config initialized ");
	}
	
	public User createUser(final User newUser) {
		logger.debug("Start of createUser()");
		// TODO Auto-generated method stub
		
		this.session.beginTransaction();
		this.session.save(newUser);
		this.session.getTransaction().commit();
		logger.debug("End of createUser()");
		return newUser;
	}

	public User getUser(final Map<String, Object> params, final String queryName) {

		logger.debug("Start of getUser()");
		// TODO Auto-generated method stub
		this.session.beginTransaction();
		final Query getUserByUnameNPwdQuery = this.session.getNamedQuery(queryName);
		logger.debug("Query Parms are = "+params);
		final Set<Entry<String, Object>> mapContents = params.entrySet();
		for (Entry<String, Object> entry : mapContents) {
			final Object val = entry.getValue();
			if (val instanceof String) {
				getUserByUnameNPwdQuery.setString(entry.getKey(), ((String)val));
			} else {
				throw new SAUnsupportedQueryParamException(SAConstants.DAL_EX_UNSUPPORTED_QUERYPARAM_GETUSER, 
						entry.getKey(), entry.getValue().getClass().getName());
			}
		}
		final List<User> users = (List<User>) getUserByUnameNPwdQuery.list();
		
		this.session.getTransaction().commit();
		logger.debug("End of getUser()");
		return (users.size()==1)?users.get(0):null;
	}

	public boolean deleteUser(final int uId, final String paramName, final String queryName) {
		logger.debug("Start of deleteUser()");
		// TODO Auto-generated method stub
		this.session.beginTransaction();
		final Query deleteUserByUId = this.session.getNamedQuery(queryName); 
		deleteUserByUId.setInteger(paramName, uId);
		int result = deleteUserByUId.executeUpdate();
		logger.debug("Result after delete is = "+result);
		this.session.getTransaction().commit();
		logger.debug("End of deleteUser()");
		return (result==0)?false:true;
	}

	public boolean deleteUser(final User user) {
		logger.debug("Start of deleteUser(User)");
		// TODO Auto-generated method stub
		this.session.beginTransaction();
		boolean result = false;
		
		User userToBeDeleted = (User) this.session.get(User.class, user.getSaUid());
		if (null != userToBeDeleted) {
			this.session.delete(userToBeDeleted);
			result = true;
		} else {
			result = false;
		}
		this.session.getTransaction().commit();
		logger.debug("Is Delete of user successful ? "+result);
		logger.debug("End of deleteUser(User)");
		return result;
	}
	
	public boolean modifyUser(final User user) {
		logger.debug("Start of modifyUser()");
		// TODO Auto-generated method stub
		this.session.beginTransaction();
		boolean result = false;
		
		User userToBeUpdated = (User) this.session.get(User.class, user.getSaUid());
		if (null != userToBeUpdated) {
			this.session.merge(user);
			result = true;
		} else {
			result = false;
		}
		
		this.session.getTransaction().commit();
		logger.debug("Is Update of user successful ? "+result);
		logger.debug("End of modifyUser()");
		return result;
	}

	public List<User> getUserList(final Map<String, Object> params, final String queryName) {
		logger.debug("Start of getUserList()");
		this.session.beginTransaction();
		final Query getUsersByParamQuery = this.session.getNamedQuery(queryName);
		final Set<Entry<String, Object>> mapContents = params.entrySet();
		logger.debug("Query Parms are = "+params);
		for (Entry<String, Object> entry : mapContents) {
			final Object val = entry.getValue();
			if (val instanceof Integer) {
				getUsersByParamQuery
					.setInteger(entry.getKey(), ((Integer)val).intValue());
			} else if (val instanceof Boolean) {
				getUsersByParamQuery
					.setBoolean(entry.getKey(), ((Boolean)val).booleanValue());
			} else if (val instanceof Float) {
				getUsersByParamQuery
					.setFloat(entry.getKey(), ((Float)val).floatValue());
			} else if (val instanceof Double) {
				getUsersByParamQuery
					.setDouble(entry.getKey(), ((Double)val).doubleValue());
			} else if (val instanceof Short) {
				getUsersByParamQuery
					.setShort(entry.getKey(), ((Short)val).shortValue());
			} else if (val instanceof Long) {
				getUsersByParamQuery
					.setLong(entry.getKey(), ((Long)val).longValue());
			} else if (val instanceof String) {
				getUsersByParamQuery
					.setString(entry.getKey(), ((String)val));
			} else {
				throw new SAUnsupportedQueryParamException(SAConstants.DAL_EX_UNSUPPORTED_QUERYPARAM, 
						entry.getKey(), entry.getValue().getClass().getName());
			}
		}
		final List<User> users = (List<User>) getUsersByParamQuery.list();
		this.session.getTransaction().commit();
		logger.debug("End of getUserList()");
		return users;
	}

	public List<User> getAllUsers() {
		logger.debug("Start of getAllUsers()");
		this.session.beginTransaction();
		final Query getUsersQuery = this.session.getNamedQuery(SAConstants.NQUERY_USER_GETALLUSERS_KEY);
		final List<User> users = (List<User>) getUsersQuery.list();
		this.session.getTransaction().commit();
		logger.debug("End of getAllUsers()");
		return users;
	}
	
	

}
