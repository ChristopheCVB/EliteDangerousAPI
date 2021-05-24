package com.christophecvb.elitedangerous.events.loadout;

import com.christophecvb.elitedangerous.events.Event;

public abstract class SuitLoadoutEvent extends Event {
    public Long suitID;
    public String suitName;
    public Long loadoutID;
    public String loadoutName;
}
