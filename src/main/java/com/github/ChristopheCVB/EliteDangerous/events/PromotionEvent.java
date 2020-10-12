package com.github.ChristopheCVB.EliteDangerous.events;

public class PromotionEvent extends Event {
    public Integer trade;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPromotionEventTriggered((PromotionEvent) event);
        }

        void onPromotionEventTriggered(PromotionEvent promotionEvent);
    }
}
