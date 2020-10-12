package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class NewCommanderEvent extends Event {
    public String name;
    public String fID;
    public String starterPackage;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNewCommanderEventTriggered((NewCommanderEvent) event);
        }

        void onNewCommanderEventTriggered(NewCommanderEvent newCommanderEvent);
    }
}
