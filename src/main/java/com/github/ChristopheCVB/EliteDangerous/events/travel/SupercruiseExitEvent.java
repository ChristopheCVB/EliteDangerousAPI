package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class SupercruiseExitEvent extends Event {
	public String starSystem;
	public String body;
	public String bodyType;
	private Long systemAddress;
	private Integer bodyID;

	public SupercruiseExitEvent(String timestamp) {
		super(timestamp);
	}
}
