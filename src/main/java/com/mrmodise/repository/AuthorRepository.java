package com.mrmodise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrmodise.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
