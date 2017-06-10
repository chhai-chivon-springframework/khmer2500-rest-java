package com.khmer2500.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khmer2500.api.ResponseApi;
import com.khmer2500.rest.entities.User;
import com.khmer2500.rest.services.UserService;

@Controller
@RequestMapping(value = "/api/users")
public class UserController extends ResponseApi {
	
	@Autowired
	private UserService userService;
	
	Map<String, Object>  map = new HashMap<>();
	
	@RequestMapping(value = "/find-user-username/{username}")
	public ResponseEntity<Map<String, Object>> findUserByUsername(@PathVariable("username") String username){
		List<User> listUsers = new ArrayList<>();
		 if((userService.findUserByUsername(username)) != null){
			 map.put("DATA", listUsers);
			 map.put("STATUS", true);
			 map.put("MESSAGE", "SUCCESS");
		 }else{
			 map.put("STATUS", false);
			 map.put("MESSAGE", "FAIL");
		 }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/find-user-email/{email}")
	public ResponseEntity<Map<String, Object>> findUserByEmail(@PathVariable("email") String email){
		List<User> listUsers = new ArrayList<>();
		 if((userService.findUserByEmail(email)) != null){
			 map.put("DATA", listUsers);
			 map.put("STATUS", true);
			 map.put("MESSAGE", "SUCCESS");
		 }else{
			 map.put("STATUS", false);
			 map.put("MESSAGE", "FAIL");
		 }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-all-users")
	public ResponseEntity<Map<String, Object>> getAllUsers(){
		List<User> listUsers = new ArrayList<>();
		 if(!(userService.getAllUsers()).isEmpty()){
			 map.put("DATA", listUsers);
			 map.put("STATUS", true);
			 map.put("MESSAGE", "SUCCESS");
		 }else{
			 map.put("STATUS", false);
			 map.put("MESSAGE", "FAIL");
		 }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-all-users-role")
	public ResponseEntity<Map<String, Object>> getAllUserRoles(){
		List<User> listUsers = new ArrayList<>();
		 if(!(userService.getAllUserRoles()).isEmpty()){
			 map.put("DATA", listUsers);
			 map.put("STATUS", true);
			 map.put("MESSAGE", "SUCCESS");
		 }else{
			 map.put("STATUS", false);
			 map.put("MESSAGE", "FAIL");
		 }
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
	
}
