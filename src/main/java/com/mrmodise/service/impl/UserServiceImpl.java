package com.mrmodise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrmodise.repository.UserRepository;
import com.mrmodise.service.UserService;
import com.mrmodise.domain.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
