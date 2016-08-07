package com.mrmodise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrmodise.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	private PostService postService;
	
	@Autowired
	public AdminController(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping("/")
	public String admin(Model model){
		model.addAttribute("posts", postService.listAll());
		return "admin/admin";
	}
	
	@RequestMapping("/post/save")
	public String savePost(){
		return "admin/posts/add-post";
	}
	
	@RequestMapping("/posts-by-author/{author}")
	public String listAuthor(@PathVariable(value = "author") String author, Model model){
		model.addAttribute("posts", postService.findPostByAuthor(author));
		return "admin/admin";
	}
	
	@RequestMapping("/posts/drafts")
	public String drafts(Model model){
		model.addAttribute("posts", postService.findDraftPosts());
		return "admin/admin";
	}

}
