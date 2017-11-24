package com.ceitechs.dproz.usermanagement.domain;

import java.util.Optional;


public interface UserService {
	
	Optional<User> getUser(String id);
	
	Optional<User> findOneByEmailIgnoreCase(String email);
	
	boolean existsUser(String id);
	
	User addUser(User user);
	
	User updateUser(User user);
	
}
