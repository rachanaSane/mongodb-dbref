package com.example.mongodbref.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.mongodbref.entity.CustomerEntity;

public interface CustomerEntityRepository extends MongoRepository<CustomerEntity, String> {

}
