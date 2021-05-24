package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;

import java.util.ArrayList;

public class SellOrganicDataEvent extends Event {
    public Integer marketID;
    public ArrayList<BioData> bioData;

    public static class BioData {
        public String genus;
        public String species;
        public Long value;
        public Long bonus;
    }
}
