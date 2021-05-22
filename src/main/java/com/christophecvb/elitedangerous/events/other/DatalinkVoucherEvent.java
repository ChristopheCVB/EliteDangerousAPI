package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class DatalinkVoucherEvent extends Event {
    public Long reward;
    public String victimFaction;
    public String payeeFaction;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDatalinkVoucherEventTriggered((DatalinkVoucherEvent) event);
        }

        void onDatalinkVoucherEventTriggered(DatalinkVoucherEvent datalinkVoucherEvent);
    }
}
