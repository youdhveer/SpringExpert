package com.example.mongodb.dao;

import com.example.mongodb.entity.User;
import com.example.mongodb.exception.SequenceException;

public interface SpringMongoDAO {

	void save(User user) throws SequenceException;
}
