/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 12:15
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionAbandonedEvent extends Event {
	
	public String name;
	public Long missionId;
	
	public MissionAbandonedEvent(String timestamp) {
        super(timestamp);
    }
}
