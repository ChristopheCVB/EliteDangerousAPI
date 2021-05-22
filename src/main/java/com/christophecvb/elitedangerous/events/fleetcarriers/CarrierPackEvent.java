package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public abstract class CarrierPackEvent extends Event {
    public Long carrierID;
    public String operation;
    public String packTheme;
    public Integer packTier;
    public Integer cost;
}
