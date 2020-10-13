package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.station.Discovered;

import java.util.List;

public class MultiSellExplorationDataEvent extends Event {
    public List<Discovered> discovered;
    public Integer baseValue, totalEarnings, bonus;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMultiSellExplorationDataEventTriggered((MultiSellExplorationDataEvent) event);
        }

        void onMultiSellExplorationDataEventTriggered(MultiSellExplorationDataEvent multiSellExplorationDataEvent);
    }
}
