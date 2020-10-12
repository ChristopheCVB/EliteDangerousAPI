package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommunityGoalDiscardEvent extends Event {
    @SerializedName("CGID")
    public Integer cgid;
    public String name;
    public String system;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCommunityGoalDiscardEventTriggered((CommunityGoalDiscardEvent) event);
        }

        void onCommunityGoalDiscardEventTriggered(CommunityGoalDiscardEvent communityGoalDiscardEvent);
    }
}
