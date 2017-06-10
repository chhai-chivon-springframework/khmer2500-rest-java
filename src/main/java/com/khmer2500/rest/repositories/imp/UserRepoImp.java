package com.khmer2500.rest.repositories.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.entities.UserRole;
import com.khmer2500.rest.repositories.UserRepo;


@Repository
public class UserRepoImp implements UserRepo{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateUserStatus(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
