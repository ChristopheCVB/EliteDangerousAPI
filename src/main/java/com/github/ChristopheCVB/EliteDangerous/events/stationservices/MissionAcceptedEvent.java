/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 13:54
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionAcceptedEvent extends Event {
	
	public String faction;
	public String name;
	public String localisedName;
	public String targetFaction;
	public String destinationSystem;
	public String destinationStation;
	public String influence;
	public String reputation;
	public Long reward;
	public Long missionId;
	public Long expiry;
	
	public MissionAcceptedEvent(String timestamp) {
        super(timestamp);
    }
}
