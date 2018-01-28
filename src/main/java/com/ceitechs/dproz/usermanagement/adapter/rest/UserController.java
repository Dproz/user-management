package com.ceitechs.dproz.usermanagement.adapter.rest;

import com.ceitechs.dproz.shared.security.SecurityUtils;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceitechs.dproz.shared.rest.util.HeaderUtil;
import com.ceitechs.dproz.usermanagement.adapter.rest.errors.CustomParameterizedException;
import com.ceitechs.dproz.usermanagement.adapter.rest.errors.EmailAlreadyUsedException;
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
	  validateUserReferenceId(id);
		return ResponseUtil.wrapOrNotFound(userService.getUser(id));
		
	}

  private void validateUserReferenceId(String id) {
    boolean isValid = Optional.ofNullable(SecurityUtils.getCurrentUserReferenceId()).
        map(idFromToken ->  idFromToken.equals(id)).orElse(false);
    if (!isValid){
      throw new CustomParameterizedException("getUser.invalidReferenceId");
    }
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> addUser(@RequestBody User user){
		if (user.isActive()) {
			// new user cannot be active
			throw new CustomParameterizedException("newUser.invalidStatus");
		}
        userService.findOneByEmailIgnoreCase(user.getEmailAddress()).ifPresent(u -> {throw new EmailAlreadyUsedException();});
		User userAdded = userService.addUser(user);
		 return ResponseEntity.ok()
		            .headers(HeaderUtil.createEntityUpdateAlert("USER", userAdded.getUserReferenceId()))
		            .body(userAdded);
	}
	
	@PutMapping(value= "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
		User existingUser = getExistingUser(id);
		if (existingUser.isActive() != user.isActive()) {
			// update user cannot change the activation status
			throw new CustomParameterizedException("invalid.activeIndicator",id);					
		}
		User userUpdated = userService.updateUser(user);
		return  ResponseEntity.ok()
	            .headers(HeaderUtil.createEntityUpdateAlert("USER", userUpdated.getUserReferenceId()))
	            .body(userUpdated);
	}
	
	@PutMapping(value= "/{id}/activation", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> userActivation(@PathVariable String id, @RequestParam boolean activationIndicator){
		User existingUser = getExistingUser(id);
		existingUser.setActive(activationIndicator);
		User updatedUser = userService.updateUser(existingUser);
		return  ResponseEntity.ok()
	            .headers(HeaderUtil.createEntityUpdateAlert("USER", updatedUser.getUserReferenceId()))
	            .body(updatedUser);
	}
	
	private User getExistingUser(String id) {
		return userService
				.getUser(id)
				.orElseThrow(() -> new CustomParameterizedException("updateUser.invalidUser",id));
	}
		
}
