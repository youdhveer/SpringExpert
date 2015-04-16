package com.example.mongodb.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.example.mongodb.dao.UserDAO;
import com.example.mongodb.entity.User;

@Service
public class UserDAOImpl implements UserDAO{

	@Autowired
	private MongoOperations mongoOperation;

	public void save(User user) {
		mongoOperation.save(user);
	}
}
