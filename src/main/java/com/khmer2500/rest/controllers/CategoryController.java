package com.khmer2500.rest.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khmer2500.rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmer2500.rest.api.ResponseApi;
import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.form.CategoryForm;
import com.khmer2500.rest.services.CategoryService;

@Controller
@RequestMapping(value ="/api/category")
public class CategoryController extends ResponseApi {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/get-all-category", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> getAllCategory(
			@RequestParam(value ="page", required = false , defaultValue="1") int page,
			@RequestParam(value ="limit", required = false , defaultValue="15") int limit
			){
		Map<String,Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
			pagination.setPage(page);
			pagination.setLimit(limit);
			try {
				if((categoryService.getAllCategories(pagination) != null)){
					map.put("DATA", categoryService.getAllCategories(pagination));
					map.put("STATUS", true);
					map.put("MESSAGE", "SUCCESS");
					map.put("PAGE", pagination.getPage());
					map.put("LIMIT", pagination.getLimit());
				}else{
					map.put("DATA","NOT FOUND");
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
				map.put("STATUS", false);
				map.put("MESSAGE", "FAIL");
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-category-by-id/{id}", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> findCategoryById(@PathVariable("id") Long id){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<Category> categories = new ArrayList<>();
				if(categoryService.findCategoryById(id) != null){
					categories.add(categoryService.findCategoryById(id));
					map.put("DATA", categories);
					map.put("STATUS", true);
					map.put("MESSAGE", "SUCCESS");
				}else{
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/find-category-by-name/{name}", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> findCategoryByName(@PathVariable("name") String name){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<Category> categories = new ArrayList<>();
				if(categoryService.findCategoryByName(name) != null){
					categories.add(categoryService.findCategoryByName(name));
					map.put("DATA", categories);
					map.put("STATUS", true);
					map.put("MESSAGE", "SUCCESS");
				}else{
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/save-category", method = RequestMethod.POST,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> saveCategory(@RequestBody CategoryForm  categoryForm){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<Category> categories = new ArrayList<>();
				Category category= new Category();
						category.setName(categoryForm.getName());
						category.setDescription(categoryForm.getDescription());
						category.setDate(new Date());
				if(categoryService.saveCategory(category)){
					categories.add(category);
					map.put("DATA", categories);
					map.put("STATUS", true);
					map.put("MESSAGE", "SUCCESS");
				}else{
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-category/{id}", method = RequestMethod.PUT,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> updateCategory(@PathVariable("id") Long id,@RequestBody CategoryForm  categoryForm){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				Category category = categoryService.findCategoryById(id);
					category.setName(categoryForm.getName());
					category.setDescription(categoryForm.getDescription());
					category.setDate(new Date());
				List<Category> categories = new ArrayList<>();
					categories.add(category);
				if(categoryService.updateCategory(category)){
					map.put("DATA", categories);
					map.put("STATUS", true);
					map.put("MESSAGE", "SUCCESS");
				}else{
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-category/{id}" , method = RequestMethod.DELETE,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> deleteCategory(@PathVariable("id") Long id){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				if(categoryService.deleteCategory(id)){
					map.put("STATUS", true);
					map.put("MESSAGE", "DELETE SUCCESS");
				}else{
					map.put("STATUS", false);
					map.put("MESSAGE", "FAIL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
