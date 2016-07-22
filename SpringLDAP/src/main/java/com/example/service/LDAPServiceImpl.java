package com.example.service;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import com.example.model.UserProfile;

public class LDAPServiceImpl implements LDAPService{

	private static Logger logger = LoggerFactory.getLogger(LDAPServiceImpl.class.getName());
	
	@Autowired(required = true)		
	private LdapTemplate ldapTemplate;
	
	public LDAPServiceImpl(LdapTemplate ldapTemplate){
		this.ldapTemplate=ldapTemplate;
	}
	
	public boolean login(String userName, String password) throws Exception{
		  boolean isValiduser=false; 
		  logger.info("validating user..."+userName);
		  AndFilter filter = new AndFilter();
		  filter.and(new EqualsFilter("objectclass", "person")).and(new EqualsFilter("mail", userName));
		  
		  //LdapQueryBuilder query=new Query().where("uid").is("john.doe"),
		  if(ldapTemplate ==null){
			  logger.warn("Failed to autowire ldapTemplate....");
		  }else{
			  isValiduser=ldapTemplate.authenticate(DistinguishedName.EMPTY_PATH, filter.toString(), password);
		  }
		  return isValiduser;
	}

	
	public UserProfile getUserProfileFromLdap(String userName, String password) throws Exception{
		UserProfile userProfile=new UserProfile();		
		if(login(userName, password)){
			logger.info("validated user successfully..."+userName);
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);			
			List<UserProfile> userList=ldapTemplate.search("", "mail=" + userName, controls,new UserAttributesMapper());
			if(userList !=null){
				userProfile=userList.get(0);
			}
			
		}else{
			logger.info("Failed to validate user...");
		}
		
		
		return userProfile;
	}
	
	private class UserAttributesMapper implements AttributesMapper {
	      public Object mapFromAttributes(Attributes attrs) throws NamingException {
	         UserProfile userProfile=new UserProfile();
	         userProfile.setUserName((String)attrs.get("cn").get());
	         userProfile.setEmail((String)attrs.get("mail").get());
	         //userProfile.setDescription((String)attrs.get("description").get());
	         return userProfile;
	      }
	}
	

}
