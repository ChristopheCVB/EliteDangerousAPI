package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.MicroResource;

public class BuyMicroResourcesEvent extends Event {
    public String name;
    public String nameLocalised;
    public MicroResource.Category category;
    public Integer count;
    public Long price;
    public Long marketID;
}
