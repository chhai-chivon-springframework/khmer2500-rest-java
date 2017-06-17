package com.khmer2500.rest.services;

import java.util.List;

import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.entities.User;



public interface UserService {
	public User findUserById(Long id);
	public User findUserByName(String name);
	public User finduserByEmail(String email);
	public Boolean saveUser(User user);
	public Boolean updateUser(User user);
	public Boolean deleteUser(Long id);
	public List<User> getAllUsers(Pagination pagination);
}
