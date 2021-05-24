package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.OrganicData;

import java.util.ArrayList;

public class SellOrganicDataEvent extends Event {
    public Integer marketID;
    public ArrayList<BioData> bioData;

    public static class BioData extends OrganicData {
        public Long value;
        public Long bonus;
    }
}
