package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import com.google.gson.annotations.SerializedName;

public class Killer {
	@SerializedName("Name")
	public String name;
	@SerializedName("Ship")
	public String ship;
	@SerializedName("Rank")
	public String rank;
}
