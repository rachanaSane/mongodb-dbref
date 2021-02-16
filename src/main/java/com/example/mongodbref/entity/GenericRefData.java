package com.example.mongodbref.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GenericRefData")
public class GenericRefData {

	String refDataId;
	List<String> value;
	List<RefData> valueObjects;
	public String getRefDataId() {
		return refDataId;
	}
	public void setRefDataId(String refDataId) {
		this.refDataId = refDataId;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	public List<RefData> getValueObjects() {
		return valueObjects;
	}
	public void setValueObjects(List<RefData> valueObjects) {
		this.valueObjects = valueObjects;
	}
	
	
	
}
