package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyExplorationDataEvent extends Event {
    public String system;
    public Integer cost;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onBuyExplorationDataEventTriggered((BuyExplorationDataEvent) event);
        }

        void onBuyExplorationDataEventTriggered(BuyExplorationDataEvent buyExplorationDataEvent);
    }
}
