package com.example.mongodbref.service;

import com.example.mongodbref.entity.GenericRefData;

public interface GenericRefDataService {

	 GenericRefData serachGenericRefData(String refDataId, String searchTerm);
	 
	 GenericRefData saveGenericRefData();
}
