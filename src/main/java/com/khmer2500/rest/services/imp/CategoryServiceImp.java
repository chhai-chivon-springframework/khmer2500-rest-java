package com.khmer2500.rest.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.repositories.CategoryRepo;
import com.khmer2500.rest.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category findCategoryById(Long id) {
		return categoryRepo.findCategoryById(id);
	}

	@Override
	public Category findCategoryByName(String name) {
		return categoryRepo.findCategoryByName(name);
	}

	@Override
	public Boolean saveCategory(Category category) {
		return categoryRepo.saveCategory(category);
	}

	@Override
	public Boolean updateCategory(Category category) {
		return categoryRepo.updateCategory(category);
	}

	@Override
	public Boolean deleteCategory(Long id) {
		return categoryRepo.deleteCategory(id);
	}

	@Override
	public List<Category> getAllCategories(Pagination pagination) {
		return categoryRepo.getAllCategories(pagination);
	}

}
