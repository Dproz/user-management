package com.ceitechs.dproz.usermanagement.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ceitechs.dproz.shared.security.AuthoritiesConstants;
import com.ceitechs.dproz.usermanagement.adapter.datastore.mongo.UserRepostitory;
import com.ceitechs.dproz.usermanagement.domain.Authority;
import com.ceitechs.dproz.usermanagement.domain.User;
import com.ceitechs.dproz.usermanagement.domain.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepostitory userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepostitory userRepostitory,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepostitory;	
		this.passwordEncoder = passwordEncoder;
	}
	

	@Override
	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}

	@Override
	public User addUser(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        // TO DO for now default to USER ROLE
        Authority userAuthority = new Authority();
		userAuthority.setName(AuthoritiesConstants.USER);
		user.getAuthorities().add(userAuthority);
        user.setPassword(encryptedPassword);
		return userRepository.insert(user);
	}


	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public boolean existsUser(String id) {
		return userRepository.existsById(id);
	}


	@Override
	public Optional<User> findOneByEmailIgnoreCase(String emailAddress) {
		return userRepository.findOneByEmailAddressIgnoreCase(emailAddress);
	}

}
