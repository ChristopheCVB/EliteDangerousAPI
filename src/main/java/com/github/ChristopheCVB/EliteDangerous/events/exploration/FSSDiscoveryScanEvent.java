package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FSSDiscoveryScanEvent extends Event {
	public String systemName;
	public Long systemAddress;
	public Double progress;
	public Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp) {
        super(timestamp);
    }
}
