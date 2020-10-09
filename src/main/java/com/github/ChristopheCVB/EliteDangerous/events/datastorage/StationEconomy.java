package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class StationEconomy {
	
	private String name, nameLocalised;
	private Double proportion;
	
	public StationEconomy(String name, String nameLocalised, Double proportion) {
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.proportion = proportion;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public Double getProportion() {
		return proportion;
	}

}
