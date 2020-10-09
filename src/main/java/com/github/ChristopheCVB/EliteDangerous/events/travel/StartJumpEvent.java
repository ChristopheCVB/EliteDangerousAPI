package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class StartJumpEvent extends Event {
	
	private String jumpType, starSystem, starClass;
	private Long systemAddress;
	
	public StartJumpEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.jumpType = JsonUtils.pullString(jsonEvent, "JumpType");
        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.starClass = JsonUtils.pullString(jsonEvent, "StarClass");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getJumpType() {
		return jumpType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getStarClass() {
		return starClass;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}
	
}
