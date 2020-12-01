package com.example.mongodbref.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbref.entity.AccountEntity;

public interface AccountEntityRepository extends MongoRepository<AccountEntity, String> {

	AccountEntity findByName(String string);

}
