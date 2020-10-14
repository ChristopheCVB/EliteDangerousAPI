package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class CarrierPackEvent extends Event {
    public Long carrierID;
    public String operation;
    public String packTheme;
    public Integer packTier;
    public Integer cost;
}
