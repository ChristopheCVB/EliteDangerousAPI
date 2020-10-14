package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplaySalaryEvent extends Event {
    public String power;
    public Integer amount;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplaySalaryEventTriggered((PowerplaySalaryEvent) event);
        }

        void onPowerplaySalaryEventTriggered(PowerplaySalaryEvent powerplaySalaryEvent);
    }
}
