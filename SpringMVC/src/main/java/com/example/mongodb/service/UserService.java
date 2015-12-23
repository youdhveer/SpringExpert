package com.example.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.mongodb.dao.SequenceDao;
import com.example.mongodb.entity.User;

@Repository
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SequenceDao sequenceDao;

	/*@Autowired
	private UserDAO userDAO;*/

	public static final String COLLECTION_NAME = "users"; 
	private static final String USER_SEQ_KEY = "user";

	public void addUser(User user) {
		if (!mongoTemplate.collectionExists(User.class)) { 
			mongoTemplate.createCollection(User.class);
		}                       
		//user.setId(UUID.randomUUID().toString());
		user.setId(sequenceDao.getNextSequenceId(USER_SEQ_KEY,mongoTemplate)+"");	
		mongoTemplate.insert(user, COLLECTION_NAME); //------3)
	}

	public List<User> listUsers() {
		return mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}
	
	public List<User> searchUsers(String searchText){		
		Query query = new Query();
		//query.addCriteria(Criteria.where("name").regex("D.*G", "i"));
		query.addCriteria(Criteria.where("name").regex(searchText));		 
		List<User> userList = mongoTemplate.find(query, User.class);
		return userList;
	}
}
