package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Mission;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class MissionsEvent extends Event {
//	TODO: can you do this to, haven't done anything
	private List<Mission> active;
	private List<Mission> failed;
	private List<Mission> complete;
	
	public MissionsEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.active = GameFilesUtils.createMissionList(JsonUtils.pullJsonArray(jsonEvent, "Active"));
        this.failed = GameFilesUtils.createMissionList(JsonUtils.pullJsonArray(jsonEvent, "Failed"));
        this.complete = GameFilesUtils.createMissionList(JsonUtils.pullJsonArray(jsonEvent, "Complete"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<Mission> getActive() {
		return active;
	}

	public List<Mission> getFailed() {
		return failed;
	}

	public List<Mission> getComplete() {
		return complete;
	}

}
