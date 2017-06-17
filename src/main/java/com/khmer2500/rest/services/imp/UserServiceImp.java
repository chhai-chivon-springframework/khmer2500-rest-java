package com.khmer2500.rest.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.entities.UserRole;
import com.khmer2500.rest.repositories.UserRepo;
import com.khmer2500.rest.services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User finduserByEmail(String email) {
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
	public Boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}



}
