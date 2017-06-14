package com.khmer2500.rest.repositories.imp;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.entities.UserRole;
import com.khmer2500.rest.repositories.UserRepo;


@Repository
@Transactional
public class UserRepoImp implements UserRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUserById(Long id) {
		try{
			return (User) sessionFactory.getCurrentSession()
										.get(User.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		try{
			return (User) sessionFactory.getCurrentSession()
										.createCriteria(User.class)
										.add(Restrictions.eq("username", username))
										.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		try {
			return  (User) sessionFactory.getCurrentSession()
								  .createCriteria(User.class)
								  .add(Restrictions.eq("email", email))
								  .uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*	@Override
	public Boolean saveUser(User user) {
		try {
			System.out.println(user.getPassword());
			user.setCreatedBy(this.findUserByUsername(getPrincipal()));
			user.setCreatedDate(new Date());
			user.setLastUpdatedBy(this.findUserByUsername(getPrincipal()));
			user.setLastUpdatedDate(new Date());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			return sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
*/
	/*@Override
	public Boolean updateUser(User userUpdate) {
		try {
			User user = (User) sessionFactory.getCurrentSession()
											 .get(User.class, userUpdate.getId());
			Long id = user.getUserRoles()
						  .iterator()
						  .next()
						  .getId();
			System.out.println(id);
			UserRole userRole = (UserRole) sessionFactory.getCurrentSession()
														 .get(UserRole.class, id);
			Set userRoles = new HashSet<UserRole>();
			userRoles.add(userRole);
			user.setLastUpdatedBy(this.findUserByUsername(getPrincipal()));
			user.setLastUpdatedDate(new Date());
			user.setEmail(userUpdate.getEmail());
			user.setFirstName(userUpdate.getFirstName());
			user.setLastName(userUpdate.getLastName());
			user.setStatus(userUpdate.getStatus());
			user.setUserRoles(userRoles);
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}*/

	@Override
	public List<User> getAllUsers() {
		try {
			return (List<User>)sessionFactory.getCurrentSession()
											 .createCriteria(User.class)
											 .list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		try {
			return (List<UserRole>)sessionFactory.getCurrentSession()
												 .createCriteria(UserRole.class)
												 .list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}


	/*@Override
	public Boolean updateUserStatus(Long id) {
		try {
			Session session = null;
			try{
				session = sessionFactory.getCurrentSession();
				User user = session.load(User.class, id);
				if(user.getStatus().equals(Status.ACTIVE)){
					user.setStatus(Status.INACTIVE);
				}else if(user.getStatus().equals(Status.INACTIVE)){
					user.setStatus(Status.ACTIVE);
				}else {
					user.setStatus(Status.ACTIVE);
				}
				user.setLastUpdatedDate(new Date());
				return true;
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
		return false;
	}*/

	/*@Override
	public Boolean deleteUser(Long id) {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			User user = session.load(User.class, id);
			user.setStatus(Status.DELETED);
			user.setLastUpdatedDate(new Date());
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
*/
	/*private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}*/
}
