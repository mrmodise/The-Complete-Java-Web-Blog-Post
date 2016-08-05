package com.mrmodise.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrmodise.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findAllByOrderByPostedOnDesc();
	Post findFirstByOrderByPostedOn();
	Post findBySlug(String slug);
}
