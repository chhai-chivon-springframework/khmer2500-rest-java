package com.khmer2500.services;

import java.util.List;

import com.khmer2500.entities.User;
import com.khmer2500.entities.UserRole;

public interface UserService {
public User findUserById(Long id);
	
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	//public Boolean saveUser(User user);
	
	//public Boolean updateUser(User user);
	
	public List<User> getAllUsers();
	
	public List<UserRole> getAllUserRoles();
	
	/*public Boolean updateUserStatus(Long id);*/
	
	//public Boolean deleteUser(Long id);
}
