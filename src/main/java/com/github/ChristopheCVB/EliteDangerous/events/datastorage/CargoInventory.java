package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class CargoInventory {
	
	private String name;
	private Integer count, missionId, stolen;
	
	public CargoInventory(String name, int count, int stolen, int missionId) {
		this.name = name;
		this.count = count;
		this.stolen = stolen;
		this.missionId = missionId;
		
	}
	
	public CargoInventory(String name, int count, int stolen) {
		this.name = name;
		this.count = count;
		this.stolen = stolen;
		
	}

	public String getName() {
		return name;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getMissionId() {
		return missionId;
	}

	public Integer getStolen() {
		return stolen;
	}

}
