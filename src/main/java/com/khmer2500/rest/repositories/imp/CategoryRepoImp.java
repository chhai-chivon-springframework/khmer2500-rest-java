package com.khmer2500.rest.repositories.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.repositories.CategoryRepo;



@Repository
public class CategoryRepoImp implements CategoryRepo{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Category findCategoryById(Long id) {
		try {
			return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class,"category") .add(Restrictions.eq("category.id",id)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Category findCategoryByName(String name) {
		try {
			return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class,"category") .add(Restrictions.eq("category.name",name)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Boolean saveCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean deleteCategory(Long id) {
		try {
			Category category = sessionFactory.getCurrentSession().load(Category.class, id);
			if (category != null) {
				sessionFactory.getCurrentSession().delete(category);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	@Transactional
	public List<Category> getAllCategories(Pagination pagination) {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.setFirstResult(pagination.offset());
			criteria.setMaxResults(pagination.getLimit());
			List<Category> categories = (List<Category>)criteria.list();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
