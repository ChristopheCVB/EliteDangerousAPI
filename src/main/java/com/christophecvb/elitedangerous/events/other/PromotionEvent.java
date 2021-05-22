package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class PromotionEvent extends Event {
    public Integer combat;
    public Integer trade;
    public Integer explore;
    @SerializedName("CQC")
    public Integer cqc;
    public Integer federation;
    public Integer empire;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPromotionEventTriggered((PromotionEvent) event);
        }

        void onPromotionEventTriggered(PromotionEvent promotionEvent);
    }
}
