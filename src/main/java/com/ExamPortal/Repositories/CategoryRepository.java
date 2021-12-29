package com.ExamPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortal.Model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
