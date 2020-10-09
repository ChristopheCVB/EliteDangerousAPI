package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

public class Material {
	
	private String name;
	private Double percent;
	
	public Material(String name, Double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public Double getPercent() {
		return percent;
	}

}
