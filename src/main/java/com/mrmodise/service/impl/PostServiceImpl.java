package com.mrmodise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmodise.domain.Post;
import com.mrmodise.repository.PostRepository;
import com.mrmodise.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> listAll() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post findPostBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}

	@Override
	public List<Post> list() {
		return postRepository.findAllByDraft(false);
	}

	@Override
	public List<Post> findPostByAuthor(String author) {
		return postRepository.findByAuthorFirstName(author);
	}

	@Override
	public List<Post> findDraftPosts() {
		return postRepository.findByDraft(true);
	}

	@Override
	public Post getPost(Long id) {
		return postRepository.findOne(id);
	}

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.delete(id);
	}

}
