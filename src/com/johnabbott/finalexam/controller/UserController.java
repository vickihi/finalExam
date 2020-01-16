package com.johnabbott.finalexam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.finalexam.model.UserEntity;
import com.johnabbott.finalexam.service.UserService;



@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getUsersList() {
		ModelAndView modelView = new ModelAndView("user-register");
		List<UserEntity> users = service.getUsers();
		modelView.addObject("userList", users);
		modelView.addObject("user", new UserEntity());

		return modelView;
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") UserEntity user) {
		if (service.addUser(user))
			return "redirect:/users/register";
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		ModelAndView modelView = new ModelAndView("user-login");
		List<UserEntity> users = service.getUsers();
		modelView.addObject("userList", users);
		modelView.addObject("user", new UserEntity());

		return modelView;
	}
	
	@RequestMapping(value = "checkuser", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") UserEntity user) {
		if (service.getUserByName(user.getUsername()) != null)
			return "home";
		else {
			return "redirect:/users/register";
		}
	}


}

