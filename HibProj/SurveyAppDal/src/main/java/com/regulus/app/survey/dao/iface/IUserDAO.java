package com.regulus.app.survey.dao.iface;

import java.util.List;
import java.util.Map;

import com.regulus.app.survey.entities.User;

/**
 * This interface is used to create, delete, modify or get user
 * 
 * @author Omkar P
 *
 */
public interface IUserDAO {

	public User createUser(final User newUser);
	
	public User getUser(final User existingUser);
	
	public boolean deleteUser(final User user);
	
	public boolean modifyUser(final User user);
	
	public List<User> getUserList(final Map<String, Object> params, final String queryName);
	
	public List<User> getAllUsers();
}
