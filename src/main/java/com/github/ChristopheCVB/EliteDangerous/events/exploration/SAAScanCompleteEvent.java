package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SAAScanCompleteEvent extends Event {
    public String bodyName;
    public Integer bodyID, probesUsed, efficiencyTarget;
    public Long systemAddress;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSAAScanCompleteEventTriggered((SAAScanCompleteEvent) event);
        }

        void onSAAScanCompleteEventTriggered(SAAScanCompleteEvent navRouteEvent);
    }
}
