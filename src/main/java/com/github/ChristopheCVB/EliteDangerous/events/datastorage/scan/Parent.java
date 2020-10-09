package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

public class Parent {
	
	private String bodyType;
	private Integer bodyID;
	
	public Parent(String bodyType, Integer bodyID) {
		this.bodyType = bodyType;
		this.bodyID = bodyID;
	}

	public String getBodyType() {
		return bodyType;
	}

	public Integer getBodyID() {
		return bodyID;
	}
}
