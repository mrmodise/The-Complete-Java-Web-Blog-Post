package com.mrmodise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmodise.repository.PostRepository;
import com.mrmodise.service.PostService;
import com.mrmodise.domain.Post;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> listAll() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post getLatestPost() {
		return postRepository.findFirstByOrderByPostedOn();
	}

	@Override
	public Post findPostBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}

}
