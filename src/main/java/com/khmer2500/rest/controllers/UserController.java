package com.khmer2500.rest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmer2500.rest.entities.Pagination;
import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.form.UserForm;
import com.khmer2500.rest.services.UserService;

@Controller
@RequestMapping(value = "/api/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/get-all-users", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> getAllUsers(
			@RequestParam(value ="page", required = false , defaultValue="1") int page,
			@RequestParam(value ="limit", required = false , defaultValue="15") int limit
			){
		Map<String,Object> map = new HashMap<String, Object>();
		Pagination pagination = new Pagination();
			pagination.setPage(page);
			pagination.setLimit(limit);
			try {
				if((userService.getAllUsers(pagination)) != null){
					map.put("DATA", userService.getAllUsers(pagination));
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
	
	@RequestMapping(value="/find-user-by-id/{id}", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> findUserById(@PathVariable("id") Long id){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<User> users = new ArrayList<>();
				if(userService.findUserById(id) != null){
					users.add(userService.findUserById(id));
				map.put("DATA", users);
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
	
	@RequestMapping(value="/find-user-by-name/{username}", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> findUserByName(@PathVariable("username") String username){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<User> users = new ArrayList<>();
				if(userService.findUserByName(username) != null){
					users.add(userService.findUserByName(username));
					map.put("DATA", users);
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
	

	@RequestMapping(value="/find-user-by-email/{email}", method = RequestMethod.GET,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> findUserByEmail(@PathVariable("email") String email){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<User> users = new ArrayList<>();
				if(userService.findUserByEmail(email) != null){
					users.add(userService.findUserByEmail(email));
					map.put("DATA", users);
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
	
	@RequestMapping(value="/save-user", method = RequestMethod.POST,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> saveUser(@RequestBody UserForm  userForm){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				List<User> users = new ArrayList<>();
				User user= new User();
						user.setUsername(userForm.getUsername());
						user.setPassword(userForm.getPassword());
						user.setFirstName(userForm.getFirstName());
						user.setLastName(userForm.getLastName());
						user.setEmail(userForm.getEmail());
				if(userService.saveUser(user)){
					users.add(user);
					map.put("DATA", users);
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
	
	@RequestMapping(value="/update-user/{id}", method = RequestMethod.PUT,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> updateUser(@PathVariable("id") Long id,@RequestBody UserForm  userForm){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				User user = userService.findUserById(id);
					user.setUsername(userForm.getUsername());
					user.setPassword(userForm.getPassword());
					user.setFirstName(userForm.getFirstName());
					user.setLastName(userForm.getLastName());
					user.setEmail(userForm.getEmail());
				List<User> users = new ArrayList<>();
					users.add(user);
				if(userService.updateUser(user)){
					map.put("DATA", users);
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
	
	@RequestMapping(value="/delete-user/{id}" , method = RequestMethod.DELETE,headers = "Accept=Application/json")
	public ResponseEntity<Map<String,Object>> deleteUser(@PathVariable("id") Long id){
		Map<String,Object> map = new HashMap<String, Object>();
			try {
				if(userService.deleteUser(id)){
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
