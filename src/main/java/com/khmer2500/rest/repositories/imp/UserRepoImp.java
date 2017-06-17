package com.khmer2500.rest.repositories.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.repositories.UserRepo;


@Repository
@Transactional
public class UserRepoImp implements UserRepo{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public User findUserById(Long id) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class,"user") .add(Restrictions.eq("user.id",id)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public User findUserByName(String name) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class,"user") .add(Restrictions.eq("user.name",name)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public User finduserByEmail(String email) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class,"user") .add(Restrictions.eq("user.email",email)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean deleteUser(Long id) {
		try {
			User user = sessionFactory.getCurrentSession().load(User.class, id);
			if (user != null) {
				sessionFactory.getCurrentSession().delete(user);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public List<User> getAllUsers(Pagination pagination) {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.setFirstResult(pagination.offset());
			criteria.setMaxResults(pagination.getLimit());
			List<User> users = (List<User>)criteria.list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
