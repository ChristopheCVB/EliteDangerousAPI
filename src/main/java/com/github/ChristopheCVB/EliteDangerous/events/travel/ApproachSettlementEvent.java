/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 12:46
*/

package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ApproachSettlementEvent extends Event {
	
	public String name;
	public String bodyName;
	public Integer bodyId;
	public Double latitude;
	public Double longitude;
	public Long marketId;
	public Long systemaddress;
	
	public ApproachSettlementEvent(String timestamp) {
        super(timestamp);
    }
}
