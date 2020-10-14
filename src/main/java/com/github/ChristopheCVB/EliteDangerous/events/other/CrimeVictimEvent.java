package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CrimeVictimEvent extends Event {
    public String offender;
    public String crimeType;
    @SerializedName("Fine_or_Bounty")
    public String fineOrBounty;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrimeVictimEventTriggered((CrimeVictimEvent) event);
        }

        void onCrimeVictimEventTriggered(CrimeVictimEvent crimeVictimEvent);
    }
}
