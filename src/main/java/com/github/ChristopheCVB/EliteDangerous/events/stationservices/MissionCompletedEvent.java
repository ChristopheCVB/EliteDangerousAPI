/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:04
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionCompletedEvent extends Event {
	
	public String faction;
	public String name;
	public String targetFaction;
	public String destinationSystem;
	public String destinationStation;
	public Long missionId;
	public Long reward;
	
	public MissionCompletedEvent(String timestamp) {
        super(timestamp);
    }
}
