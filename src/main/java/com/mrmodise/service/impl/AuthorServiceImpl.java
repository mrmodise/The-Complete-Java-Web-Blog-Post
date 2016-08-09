package com.mrmodise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmodise.domain.Author;
import com.mrmodise.repository.AuthorRepository;
import com.mrmodise.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> findAllAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

}
