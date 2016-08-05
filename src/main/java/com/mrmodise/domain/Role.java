package com.mrmodise.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * 
 * @author mrmodise
 * @purpose: this role object will be converted into a table using ORM/JPA
 */

@Entity
@Data
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	private String role;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	private Role(){
		
	}

}
