package com.mrmodise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrmodise.service.PostService;

/**
 * 
 * @author Morebodi Modise
 * @email modisemorebodi@gmail.com
 * @purpose defines all roles relating to posts
 *
 */
@Controller
public class PostController {
	
	// defines the post service object to be used for injection
	private PostService postService;
	
	// constructor based injection
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// return a post for a single view 
	@RequestMapping("/posts/view/{slug}")
	public String listPosts(@PathVariable(value = "slug") String slug, Model model){
		model.addAttribute("post", postService.findPostBySlug(slug));
		return "posts/view";
	}

}
