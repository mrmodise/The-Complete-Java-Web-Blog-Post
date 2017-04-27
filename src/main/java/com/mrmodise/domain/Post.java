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

import com.mrmodise.domain.User;

import lombok.Data;

@Entity
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
	private User user;
	
	public Post(){
		this.draft = false;
		
	}
		
	public Post(String title, String body, Date postedOn) {
		this.title = title;
		this.body = body;
		this.postedOn = postedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
