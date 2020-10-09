package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class Mission {
	
	private Integer missionID, expires;
	private String name;
	private Boolean passengerMission;
	
	public Mission(Integer missionID, String name, Boolean passengerMission, Integer expires) {
		this.missionID = missionID;
		this.expires = expires;
		this.name = name;
		this.passengerMission = passengerMission;
	}

	public Integer getMissionID() {
		return missionID;
	}

	public Integer getExpires() {
		return expires;
	}

	public String getName() {
		return name;
	}

	public Boolean getPassengerMission() {
		return passengerMission;
	}

}
