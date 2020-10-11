package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class StartJumpEvent extends Event {
	public String jumpType, starSystem, starClass;
	public Long systemAddress;
}
