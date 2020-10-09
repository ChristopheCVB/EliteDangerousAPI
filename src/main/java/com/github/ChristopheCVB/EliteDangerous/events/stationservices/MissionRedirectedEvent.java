/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:11
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MissionRedirectedEvent extends Event {
	
	private String name, newDestinationStation, newDestinationSystem, oldDestinationStation, oldDestinationSystem;
	private Long missionId;
	
	public MissionRedirectedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.newDestinationStation = JsonUtils.pullString(jsonEvent, "NewDestinationStation");
        this.newDestinationSystem = JsonUtils.pullString(jsonEvent, "NewDestinationSystem");
        this.oldDestinationStation = JsonUtils.pullString(jsonEvent, "OldDestinationStation");
        this.oldDestinationSystem = JsonUtils.pullString(jsonEvent, "OldDestinationSystem");
        this.missionId = JsonUtils.pullLong(jsonEvent, "MissionID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getNewDestinationStation() {
		return newDestinationStation;
	}

	public String getNewDestinationSystem() {
		return newDestinationSystem;
	}

	public String getOldDestinationStation() {
		return oldDestinationStation;
	}

	public String getOldDestinationSystem() {
		return oldDestinationSystem;
	}

	public Long getMissionId() {
		return missionId;
	}

}
