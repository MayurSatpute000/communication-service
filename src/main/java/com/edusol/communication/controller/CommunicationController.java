package com.edusol.communication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.communication.model.User;
import com.edusol.communication.service.CommunicationService;


@RestController
@RequestMapping("/communication")
public class CommunicationController {
	
	@Autowired
	private CommunicationService communicationService;
	
	@GetMapping("/get-users")
	public List<User> getUsers(){
		
		return communicationService.getUsers();
	}
	
	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user){
		
		return communicationService.updateUser(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable int id){
		
		return communicationService.deleteUser(id);
	}
	
	@PostMapping("/add-user")
	public String addUser(@RequestBody User user){
		
		return communicationService.addUser(user);
	}
	
	@GetMapping("/get-By-city/{city}")
	public List<User> getUserByCity(@PathVariable String city){
		
		return communicationService.getUserByCity(city);
	}
	
	@GetMapping("/get-by-id/{id}")
	public List<User> getUserById(@PathVariable int id){
		
		return communicationService.getUserById(id);
	}
	
	@GetMapping("/get-by-email/{email}")
	public List<User> getUserById(@PathVariable String email){
		
		return communicationService.getUserByEmail(email);
	}
	@DeleteMapping("/delete-by-city/{city}")
	public String deleteUser(@PathVariable String city){
		
		return communicationService.deleteByCity(city);
	}

}
