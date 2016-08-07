package com.mrmodise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("posts", postService.list());
		return "admin/admin";
	}
	
	@RequestMapping("/post/save")
	public String savePost(){
		return "admin/posts/add-post";
	}

}
