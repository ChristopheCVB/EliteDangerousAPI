package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class StartJumpEvent extends Event {
    public static final String JUMP_TYPE_HYPERSPACE = "Hyperspace";
    public static final String JUMP_TYPE_SUPERCRUISE = "Supercruise";

    public String jumpType, starSystem, starClass;
    public Long systemAddress;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStartJumpEventTriggered((StartJumpEvent) event);
        }

        void onStartJumpEventTriggered(StartJumpEvent startJumpEvent);
    }
}
