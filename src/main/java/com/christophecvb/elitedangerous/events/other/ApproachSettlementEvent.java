package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class ApproachSettlementEvent extends Event {
    public String name;
    public String bodyName;
    public Integer bodyID;
    public Double latitude;
    public Double longitude;
    public Long marketID;
    public Long systemAddress;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onApproachSettlementEventTriggered((ApproachSettlementEvent) event);
        }

        void onApproachSettlementEventTriggered(ApproachSettlementEvent approachSettlementEvent);
    }
}
