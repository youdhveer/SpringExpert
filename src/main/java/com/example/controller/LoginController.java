package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.UserProfile;
import com.example.service.LDAPService;



@Controller
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class.getName());
	
	@Autowired
	private LDAPService ldapService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		String email=request.getParameter("email");  
	    String password=request.getParameter("password");
	        
		logger.info("Going to login user  : "+email);
		ModelAndView model = new ModelAndView("login");;
		
		HttpSession session=request.getSession();
		
		try {
			if(email !=null && password !=null){
				UserProfile userProfile = ldapService.getUserProfileFromLdap(email, password);
				model = new ModelAndView("success");
				session.setAttribute("email", userProfile.getEmail());
				model.addObject("UserProfile", userProfile);
				
				logger.info("User authentication completes for : "+email);	
			}else{
				throw new Exception("Either email or password is null.");
			}			
		} catch (Exception e) {
			logger.error("Exception :: "+e.getMessage());
			model.addObject("Error", "Exception  :: "+e.getMessage());
			e.printStackTrace();
		}		
		return model;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
			
		HttpSession session=request.getSession();
		if(session !=null){
			logger.info("Logout user : "+session.getAttribute("email")+" successfully !");
			session.invalidate();
		}
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
		

}