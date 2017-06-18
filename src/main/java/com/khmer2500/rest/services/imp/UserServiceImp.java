package com.khmer2500.rest.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.repositories.UserRepo;
import com.khmer2500.rest.services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired 
	private UserRepo  userRepo;
	
	@Override
	public User findUserById(Long id) {
		return userRepo.findUserById(id);
	}

	@Override
	public User findUserByName(String username) {
		return userRepo.findUserByName(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.finduserByEmail(email);
	}

	@Override
	public Boolean saveUser(User user) {
		return userRepo.saveUser(user);
	}

	@Override
	public Boolean updateUser(User user) {
		return userRepo.updateUser(user);
	}

	@Override
	public Boolean deleteUser(Long id) {
		return userRepo.deleteUser(id);
	}

	@Override
	public List<User> getAllUsers(Pagination pagination) {
		return userRepo.getAllUsers(pagination);
	}

}
