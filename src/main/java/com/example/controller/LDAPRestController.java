package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.UserProfile;
import com.example.util.LDAPViaJNDI;



/**
 * This controller will do LDAP Authentication based on user 
 * @author Youdhveer
 *
 */
@Controller
public class LDAPRestController {

	@Autowired
	LDAPViaJNDI ldapViaJNDI;	
	
	@RequestMapping(value = "/searchLDAPUser", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserProfile getUserProfileByEmail(@RequestParam("email") String name) {
		System.out.println("getUserViaQueryParam  by id : "+name);
        UserProfile user=ldapViaJNDI.isValidUser(name);
        return user;
	}
	
	
}
