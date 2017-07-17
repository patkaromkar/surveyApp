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

	public User getUser(final User existingUser) {
		logger.debug("Start of getUser()");
		// TODO Auto-generated method stub
		logger.debug("End of getUser()");
		return null;
	}

	public boolean deleteUser(final User user) {
		logger.debug("Start of deleteUser()");
		// TODO Auto-generated method stub
		this.session.beginTransaction();
		this.session.delete(user);
		this.session.getTransaction().commit();
		logger.debug("End of deleteUser()");
		return false;
	}

	public boolean modifyUser(final User user) {
		logger.debug("Start of modifyUser()");
		// TODO Auto-generated method stub
		logger.debug("End of modifyUser()");
		return false;
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
