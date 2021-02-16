package com.example.mongodbref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbref.entity.GenericRefData;
import com.example.mongodbref.service.GenericRefDataService;

@RestController
@RequestMapping(value = {"/api"})
public class GenericRefDataController {
	
	private GenericRefDataService genericRefDataService;

	@Autowired
	public void setGenericRefDataService(GenericRefDataService genericRefDataService) {
		this.genericRefDataService = genericRefDataService;
	}
	
	@GetMapping(value ="/lookup/{refDataId}/filter/{search}")
	public ResponseEntity<GenericRefData> searchGenericRefData(@PathVariable("refDataId") String refDataId,
			@PathVariable("search") String search){
		GenericRefData genericRefData=genericRefDataService.serachGenericRefData(refDataId, search);
		return new ResponseEntity<>(genericRefData,HttpStatus.OK);
	}
	
	@GetMapping(value ="/save")
	public ResponseEntity<String> saveGenericRefData(){
		GenericRefData genericRefData=genericRefDataService.saveGenericRefData();
		return new ResponseEntity<>("done",HttpStatus.OK);
	}
	

}
