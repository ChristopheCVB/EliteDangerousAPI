package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FSSDiscoveryScanEvent extends Event {
    public String systemName;
    public Long systemAddress;
    public Double progress;
    public Integer bodyCount, nonBodyCount;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFSSDiscoveryScanEventTriggered((FSSDiscoveryScanEvent) event);
        }

        void onFSSDiscoveryScanEventTriggered(FSSDiscoveryScanEvent fssDiscoveryScanEvent);
    }
}
