package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.SAASignal;

import java.util.List;

public class SAASignalsFoundEvent extends Event {
    public Long systemAddress;
    public String bodyName;
    public Integer bodyID;
    public List<SAASignal> signals;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSAAScanCompleteEventTriggered((SAASignalsFoundEvent) event);
        }

        void onSAAScanCompleteEventTriggered(SAASignalsFoundEvent navRouteEvent);
    }
}
