package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

import java.util.List;

public class WingJoinEvent extends Event {
    public List<String> others;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onWingJoinEventTriggered((WingJoinEvent) event);
        }

        void onWingJoinEventTriggered(WingJoinEvent wingJoinEvent);
    }
}
