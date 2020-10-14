package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CrewLaunchFighterEvent extends Event {
    public String crew;
    @SerializedName("ID")
    public Long id;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewLaunchFighterEventTriggered((CrewLaunchFighterEvent) event);
        }

        void onCrewLaunchFighterEventTriggered(CrewLaunchFighterEvent crewLaunchFighterEvent);
    }
}
