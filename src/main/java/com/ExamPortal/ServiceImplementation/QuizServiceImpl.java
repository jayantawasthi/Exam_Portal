package com.ExamPortal.ServiceImplementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ExamPortal.Model.exam.Category;
import com.ExamPortal.Model.exam.Quiz;
import com.ExamPortal.Repositories.QuizRepository;
import com.ExamPortal.Service.QuizService;

@Service
public class QuizServiceImpl  implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	//save quiz
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	//update quiz
	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	//get all quizzes
	
	public Page<Quiz> getQuizzes(Pageable pageable) {
		
		//current page
		//per page=3
		return this.quizRepository.findAll( pageable) ;
	}

	//get single quiz
	public Quiz getQuiz(Long quizId) {
		return (Quiz) this.quizRepository.findById(quizId).get();
	}

	//delete quiz
	@Override
	public void deleteQuiz(Long quizId) {
		
		Quiz quiz =new Quiz();
		quiz.setqId(quizId);

		this.quizRepository.delete(quiz);
	}

	//get quizzes of given category
	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		return this.quizRepository.findBycategory(category);
	}

	//get active quiz only
	public Page<Quiz> getActiveQuizzes(org.springframework.data.domain.Pageable pageable) {
		return  quizRepository.findByActive(pageable,true);
		
	}

	//get active of quizzes of  given category
	public Page<Quiz> getActiveQuizzesOfCategory(Category category,org.springframework.data.domain.Pageable pageable) {
		return this.quizRepository.findBycategoryAndActive(category, true,pageable);
	}


//	public List<Quiz> getActiveQuizzesOfCategory(Category category) {
//		return this.quizRepository.findBycategoryAndActive(category, true);
//
//	}

	

}
