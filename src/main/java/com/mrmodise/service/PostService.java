package com.mrmodise.service;

import java.util.List;

import com.mrmodise.domain.Post;

public interface PostService {
	List<Post> listAll();
	Post getLatestPost();
	Post findPostBySlug(String slug);
}
