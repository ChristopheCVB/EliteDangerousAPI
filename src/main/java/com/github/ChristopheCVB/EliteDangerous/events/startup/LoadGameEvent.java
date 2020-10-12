package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LoadGameEvent extends Event {
    public String commander;
    public String fID;
    public String ship;
    public String shipLocalised;
    public String shipName;
    public String shipIdent;
    public String gameMode;
    public String group;
    public Integer shipId;
    public Double fuelLevel;
    public Double fuelCapacity;
    public Long credits;
    public Long loan;
    public Boolean horizons;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLoadGameEventTriggered((LoadGameEvent) event);
        }

        void onLoadGameEventTriggered(LoadGameEvent loadGameEvent);
    }
}
