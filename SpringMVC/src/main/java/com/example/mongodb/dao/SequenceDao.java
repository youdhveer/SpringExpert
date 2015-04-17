package com.example.mongodb.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.mongodb.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key,MongoTemplate mongoTemplate) throws SequenceException;
}
