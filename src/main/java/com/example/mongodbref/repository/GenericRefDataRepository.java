package com.example.mongodbref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbref.entity.GenericRefData;

public interface GenericRefDataRepository extends MongoRepository<GenericRefData,String>,GenericRefDataRepositoryCustom{

	
}
