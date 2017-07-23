package com.regulus.app.survey.dao.iface;

import java.util.List;

import com.regulus.app.survey.entities.QuestionType;
import com.regulus.app.survey.exceptions.QuestionTypeNotFoundException;

/**
 * This interface is used to represent the QuestionTypeDAO to perform operations like create, delete, modify or get QuestionType
 * 
 * @author Omkar P
 *
 */
public interface IQTypeDAO {

	public QuestionType createQuestionType(final QuestionType newQuestionType);
	
	public QuestionType getQuestionType(final int questionTypeID);
	
	public QuestionType getQuestionType(final String questionType)  throws QuestionTypeNotFoundException ;
	
	public boolean deleteQuestionType(final int ssId, final String paramName);
	
	public boolean modifyQuestionType(final QuestionType questionType);
	
	public List<QuestionType> getAllQuestionTypes();
	
}
