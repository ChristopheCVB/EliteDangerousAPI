package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FSSAllBodiesFoundEvent extends Event {
    public String systemName;
    public Long systemAddress;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFSSAllBodiesFoundEventTriggered((FSSAllBodiesFoundEvent) event);
        }

        void onFSSAllBodiesFoundEventTriggered(FSSAllBodiesFoundEvent fssAllBodiesFoundEvent);
    }
}
