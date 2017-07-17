package com.regulus.app.survey.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the master table SURVEYSTATUS.
 * The table will hold possible states a survey can have.
 * 
 * A survey can have following states: -
 * Open 	- Survey is available for users participation
 * Draft	- Survey is in draft mode and not yet available for users participation
 * Closed	- Survey is closed for users participation
 * Deleted	- Survey is deleted (soft delete) by admin and no longer available for the participation by users
 * 
 * @author Omkar P
 *
 */
@Entity(name="SurveyStatus")
@Table(name="sa_surveystatus")
public class SurveyStatus {

	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int saSurveyStatusId;
	
	@Column(name="status_name",
			length=10,
			nullable=false)
	private String saSurveyStatusName;
	
	public int getSaSurveyStatusId() {
		return saSurveyStatusId;
	}
	public void setSaSurveyStatusId(int saSurveyStatusId) {
		this.saSurveyStatusId = saSurveyStatusId;
	}
	public String getSaSurveyStatusName() {
		return saSurveyStatusName;
	}
	public void setSaSurveyStatusName(String saSurveyStatusName) {
		this.saSurveyStatusName = saSurveyStatusName;
	}
	
	
}
