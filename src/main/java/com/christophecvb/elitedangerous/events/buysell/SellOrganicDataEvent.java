package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;

import java.util.ArrayList;

public class SellOrganicDataEvent extends Event {
    public Integer marketID;
    public ArrayList<BioDataItem> bioData;

    public static class BioDataItem {
        public String genus;
        public String species;
        public Long value;
        public Long bonus;
    }
}
