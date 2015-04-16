package com.example.mongodb.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.dao.SequenceDao;
import com.example.mongodb.dao.SpringMongoDAO;
import com.example.mongodb.dao.UserDAO;
import com.example.mongodb.entity.User;
import com.example.mongodb.exception.SequenceException;

@Service
public class SpringMongoDAOImpl implements SpringMongoDAO{

	private static final String USER_SEQ_KEY = "user";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private UserDAO userDAO;

	public void save(User user) throws SequenceException {

		user.setId(sequenceDao.getNextSequenceId(USER_SEQ_KEY)+"");	
		userDAO.save(user);		

	}
}
