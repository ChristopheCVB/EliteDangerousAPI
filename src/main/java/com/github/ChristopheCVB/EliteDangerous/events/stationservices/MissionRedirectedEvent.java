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
	
	public String name;
	public String newDestinationStation;
	public String newDestinationSystem;
	public String oldDestinationStation;
	public String oldDestinationSystem;
	public Long missionId;
	
	public MissionRedirectedEvent(String timestamp) {
        super(timestamp);
    }
}
