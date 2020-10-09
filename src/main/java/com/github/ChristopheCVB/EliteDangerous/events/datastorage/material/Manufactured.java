package com.github.ChristopheCVB.EliteDangerous.events.datastorage.material;

public class Manufactured {
	
	private String name;
	private String name_localised;
	private Integer count;
	
	public Manufactured(String name, String name_localised, Integer count) {
		this.name = name;
		this.name_localised = name_localised;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return name_localised;
	}

	public Integer getCount() {
		return count;
	}

}
