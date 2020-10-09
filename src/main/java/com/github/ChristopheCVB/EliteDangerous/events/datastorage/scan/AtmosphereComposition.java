package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

public class AtmosphereComposition {
	
	private String name;
	private Double percent;
	
	public AtmosphereComposition(String name, Double percent) {
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
