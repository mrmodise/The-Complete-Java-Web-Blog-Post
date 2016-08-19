package com.mrmodise.controller.admin;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrmodise.service.PostService;
import com.mrmodise.service.UserService;

@Controller
@RequestMapping("/admin")
@Secured( {"ROLE_ADMIN"} )
public class AdminController {

	private PostService postService;
	private UserService userService;

	@Autowired
	public AdminController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}

	@RequestMapping("/")
	public String admin(Model model, Principal principal) {
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		model.addAttribute("posts", postService.listAll());
		return "admin/admin";
	}

	@RequestMapping("/posts-by-author/{id}")
	public String listAuthor(@PathVariable(value = "id") Long id, Model model, Principal principal) {
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		model.addAttribute("posts", postService.findByUserId(id));
		return "admin/admin";
	}

	@RequestMapping("/posts/drafts/{id}")
	public String drafts(@PathVariable Long id, Model model, Principal principal) {
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		model.addAttribute("posts", postService.findDraftPosts(id));
		return "admin/admin";
	}
	
	@RequestMapping("/account/{id}")
	public String account(@PathVariable(value="id") Long id, Model model){
		model.addAttribute("user", userService.findById(id));
		return "admin/account/account";
	}

}
