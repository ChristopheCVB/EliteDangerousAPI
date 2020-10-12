package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class EngineerContributionEvent extends Event {
    public String engineer;
    public String type;
    public String commodity;
    public String faction;
    public String material;
    public Integer engineerID;
    public Integer quantity;
    public Integer totalQuantity;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onEngineerContributionEventTriggered((EngineerContributionEvent) event);
        }

        void onEngineerContributionEventTriggered(EngineerContributionEvent engineerContributionEvent);
    }
}
