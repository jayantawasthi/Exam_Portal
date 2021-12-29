package com.ExamPortal.Repositories;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.ExamPortal.Model.exam.Category;
import com.ExamPortal.Model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
	
//	findByQuiz()

	List<Quiz> findBycategory(Category category);
	
	Page<Quiz> findByActive(Pageable pageable,Boolean b);
	
	Page<Quiz> findBycategoryAndActive(Category category,boolean b,Pageable pageable);
//	List<Quiz> findBycategoryAndActive(Category category,boolean b);


//	Page findById(Long quizId, Pageable pageable);

}
