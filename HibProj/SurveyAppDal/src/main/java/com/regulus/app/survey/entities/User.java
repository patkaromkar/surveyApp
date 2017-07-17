package com.regulus.app.survey.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.regulus.app.survey.util.SAConstants;

/**
 * This class represents the master table SURVEYUSERS.
 * The table will hold all users who can participate in the survey.
 * There are only 2 types of users: -
 * Normal users = These are normal users who can only participate in a survey
 * Admin users	= These are special users and they have rights to create, edit, delete a survey
 *  
 * @author Omkar P
 *
 */
@Entity(name="User")
@Table(name="sa_user")
@NamedQueries(value={
		@NamedQuery(name=SAConstants.NQUERY_USER_GETALLUSERS_KEY, 
				query=SAConstants.NQUERY_USER_GETALLUSERS),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_BY_UNAME_PWD_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_BY_UNAME_PWD),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_FNAME_LIKE_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_FNAME_LIKE),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_LNAME_LIKE_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_LNAME_LIKE),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_NAME_LIKE_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_NAME_LIKE),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_BY_EMAIL_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_BY_EMAIL),
		@NamedQuery(name=SAConstants.NQUERY_USER_GETUSER_BY_ADMIN_KEY, 
				query=SAConstants.NQUERY_USER_GETUSER_BY_ADMIN)


})
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int saUid;
	
	@Column(name="first_name",
			length=10,
			nullable=false)
	private String saUfirstName;
	
	@Column(name="last_name",
			length=10,
			nullable=false)
	private String saULastName;
	
	@Column(name="username",
			length=10,
			nullable=false,
			unique=true)
	private String saUsername;
	
	@Column(name="pwd",
			length=10,
			nullable=false)
	private String saPassword;
	
	@Column(name="isAdmin",
			nullable=false)
	private boolean saIsAdmin;
	
	@Column(name="userimgloc",
			length=500)
	private String saUserPhotoLocation;
	
	@Column(name="email",
			length=90,
			nullable=false)
	private String email;
	
	
	public int getSaUid() {
		return saUid;
	}
	public void setSaUid(int saUid) {
		this.saUid = saUid;
	}
	public String getSaUfirstName() {
		return saUfirstName;
	}
	public void setSaUfirstName(String saUfirstName) {
		this.saUfirstName = saUfirstName;
	}
	public String getSaULastName() {
		return saULastName;
	}
	public void setSaULastName(String saULastName) {
		this.saULastName = saULastName;
	}
	public String getSaUsername() {
		return saUsername;
	}
	public void setSaUsername(String saUsername) {
		this.saUsername = saUsername;
	}
	public String getSaPassword() {
		return saPassword;
	}
	public void setSaPassword(String saPassword) {
		this.saPassword = saPassword;
	}
	public boolean isSaIsAdmin() {
		return saIsAdmin;
	}
	public void setSaIsAdmin(boolean saIsAdmin) {
		this.saIsAdmin = saIsAdmin;
	}
	public String getSaUserPhotoLocation() {
		return saUserPhotoLocation;
	}
	public void setSaUserPhotoLocation(String saUserPhotoLocation) {
		this.saUserPhotoLocation = saUserPhotoLocation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
