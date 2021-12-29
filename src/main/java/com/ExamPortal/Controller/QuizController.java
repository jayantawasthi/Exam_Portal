package com.ExamPortal.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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

import com.ExamPortal.Model.exam.Category;
import com.ExamPortal.Model.exam.Quiz;
import com.ExamPortal.Service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	// add quiz
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}

	// update Quiz
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.updateQuiz(quiz);
	}

	// Get single Quiz
	@GetMapping("/{quizId}")
	public Quiz getSingleQuiz(@PathVariable("quizId") long qId) {
//		System.out.println("inside singlequiz ");
		return this.quizService.getQuiz(qId);
	}

	// Get all Quiz
	@GetMapping("/user/{pageNumber}")
	public Page<Quiz> geAllQuiz(@PathVariable("pageNumber") int pageNumber) {
//		System.out.println("inside quiz");

		Pageable pageRequest = PageRequest.of(pageNumber, 3,Sort.by("numberOfQuestions").ascending());
		return quizService.getQuizzes(pageRequest);
	}

	// delete Quiz
	@DeleteMapping("/{qId}")
	public void deleteQuiz(@PathVariable("qId") long qid) {
		this.quizService.deleteQuiz(qid);
	}

	// get Quizzes of category
	@GetMapping("categories/{qId}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("qId") long qid) {

		Category category = new Category();
		category.setcId(qid);
		List<Quiz> quizzesOfCategory = this.quizService.getQuizzesOfCategory(category);
		System.out.println("jwwwrw");
		return quizzesOfCategory;

	}

	// get active quizzes
	@GetMapping("/active/{page}")
	public Page<Quiz> getActiveQuizzes(@PathVariable("page") int page) {

		Pageable pageRequest = PageRequest.of(page, 4,Sort.by("title").ascending());

		Page<Quiz> activeQuizzes = (Page<Quiz>) this.quizService.getActiveQuizzes(pageRequest);
		return activeQuizzes;
	}

	// get active quizzes of given category
	@GetMapping("/category/active/{cid}/{pagenumber}")
	public Page<Quiz> getActiveQuizzes(@PathVariable("cid") long cid, @PathVariable("pagenumber") int pagenumber) {

		Category category = new Category();
		category.setcId(cid);
		Pageable pageRequest = PageRequest.of(pagenumber, 4,Sort.by("title").ascending());

		Page<Quiz> activeQuizzesOfCategory = this.quizService.getActiveQuizzesOfCategory(category, pageRequest);
		return  activeQuizzesOfCategory;
	}
	
//	// get active quizzes of given category
//	@GetMapping("/category/active/{cid}")
//	public List<Quiz> getActiveQuizzes(@PathVariable("cid") long cid){
//		
//		Category category = new Category();
//		
//		category.setcId(cid);
////		Pageable pageRequest = PageRequest.of(pagenumber, 4);
//		
//		List<Quiz> activeQuizzesOfCategory = this.quizService.getActiveQuizzesOfCategory(category);
////		 System.out.println(activeQuizzesOfCategory.toString());
//		return (List<Quiz>) activeQuizzesOfCategory.stream().sorted((a,b)->a.getTitle().compareTo(b.getTitle()));
//		
//	}
}
