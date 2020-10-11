package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SupercruiseExitEvent extends Event {
	public String starSystem;
	public String body;
	public String bodyType;
	private Long systemAddress;
	private Integer bodyID;
}
