package com.regulus.app.survey.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.regulus.app.survey.util.SAConstants;

/**
 * This class represents the transaction table SURVEY.
 * The table will hold surveys available in the system.
 * 
 * 
 * @author Omkar P
 *
 */
@Entity(name="Survey")
@Table(name="survey")
@NamedQueries(value={
		@NamedQuery(name=SAConstants.NQUERY_SURVEY_GETALL_SURVEYS_KEY,
						query=SAConstants.NQUERY_SURVEY_GETALL_SURVEYS),
		@NamedQuery(name=SAConstants.NQUERY_SURVEY_GETALL_SURVEY_BY_USER_KEY,
			query=SAConstants.NQUERY_SURVEY_GETALL_SURVEY_BY_USER)
		
})
public class Survey {

	@Id
	@Column(name="survey_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int saSid;
	
	@Column(name="survey_title",
			length=1000,
			nullable=false)
	private String saSurveyTitle;
	
	@Column(name="doc") // doc = date of creation
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date saSurveyCreatedOn;
	
	@JoinColumn(name="created_by", nullable=false)
	@ManyToOne(cascade=CascadeType.ALL,
				fetch=FetchType.LAZY)
	private User saSurveyCreatedBy;

	@JoinColumn(name="survey_status", nullable=false)
	@OneToOne(fetch=FetchType.EAGER)
	private SurveyStatus saSS;
	
	public int getSaSid() {
		return saSid;
	}

	public void setSaSid(int saSid) {
		this.saSid = saSid;
	}

	public String getSaSurveyTitle() {
		return saSurveyTitle;
	}

	public void setSaSurveyTitle(String saSurveyTitle) {
		this.saSurveyTitle = saSurveyTitle;
	}

	public Date getSaSurveyCreatedOn() {
		return saSurveyCreatedOn;
	}

	public void setSaSurveyCreatedOn(Date saSurveyCreatedOn) {
		this.saSurveyCreatedOn = saSurveyCreatedOn;
	}

	public User getSaSurveyCreatedBy() {
		return saSurveyCreatedBy;
	}

	public void setSaSurveyCreatedBy(User saSurveyCreatedBy) {
		this.saSurveyCreatedBy = saSurveyCreatedBy;
	}

	public SurveyStatus getSaSS() {
		return saSS;
	}

	public void setSaSS(SurveyStatus saSS) {
		this.saSS = saSS;
	}

	

}
