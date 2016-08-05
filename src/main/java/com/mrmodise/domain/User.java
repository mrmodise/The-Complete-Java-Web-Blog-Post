package com.mrmodise.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.mrmodise.domain.Role;

import lombok.Data;

/**
 * 
 * @author mrmodise
 * @purpose: this user object will be converted into a table using ORM/JPA
 */

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	public String fullName;
	private String email;
	private String password;
	
	/**
	 * create user roles table
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })

	private Set<Role> roles = new HashSet<Role>();

	public User() {
		// TODO Auto-generated constructor stub
	}
}
