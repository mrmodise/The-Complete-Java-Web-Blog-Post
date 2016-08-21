package com.mrmodise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrmodise.service.PostService;
import com.mrmodise.service.UserService;

@Controller
public class HomeController {
	
	
		private PostService postService;
		private UserService userService;
		
		@Autowired
		public HomeController(PostService postService, UserService userService) {
			this.postService = postService;
			this.userService = userService;
		}

		// root route and mapping to view
		@RequestMapping("/")
		public String home(Model model){
			model.addAttribute("posts", postService.list());
			return "index";
		}
	
		// author of a blog post route and mapping to view
		@RequestMapping("/author")
		public String author(){
			return "author/staff-writer";
		}
		
		// team members route and mapping to view
		@RequestMapping("/our-team")
		public String team(){
			return "teams/team";
		}
		
		// member profile route and mapping to view
		@RequestMapping("/member-profile/{id}")
		public String member(@PathVariable(value="id") Long id, Model model){
			model.addAttribute("user", userService.findById(id));
			return "member/member-profile";
		}
		
		// contact us route and mapping to view
		@RequestMapping("/contact-us")
		public String contactUs(){
			return "contact-us/contact-us";
		}
		
		// about us route and mapping to view
		@RequestMapping("/about-financial-tech-journal")
		public String aboutUs(){
			return "about-us/about-us";
		}
}
