package com.example.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;
 

 
@Controller
public class UserController {
	@Autowired
	private UserService userService;
 
		
	 @RequestMapping(value = "/user", method = RequestMethod.GET)  
	 public String getUserList(ModelMap model) {  
		 model.addAttribute("userList", userService.listUsers());  
		 return "userList"; 
	 }  

	 @RequestMapping(value = "/user/saveUser", method = RequestMethod.POST)  
	 public View createUser(@ModelAttribute User user, ModelMap model) {
		 userService.addUser(user); 
		 return new RedirectView("/SpringMVC/user");	  
	 }
	 
	 @RequestMapping(value = "/user/search", method = RequestMethod.POST)  
	 public String getSearchUserList(@RequestParam(value="searchText") String searchText,ModelMap model) {  
		 model.addAttribute("userList", userService.searchUsers(searchText));  
		 return "userList"; 
	 }  
}
