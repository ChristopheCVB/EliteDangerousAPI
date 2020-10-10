package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FSSAllBodiesFoundEvent extends Event {
	public String systemName;
	public Long systemAddress;
	public Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp) {
        super(timestamp);
    }
}
