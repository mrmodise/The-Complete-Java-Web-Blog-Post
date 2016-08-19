package com.mrmodise.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrmodise.domain.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
	List<Post> findAllByDraft(boolean draft);
	Post findFirstByOrderByPostedOn();
	Post findBySlug(String slug);
	List<Post> findByUserFirstName(String authorId);
	List<Post> findByDraftAndUserId(boolean draft, Long id);
	List<Post> findByUserId(Long id);
}
