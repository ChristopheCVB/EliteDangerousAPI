package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.MicroResource;

import java.util.ArrayList;

public class TradeMicroResourcesEvent extends Event {
    public ArrayList<MicroResource> offered;
    public String received;
    public Integer count;
    public Long marketID;
    public MicroResource.Category category;
}

