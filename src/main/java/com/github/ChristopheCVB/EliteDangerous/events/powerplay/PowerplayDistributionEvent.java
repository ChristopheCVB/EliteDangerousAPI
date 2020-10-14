package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class PowerplayDistributionEvent extends Event {
    public String power;
    public String type;
    public Integer count;
}
