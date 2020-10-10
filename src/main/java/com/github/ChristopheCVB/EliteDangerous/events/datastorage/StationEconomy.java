package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import com.google.gson.annotations.SerializedName;

public class StationEconomy {
	public String name;
	@SerializedName("Name_Localised")
	public String nameLocalised;
	public Double proportion;
}
