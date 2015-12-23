package com.example.mongodb.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.mongodb.dao.SequenceDao;
import com.example.mongodb.entity.Stock;
import com.example.mongodb.entity.User;

@Repository
public class StockService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SequenceDao sequenceDao;

	
	public static final String COLLECTION_NAME = "stocks"; 
	private static final String USER_SEQ_KEY = "stock";

	public void addStock(Stock stock) {
		if (!mongoTemplate.collectionExists(Stock.class)) { 
			mongoTemplate.createCollection(Stock.class);
		}                       
		stock.setId(UUID.randomUUID().toString());
		stock.setCreatedOn(new Date());
		//stock.setId(sequenceDao.getNextSequenceId(USER_SEQ_KEY,mongoTemplate)+"");	
		mongoTemplate.insert(stock, COLLECTION_NAME); //------3)
		System.out.println("stock :: "+stock.getId());
	}

	public void deleteStock(Stock stock) {
		if (mongoTemplate.collectionExists(Stock.class)) { 
			//mongoTemplate.remove(stock, COLLECTION_NAME);
			Query query = new Query();			
			query.addCriteria(Criteria.where("symbol").is(stock.getSymbol()));
			mongoTemplate.findAndRemove(query, Stock.class,COLLECTION_NAME);
		} 		
	}
	
	public void updateStock(Stock stock) {
		if (mongoTemplate.collectionExists(Stock.class)) { 			
			Stock oldStock=mongoTemplate.findById(stock.getId(), Stock.class, COLLECTION_NAME);
			if(oldStock !=null ){
				stock.setCreatedOn(oldStock.getCreatedOn());
				mongoTemplate.insert(stock, COLLECTION_NAME);
			}			
		}                       
		
		
	}
	
	public List<Stock> listStocks() {
		return mongoTemplate.findAll(Stock.class, COLLECTION_NAME);
	}
	
	public List<Stock> searchStock(String searchText){		
		Query query = new Query();
		//query.addCriteria(Criteria.where("name").regex("D.*G", "i"));
		query.addCriteria(Criteria.where("name").regex(searchText));		 
		List<Stock> resultList = mongoTemplate.find(query, Stock.class);
		return resultList;
	}
}
