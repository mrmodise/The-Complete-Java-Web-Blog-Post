package com.mrmodise.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrmodise.domain.User;
import com.mrmodise.service.UserService;

@Controller
@RequestMapping("/admin")
@Secured({ "ROLE_ADMIN" })
public class AdminUserController {

	private UserService userService;

	@Autowired
	public AdminUserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user/create")
	public String createUser(Model model){
		model.addAttribute("user", new User());
		return "admin/user/add-user";
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult, Model model){
		
		if (bindingResult.hasErrors()) {
			return "admin/user/add-user";
		} else {
			User savedUser = userService.saveUser(user);
			return "redirect:/admin/user/single/view/" + savedUser.getUserId();
		}
	}

}
