package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Users;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "https://reactjs-springboot.herokuapp.com")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping(value="/rest/hello")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(value="/rest/hello/{name}")
	public String helloWorldName(@PathVariable String name) {
		return "Hello "+name;
	}
	
	@GetMapping(value = "/rest/users")
	public List<Users> getAllUsers() {

		return repository.findAll();

	}
	
	@PostMapping(value = "/rest/users")
	public List<Users> createUser(@RequestBody Users user) {
		repository.save(user);
		return repository.findAll();
		
	}

}
