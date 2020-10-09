package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class FSDTargetEvent extends Event {
	
	private String name, starClass;
	private Long systemAdress;
	private Integer remainingJumpsInRoute;
	
	public FSDTargetEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.systemAdress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.remainingJumpsInRoute = JsonUtils.pullInt(jsonEvent, "RemainingJumpsInRoute");
        this.starClass = JsonUtils.pullString(jsonEvent, "StarClass");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getStarClass() {
		return starClass;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Integer getRemainingJumpsInRoute() {
		return remainingJumpsInRoute;
	}

}
