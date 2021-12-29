package com.ExamPortal.Service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ExamPortal.Model.exam.Category;
import com.ExamPortal.Model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz  quiz);
	
	public Quiz updateQuiz(Quiz  quiz);
	
	public Page<Quiz>getQuizzes(Pageable pageable);
	
	public Quiz getQuiz(Long  quizId);
	
	public void deleteQuiz(Long  quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);
	
	public Page<Quiz> getActiveQuizzes (Pageable pageRequest );
	
	public Page<Quiz> getActiveQuizzesOfCategory(Category category,Pageable pageable);
//	public List<Quiz> getActiveQuizzesOfCategory(Category category);
	
	

}
