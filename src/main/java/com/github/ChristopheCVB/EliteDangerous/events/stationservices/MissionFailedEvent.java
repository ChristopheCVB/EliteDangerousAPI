/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:08
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionFailedEvent extends Event {
	
	public String name;
	public Long missionId;
	
	public MissionFailedEvent(String timestamp) {
        super(timestamp);
    }
}
