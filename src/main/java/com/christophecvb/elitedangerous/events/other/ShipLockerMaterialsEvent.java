package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.material.Item;

import java.util.ArrayList;

public class ShipLockerMaterialsEvent extends Event {
    public ArrayList<LockerItem> items;
    public ArrayList<LockerItem> components;
    public ArrayList<LockerItem> consumables;
    public ArrayList<LockerItem> data;

    public static class LockerItem extends Item {
        public Long ownerID;
        public Long missionID;
    }
}
