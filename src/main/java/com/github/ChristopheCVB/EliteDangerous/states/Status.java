package com.github.ChristopheCVB.EliteDangerous.states;

public class Status {
    public Long flags;
    public Fuel fuel;
    public Double cargo;

    public static class Fuel {
        public Double fuelMain;
        public Double fuelReservoir;
    }
}

// TODO: Parse Status data
//{ "timestamp":"2020-10-08T16:52:37Z", "event":"Status", "Flags":16777240, "Pips":[4,8,0], "FireGroup":0, "GuiFocus":0, "Fuel":{ "FuelMain":1.906994, "FuelReservoir":0.284744 }, "Cargo":2.000000, "LegalState":"Clean" }
