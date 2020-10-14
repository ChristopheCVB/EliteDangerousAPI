package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class EndCrewSessionEvent extends Event {
    public Boolean onCrime;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onEndCrewSessionTriggered((EndCrewSessionEvent) event);
        }

        void onEndCrewSessionTriggered(EndCrewSessionEvent endCrewSessionEvent);
    }
}
