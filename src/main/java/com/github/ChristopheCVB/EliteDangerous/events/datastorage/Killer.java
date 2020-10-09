package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class Killer {
	
	private String name, ship, rank;

	public Killer(String name, String ship, String rank) {
		this.name = name;
		this.ship = ship;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public String getShip() {
		return ship;
	}

	public String getRank() {
		return rank;
	}

}
