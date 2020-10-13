package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.Conflict;
import com.github.ChristopheCVB.EliteDangerous.models.Faction;
import com.github.ChristopheCVB.EliteDangerous.models.StationEconomy;

import java.util.List;

public class CarrierJumpEvent extends Event {
    public String starSystem;
    public String systemAllegiance;
    public String systemEconomy;
    public String systemEconomyLocalised;
    public String systemSecondEconomy;
    public String systemSecondEconomyLocalised;
    public String systemGovernment;
    public String systemGovernmentLocalised;
    public String systemSecurity;
    public String systemSecurityLocalised;
    public String body;
    public String bodyType;
    public Faction systemFaction;
    public String powerplayState;
    public String stationName;
    public String stationType;
    public String stationEconomy;
    public Faction stationFaction;
    public String stationAllegiance;
    public String stationGovernment;
    public String stationEconomyLocalised;
    public String stationGovernmentLocalised;
    private Double[] starPos;
    private Long systemAddress, population, marketID;
    private Integer bodyID;
    private Boolean docked;
    private List<Faction> factions;
    private List<Conflict> conflicts;
    private List<String> powers, stationServices;
    private List<StationEconomy> stationEconomies;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierJumpEventTriggered((CarrierJumpEvent) event);
        }

        void onCarrierJumpEventTriggered(CarrierJumpEvent carrierJumpEvent);
    }
}
