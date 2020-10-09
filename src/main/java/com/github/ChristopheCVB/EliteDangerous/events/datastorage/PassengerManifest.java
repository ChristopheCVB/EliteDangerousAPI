package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class PassengerManifest {
	
	private String type;
	private Integer count;
	private Boolean vip, wanted;
	private Long missionID;
	
	public PassengerManifest(String type, Integer count, Boolean vip, Boolean wanted, Long missionID) {
		this.type = type;
		this.count = count;
		this.vip = vip;
		this.wanted = wanted;
		this.missionID = missionID;
	}

	public String getType() {
		return type;
	}

	public Integer getCount() {
		return count;
	}

	public Boolean getVip() {
		return vip;
	}

	public Boolean getWanted() {
		return wanted;
	}

	public Long getMissionID() {
		return missionID;
	}

}
