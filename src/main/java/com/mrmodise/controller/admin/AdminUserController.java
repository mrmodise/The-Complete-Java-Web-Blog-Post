package com.mrmodise.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			return "admin/admin";
		} else {
			User savedUser = userService.saveUser(user);
			return "redirect:/admin/user/single/view/" + savedUser.getUserId();
		}
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult bindingResult, Model model, RedirectAttributes attributes){
		
		if (bindingResult.hasErrors()) {
			return "redirect:/admin/account/" + user.getId();
		} else {
			User updateUser = userService.updateUser(user, user.getId());
			attributes.addAttribute("success", "Your profile information has been successfully updated");
			return "redirect:/admin/account/" + updateUser.getUserId();
		}
	}

}
