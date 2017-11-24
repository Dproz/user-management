package com.ceitechs.dproz.usermanagement.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ceitechs.dproz.usermanagement.adapter.datastore.mongo.UserRepostitory;
import com.ceitechs.dproz.usermanagement.domain.User;
import com.ceitechs.dproz.usermanagement.domain.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepostitory userRepository;
	
	public UserServiceImpl(UserRepostitory userRepostitory) {
		this.userRepository = userRepostitory;	
	}
	

	@Override
	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}

	@Override
	public User addUser(User user) {
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
