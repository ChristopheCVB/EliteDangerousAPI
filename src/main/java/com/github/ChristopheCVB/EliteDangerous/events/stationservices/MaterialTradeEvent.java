package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.TradeData;

public class MaterialTradeEvent extends Event {
    public Long marketID;
    public String traderType;
    public TradeData paid;
    public TradeData received;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMaterialTradeEventTriggered((MaterialTradeEvent) event);
        }

        void onMaterialTradeEventTriggered(MaterialTradeEvent materialTradeEvent);
    }
}
