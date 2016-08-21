package com.mrmodise.controller.admin;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mrmodise.domain.Post;
import com.mrmodise.service.PostService;
import com.mrmodise.service.UserService;

@Controller
@RequestMapping("/admin")
@Secured({ "ROLE_ADMIN" })
public class AdminPostController {

	private PostService postService;
	private UserService userService;
	private Principal principal;

	@Autowired
	public AdminPostController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}

	@RequestMapping("/post/create")
	public String createPost(Model model) {
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		// create a new post object
		model.addAttribute("post", new Post());
		// get a list of authors
		model.addAttribute("user", userService.findByEmail(principal.getName()));

		return "admin/posts/add-post";
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			// get a list of authors
			// model.addAttribute("authors", authorService.findAllAuthors());
			model.addAttribute("user", userService.findByEmail(principal.getName()));
			return "admin/posts/add-post";
		} else {
			post.setPostedOn(new Date());
			Post savedPost = postService.savePost(post);
			return "redirect:/admin/post/single/view/" + savedPost.getId();
		}

	}

	@RequestMapping("/post/single/view/{id}")
	public String viewPost(@PathVariable(value = "id") Long id, Model model, Principal principal) {
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		model.addAttribute("post", postService.getPost(id));
		return "admin/posts/view-post";
	}

	@RequestMapping("/post/edit/{id}")
	public String editPost(@PathVariable(value = "id") Long id, Model model, Principal principal) {

		model.addAttribute("user", userService.findByEmail(principal.getName()));
		// create a new post object
		model.addAttribute("post", postService.getPost(id));

		// get a list of authors
		model.addAttribute("authors", userService.findAllActiveUsers());

		return "admin/posts/add-post";
	}

	@RequestMapping(value = "/post/delete/{id}")
	public String deletePost(@PathVariable(value = "id") Long id, Model model, RedirectAttributes redirectAttributes,
			Principal principal) {
		Post post = postService.getPost(id);
		postService.deletePost(id);
		redirectAttributes.addFlashAttribute("message", "The post '" + post.getTitle() + "' was successfully deleted");
		model.addAttribute("user", userService.findByEmail(principal.getName()));
		model.addAttribute("posts", postService.listAll());
		return "redirect:/admin/";
	}

}
