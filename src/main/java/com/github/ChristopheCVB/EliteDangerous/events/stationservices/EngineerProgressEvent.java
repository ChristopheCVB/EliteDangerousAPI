package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.Engineer;

import java.util.ArrayList;

public class EngineerProgressEvent extends Event {
    public ArrayList<Engineer> engineers;

    public Integer rank;
    public Double rankProgress;

    public EngineerProgressEvent(String timestamp) {
        super(timestamp);
    }
}
