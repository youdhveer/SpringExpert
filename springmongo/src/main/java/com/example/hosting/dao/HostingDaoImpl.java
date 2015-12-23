package com.example.hosting.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.example.hosting.model.Hosting;

@Service
public class HostingDaoImpl implements HostingDao {

	@Autowired
	private MongoOperations mongoOperation;

	public void save(Hosting hosting) {

		mongoOperation.save(hosting);

	}

}