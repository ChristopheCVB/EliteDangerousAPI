package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommanderEvent extends Event {
    public String name;
    public String FID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCommanderEventTriggered((CommanderEvent) event);
        }

        void onCommanderEventTriggered(CommanderEvent commanderEvent);
    }
}
