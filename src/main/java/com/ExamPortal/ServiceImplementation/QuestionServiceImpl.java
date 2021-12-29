package com.ExamPortal.ServiceImplementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortal.Model.exam.Questions;
import com.ExamPortal.Model.exam.Quiz;
import com.ExamPortal.Repositories.QuestionRepository;
import com.ExamPortal.Service.QuestionService;
import com.ExamPortal.Service.QuizService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Questions addQuestions(Questions questions) {
		return this.questionRepository.save(questions);
	}

	@Override
	public Questions updateQuestions(Questions questions) {
		return this.questionRepository.save(questions);
	}

	@Override
	public Set<Questions> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz) {

	return this.questionRepository.findByQuiz(quiz);
}

	@Override
	public Questions getSingleQuestion(long quesId) {
		return this.questionRepository.findById(quesId).get() ;
	}

	@Override
	public void deleteQuestions(Long quesId) {

		this.questionRepository.deleteById(quesId);
	}
	
	
	

}
