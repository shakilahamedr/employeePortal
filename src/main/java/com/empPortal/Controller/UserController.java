package com.empPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empPortal.model.User;
import com.empPortal.repository.UserRepository;
import com.empPortal.vo.JwtRequest;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRep;
	
//	@PostMapping("/saveUser")
//	public User saveUser(@RequestBody User user) {
//		userRep.save(user);
//		return user;
//	}
	
	@PostMapping("/login")
	public User login(@RequestBody JwtRequest cred ) {
		return userRep.findByUsername(cred.getUsername());
	}
	
	
}
