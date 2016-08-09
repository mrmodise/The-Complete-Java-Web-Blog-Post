package com.mrmodise.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	@Column(columnDefinition="TEXT")
	private String body;
	
	@NotEmpty
	@Column(columnDefinition="TEXT")
	private String teaser;
	
	@NotEmpty
	private String slug;
	
	@NotEmpty
	private String status;
	
	private boolean draft;
	
	@CreatedDate 
	@Column(columnDefinition = "TIMESTAMP")
	private Date postedOn;
	
	private String imageName;
	
	@NotNull
	@ManyToOne(optional = false)
	private Author author;
	
	public Post(){
		this.draft = false;
		
	}
		
	public Post(String title, String body, Date postedOn) {
		this.title = title;
		this.body = body;
		this.postedOn = postedOn;
	}
	
	
}
