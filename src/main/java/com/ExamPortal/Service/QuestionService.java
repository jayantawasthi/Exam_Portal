package com.ExamPortal.Service;

import java.util.Set;

import com.ExamPortal.Model.exam.Questions;
import com.ExamPortal.Model.exam.Quiz;

public interface QuestionService {

	public Questions addQuestions(Questions questions);
	
	public Questions updateQuestions(Questions questions);
	
	public Set<Questions>getQuestions();
	
	public Questions getSingleQuestion(long quesId);
		
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestions(Long quesId);
	
}
