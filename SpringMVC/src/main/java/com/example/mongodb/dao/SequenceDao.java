package com.example.mongodb.dao;

import com.example.mongodb.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;
}
