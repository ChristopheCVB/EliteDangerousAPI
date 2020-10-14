package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

import java.util.List;

public class PowerplayVoucherEvent extends Event {
    public String power;
    public List<String> systems;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayVoucherEventTriggered((PowerplayVoucherEvent) event);
        }

        void onPowerplayVoucherEventTriggered(PowerplayVoucherEvent powerplayVoucherEvent);
    }
}
