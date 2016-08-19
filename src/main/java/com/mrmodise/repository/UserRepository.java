package com.mrmodise.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrmodise.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
	List<User> findAllByStatus(String status);
	User findByFirstName(String author);
}
