package com.christophecvb.elitedangerous.events.buysell;

import com.christophecvb.elitedangerous.events.Event;

public class BuyMicroResourcesEvent extends Event {
    public String name;
    public String nameLocalised;
    public Category category;
    public Integer count;
    public Long price;
    public Long marketID;

    public enum Category {
        Encoded,
        Raw,
        Manufactured,
        Item,
        Component,
        Data,
        Consumable,
    }
}
