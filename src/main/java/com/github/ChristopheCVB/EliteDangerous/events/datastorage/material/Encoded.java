package com.github.ChristopheCVB.EliteDangerous.events.datastorage.material;

public class Encoded {
	
	private String name;
	private String name_localised;
	private Integer count;
	
	public Encoded(String name, String name_localised, Integer count) {
		this.name = name;
		this.name_localised = name_localised;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public String getNamelocalised() {
		return name_localised;
	}

	public Integer getCount() {
		return count;
	}

}
