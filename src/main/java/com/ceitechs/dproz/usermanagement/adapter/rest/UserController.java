package com.ceitechs.dproz.usermanagement.adapter.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceitechs.dproz.shared.rest.util.HeaderUtil;
import com.ceitechs.dproz.shared.security.errors.CustomParameterizedException;
import com.ceitechs.dproz.usermanagement.domain.User;
import com.ceitechs.dproz.usermanagement.domain.UserService;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/dproz/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	} 
	
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id){	
		return ResponseUtil.wrapOrNotFound(userService.getUser(id));
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> addUser(@RequestBody User user){	
		User userAdded = userService.addUser(user);
		 return ResponseEntity.ok()
		            .headers(HeaderUtil.createEntityUpdateAlert("USER", userAdded.getUserReferenceId()))
		            .body(userAdded);
	}
	
	@PutMapping(value= "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
		if (!userService.existsUser(id)) {		
			throw new CustomParameterizedException("updateUser.invalidUser",id);		
		}
		User userUpdated = userService.addUser(user);
		return  ResponseEntity.ok()
	            .headers(HeaderUtil.createEntityUpdateAlert("USER", userUpdated.getUserReferenceId()))
	            .body(userUpdated);
	}
	
}
