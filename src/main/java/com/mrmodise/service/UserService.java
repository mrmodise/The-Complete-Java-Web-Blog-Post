package com.mrmodise.service;

import com.mrmodise.domain.User;

public interface UserService {
	User saveUser(User user);
	User findByEmail(String email);
}
