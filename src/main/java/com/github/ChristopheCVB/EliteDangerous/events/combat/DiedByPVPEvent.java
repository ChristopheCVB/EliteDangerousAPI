package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.google.gson.annotations.SerializedName;

public class DiedByPVPEvent extends DiedEvent {
    @SerializedName("KillerName")
    public String killerName;
    @SerializedName("KillerShip")
    public String killerShip;
    @SerializedName("KillerRank")
    public String killerRank;

    public DiedByPVPEvent(String timestamp) {
        super(timestamp);
    }
}