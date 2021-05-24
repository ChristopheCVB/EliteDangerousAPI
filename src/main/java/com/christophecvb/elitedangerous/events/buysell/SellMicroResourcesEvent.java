package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.MicroResource;

import java.util.ArrayList;

public class SellMicroResourcesEvent extends Event {
    public ArrayList<MicroResource> microResources;
    public Long price;
    public Long marketID;
}
