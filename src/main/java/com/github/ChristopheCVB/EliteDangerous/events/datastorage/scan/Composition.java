package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

public class Composition {
	
	private String name;
	private Double percent;
	
	public Composition(String name, Double percent) {
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
