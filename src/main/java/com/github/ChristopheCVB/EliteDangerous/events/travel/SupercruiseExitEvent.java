package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class SupercruiseExitEvent extends Event {
	@SerializedName("StarSustem")
	public String starSystem;
	@SerializedName("Body")
	public String body;
	@SerializedName("BodyType")
	public String bodyType;
	@SerializedName("SystemAddress")
	private Long systemAddress;
	@SerializedName("BodyID")
	private Integer bodyID;

	public SupercruiseExitEvent(String timestamp) {
		super(timestamp);
	}
}
