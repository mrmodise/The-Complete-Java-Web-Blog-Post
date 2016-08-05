package com.mrmodise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
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
		@RequestMapping("/member-profile")
		public String member(){
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
		
		// about us route and mapping to view
			@RequestMapping("/register")
			public String register(){
				return "register/guest-register";
			}

}
