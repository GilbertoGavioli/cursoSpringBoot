package com.gilbertogavioli.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gilbertogavioli.hroauth.entities.User;
import com.gilbertogavioli.hroauth.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {

	@Autowired
	private UserService service;
	
	@GetMapping(value="/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
	
	User user = service.findByEmail(email);
	return ResponseEntity.ok(user) ;
	}
		
	
}
