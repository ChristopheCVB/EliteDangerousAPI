package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class EjectCargoEvent extends Event {
	public String type;
	public String typeLocalised;
	public String powerplayOrigin;
	public Integer count;
	public Long missionID;
	public Boolean abandoned;
}
