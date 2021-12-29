package com.ExamPortal.Repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortal.Model.exam.Questions;
import com.ExamPortal.Model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
 Set<Questions>	findByQuiz(Quiz quiz);
}
