package com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer;

public class Ingredient {
	
	private String name;
	private Integer count;
	
	public Ingredient(String name, Integer count) {
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getCount() {
		return count;
	}

}
