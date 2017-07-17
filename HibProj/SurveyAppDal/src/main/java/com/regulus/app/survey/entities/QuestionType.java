package com.regulus.app.survey.entities;

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
public class QuestionType {

	private int saQuestionId;
	private String saQuestionType;
	
	public int getSaQuestionId() {
		return saQuestionId;
	}
	public void setSaQuestionId(int saQuestionId) {
		this.saQuestionId = saQuestionId;
	}
	public String getSaQuestionType() {
		return saQuestionType;
	}
	public void setSaQuestionType(String saQuestionType) {
		this.saQuestionType = saQuestionType;
	}
	
	
}
