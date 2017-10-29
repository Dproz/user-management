package com.ceitechs.dproz.usermanagement.domain;

import java.util.Optional;

public interface UserService {
	
	Optional<User> getUser(String id);
	
	User addUser(User user);

}
