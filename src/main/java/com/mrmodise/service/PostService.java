package com.mrmodise.service;

import java.util.List;

import com.mrmodise.domain.Post;

public interface PostService {
	List<Post> listAll();
	List<Post> list();
	Post getLatestPost();
	Post findPostBySlug(String slug);
	List<Post> findPostByAuthor(String author);
	List<Post> findDraftPosts();
}
