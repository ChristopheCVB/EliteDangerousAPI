package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class JetConeBoostEvent extends Event {
    public Float boostValue;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onJetConeBoostEventTriggered((JetConeBoostEvent) event);
        }

        void onJetConeBoostEventTriggered(JetConeBoostEvent jetConeBoostEvent);
    }
}
