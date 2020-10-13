package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.Faction;
import com.github.ChristopheCVB.EliteDangerous.models.StationEconomy;

import java.util.List;

public class DockedEvent extends Event {
    public String stationName;
    public String stationType;
    public String starSystem;
    public Faction stationFaction;
    public String stationGovernment;
    public String stationGovernmentLocalised;
    public String stationAllegiance;
    public String stationEconomy;
    public String stationEconomyLocalised;
    public List<StationEconomy> stationEconomies;
    public Long systemAddress;
    public Long marketID;
    public Double distFromStarLS;
    public Boolean cockpitBreach;
    public List<String> stationServices;
    public Boolean activeFine;
    public Boolean wanted;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDockedEventTriggered((DockedEvent) event);
        }

        void onDockedEventTriggered(DockedEvent dockedEvent);
    }
}
