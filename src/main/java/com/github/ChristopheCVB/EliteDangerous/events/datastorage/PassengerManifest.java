package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import com.google.gson.annotations.SerializedName;

public class PassengerManifest {
	public String type;
	public Integer count;
	@SerializedName("VIP")
	public Boolean vip;
	public Boolean wanted;
	public Long missionID;
}
