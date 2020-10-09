package com.github.ChristopheCVB.EliteDangerous.events.datastorage.material;

public class Raw {
	
	private String name;
	private Integer count;
	
	public Raw(String name, Integer count) {
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
