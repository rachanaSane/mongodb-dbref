package com.example.mongodbref.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mongodbref.entity.GenericRefData;
import com.example.mongodbref.entity.RefData;
import com.example.mongodbref.repository.GenericRefDataRepository;

@Service
@Transactional
public class GenericRefDataServiceImpl implements GenericRefDataService {

	private final GenericRefDataRepository genericRefDataRepository;

	public GenericRefDataServiceImpl(GenericRefDataRepository genericRefDataRepository) {		
		this.genericRefDataRepository = genericRefDataRepository;
	}
	
	public GenericRefData serachGenericRefData(String refDataId, String searchTerm) {
		return genericRefDataRepository.searchValueObjects(refDataId, searchTerm);
	}
	
	public GenericRefData saveGenericRefData() {
		GenericRefData genericRefData = new GenericRefData();
		genericRefData.setRefDataId("ControlPoint");
		List<RefData> refDataList = new ArrayList<RefData>();
		RefData refData1 = new RefData("AUS","test1");
		RefData refData2 = new RefData("PQR","test2");
		RefData refData3 = new RefData("NRT","test3");
		refDataList.add(refData1);
		refDataList.add(refData2);
		refDataList.add(refData3);
		genericRefData.setValueObjects(refDataList);
		return genericRefDataRepository.save(genericRefData);
	}
	
}
