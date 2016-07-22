package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.UserProfile;



@Service("ldapService")
public interface LDAPService {

	public UserProfile getUserProfileFromLdap(String userName, String password) throws Exception;
}
