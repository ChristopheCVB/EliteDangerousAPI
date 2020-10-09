package com.github.ChristopheCVB.EliteDangerous.states;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("Flags")
    public Long flags;
    @SerializedName("Fuel")
    public Fuel fuel;
    @SerializedName("Cargo")
    public Double cargo;

    public static class Fuel {
        @SerializedName("FuelMain")
        public Double main;
        @SerializedName("FuelReservoir")
        public Double reservoir;
    }
}

// TODO: Parse Status
//{ "timestamp":"2020-10-08T16:52:37Z", "event":"Status", "Flags":16777240, "Pips":[4,8,0], "FireGroup":0, "GuiFocus":0, "Fuel":{ "FuelMain":1.906994, "FuelReservoir":0.284744 }, "Cargo":2.000000, "LegalState":"Clean" }
