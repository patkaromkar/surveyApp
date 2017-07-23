package com.regulus.app.survey.entities;

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

import com.regulus.app.survey.util.SAConstants;

/**
 * This entity object represents the question of a survey
 * 
 * @author Omkar P
 *
 */
@Entity(name="Question")
@Table(name="question")
@NamedQueries(value={
		@NamedQuery(name=SAConstants.NQUERY_QUESTION_DELETE_Q_BY_ID_KEY, 
						query=SAConstants.NQUERY_QUESTION_DELETE_Q_BY_ID),
		@NamedQuery(name=SAConstants.NQUERY_QUESTION_GETALLQS_BY_SURVEY_KEY,
						query=SAConstants.NQUERY_QUESTION_GETALLQS_BY_SURVEY)
})
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_id")
	private int qId;
	
	@Column(name="question_title", nullable=false, length=1000)
	private String qTitle;
	
	@JoinColumn(name="question_type", nullable=false)
	@OneToOne(fetch=FetchType.EAGER)
	private QuestionType qType;
	
	@JoinColumn(name="q_of_survey", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Survey qBelongsToSurvey;
	
	
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public QuestionType getqType() {
		return qType;
	}
	public void setqType(QuestionType qType) {
		this.qType = qType;
	}
	public Survey getqBelongsToSurvey() {
		return qBelongsToSurvey;
	}
	public void setqBelongsToSurvey(Survey qBelongsToSurvey) {
		this.qBelongsToSurvey = qBelongsToSurvey;
	}
	
	
}
