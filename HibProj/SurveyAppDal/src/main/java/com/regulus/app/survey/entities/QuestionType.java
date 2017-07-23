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
 * This class represents the master table SURVEYQTYPE.
 * The table will hold possible Types of question a survey can have.
 * 
 * A Question can be of following types: -
 * MCQ 	- Multiple Choice Questions. These questions are characterized by answers having checkboxes on UI
 * SCQ	- Single  Choice Questions. These questions are characterized by answers having either radio buttons or drop down list
 * 
 * @author Omkar P
 *
 */
@Entity(name="QuestionType")
@Table(name="sa_question_type")
@NamedQueries(value={
		@NamedQuery(name=SAConstants.NQUERY_QTYPE_GETALL_QTYPES_KEY,
						query=SAConstants.NQUERY_QTYPE_GETALL_QTYPES),
		@NamedQuery(name=SAConstants.NQUERY_QTYPE_DELETE_QTYPE_KEY,
						query=SAConstants.NQUERY_QTYPE_DELETE_QTYPE),
		@NamedQuery(name=SAConstants.NQUERY_QTYPE_GETQTYPE_BY_NAME_KEY,
						query=SAConstants.NQUERY_QTYPE_GETQTYPE_BY_NAME)
})

public class QuestionType {

	@Id
	@Column(name="qtype_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int saQuestionTypeId;
	
	@Column(name="qtype_name",
			nullable=false,
			length=5)
	private String saQuestionType;
	
	public int getSaQuestionId() {
		return saQuestionTypeId;
	}
	public void setSaQuestionId(int saQuestionId) {
		this.saQuestionTypeId = saQuestionId;
	}
	public String getSaQuestionType() {
		return saQuestionType;
	}
	public void setSaQuestionType(String saQuestionType) {
		this.saQuestionType = saQuestionType;
	}
	
}
