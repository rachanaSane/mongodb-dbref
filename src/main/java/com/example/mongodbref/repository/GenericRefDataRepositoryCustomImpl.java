package com.example.mongodbref.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import com.example.mongodbref.entity.GenericRefData;
import com.mongodb.BasicDBObject;

public class GenericRefDataRepositoryCustomImpl implements GenericRefDataRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public GenericRefData searchValueObjects(String refDataId, String searchTerm) {
		
		Aggregation aggregation=Aggregation.newAggregation(
				Aggregation.match(Criteria.where("refDataId").is("ControlPoint")),
						Aggregation.unwind("valueObjects"),
						Aggregation.match(Criteria.where("valueObjects.key").regex(searchTerm,"i")),
						Aggregation.group("_id").push(new BasicDBObject("key","$valueObjects.key").append("value", "$valueObjects.value")).as("valueObjects"));
		
		AggregationResults<GenericRefData>  groupResults=mongoTemplate.aggregate(aggregation, "GenericRefData",GenericRefData.class);
		return groupResults.getUniqueMappedResult();
		
	}

}
