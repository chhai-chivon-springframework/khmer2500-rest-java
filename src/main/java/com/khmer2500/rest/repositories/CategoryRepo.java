package com.khmer2500.rest.repositories;

import java.util.List;
import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.Pagination;
public interface CategoryRepo {
	public Category findCategoryById(Long id);
	public Category findCategoryByName(String name);
	public Boolean saveCategory(Category category);
	public Boolean updateCategory(Category category);
	public Boolean deleteCategory(Long id);
	public List<Category> getAllCategories(Pagination pagination);
}
