package com.ExamPortal.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortal.Model.exam.Questions;
import com.ExamPortal.Model.exam.Quiz;
import com.ExamPortal.Service.QuestionService;
import com.ExamPortal.Service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public Questions addQuestions(@RequestBody Questions questions) {
		return this.questionService.addQuestions(questions);
	}
	
	//update question
	@PutMapping("/")
	public Questions updateQuestions(@RequestBody Questions questions) {
		return this.questionService.updateQuestions(questions);
	}
	
	//get question
	
	@GetMapping("/{quesId}")
	public Questions getSingleQuestions(@PathVariable("quesId")  long quesId) {
		return this.questionService.getSingleQuestion(quesId);
}
	
	//get all questions
	@GetMapping("/")
	public Set<Questions> getAllQuestions(@RequestBody Questions questions) {
	return	this.questionService.getQuestions();
	}
	
	//delete questions	
	@DeleteMapping("/{quesId}")
	public void deleteQuestions(@PathVariable("quesId") long quesId) {
		 this.questionService.deleteQuestions(quesId);
	}
	
	//get all question of any qid
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") long qid){
		
		
		
		Quiz quiz = this.quizService.getQuiz(qid);
//		System.out.println(quiz);
		Set<Questions> questions = quiz.getQuestions();
		
		List list = new ArrayList<>(questions);
		if (list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
			
		}
		
		Collections.shuffle(list);

		return ResponseEntity.ok(list);
	}
	
	//get questions of quiz
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") long qid){
		
		Quiz quiz=new Quiz();
		quiz.setqId(qid);
		Set<Questions> questions=this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questions);
	}
}
