package com.accolite.web.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.internal.engine.valueextraction.ArrayElement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.web.demo.models.Users;
import com.accolite.web.demo.services.UserServices;

@RestController
public class SecondController {
	private final Users userService = new Users();
	private static Map<Integer,Users> users = new HashMap<Integer,Users>();
	
	@PostMapping(path="/save-cust-info")
	public String addUser(@RequestBody Users user)
	{
		users.put(user.getId(),user);
		return user.getId()+" "+user.getSalary();
	}
	
	@GetMapping("user/{id}")
	public int getUserById(@PathVariable int id)
	{
		return userService.getId();
	}
	
	@DeleteMapping("deluser/{id}")
	public String deleteUserById(@PathVariable int id) {
		if(users.get(id)==null)return "user dosent exist";
		users.remove(id);
		return "User removed ";
	}
	
	
	
	
	
	
	
}