package com.mrmodise.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE},fetch = FetchType.EAGER, mappedBy="author", orphanRemoval=true)
	private List<Post> posts;
	
	public Author(){
		
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
