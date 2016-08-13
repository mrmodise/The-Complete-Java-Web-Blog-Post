package com.mrmodise.controller;

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
import com.mrmodise.service.AuthorService;
import com.mrmodise.service.PostService;

@Controller
@RequestMapping("/admin")
@Secured( {"ROLE_ADMIN"} )
public class AdminController {

	private PostService postService;
	private AuthorService authorService;

	@Autowired
	public AdminController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}

	@RequestMapping("/")
	public String admin(Model model) {
		model.addAttribute("posts", postService.listAll());
		return "admin/admin";
	}

	@RequestMapping("/post/create")
	public String createPost(Model model) {
		// create a new post object
		model.addAttribute("post", new Post());
		// get a list of authors
		model.addAttribute("authors", authorService.findAllAuthors());

		return "admin/posts/add-post";
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			// get a list of authors
			model.addAttribute("authors", authorService.findAllAuthors());
			return "admin/posts/add-post";
		} else {
			post.setPostedOn(new Date());
			Post savedPost = postService.savePost(post);
			return "redirect:/admin/post/single/view/" + savedPost.getId();
		}
		
	}

	@RequestMapping("/post/single/view/{id}")
	public String viewPost(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("post", postService.getPost(id));
		return "admin/posts/view-post";
	}

	@RequestMapping(value = "/post/delete/{id}")
	public String deletePost(@PathVariable(value = "id") Long id, Model model, RedirectAttributes redirectAttributes) {
		Post post = postService.getPost(id);
		postService.deletePost(id);
		redirectAttributes.addFlashAttribute("message", "The post '" + post.getTitle() + "' was successfully deleted");
		model.addAttribute("posts", postService.listAll());
		return "redirect:/admin/";
	}

	@RequestMapping("/posts-by-author/{author}")
	public String listAuthor(@PathVariable(value = "author") String author, Model model) {
		model.addAttribute("posts", postService.findPostByAuthor(author));
		return "admin/admin";
	}

	@RequestMapping("/posts/drafts")
	public String drafts(Model model) {
		model.addAttribute("posts", postService.findDraftPosts());
		return "admin/admin";
	}
	
	@RequestMapping("/post/edit/{id}")
	public String editPost(@PathVariable(value="id") Long id, Model model) {

		// create a new post object
		model.addAttribute("post", postService.getPost(id));

		// get a list of authors
		model.addAttribute("authors", authorService.findAllAuthors());

		return "admin/posts/add-post";
	}

}
