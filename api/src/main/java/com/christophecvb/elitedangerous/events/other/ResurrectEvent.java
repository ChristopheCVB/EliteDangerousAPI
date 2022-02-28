package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class ResurrectEvent extends Event {
    public String option;
    public Long cost;
    public Boolean bankrupt;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onResurrectEventTriggered((ResurrectEvent) event);
        }

        void onResurrectEventTriggered(ResurrectEvent resurrectEvent);
    }
}
