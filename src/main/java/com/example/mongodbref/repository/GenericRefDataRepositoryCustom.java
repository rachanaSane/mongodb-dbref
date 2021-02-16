package com.example.mongodbref.repository;

import com.example.mongodbref.entity.GenericRefData;

public interface GenericRefDataRepositoryCustom {
	
	 GenericRefData searchValueObjects(String refDataId, String searchTerm);
}
