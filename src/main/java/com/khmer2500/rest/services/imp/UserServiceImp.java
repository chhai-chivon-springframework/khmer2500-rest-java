package com.khmer2500.rest.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.entities.UserRole;
import com.khmer2500.rest.repositories.UserRepo;
import com.khmer2500.rest.services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User findUserById(Long id) {
		return userRepo.findUserById(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findUserByEmail(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.getAllUsers();
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRepo.getAllUserRoles();
	}

}
