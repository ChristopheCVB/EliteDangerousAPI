package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class ProgressEvent extends Event {
    public Integer combat;
    public Integer trade;
    public Integer explore;
    public Integer empire;
    public Integer federation;
    @SerializedName("CQC")
    public Integer cqc;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onProgressEventTriggered((ProgressEvent) event);
        }

        void onProgressEventTriggered(ProgressEvent progressEvent);
    }
}
