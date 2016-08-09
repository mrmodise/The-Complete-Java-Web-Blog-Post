package com.mrmodise.service;

import java.util.List;

import com.mrmodise.domain.Post;

public interface PostService {
	
	Post savePost(Post post);
	List<Post> listAll();
	List<Post> list();
	Post getPost(Long id);
	Post findPostBySlug(String slug);
	List<Post> findPostByAuthor(String author);
	List<Post> findDraftPosts();
	void deletePost(Long id);
}
