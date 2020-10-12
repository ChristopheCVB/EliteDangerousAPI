package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LiftoffEvent extends Event {
    public Boolean playerControlled;
    public Double longitude, latitude;
    public String nearestDestination;
    public String nearestDestinationLocalised;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLiftoffEventTriggered((LiftoffEvent) event);
        }

        void onLiftoffEventTriggered(LiftoffEvent liftoffEvent);
    }
}
