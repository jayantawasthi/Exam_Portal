package com.ExamPortal.ServiceImplementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortal.Model.exam.Category;
import com.ExamPortal.Repositories.CategoryRepository;
import com.ExamPortal.Service.CategoryService;

@Service
public class CategorySeviceImpl  implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>( this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		Category category =new Category();
		category.setcId(categoryId);

		this.categoryRepository.delete(category);
	}

}
