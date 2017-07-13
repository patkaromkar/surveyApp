package com.regulus.app.survey.entities;

public class User {

	private int saUid;
	private String saUfirstName;
	private String saULastName;
	private String saUsername;
	private String saPassword;
	private boolean saIsAdmin;
	private String saUserPhotoLocation;
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
