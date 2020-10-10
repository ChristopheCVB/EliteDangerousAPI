package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class SupercruiseEntryEvent extends Event {
	@SerializedName("StarSystem")
	public String starSystem;
	@SerializedName("SystemAddress")
	public Long systemAddress;

	public SupercruiseEntryEvent(String timestamp) {
		super(timestamp);
	}
}
