package com.mrmodise.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String body;
	
	@Column(columnDefinition="TEXT")
	private String teaser;
	
	private String slug;
	
	@CreatedDate @Column(columnDefinition = "TIMESTAMP")
	private Date postedOn;
	
	private String imageName;
	
	@ManyToOne
	private Author author;
	
	public Post(){
		
	}
		
	public Post(String title, String body, Date postedOn) {
		super();
		this.title = title;
		this.body = body;
		this.postedOn = postedOn;
	}
}
