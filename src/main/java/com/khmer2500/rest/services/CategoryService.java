package com.khmer2500.rest.services;

import java.util.List;

import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.Pagination;

public interface CategoryService {
	public Category findCategoryById(Long id);
	public Category findCategoryByName(String name);
	public Boolean saveCategory(Category category);
	public Boolean updateCategory(Category category);
	public Boolean deleteCategory(Long id);
	public List<Category> getAllCategories(Pagination pagination);
}
