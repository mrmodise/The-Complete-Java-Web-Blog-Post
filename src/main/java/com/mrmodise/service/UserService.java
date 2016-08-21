package com.mrmodise.service;

import java.util.List;

import com.mrmodise.domain.User;

public interface UserService {
	User saveUser(User user);
	User findByEmail(String email);
	List<User> findAllActiveUsers();
	User findByFirstName(String author);
	User findById(Long id);
	User updateUser(User user, Long id);
}
