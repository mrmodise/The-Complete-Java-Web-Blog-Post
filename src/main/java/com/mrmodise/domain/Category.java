package com.mrmodise.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@NotEmpty
	private String categoryName;
	
}
